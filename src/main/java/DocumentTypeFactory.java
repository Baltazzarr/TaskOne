import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * Фабрика типов документов
 */
public class DocumentTypeFactory {

    /**
     * Документ
     */
    final protected Document document;

    public DocumentTypeFactory(Document document) {
        this.document = document;
    }

    /**
     * Проверить актуальность документа
     * @return true, если документ актуален; false - в противном случае
     */
    public boolean isActual() {
        DocumentType documentType = null;
        if (document.getDocumentTypeId() == 1L) {
            documentType = new Passport(document.getPerson().getBirthdate());
        }
        if (document.getDocumentTypeId() == 2L) {
            documentType = new BiometricForeignPassport();
        }
        if (document.getDocumentTypeId() == 3L) {
            documentType = new MilitaryID();
        }
        if (documentType == null) {
            return false;
        } else {
            return documentType.isActual(document.getStartDate());
        }
    }

    /**
     * Интерфейс типа доумента
     */
    public interface DocumentType {

        /**
         * Проверить актуальность документа
         * @param date дата выдачи документа
         * @return true, если документ актуален; false - в противном случае
         */
        public boolean isActual(LocalDate date);
    }

    /**
     * Внутренний паспорт
     */
    public class Passport implements DocumentType {

        /**
         * Дата рождения
         */
        protected LocalDate birthDate;

        public Passport(LocalDate birthDate) {
            this.birthDate = birthDate;
        }

        @Override
        public boolean isActual(LocalDate date) {
            int age = Period.between(birthDate, LocalDate.now()).getYears();
            if (age < 14) {
                return false;
            }
            if (age < 20) {
                return true;
            }
            if (age < 45) {
                return date.isAfter(birthDate.plusYears(20));
            }
            return date.isAfter(birthDate.plusYears(45));
        }

    }

    /**
     * Биометрический заграничный паспорт
     */
    public class BiometricForeignPassport implements DocumentType {

        @Override
        public boolean isActual(LocalDate date) {
            return date.plusYears(10).isAfter(LocalDate.now());
        }

    }

    /**
     * Военный билет
     */
    public class MilitaryID implements DocumentType {

        @Override
        public boolean isActual(LocalDate date) {
            return  true;
        }

    }

}
