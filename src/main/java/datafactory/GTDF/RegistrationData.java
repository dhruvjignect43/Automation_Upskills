package datafactory.GTDF;

import dataobjects.GTDO.register;
import utilities.JavaHelpers;

public class RegistrationData {

    register registerData = new register();


    public register validRegDetails() throws InterruptedException {
        JavaHelpers javaHelpers = new JavaHelpers();

        registerData.setFirstName(javaHelpers.generateRandomString(5, 10));
        registerData.setLastName(javaHelpers.generateRandomString(5, 10));
        registerData.setDob("22012002");
        registerData.setBirthName(javaHelpers.generateRandomString(5, 10));
        registerData.setPlaceOfBirth(javaHelpers.generateRandomString(5, 10));
        registerData.setTelephoneNum(javaHelpers.getRandomNumbers(8));
        registerData.setStreet("cdjbcdjs");
        registerData.setHouseNum("12B");
        registerData.setPostalCode(javaHelpers.getRandomNumbers(5));
        registerData.setCity("Berlin");
        registerData.setNickName(javaHelpers.generateRandomString(5, 10));
        registerData.setPlayerPassword(javaHelpers.generateRandomString(5, 7) + "@7534");
        registerData.setPlayerEmail("userss@greentube.com");
        registerData.setSecurityResponseTextBox(javaHelpers.generateRandomString(5, 7));
        registerData.setMonthlyDeposit(javaHelpers.getRandomNumbers(3));
        return registerData;
    }
}
