package Day4;
/*
* The method accepts 3 input numbers: the cost of beer, the cost of whiskey and the money in your pocket
if there is enough money in your pocket for whiskey, then we take whiskey
if there is only enough money in your pocket for beer, then we take beer
if there is enough money in your pocket for both beer and whiskey, then we take both
but if you have the wind in your pocket, we leave the bar
*
*
* */
public class Task2 {
    private static final int WHISKEY_COST = 22;
    private static final int BEAR_COST = 12;

    public static void main(String[] args) {
        makeOrder(WHISKEY_COST,BEAR_COST, 100);
        makeOrder(WHISKEY_COST,BEAR_COST, 12);
        makeOrder(WHISKEY_COST,BEAR_COST, 9);
    }

    public static void print(String str,int money){
        System.out.println("Whiskey cost: "+WHISKEY_COST);
        System.out.println("Bear cost: "+BEAR_COST);
        System.out.println("---------------------------");
        System.out.println("I bought "+str+" bc i had "+money+"$\n\n");
    }

    private static void makeOrder(int whiskeyCost, int bearCost, int moneyInWallet) {


        if (moneyInWallet >= whiskeyCost+bearCost){
            print("both",moneyInWallet);
        }else if (moneyInWallet >= whiskeyCost){
            print("only whiskey",moneyInWallet);
        }else if (moneyInWallet >= bearCost){
            print("only bear",moneyInWallet);
        }else {
            print("nothing",moneyInWallet);
        }


    }
}
