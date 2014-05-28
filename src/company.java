
import java.util.HashMap;

/**
 * Created by anizienko on 14.05.14.
 */
public class company {

    static String Comp, company, player;
    public static HashMap<String, Comp> allCompanies = new HashMap();
    static Object currentCompany = null;




    static void createCompanies()
    {
        allCompanies.put("Лаборатория КАСПЕРСКОГО", new Comp(12000, 4000,20000, 60000, 1, 10000)); // Стоимость, рента одинарная,рента за филиал,рента за предприятие
        allCompanies.put("Фирма 1C", new Comp(13000, 5000,25000, 70000, 1, 10000));
        allCompanies.put("Компания ЯНДЕКС", new Comp(14000, 5000,30000, 80000, 1, 10000));
        allCompanies.put("Фабрика БОЛЬШЕВИК", new Comp(9000, 1000,12000, 45000, 2, 5000));
        allCompanies.put("ВИММ-БИЛЛЬ-ДАНН", new Comp(11000, 3000,18000, 65000, 2, 5000));
        allCompanies.put("Фабрика РОССИЯ", new Comp(10000, 2000,15000, 55000, 2, 5000));
        allCompanies.put("ОАО БАНАНА-МАМА", new Comp(24000, 4000,20000, 74000, 3, 15000));
        allCompanies.put("Компания ЭЛЬДОРАДО", new Comp(25000, 4000,24000, 76000, 3, 15000));
        allCompanies.put("ОАО ДЕТСКИЙ МИР", new Comp(26000, 5000, 28000, 80000, 3, 15000));
        allCompanies.put("Гостиница RADISSON", new Comp(31000, 7000, 39000, 120000, 4, 20000));
        allCompanies.put("Турагентсво РОЗА ВЕТРОВ", new Comp(30000, 6000, 36000, 115000, 4, 20000));
        allCompanies.put("С/К РОСНО", new Comp(29000, 6000, 31000, 110000, 4, 20000));
        allCompanies.put("Радио ЭХО МОСКВЫ", new Comp(18000, 3000, 21000, 71000, 5, 10000));
        allCompanies.put("Издательство КОММЕРСАНТ", new Comp(19000, 3000, 22000, 74000, 5, 10000));
        allCompanies.put("РИА РБК", new Comp(20000, 4000, 23000, 77000, 5, 10000));
        allCompanies.put("S7 AIRLINE", new Comp(28000, 6000, 35000, 96000, 6, 15000));
        allCompanies.put("АЭРОФЛОТ", new Comp(27000, 6000, 33000, 93000, 6, 15000));
        allCompanies.put("ТРАНСАЭРО", new Comp(26000, 5000, 31000, 90000, 6, 15000));
        allCompanies.put("ЗАО РОСКОСМОС", new Comp(17000, 5000, 26000, 69000, 7, 10000));
        allCompanies.put("РКП ЭНЕРГИЯ", new Comp(16000, 4000, 24000, 65000, 7, 10000));
        allCompanies.put("Автозавод АВТОВАЗ", new Comp(15000, 4000, 22000, 62000, 7, 10000));
        allCompanies.put("ТНК", new Comp(32000, 6000, 50000, 140000, 8, 20000));
        allCompanies.put("ЛУКОЙЛ", new Comp(33000, 6000, 55000, 160000, 8, 20000));
        allCompanies.put("РОСНЕФТЬ", new Comp(34000, 7000, 60000, 180000, 8, 20000));
        allCompanies.put("МТС", new Comp(23000, 5000, 30000, 89000, 9, 10000));
        allCompanies.put("БИЛАЙН", new Comp(22000, 4000, 28000, 87000, 9, 10000));
        allCompanies.put("МЕГАФОН", new Comp(21000, 4000, 26000, 85000, 9, 10000));
        allCompanies.put("Концерн КАЛИНА", new Comp(8000, 1000, 6000, 36000, 10, 5000));
        allCompanies.put("ЮДАШКИН", new Comp(7000, 1000, 5000, 28000, 10, 5000));
        allCompanies.put("Сеть АРБАТПРЕСТИЖ", new Comp(6000, 1000, 4000, 20000, 10, 5000));
        allCompanies.put("MC'DONALDS", new Comp(55000, 30000,30000, 30000,0,0));
        allCompanies.put("ADIDAS", new Comp(49000, 28000, 28000, 28000,0,0));
        allCompanies.put("TISSOT", new Comp(50000, 29000, 29000, 29000,0,0));
        allCompanies.put("FERRARI", new Comp(61000, 35000, 35000, 35000,0,0));
        allCompanies.put("APPLE", new Comp(57000, 30000, 30000, 30000,0,0));
        allCompanies.put("SAMSUNG", new Comp(58000, 33000, 33000, 33000,0,0));
        allCompanies.put("DISNEYLAND", new Comp(110000, 64000, 64000, 64000,0,0));
        allCompanies.put("SHELL", new Comp(500000, 240000, 240000, 240000,0,0));
        allCompanies.put("GENERAL ELECTRIC", new Comp(750000, 350000, 350000, 350000,0,0));



    }



    public static boolean isCompanyExist(String name)
    {
        if (allCompanies.get(name) != null)
            return true;
        else
            return false;
    }

    public static boolean isCompanyFree(String name)
    {
        if (allCompanies.get(name).owner != null)
        {
            System.out.println("Извините, но компания уже куплена игроков по имени " + allCompanies.get(name).owner);
            return false;
        }
        else
            return true;

    }



    static void show()
    {
        System.out.println("Для дебаг мода");
    }


}
