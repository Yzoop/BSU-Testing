package Lab3;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class classAccountDB {
    private static HashMap<String, Account> HM_LoginPassword;
    private static final String FILE_NAME = "accounts.txt";
    private static final String ERROR_DB_NOT_INITILIZED = "Ошибка: база аккаунтов не иницилизирована";
    private static final String ERROR_FILE_READING = "Ошибка: невозможно прочитать базу аккаунтов";
    private static final String FILE_END = "#end";
    private static final String FILE_ACCOUNT_DIVIDER = "---";
    private static final String FILE_ACCOUNT_LOG = "LOG";
    private static final String FILE_ACCOUNT_PAS = "PAS";

    private static boolean IsAccountDBInitalized = false;

    enum enLogIn
    {
        eCorrect,
        eErrorNotFound,
        eErrorWrongPassword
    }

    public void Read_Account_DB()
    {
        try {
            File file = new File(FILE_NAME);
            Scanner in = new Scanner(file);
            String Line;
            String CurrentLogin = "", CurrentPassword = "";
            while ((in.hasNext()))
            {
                Line = in.nextLine();
                if (!Line.equals(FILE_ACCOUNT_DIVIDER))
                {
                    if (Line.contains(FILE_ACCOUNT_LOG))
                    {
                        CurrentLogin = Line.substring(Line.indexOf(':') + 1);
                    }
                    else if (Line.contains(FILE_ACCOUNT_PAS))
                    {
                        CurrentPassword = Line.substring(Line.indexOf(':') + 1);
                    }
                }
                else //if divider faced
                {
                    HM_LoginPassword.put(CurrentLogin, new Account(CurrentLogin, CurrentPassword));
                    System.out.printf("'%s' : '%s'\n", CurrentLogin, CurrentPassword);
                }
            }

            IsAccountDBInitalized = true;
        }
        catch (Exception ex)
        {
            System.out.println(ERROR_FILE_READING);
        }
    }


    public enLogIn connect(final Account account) throws Exception {
        if (IsAccountDBInitalized) {
            if (HM_LoginPassword.containsKey(account.Get_Log())) {
                //if (MyPassword of Account with _login) == _password
                if ((HM_LoginPassword.get(account.Get_Log()).Get_Pas()).equals(account.Get_Pas())) {
                    return enLogIn.eCorrect;
                } else //wrong password
                {
                    return enLogIn.eErrorWrongPassword;
                }
            }
            else //not found account with _login
            {
                return enLogIn.eErrorNotFound;
            }
        }
        else {
            throw new Exception(ERROR_DB_NOT_INITILIZED);

        }
    }


    public classAccountDB()
    {
        HM_LoginPassword = new HashMap<String, Account>();
    }

}
