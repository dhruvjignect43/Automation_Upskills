package datafactory.GTDF;

import dataobjects.GTDO.phone;
import utilities.JavaHelpers;

public class PhoneNumberData {

    phone phoneData = new phone();

    public phone validPhoneNum(){
        JavaHelpers javaHelpers = new JavaHelpers();
        phoneData.setPhoneNum(javaHelpers.getRandomNumbers(12));
        return phoneData;
    }
}
