import java.util.List;

/**
 * Объект данных человека
 */
public class PersonDataObject extends DataObject {

    public void insert(Person person) {
        super.insert(person);
    }

    public void update(Person person) {
        super.update(person);
    }

    public void delete(Person person) {
        super.delete(person);
    }

    public Person getById(int id) {
        return DatabaseSessionFactory.getSessionFactory().openSession().get(Person.class, id);
    }

    public List<Person> getAll() {
        return DatabaseSessionFactory.getSessionFactory().openSession().createQuery("From Person").list();
    }

}
