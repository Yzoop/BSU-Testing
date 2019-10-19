package Lab3;

public class caseTest {
    private static classAccountDB MyAccountDB;
    public static final  String RED = "\u001B[31m";
    public static final  String GREEN = "\u001B[32m";
    public static final  String RESET = "\u001B[0m";


    private static void Set_DB()
    {
        MyAccountDB = new classAccountDB();
        MyAccountDB.Read_Account_DB();
    }


    private static void Print_Test(final Account tester,final classAccountDB.enLogIn supposedAns)
    {
        System.out.printf("Входные данные: логин = '%s'; пароль = '%s'\n", tester.Get_Log(),
                tester.Get_Pas());
        System.out.printf("Ожидаемый ответ: %s\n", classTest.Ans_According_To_ID(supposedAns));

    }


    private static void Print_Checker(classAccountDB.enLogIn connectionStatus, classAccountDB.enLogIn supposedStatus)
    {
        if (connectionStatus.equals(supposedStatus))
        {
            System.out.printf(GREEN + "Оценка: Тест пройден. ответ: %s"+ RESET
                            + "\n\n---------------------------------------------------------\n\n",
                    classTest.Ans_According_To_ID(connectionStatus));
        }
        else
        {
            System.out.printf(RED + "Оценка: Тест не пройден! ответ: %s" + RESET
                            + "\n\n---------------------------------------------------------\n\n",
                    classTest.Ans_According_To_ID(connectionStatus));
        }
    }



    private static void Start_Testing()
    {
        try
        {
            classTest MyTester;
            MyTester = new classTest();
            while(MyTester.Is_Not_Finished())
            {
                Account  accountToTest = MyTester.Next_Test();
                classAccountDB.enLogIn SupposedConnectionStatus = MyTester.Get_Supposed_Status();
                Print_Test(accountToTest, SupposedConnectionStatus);
                Print_Checker(MyAccountDB.connect(accountToTest), SupposedConnectionStatus);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }


    public static void main(String[] args)
    {
        Set_DB();
        Start_Testing();
    }

}
