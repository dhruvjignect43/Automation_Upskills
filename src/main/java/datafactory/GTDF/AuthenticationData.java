package datafactory.GTDF;

import dataobjects.GTDO.authentication;

public class AuthenticationData {

    authentication authenticationData = new authentication();

    public authentication authUser() {

        authenticationData.setUsername("admin");
        authenticationData.setPassword("matrix4215");
        return authenticationData;
    }
}