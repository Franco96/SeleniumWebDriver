import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {

    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver",Utils.CHROME_DRIVER_LOCATION);
    }



    @Test(testName = "Login Successfully")
    public static void loginSuccessfully(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUserName();
        loginForm.enterPassword();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductsPage products = new ProductsPage(driver);
        Assert.assertEquals(products.getTitle(),"PRODUCTS");

    }

    @Test(testName = "Add one item to cart")
    public static void verifyItemAdded(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUserName();
        loginForm.enterPassword();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductsPage products = new ProductsPage(driver);
        products.addToCartSauceBackpack();
        Assert.assertEquals(products.getCardBadge(),"1");
    }

    @Test(testName = "Login Error UserName and password not exist")
    public static void loginError(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUserNameNotExist();
        loginForm.enterPasswordNotExist();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Assert.assertEquals(loginForm.getErrorMsgLogin(),"Epic sadface: Username and password do not match any user in this service");
    }


    @Test(testName = "Logout Successfully")
    public static void LogoutSuccessfully(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUserName();
        loginForm.enterPassword();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        ProductsPage products = new ProductsPage(driver);
        products.pressNavBarButton();
        products.pressLogoutButton();

        Assert.assertEquals(loginForm.getPassworAllLabel(),"Password for all users:");
    }

    @Test(testName = "Verify Card Buy")
    public static void VerifyCardBuy(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUserName();
        loginForm.enterPassword();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        ProductsPage products = new ProductsPage(driver);
        products.addToCartSauceBackpack();
        products.pressCartButton();

        Assert.assertEquals(products.getBackPackLabel(),"Sauce Labs Backpack");
    }


    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
