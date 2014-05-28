
import java.util.HashMap;

/**
 * Created by anizienko on 14.05.14.
 */
public class players {
    private static Integer balance;
    private static String player;
    public static HashMap<String, Integer> allplayers = new HashMap();

    players(String name, Integer bal)
    {
        player=name;
        balance=bal;
    }

    static void addPlayer(String name, Integer balance)
    {
        allplayers.put(name,  balance); //имя и баланс игроков при создании

    }
    public static void addMoney(String name,Integer amount)
    {

        allplayers.put(name, amount);
    }



    static Integer removeMoney(String name, Integer amount)
    {
    if (amount<0)
        return 0;

    else
        allplayers.put(name, amount);
        return 1;
    }

    static Object getBalance(String name)
    {

        return allplayers.get(name);
    }

    public static boolean isPlayerExist(String name)
    {
        if (allplayers.get(name) != null)
            return true;
        else
            return false;
    }

    static void show()
    {
        System.out.println("Для дебаг мода");
    }
}
