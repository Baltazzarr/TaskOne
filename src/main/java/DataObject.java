import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Аьстрактный класс объекта данных
 */
public abstract class DataObject implements DataInterface {

    @Override
    public void insert(Object object) {
        Session session = DatabaseSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Object object) {
        Session session = DatabaseSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Object object) {
        Session session = DatabaseSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
    }

}
