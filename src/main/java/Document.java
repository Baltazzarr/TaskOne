import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "\"DOCUMENT\"")
public class Document {

    @Column(name = "\"NUMBER\"", nullable = false, length = 50)
    private String number;

    @Column(name = "\"START_DATE\"", nullable = false)
    private LocalDate startDate;

    @Column(name = "\"DOCUMENT_TYPE_ID\"", nullable = false)
    private long documentTypeId;

    @Column(name = "\"PERSON_ID\"", nullable = false, insertable = false, updatable = false)
    private long personId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID\"", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "\"PERSON_ID\"")
    protected Person person;

    public Document() {}

    public Document(String number, LocalDate startDate, Long documentTypeId) {
        this.number = number;
        this.startDate = startDate;
        this.documentTypeId = documentTypeId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public long getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(long documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public long getPersonIdId() {
        return personId;
    }

    public void setPersonId(long documentId) {
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return personId == document.personId && documentTypeId == document.documentTypeId && id == document.id
                && Objects.equals(number, document.number) && Objects.equals(startDate, document.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, startDate, personId, documentTypeId, id);
    }

    @Override
    public String toString() {
        return String.format("Document (number = %s, type = %d, Person=(%s))",
                number, documentTypeId, person.toString());
    }

}
