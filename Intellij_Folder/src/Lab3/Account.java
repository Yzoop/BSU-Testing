package Lab3;

public class Account {
    public static final String ERROR_CREATE_ACCOUNT = "Ошибка: невозможно создать аккаунт";
    public static final int MAX_LOGIN_LENGTH = 10, MAX_PASSWORD_LENGTH = 8;
    private String MyLogin, MyPassword;


    public String Get_Log()
    {
        return MyLogin;
    }

    public String Get_Pas()
    {
        return MyPassword;
    }

    public Account(final String _login, final String _password)
    {
        if (_login.length() <= MAX_LOGIN_LENGTH && _password.length() <= MAX_PASSWORD_LENGTH) {
            MyLogin = _login;
            MyPassword = _password;
        }
        else
        {
            this.MyPassword = null;
            this.MyLogin = null;
        }
    }
}
