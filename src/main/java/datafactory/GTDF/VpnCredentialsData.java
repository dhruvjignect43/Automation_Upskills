package datafactory.GTDF;

import dataobjects.GTDO.authentication;
import utilities.JavaHelpers;

public class VpnCredentialsData {

    authentication vpnAuthData = new authentication();

    public authentication validVPN(){
        vpnAuthData.setUsername("mmeza");
        vpnAuthData.setPassword("GTvpn2022");
        return vpnAuthData;
    }
    public authentication inValidVPN(){
        String timeStamp = new JavaHelpers().timeStamp();
        vpnAuthData.setUsername(timeStamp);
        vpnAuthData.setPassword(timeStamp);
        return vpnAuthData;
    }
}
