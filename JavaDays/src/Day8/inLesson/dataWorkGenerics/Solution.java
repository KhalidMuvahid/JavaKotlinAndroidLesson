package Day8.inLesson.dataWorkGenerics;

public class Solution {
    public static void main(String[] args) {
        MyData data = getMyData();
        System.out.println(data);
    }

    private static MyData getMyData() {
        return new Repository<MyData>(new CloudDataSource(),new CachedDataSource()).getData();
    }
}
