package Day8.inLesson.dataWorkGenerics;

public class CachedDataSource<T> implements MutableDataSource<T>{
    private T data;
    @Override
    public T getData() {
        return data;
    }

    @Override
    public void saveData(T data) {
        this.data = data;
    }
}
