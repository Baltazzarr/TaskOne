import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Действия с документами
 */
public class DocumentService {

    /**
     * Вернуть список документов по совпадению подстроки в номере
     * @param subNumber подстрока поиска
     * @return список документ, удовлетворяющих условию поиска
     */
    public List<Document> getByMatchInNumber(String subNumber) {
        Session session = null;
        List<Document> documents;
        try {
            session = DatabaseSessionFactory.getSessionFactory().openSession();
            org.hibernate.query.Query query = session.createQuery(
                    "select d from Document d where d.number like :number");
            query.setParameter("number", "%" + subNumber + "%");
            documents = query.getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return documents;
    }

    /**
     * Проверить актуальность документа
     * @param document документ
     * @return true, если документ актуален; false - в противном случае
     */
    public boolean isActual(Document document) {
        DocumentTypeFactory documentTypeFactory = new DocumentTypeFactory(document);
        return documentTypeFactory.isActual();
    }

}
