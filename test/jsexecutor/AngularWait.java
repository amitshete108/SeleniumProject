package jsexecutor;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

//Wait for Angular Load
    
public class AngularWait {
WebDriverWait wait;
public void waitForAngularLoad(WebDriver driver) {
	wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

        //Wait for ANGULAR to load
        ExpectedCondition<Boolean> angularLoad = driver1 -> Boolean.valueOf(((JavascriptExecutor) driver1)
                .executeScript(angularReadyScript).toString());

        //Get Angular is Ready
        boolean angularReady = Boolean.valueOf(jsExecutor.executeScript(angularReadyScript).toString());

        //Wait ANGULAR until it is Ready!
        if(!angularReady) {
            System.out.println("ANGULAR is NOT Ready!");
            //Wait for Angular to load
            wait.until(angularLoad);
        } else {
            System.out.println("ANGULAR is Ready!");
        }
    }

    //Wait Until JS Ready
    public  void waitUntilJSReady(WebDriver driver) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    	wait = new WebDriverWait(driver,Duration.ofSeconds(20)); 	
        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver1 -> ((JavascriptExecutor)driver1)
                .executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady =  (Boolean) jsExecutor.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if(!jsReady) {
            System.out.println("JS in NOT Ready!");
            //Wait for Javascript to load
            wait.until(jsLoad);
        } else {
            System.out.println("JS is Ready!");
        }
    }

    //Wait Until JQuery and JS Ready
    public void waitUntilJQueryReady(WebDriver driver) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //First check that JQuery is defined on the page. If it is, then wait AJAX
        Boolean jQueryDefined = (Boolean) jsExecutor.executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined == true) {
            //Pre Wait for stability (Optional)
        //    sleep(20);

            //Wait JQuery Load
            waitForJQueryLoad(driver);

            //Wait JS Load
            waitUntilJSReady(driver);

            //Post Wait for stability (Optional)
         //   sleep(20);
        }  else {
            System.out.println("jQuery is not defined on this site!");
        }
    }
    
    public void waitForJQueryLoad(WebDriver driver) {
       	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = driver1 -> ((Long)jsExecutor.executeScript("return jQuery.active") == 0);
     	wait = new WebDriverWait(driver,Duration.ofSeconds(20)); 	
        
        //Get JQuery is Ready
        boolean jqueryReady = (Boolean) jsExecutor.executeScript("return jQuery.active==0");

        //Wait JQuery until it is Ready!
        if(!jqueryReady) {
            System.out.println("JQuery is NOT Ready!");
            //Wait for jQuery to load
            wait.until(jQueryLoad);
        } else {
            System.out.println("JQuery is Ready!");
        }
    }
}