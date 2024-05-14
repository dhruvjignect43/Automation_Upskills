package dataobjects;

public class product {
    private String searchText;
    private String productText;
    private String emptyText;
    private String productQty;
    private String searchValidText;
    private String womenText;
    private String orderText;

    public String getProductQty() {
        return productQty;
    }

    public void setProductQty(String productQty) {
        this.productQty = productQty;
    }

    public String getSearchValidText() {
        return searchValidText;
    }

    public void setSearchValidText(String searchValidText) {
        this.searchValidText = searchValidText;
    }

    public String getWomenText() {
        return womenText;
    }

    public void setWomenText(String womenText) {
        this.womenText = womenText;
    }

    public String getOrderText() {
        return orderText;
    }

    public void setOrderText(String orderText) {
        this.orderText = orderText;
    }

    public String getEmptyText() {
        return emptyText;
    }

    public void setEmptyText(String emptyText) {
        this.emptyText = emptyText;
    }

    public String getProductText() {
        return productText;
    }

    public void setProductText(String productText) {
        this.productText = productText;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
