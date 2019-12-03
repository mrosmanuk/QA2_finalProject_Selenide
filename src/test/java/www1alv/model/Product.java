package www1alv.model;

public class Product {
    private static String productName;
    private static String productPrice;
    private static String productNameBeforeCheckout;
    private static String productPriceBeforeCheckout;

    public static String getProductName() {
        return productName;
    }

    public static void setProductName(String productName) {
        Product.productName = productName;
    }

    public static String getProductPrice() {
        return productPrice;
    }

    public static void setProductPrice(String productPrice) {
        Product.productPrice = productPrice;
    }

    public static String getProductNameBeforeCheckout() {
        return productNameBeforeCheckout;
    }

    public void setProductNameBeforeCheckout(String productNameBeforeCheckout) {
        Product.productNameBeforeCheckout = productNameBeforeCheckout;
    }

    public static String getProductPriceBeforeCheckout() {
        return productPriceBeforeCheckout;
    }

    public void setProductPriceBeforeCheckout(String productPriceBeforeCheckout) {
        Product.productPriceBeforeCheckout = productPriceBeforeCheckout;
    }
}
