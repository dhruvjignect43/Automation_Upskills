package datafactory.GTDF;

import dataobjects.GTDO.limit;

public class LimitData {

    limit limitData = new limit();

    public limit depositLimit() {
        limitData.setLimits("50");
        limitData.setDepositLimit("20");
        return limitData;
    }
}
