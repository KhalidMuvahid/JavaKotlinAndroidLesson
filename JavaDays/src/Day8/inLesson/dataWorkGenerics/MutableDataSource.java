package Day8.inLesson.dataWorkGenerics;

public interface MutableDataSource<T> extends DataSource<T> {

    void saveData(T data);
}
