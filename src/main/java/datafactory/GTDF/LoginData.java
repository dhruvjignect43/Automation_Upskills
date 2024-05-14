package datafactory.GTDF;

import dataobjects.GTDO.loginUser;
import utilities.JavaHelpers;

public class LoginData {

    loginUser loginUserData = new loginUser();
    loginUser invalidLoginData = new loginUser();


    public loginUser login() {
        loginUserData.setPlayerName("u66813399");
        loginUserData.setLoginPassword("welcome1!@");
        return loginUserData;
    }

    public loginUser invalidLogin() {
        String timeStamp = new JavaHelpers().timeStamp();
        invalidLoginData.setPlayerName(timeStamp + "ccsd");
        invalidLoginData.setLoginPassword(timeStamp + "csdjcn");
        return invalidLoginData;
    }
}
