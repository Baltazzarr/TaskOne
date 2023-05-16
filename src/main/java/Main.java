import java.util.List;

public class Main {

    public static void main(String[] args) {
        DocumentService documentService = new DocumentService();
        List<Document> documents = documentService.getByMatchInNumber("777");
        documents.stream().filter(documentService::isActual).map(Document::toString).forEach(System.out::println);
    }

}
