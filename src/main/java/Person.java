
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "\"PERSON\"")
public class Person {

    @Column(name = "\"FIRST_NAME\"", nullable = false, length = 100)
    private String firstName;

    @Column(name = "\"LAST_NAME\"", nullable = false, length = 100)
    private String lastName;

    @Column(name = "\"PATRONYMIC\"", nullable = true, length = 100)
    private String patronymic;

    @Column(name = "\"BIRTHDATE\"", nullable = false)
    private LocalDate birthdate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID\"", nullable = false)
    private int id;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents;

    public Person() {}

    public Person(String firstName, String lastName, String patronymic, LocalDate birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        documents = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void addAuto(Document document) {
        document.setPerson(this);
        documents.add(document);
    }

    public void removeAuto(Document document) {
        documents.remove(document);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return  id == person.id && Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName) && Objects.equals(patronymic, person.patronymic)
                && Objects.equals(birthdate, person.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic, birthdate, id);
    }

    @Override
    public String toString() {
        return String.format("FIO = %s %s %s", lastName, firstName, patronymic);
    }

}
