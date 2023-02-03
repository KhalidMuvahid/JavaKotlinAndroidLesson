package Day8.inLesson.dataWorkGenerics;

public class CloudDataSource<T> implements DataSource<MyData> {
    @Override
    public MyData getData() {
        return new MyData(1,"description");
    }


}
