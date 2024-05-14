package datafactory.GTDF;

import dataobjects.GTDO.inviteEmail;
import utilities.JavaHelpers;

public class InviteEmailData {

    inviteEmail inviteEmailData = new inviteEmail();

    public inviteEmail validEmail() {

        inviteEmailData.setEmail("shardul@Mailinator.com");
        return inviteEmailData;
    }

    public inviteEmail inValidEmail() {
        String timeStamp = new JavaHelpers().timeStamp();
        inviteEmailData.setEmail(timeStamp + "mailinator.com");
        return inviteEmailData;
    }
}
