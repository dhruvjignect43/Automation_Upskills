package datafactory;

import dataobjects.registerUser;
import utilities.JavaHelpers;

public class LoginRegisterData {
 public static registerUser getAccountInfoTextData(){

     registerUser registerUserData = new registerUser();
     String timeStamp = new JavaHelpers().timeStamp();
     String zipCode =  new JavaHelpers().getRandomNumbers(6);
     String mobileNum =  new JavaHelpers().getRandomNumbers(10);

     registerUserData.setAccountInfoText("Enter Account Information");
     registerUserData.setPassword("Password@123");
     registerUserData.setFirstName(timeStamp+"Joe");
     registerUserData.setLastName(timeStamp+"Doe");
     registerUserData.setCompany(timeStamp+"joedoe technology pvt.ltd");
     registerUserData.setAddress1(timeStamp+"13, J S Tower, Opp Veena Sargam,dhanukar Wadi");
     registerUserData.setAddress2(timeStamp+"Kandivali (west)");
     registerUserData.setState(timeStamp+"Maharastra");
     registerUserData.setCity(timeStamp+"Mumbai");
     registerUserData.setZipCode(zipCode);
     registerUserData.setMobileNumber("+91"+mobileNum);
     registerUserData.setAccountCreated("ACCOUNT CREATED!");
     return registerUserData;
 }
}
