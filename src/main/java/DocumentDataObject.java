import java.util.List;

/**
 * Объект данных документа
 */
public class DocumentDataObject extends DataObject {

    public void insert(Document document) {
        super.insert(document);
    }

    public void update(Document document) {
        super.update(document);
    }

    public void delete(Document document) {
        super.delete(document);
    }

    @Override
    public Document getById(int id) {
        return DatabaseSessionFactory.getSessionFactory().openSession().get(Document.class, id);
    }

    @Override
    public List<Document> getAll() {
        return DatabaseSessionFactory.getSessionFactory().openSession().createQuery("From Document").list();
    }

}
