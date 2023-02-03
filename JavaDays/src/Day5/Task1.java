package Day5;
public class Task1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,2,43,65,39,0,-11};
        int[] arr2 = new int[]{1,2,3,4,5,6,7,8,9,10};
        String[] sArr = new String[]{"ew"," ","","sf","fdsf"};
        method1(arr);
        method2(arr);
        method3(arr);
        method4(arr,2);
        method5(sArr);
        method6(arr);
        method6(arr2);
    }
    /*1. Написать метод, который найдет минимум из любого количества чисел (аргумент массив).*/
    static void method1(int[] arr){
        int min=arr[0];
        for (int a : arr){
            if (a<min){
                min=a;
            }
        }
        System.out.println(min);
    }

    /*    2. Написать метод, который перемножит все числа в массиве*/
    static void method2(int[] arr){
        int res=1;
        for (int a : arr){
            if (a>0){
                res*=a;
            }
        }
        System.out.println(res);
    }

    /*    3. Написать метод, который посчитает количество отрицательных чисел в массиве*/
    static void method3(int[] arr){
        int count=0;
        for (int a : arr){
            if (a<0){
               count++;
            }
        }
        System.out.println(count);
    }

    /* 4. Написать метод, который принимает на вход число и массив. Вывести, сколько раз в этом
    масиве встречается это число которое передали в аргументе.*/
    static void method4(int[] arr,int value){
        int count=0;
        for (int a : arr){
            if (a == value){
                count++;
            }
        }
        System.out.println(count);
    }

    /*5. Написать метод, который принимает массив строк и проверяет сколько в них пустых строк.*/
    static void method5(String[] ar){
        int count=0;
        for (String s : ar){
            if (s.trim().isEmpty()){
                count++;
            }
        }
        System.out.println(count);
    }

    /*6. Написать метод, который проверит, что числа массива являются арифметической
    последовательностью*/
    static void method6(int[] arr){
        boolean isArif=false;
        int temp=0;
        for (int a=0;a<arr.length-1;a++){
            if (arr[a+1]-arr[a] == 1){
                isArif=true;
            }else {
                isArif=false;
            }
        }
        System.out.println(isArif);
    }

}
