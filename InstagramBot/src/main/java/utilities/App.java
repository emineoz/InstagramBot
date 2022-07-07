package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {


    WebDriver driver;
    String base_url = "https://www.instagram.com/";
    By usernamelocater = new By.ByCssSelector("input[name='username']");
    By passwordlocater = new By.ByCssSelector("input[name='password']");
    By loginloater = new By.ByCssSelector("button[type='submit']");
    By instagramlogolocater = By.className("s4Iyt");
    By elifpost=By.className("_9AhH0");
    By elifprofil=By.className("XBGH5");
    By likebutton=new By.ByCssSelector("span.fr66n");
    By htmltag=By.tagName("html");
    By elifpostsayısı=By.className("g47SY");

    //By aramabutton=By.className("XTCLo d_djL DljaH");
    public App() {

        // public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(base_url);
        driver.manage().window().maximize();

    }

    public void loginwith(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernamelocater));
        driver.findElement(usernamelocater).sendKeys(username);
        driver.findElement(passwordlocater).sendKeys(password);
        driver.findElement(loginloater).click();

    }

    public void profilegit(String profilname) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(instagramlogolocater));
        driver.navigate().to(base_url.concat(profilname));


    }
       public void clickpost(){
           WebDriverWait wait = new WebDriverWait(driver, 15);
           wait.until(ExpectedConditions.visibilityOfElementLocated(elifprofil));
           driver.findElements(elifpost).get(0).click();

        }
        public void likeallpost(){
        int postcount=postsayısı();

        while(postcount>0){


            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(likebutton));
            driver.findElement(likebutton).click();
            driver.findElement(htmltag).sendKeys(Keys.ARROW_RIGHT);

            postcount --;


        }

        }

        private int postsayısı(){
        String count=driver.findElement(elifpostsayısı).getText();
        return Integer.parseInt(count);


        }


    }


