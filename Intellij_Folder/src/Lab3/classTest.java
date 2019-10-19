////desctription:
// 0 - correct;
// 1 - not found;
// 2 - wrong password
////
////
////
package Lab3;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class classTest {
    public static final String TEST_ANS_CORRECT = "Верные данные",
            TEST_ANS_NOT_FOUND = "Аккаунт не найден",
            TEST_ANS_WRONG_PASSWORD = "Неверный пароль";
    private Scanner MyScanner;
    private static int AnsCorrectID = 0, AnsNotFound = 1, AnsWrongPassword = 2;
    // identeficator of test answer (0, 1 or 2)
    private static int MyAnsID = 0;
    private static final String FILE_TEST_NAME = "test_3.txt";
    private static final String ACCOUNT_DIVIDER = ":";
    private classAccountDB.enLogIn connectType = classAccountDB.enLogIn.eCorrect;


    public boolean Is_Not_Finished() {
        return MyScanner.hasNext();
    }


    public classAccountDB.enLogIn Get_Supposed_Status()
    {
        return connectType;
    }



    public static String Ans_According_To_ID(classAccountDB.enLogIn eConnection) //returns russian name of supposed test answer
    {
        switch (eConnection) {
            case eCorrect:
                return TEST_ANS_CORRECT;
            case eErrorNotFound:
                return TEST_ANS_NOT_FOUND;
            case eErrorWrongPassword:
                return TEST_ANS_WRONG_PASSWORD;
            default:
                return "";
        }
    }


    public Account Next_Test() throws Exception {
        String line = MyScanner.nextLine();

        String[] lineParts = line.split(" ");
        MyAnsID = Integer.parseInt(lineParts[0]);

        switch (MyAnsID) {
            case 0: //correct
                connectType = classAccountDB.enLogIn.eCorrect;
                break;
            case 1: //not found
                connectType = classAccountDB.enLogIn.eErrorNotFound;
                break;
            case 2: //wrong pas
                connectType = classAccountDB.enLogIn.eErrorWrongPassword;
                break;
        }

        String[] accountParts = lineParts[1].split(ACCOUNT_DIVIDER);
        return new Account(accountParts[0], accountParts[1]);
    }


    public classTest() throws FileNotFoundException {
        File testFile = new File(FILE_TEST_NAME);
        MyScanner = new Scanner(testFile);
    }

}
