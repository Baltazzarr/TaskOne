import java.util.List;

/**
 * Общий интерфейс объекта данных
 */
public interface DataInterface<T> {

    /**
     * Вставить запись в БД
     * @param object объект данных
     */
    public void insert(T object);

    /**
     * Обновить запись в БД
     * @param object объект данных
     */
    public void update(T object);

    /**
     * Удалить запись из БД
     * @param object объект данных
     */
    public void delete(T object);

    /**
     * Получить запись по id
     * @param id идентфикатор в таблице БД
     */
    public T getById(int id);

    /**
     * Получить все записи
     */
    public List<T> getAll();

}
