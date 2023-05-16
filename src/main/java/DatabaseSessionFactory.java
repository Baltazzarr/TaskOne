import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DatabaseSessionFactory {
    protected static SessionFactory sessionFactory = createSessionFactory();

    protected DatabaseSessionFactory() {}

    // Singleton
    protected static SessionFactory createSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Person.class);
            configuration.addAnnotatedClass(Document.class);
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        getSessionFactory().close();
    }

}
