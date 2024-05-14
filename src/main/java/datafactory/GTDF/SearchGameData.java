package datafactory.GTDF;

import dataobjects.GTDO.search;

public class SearchGameData {

    search searchData = new search();

    public search nameOfGame() {

        searchData.setSearchGame("Crystal ball");
        return searchData;
    }
}
