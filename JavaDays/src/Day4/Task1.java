package Day4;
/*
*
*Write a method that takes 2 booleans
variables isTodayFriday, aLotOfMoney, i.e. Today is Friday and you have a lot of money.
*Bring out to the console the following:
if it's Friday and you have a lot of money, then go to a bar for a beer
if it’s Friday, but there is not much money, then ask a friend for a loan and go drink beer with him
in all other cases (if it’s not Friday and there is no money) go home and eat buckwheat
*
* */
public class Task1 {
    public static void main(String[] args) {
        roadToBar(true,true);
        roadToBar(true,false);
        roadToBar(false,true);
        roadToBar(false,false);
    }

    static void roadToBar(boolean isFriday,boolean isALotOfMoney){
        if (isFriday){
            if (isALotOfMoney){
                System.out.println("Go to Drink");
            }else {
                System.out.println("Hey Friend give me money and let`s drink together");
            }
        }else {
            System.out.println("go home and eat buckwheat");
        }
    }
}
