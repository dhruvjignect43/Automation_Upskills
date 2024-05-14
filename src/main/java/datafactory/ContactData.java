package datafactory;

import dataobjects.contactUs;
import utilities.JavaHelpers;

public class contactData {
    public static contactUs contactusData(){

        contactUs contactusdata = new contactUs();
        String timeStamp = new JavaHelpers().timeStamp();
        contactusdata.setName("Joe");
        contactusdata.setEmail(timeStamp+"@mailinator.com");
        contactusdata.setSubject(timeStamp+"nothing");
        contactusdata.setMessage("nothing");
        return contactusdata;
    }
}
