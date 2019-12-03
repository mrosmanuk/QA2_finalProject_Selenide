package www1alv.steps;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import www1alv.model.Product;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Productpage {

    private By price = byXpath("//div[@data-sell-price-w-vat]");
    private By productName = byXpath("//div[@class='product-main-info']/h1");
    private By placeToCart = byXpath("//*[@id='add_product_to_shopping_cart_button_top']");
    private By cartLink = byXpath("//*[@id='shopping_cart_container']/a");

    @And("I fetch and save product price and name")
    public void productPriceAndName(){
       Product.setProductPrice($(price).getAttribute("data-sell-price-w-vat"));
       System.out.println(Product.getProductPrice());
       Product.setProductName($(productName).getText());
       System.out.println(Product.getProductName());}

    @And("I place product to cart and navigate to cart")
    public void addProductToCartAndNavigateToCart() throws InterruptedException {
        $(placeToCart).click();
        Thread.sleep(2000);
        $(cartLink).click();}
}
