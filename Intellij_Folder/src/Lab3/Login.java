package Lab3;


import java.util.Scanner;

public class Login {
    private static final int MAX_ENTERS = 3;
    private static classAccountDB myDb = new classAccountDB();


    private static Account enterLoginPassword()
    {
        Scanner scan = new Scanner(System.in);
        String login = "", password = "";
        System.out.print("Введите логин:");
        login = scan.nextLine();
        System.out.print("Введите пароль:");
        password = scan.nextLine();
        System.out.println("----Принято. Начата обработка----");

        return new Account(login, password);
    }


    public static Account userConnectedAccount()
    {
        int qtEnters = 0;
        Account toReturn = null;
        classAccountDB.enLogIn connectionStatus = classAccountDB.enLogIn.eErrorNotFound;
        myDb.Read_Account_DB();
        do
        {
            try
            {
                toReturn = enterLoginPassword();
                connectionStatus = myDb.connect(toReturn);
                System.out.printf("\nОтвет сервера: %s\n", classTest.Ans_According_To_ID(connectionStatus));
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
            ++qtEnters;
        } while(connectionStatus != classAccountDB.enLogIn.eCorrect && qtEnters <= 3);

        if (connectionStatus == classAccountDB.enLogIn.eCorrect)
            return toReturn;
        else
            return null;
    }


    private static void meetUpUser(Account account)
    {
        System.out.print("\n\n\n\n");
        System.out.println("Приветствуем вас!");
    }


    public static void main(String args[])
    {
        Account userAccount;
        if ((userAccount = userConnectedAccount()) != null)
        {
            meetUpUser(userAccount);
        }

    }
}
