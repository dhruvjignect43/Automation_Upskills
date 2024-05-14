package datafactory;

import dataobjects.product;
import utilities.JavaHelpers;

public class ProductData {
    public static product productData(){
        product productdata = new product();
        String timeStamp = new JavaHelpers().timeStamp();
        String javaHelper = new JavaHelpers().getRandomNumbers(2);

        productdata.setSearchText(timeStamp+"red");
        productdata.setProductText("Blue Top");
        productdata.setEmptyText("Cart is empty!");
        productdata.setOrderText("ORDER PLACED!");
        productdata.setWomenText("WOMEN - DRESS PRODUCTS");
        productdata.setSearchValidText("Blue Top");
        productdata.setProductQty(javaHelper);
        return productdata;
    }
}
