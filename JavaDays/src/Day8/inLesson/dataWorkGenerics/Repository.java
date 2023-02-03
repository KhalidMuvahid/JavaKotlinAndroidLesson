package Day8.inLesson.dataWorkGenerics;

public class Repository<T> implements DataSource<T> {


    private final DataSource<T> cloudDataSource;
    private final MutableDataSource<T> cacheDataSource;

    public Repository(DataSource<T> cloudDataSource, MutableDataSource<T> cacheDataSource) {
        this.cloudDataSource = cloudDataSource;
        this.cacheDataSource = cacheDataSource;
    }


    @Override
    public T getData() {
        T result = cacheDataSource.getData();
        if (result == null){
            result = cloudDataSource.getData();
            cacheDataSource.saveData(result);
        }
        return result;
    }
}
