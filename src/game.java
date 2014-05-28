import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by anizienko on 14.05.14.
 */
public class game {



    public String info, companies;







    public static void main(String[] args) throws IOException {
//initialization

        String newPlayer,name_debit,name_credit,currentCompany,temp,f1,f2,f3;
        Integer amount, res,command,j,i,k,number,id;
        Object balance = 0;
        boolean repeat;
        String ev[] = {"Добавить средства", "Списать средства", "Перевести средства", "Узнать баланс", "Купить предприятие", "Продать предприятие", "Узнать владельца предприятия", "Узнать стоимость предприятия", "Узнать стоимость прохода через предприятие", "Построить филиал/предприятие", "Разрушить филлиал/предприятие"};
        Scanner num = new Scanner(System.in);// определение количества участников
        Scanner am = new Scanner(System.in);// определение количества участников
        BufferedReader enterplayer = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader entercompany = new BufferedReader (new InputStreamReader(System.in));//
        Scanner event = new Scanner (System.in); // операция

        company.createCompanies();

        System.out.println("Введите количество участников игры");
        number=0;
        k=0;
        repeat=true;
        while (repeat)
        {
            try
            {
                number = num.nextInt();
                if ((number<2) | (number>8))
                    throw new NumberFormatException();
                repeat=false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Введенные данные должны быть числовыми");
                System.out.println("Повторите ввод данных");
                num.next();
            }
            catch (NumberFormatException e)
            {
                System.out.println("Минимальное количество участников 2,Максимальное количество участников 8, повторите снова");
            }
        }
        System.out.println("Играет " + number + " игрока(игроков)");
        for (i=1;i<number+1;i++)
        {


            System.out.println("Введите имя игрока");
            newPlayer=enterplayer.readLine();
            if (players.isPlayerExist(newPlayer)==false)
               players.addPlayer(newPlayer,250000);
            else
            {
                System.out.println("Такой игрок уже есть за столом, введите другое имя");
                i--;
            }

        }

        //  company.show();

        System.out.println("Приступимм к игре! ");

        for (;;)
        {
// даем список возможных операций
            for (i=0;i<11;i++)
            {
                System.out.println("Чтобы выполнить операцию " + ev[i] + " нажмите " + (i + 1));
            }


            System.out.println("Какую операцию необходимо выполнить?");

            command = event.nextInt();
            // определяем что хочет выполнить юзер
            switch (command)
            {
                //операция "Добавить средства"
                case 1: System.out.println("Вы выбрали " + ev[command-1] );
                    System.out.println("Баланс какого игрока необходимо пополнить?" );
                    name_credit=enterplayer.readLine();
                    if ( players.isPlayerExist(name_credit) ==true)
                        System.out.println("Введите сумму, необходимую добавить игроку" );                    else
                    {
                        System.out.println("Такого игрока за столом нет!!!!! ");
                        break;
                    }
                    amount=am.nextInt();
                    players.addMoney(name_credit, (Integer) players.getBalance(name_credit)+amount);
                    System.out.println("Теперь баланс игрока " + name_credit + " составляет " + players.getBalance(name_credit));
                    break;
                //операция "Списать средства"
                case 2: System.out.println("Вы выбрали " + ev[command-1] );
                    System.out.println("Баланс какого игрока необходимо продебетовать?" );
                    name_debit=enterplayer.readLine();
                    if ( players.isPlayerExist(name_debit) ==true)
                        System.out.println("Введите сумму, необходимую вычесть у игрока" );                    else
                    {
                        System.out.println("Такого игрока за столом нет!!!!! ");
                        break;
                    }
                    amount=am.nextInt();
                    if  (players.removeMoney(name_debit, (Integer) players.getBalance(name_debit)-amount)==1)
                    System.out.println("Теперь баланс игрока " + name_debit + " составляет " + players.getBalance(name_debit) );
                    else
                        System.out.println("У игрока " + name_debit + " недостаточно средств!!! Баланс составляет: " + players.getBalance(name_debit) + " Однако требуется уплатить : " + amount + " Внесите необходимую сумму на счет путем продажи собственности и повторите попытку!" );
                    break;
                //операция "Перевести средства"
                case 3: System.out.println("Вы выбрали " + ev[command-1] );
                    System.out.println("Баланс какого игрока необходимо пополнить?" );
                    name_credit=enterplayer.readLine();
                    if ( players.isPlayerExist(name_credit) ==true)
                        System.out.println("Баланс какого игрока необходимо продебетовать?" );                   else
                    {
                        System.out.println("Такого игрока за столом нет!!!!! ");
                        break;
                    }
                    name_debit=enterplayer.readLine();
                    if ( players.isPlayerExist(name_debit) ==true)
                        System.out.println("Введите сумму, необходимую перевести с игрока " + name_debit + " игроку " + name_credit );                 else
                    {
                        System.out.println("Такого игрока за столом нет!!!!! ");
                        break;
                    }
                    amount=am.nextInt();

                    if (players.removeMoney(name_debit, (Integer) players.getBalance(name_debit)-amount)==1)
                    {
                    System.out.println("Теперь баланс игрока " + name_debit + " составляет " + players.getBalance(name_debit) );
                    players.addMoney(name_credit, (Integer) players.getBalance(name_credit)+amount);
                    System.out.println("Теперь баланс игрока " + name_credit + " составляет " + players.getBalance(name_credit) );
                    }
                    else
                        System.out.println("У игрока " + name_debit + " недостаточно средств!!! Баланс составляет: " + players.getBalance(name_debit) + " Однако требуется уплатить : " + amount + " Внесите необходимую сумму на счет путем продажи собственности и повторите попытку!");
                    break;
                //операция "Узнать баланс"
                case 4: System.out.println("Вы выбрали " + ev[command-1] );
                    System.out.println("Какого игрока необходимо узнать баланс? " );
                    newPlayer=enterplayer.readLine();
                    if ( players.isPlayerExist(newPlayer) ==false)
                    {
                        System.out.println("Такого игрока за столом нет!!!!! ");
                        break;
                    }
                    balance=players.getBalance(newPlayer);
                    System.out.println("Баланс игрока " + newPlayer + " составляет " + balance );
                    break;
                //операция "Купить предприятие"
                case 5: System.out.println("Вы выбрали " + ev[command-1] );
                    System.out.println("Какой игрок хочет приобрести фирму?" );
                    newPlayer=enterplayer.readLine();
                    if ( players.isPlayerExist(newPlayer) ==false)
                    {
                        System.out.println("Такого игрока за столом нет!!!!! ");
                        break;
                    }
                    System.out.println("Какую фирму игрок " + newPlayer + " желает приобрести?" );
                    currentCompany=entercompany.readLine();
                    if ( company.isCompanyExist(currentCompany) ==false)
                    {
                        System.out.println("Такой фирмы нет! Правописание должно быть таким же как в игре, исключая ковычки!!!! ");
                        break;
                    }
                    if ( company.isCompanyFree(currentCompany) ==false)
                    {

                        break;
                    }

                    if (players.removeMoney(newPlayer, (Integer) players.getBalance(newPlayer)-company.allCompanies.get(currentCompany).cost)==1)
                    {
                        company.allCompanies.get(currentCompany).setOwner(newPlayer);
                        System.out.println("Компания " + currentCompany + " успешно приобретена!" );
                    }
                    else
                        System.out.println("У игрока " + newPlayer + " недостаточно средств!!! Баланс составляет: " + players.getBalance(newPlayer) + " Однако фирма стоит: " + company.allCompanies.get(currentCompany).cost );
                    break;
                //операция "Продать предприятие"
                case 6: System.out.println("Вы выбрали " + ev[command-1] );
                    System.out.println("Какой игрок хочет продать фирму?" );
                    newPlayer=enterplayer.readLine();
                    if ( players.isPlayerExist(newPlayer) ==false)
                    {
                        System.out.println("Такого игрока за столом нет!!!!! ");
                        break;
                    }
                    System.out.println("Какую фирму игрок " + newPlayer + " желает продать?" );
                    currentCompany=entercompany.readLine();
                    if ( company.isCompanyExist(currentCompany) ==false)
                    {
                        System.out.println("Такой фирмы нет! Правописание должно быть таким же как в игре, исключая ковычки!!!! ");
                        break;
                    }
                    if (company.allCompanies.get(currentCompany).getOwner().equals(newPlayer))
                    {
                        company.allCompanies.get(currentCompany).setOwner(null);
                        players.addMoney(newPlayer, (Integer) players.getBalance(newPlayer)+company.allCompanies.get(currentCompany).cost +  company.allCompanies.get(currentCompany).getBranchcost());
                        System.out.println("Компания " + currentCompany + " успешно продана! Продавцу переведена стоимость предприятия в размере "+ company.allCompanies.get(currentCompany).cost + " а так же стоимость построек филиалов и предприятий, если таковые имелись в размере : " + company.allCompanies.get(currentCompany).getBranchcost());
                    }
                    else
                        System.out.println("Данная компания не принадлежит игроку " + newPlayer + " !!!!");
                    break;
                //операция "Узнать владельца предприятия"
                case 7: System.out.println("Вы выбрали " + ev[command-1] );
                    System.out.println("Информация о владельце какой фирмы Вас интересует?" );
                    currentCompany=entercompany.readLine();
                    if ( company.isCompanyExist(currentCompany) ==false)
                    {
                        System.out.println("Такой фирмы нет! Правописание должно быть таким же как в игре, исключая ковычки!!!! ");
                        break;
                    }
                    if (company.allCompanies.get(currentCompany).getOwner().equals("free"))
                        System.out.println("Данная компания в данный момент не принадлежит никому!!!" );
                    else
                        System.out.println("Данная компания в данный момент принадлежит игроку по имени " + company.allCompanies.get(currentCompany).getOwner() );
                    break;
                //операция "Узнать стоимость предприятия"
                case 8: System.out.println("Вы выбрали " + ev[command-1] );
                    System.out.println("Информация о какой фирме Вас интересует?" );
                    currentCompany=entercompany.readLine();
                    if ( company.isCompanyExist(currentCompany) ==false)
                    {
                        System.out.println("Такой фирмы нет! Правописание должно быть таким же как в игре, исключая ковычки!!!! ");
                        break;
                    }
                    System.out.println("Стоимость данной компании: " + company.allCompanies.get(currentCompany).getCost() );
                    break;
                //операция "Узнать стоимость прохода через предприятие"
                case 9: System.out.println("Вы выбрали " + ev[command-1] );
                    System.out.println("Информация о какой фирме Вас интересует?" );
                    currentCompany=entercompany.readLine();
                    if ( company.isCompanyExist(currentCompany) ==false)
                    {
                        System.out.println("Такой фирмы нет! Правописание должно быть таким же как в игре, исключая ковычки!!!! ");
                        break;
                    }
                    if (company.allCompanies.get(currentCompany).getOwner()=="free")
                        System.out.println("Стоимость посещения данной компании: " + company.allCompanies.get(currentCompany).getRent());
                    else
                    {


                    id = (Integer) company.allCompanies.get(currentCompany).getGroup();
                    if (id>0 )switch (id)
                    {
                        case 1:  f1="Лаборатория КАСПЕРСКОГО"; f2="Фирма 1C";f3="Компания ЯНДЕКС";break;
                        case 2:  f1="Фабрика БОЛЬШЕВИК"; f2="ВИММ-БИЛЛЬ-ДАНН";f3="Фабрика РОССИЯ";break;
                        case 3:  f1="ОАО БАНАНА-МАМА"; f2="Компания ЭЛЬДОРАДО";f3="ОАО ДЕТСКИЙ МИР";break;
                        case 4:  f1="Гостиница RADISSON"; f2="Турагентсво РОЗА ВЕТРОВ";f3="С/К РОСНО";break;
                        case 5:  f1="Радио ЭХО МОСКВЫ"; f2="РИА РБК";f3="Издательство КОММЕРСАНТ";break;
                        case 6:  f1="S7 AIRLINE"; f2="АЭРОФЛОТ";f3="ТРАНСАЭРО";break;
                        case 7:  f1="ЗАО РОСКОСМОС"; f2="РКП ЭНЕРГИЯ";f3="Автозавод АВТОВАЗ";break;
                        case 8:  f1="ТНК"; f2="ЛУКОЙЛ";f3="РОСНЕФТЬ";break;
                        case 9:  f1="МТС"; f2="БИЛАЙН";f3="МЕГАФОН";break;
                        case 10:  f1="Концерн КАЛИНА"; f2="ЮДАШКИН";f3="Сеть АРБАТПРЕСТИЖ";break;
                        default: f1=null; f2=null; f3=null; break;
                    }
                    else
                    {
                        System.out.println("Стоимость посещения данной компании: " + company.allCompanies.get(currentCompany).getRent());
                        break;
                    }
                    if (company.allCompanies.get(f1).getOwner().equals(company.allCompanies.get(currentCompany).getOwner())&&company.allCompanies.get(f2).getOwner().equals(company.allCompanies.get(currentCompany).getOwner())&&company.allCompanies.get(f3).getOwner().equals(company.allCompanies.get(currentCompany).getOwner())&&company.allCompanies.get(currentCompany).getBranchlevel()==1)
                         System.out.println("Стоимость посещения данной компании: " + company.allCompanies.get(currentCompany).getRent() * 2 );
                    else
                    System.out.println("Стоимость посещения данной компании: " + company.allCompanies.get(currentCompany).getRent());
                    }
                    break;
                //операция "Построить филиал/предприятие"
                case 10: System.out.println("Вы выбрали " + ev[command-1] );

                    System.out.println("Какой игрок желает построить филиал/предприятие??" );
                    newPlayer=enterplayer.readLine();
                    if ( players.isPlayerExist(newPlayer) ==false)
                    {
                        System.out.println("Такого игрока за столом нет!!!!! ");
                        break;
                    }
                    System.out.println("Для какой фирмы Вы желаете построить филиал/предприятие?" );
                    currentCompany=entercompany.readLine();
                    if ( company.isCompanyExist(currentCompany) ==false)
                    {
                        System.out.println("Такой фирмы нет! Правописание должно быть таким же как в игре, исключая ковычки!!!! ");
                        break;
                    }

                    id = (Integer) company.allCompanies.get(currentCompany).getGroup();
                    if (id>0 )switch (id)
                    {
                        case 1:  f1="Лаборатория КАСПЕРСКОГО"; f2="Фирма 1C";f3="Компания ЯНДЕКС";break;
                        case 2:  f1="Фабрика БОЛЬШЕВИК"; f2="ВИММ-БИЛЛЬ-ДАНН";f3="Фабрика РОССИЯ";break;
                        case 3:  f1="ОАО БАНАНА-МАМА"; f2="Компания ЭЛЬДОРАДО";f3="ОАО ДЕТСКИЙ МИР";break;
                        case 4:  f1="Гостиница RADISSON"; f2="Турагентсво РОЗА ВЕТРОВ";f3="С/К РОСНО";break;
                        case 5:  f1="Радио ЭХО МОСКВЫ"; f2="РИА РБК";f3="Издательство КОММЕРСАНТ";break;
                        case 6:  f1="S7 AIRLINE"; f2="АЭРОФЛОТ";f3="ТРАНСАЭРО";break;
                        case 7:  f1="ЗАО РОСКОСМОС"; f2="РКП ЭНЕРГИЯ";f3="Автозавод АВТОВАЗ";break;
                        case 8:  f1="ТНК"; f2="ЛУКОЙЛ";f3="РОСНЕФТЬ";break;
                        case 9:  f1="МТС"; f2="БИЛАЙН";f3="МЕГАФОН";break;
                        case 10:  f1="Концерн КАЛИНА"; f2="ЮДАШКИН";f3="Сеть АРБАТПРЕСТИЖ";break;
                        default: f1=null; f2=null; f3=null; break;
                    }
                    else
                    {
                        System.out.println("Извините, но у данной фирмы нет возможности строить филиал или предприятие");
                        break;
                    }




                    if (company.allCompanies.get(currentCompany).getOwner().equals(newPlayer))
                    {
                        if (company.allCompanies.get(f1).getOwner().equals(company.allCompanies.get(currentCompany).getOwner())&&company.allCompanies.get(f2).getOwner().equals(company.allCompanies.get(currentCompany).getOwner())&&company.allCompanies.get(f3).getOwner().equals(company.allCompanies.get(currentCompany).getOwner()))

                        {

                             if (company.allCompanies.get(currentCompany).getBranchlevel() == 3)
                              {
                                System.out.println("Извините, но у Вас уже построено предприятие на данной фирме!!!! ");
                                break;
                              }
                             else

                                if (company.allCompanies.get(currentCompany).getBranchlevel() == 2)
                                      if ((company.allCompanies.get(f1).getBranchlevel().equals(2)||company.allCompanies.get(f1).getBranchlevel().equals(3))&&(company.allCompanies.get(f2).getBranchlevel().equals(2)||company.allCompanies.get(f2).getBranchlevel().equals(3))&&(company.allCompanies.get(f3).getBranchlevel().equals(2)||company.allCompanies.get(f3).getBranchlevel().equals(3)))
                                              {
                                                 if  (players.removeMoney(newPlayer, (Integer) players.getBalance(newPlayer) - company.allCompanies.get(currentCompany).upCost)==1)
                                                 {
                                                  company.allCompanies.get(currentCompany).upBranchlevel();
                                                  System.out.println("Уровень фирмы повышен до " + ((company.allCompanies.get(currentCompany).getBranchlevel()) == 2 ? "филиал" : "предприятия"));
                                                 }
                                                 else
                                                     System.out.println("У игрока " + newPlayer + " недостаточно средств!!! Баланс составляет: " + players.getBalance(newPlayer) + " Однако цена постройки филиала/предприятия составляет: " + company.allCompanies.get(currentCompany).upCost );
                                                  break;
                                              }
                                       else
                                             {
                                                System.out.println("Чтобы построить предприятие на данной фирме, необходимо чтобы на всех фирмах данного участка уже был построен филиал!");
                                                break;
                                              }
                                 else
                                 players.removeMoney(newPlayer, (Integer) players.getBalance(newPlayer) - company.allCompanies.get(currentCompany).upCost);
                                 company.allCompanies.get(currentCompany).upBranchlevel();
                                 System.out.println("Уровень фирмы повышен до " + ((company.allCompanies.get(currentCompany).getBranchlevel()) == 2 ? "филиал" : "предприятия"));
                            break;
                        }
                        else
                               System.out.println("Извините, но для возможности строить филиалы или предприятия, нужно сперва купить все предприятия одного участка!!!! ");
                        break;
                    }
                    else
                        System.out.println("Извините, но у данного игрока нет прав на повышение/понижения уровня фирмы, поскольку она не является его собственностью!!!!! ");
                    break;
                //операция "Разрушить филиал/предприятие"
                case 11: System.out.println("Вы выбрали " + ev[command-1] );

                    System.out.println("Какой игрок желает разрушить филиал/предприятие??" );
                    newPlayer=enterplayer.readLine();
                    if ( players.isPlayerExist(newPlayer) ==false)
                    {
                        System.out.println("Такого игрока за столом нет!!!!! ");
                        break;
                    }
                    System.out.println("Для какой фирмы Вы желаете разрушить филиал/предприятие?" );
                    currentCompany=entercompany.readLine();
                    if ( company.isCompanyExist(currentCompany) ==false)
                    {
                        System.out.println("Такой фирмы нет! Правописание должно быть таким же как в игре, исключая ковычки!!!! ");
                        break;
                    }

                    id = (Integer) company.allCompanies.get(currentCompany).getGroup();
                    if (id>0 )switch (id)
                    {
                        case 1:  f1="Лаборатория КАСПЕРСКОГО"; f2="Фирма 1C";f3="Компания ЯНДЕКС";break;
                        case 2:  f1="Фабрика БОЛЬШЕВИК"; f2="ВИММ-БИЛЛЬ-ДАНН";f3="Фабрика РОССИЯ";break;
                        case 3:  f1="ОАО БАНАНА-МАМА"; f2="Компания ЭЛЬДОРАДО";f3="ОАО ДЕТСКИЙ МИР";break;
                        case 4:  f1="Гостиница RADISSON"; f2="Турагентсво РОЗА ВЕТРОВ";f3="С/К РОСНО";break;
                        case 5:  f1="Радио ЭХО МОСКВЫ"; f2="РИА РБК";f3="Издательство КОММЕРСАНТ";break;
                        case 6:  f1="S7 AIRLINE"; f2="АЭРОФЛОТ";f3="ТРАНСАЭРО";break;
                        case 7:  f1="ЗАО РОСКОСМОС"; f2="РКП ЭНЕРГИЯ";f3="Автозавод АВТОВАЗ";break;
                        case 8:  f1="ТНК"; f2="ЛУКОЙЛ";f3="РОСНЕФТЬ";break;
                        case 9:  f1="МТС"; f2="БИЛАЙН";f3="МЕГАФОН";break;
                        case 10:  f1="Концерн КАЛИНА"; f2="ЮДАШКИН";f3="Сеть АРБАТПРЕСТИЖ";break;
                        default: f1=null; f2=null; f3=null; break;
                    }
                    else
                    {
                        System.out.println("Извините, но у данной фирмы нет возможности строить филиал или предприятие");
                        break;
                    }




                    if (company.allCompanies.get(currentCompany).getOwner().equals(newPlayer))
                    {
                        if (company.allCompanies.get(f1).getOwner().equals(company.allCompanies.get(currentCompany).getOwner())&&company.allCompanies.get(f2).getOwner().equals(company.allCompanies.get(currentCompany).getOwner())&&company.allCompanies.get(f3).getOwner().equals(company.allCompanies.get(currentCompany).getOwner()))

                        {

                            if (company.allCompanies.get(currentCompany).getBranchlevel() == 1)
                            {
                                System.out.println("Извините, но уровень данной фирмы и так минимальный, разрушать некуда....!!!! ");
                                break;
                            }
                            else

                            if (company.allCompanies.get(currentCompany).getBranchlevel() == 2)
                            {
                                   System.out.println("Поскольку Вы производите понижение уровня с филиала до обычной фирмы, уровень всех предприятий этого участка будет понижен до филиалов! ");
                                    players.addMoney(newPlayer, (Integer) players.getBalance(newPlayer) + company.allCompanies.get(currentCompany).upCost);
                                    company.allCompanies.get(currentCompany).downBranchlevel();
                                if  (company.allCompanies.get(f1).getBranchlevel()==3)
                                {
                                    players.addMoney(newPlayer, (Integer) players.getBalance(newPlayer) + company.allCompanies.get(f1).upCost);
                                    company.allCompanies.get(f1).downBranchlevel();
                                }
                                if  (company.allCompanies.get(f2).getBranchlevel()==3)
                                {
                                    players.addMoney(newPlayer, (Integer) players.getBalance(newPlayer) + company.allCompanies.get(f2).upCost);
                                    company.allCompanies.get(f2).downBranchlevel();
                                }
                                if  (company.allCompanies.get(f3).getBranchlevel()==3)
                                {
                                    players.addMoney(newPlayer, (Integer) players.getBalance(newPlayer) + company.allCompanies.get(f3).upCost);
                                    company.allCompanies.get(f3).downBranchlevel();
                                }

                                    System.out.println("Уровень фирмы " + currentCompany + " понижен до филиал. На фирмах данного участка, где было построено предприятие, произвелось понижение до филиалов." );
                                    break;


                            }
                            else
                            //тут получается что разрушаем предприятие, а знаичт другие филиалы или предприятия разрушать не нужно
                            players.addMoney(newPlayer, (Integer) players.getBalance(newPlayer) + company.allCompanies.get(currentCompany).upCost);
                            company.allCompanies.get(currentCompany).downBranchlevel();
                            System.out.println("Уровень фирмы понижен до филиал" );
                            break;
                        }
                        else
                            System.out.println("Извините, но но на указанной фирме не может быть построен филиал или предприятие, поскольку все участки не принадлежат одному игроку!!!! ");
                        break;
                    }
                    else
                        System.out.println("Извините, но у данного игрока нет прав на повышение/понижения уровня фирмы, поскольку она не является его собственностью!!!!! ");
                    break;





            }


        }


    }
}

