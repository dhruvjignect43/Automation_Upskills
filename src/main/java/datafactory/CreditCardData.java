package datafactory;

import dataobjects.creditCardDetails;
import utilities.Constants;

public class CreditCardData {
    public static creditCardDetails creditCardDetailsData(){

        creditCardDetails creditCardData = new creditCardDetails();
        creditCardData.setNameOnCard(Constants.NameOnCard);
        creditCardData.setCardNumber(Constants.CardNumber);
        creditCardData.setCvc(Constants.CVC);
        creditCardData.setExpiration(Constants.Expiration);
        return creditCardData;
    }

}
