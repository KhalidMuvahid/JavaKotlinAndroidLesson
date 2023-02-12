package Day9;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

public class HashMapLearning {
    public static void main(String[] args) {
        /*
        ----------------------------------------------------Hashtable--------------------------------------------------------
                                 Any non-null object can be used as a key or as a value.
        * */

        Map<Integer,AJava> map = new HashMap<>();

        for (int i=1;i<10;i++){
            map.put(i,new AJava(i+" Object",i*10));
        }

        map.put(null,new AJava("Object",90));
        map.put(10,new AJava("9 Object",90));
        map.put(null,null);

        for (Map.Entry<Integer,AJava> entrySet : map.entrySet()){
            System.out.println(entrySet.getKey()+" "+entrySet.getValue());
        }

        System.out.println(map.get(10).equals(map.get(9)));

        //if we override it hashCode will be the same  bc they have same value inside obj
        //and all Strings have the same hashCode bc they are in String pool
        System.out.println(map.get(9).hashCode());
        System.out.println(map.get(10).hashCode());

    }

    private static class AJava {
        private String name;
        private int age;
        public AJava(String name,int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "AJava{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AJava aJava = (AJava) o;

            if (age != aJava.age) return false;
            return Objects.equals(name, aJava.name);
        }

        //31 bc odd prime
        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
    }
}
