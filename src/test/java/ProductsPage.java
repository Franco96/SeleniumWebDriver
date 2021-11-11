import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends PageObject{

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    private WebElement products_label;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCart_SauceBackpack;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cart_badge;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement navBar_button;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout_button;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cart_button;

    @FindBy(xpath = "//a[@id='item_4_title_link']/div")
    private WebElement backPacklabel;


    public ProductsPage(WebDriver driver) {
        super(driver);
    }



    public String getTitle(){

        return this.products_label.getText();
    }

    public void addToCartSauceBackpack(){

        this.addToCart_SauceBackpack.click();
    }

    public String getCardBadge(){
        return this.cart_badge.getText();
    }

    public void pressLogoutButton(){
        this.logout_button.click();
    }

    public void pressNavBarButton(){
        this.navBar_button.click();
    }

    public void pressCartButton(){
        this.cart_button.click();
    }

    public String getBackPackLabel(){
        return this.backPacklabel.getText();
    }
}
