import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject{

    private final String USERNAME = "standard_user";
    private final String PASSWORD = "secret_sauce";

    private final String USERNAMENOTEXIST = "standard";
    private final String PASSWORDNOTEXIST = "secret";

    @FindBy(id = "user-name")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement login_button;

    @FindBy(xpath = "//h3[@data-test= 'error']")
    private WebElement login_error;

    @FindBy(xpath = "//div[@class= 'login_password']/h4")
    private WebElement passwordAllLabel;



    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public void enterUserName(){
        this.username.sendKeys(USERNAME);
    }
    public void enterPassword(){
        this.password.sendKeys(PASSWORD);
    }

    public void enterUserNameNotExist(){
        this.username.sendKeys(USERNAMENOTEXIST);
    }
    public void enterPasswordNotExist(){
        this.password.sendKeys(PASSWORDNOTEXIST);
    }

    public void pressLoginButton(){
        this.login_button.click();
    }

    public String getPassworAllLabel(){
        return this.passwordAllLabel.getText();
    }

    public String getErrorMsgLogin(){
        return this.login_error.getText();
    }

}
