package jsexecutor;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.JavascriptExecutor;

public class WebElementExtender {
	
   public static void setAttribute(WebElement element, String attributeName, String value)
   {
       WrapsDriver wrappedElement = (WrapsDriver) element;
       
       JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
       driver.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, attributeName, value);
   }//element.setAttribute(attributeName,value)
   
   public static void highlightElement(WebElement element, WebDriver driver) {
	    for (int i = 0; i < 5; i++) {
	    	//int i;
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
	                element, "color: green; border: 5px solid green;");
	    	/*driver.executeScript("arguments[0].setAttribute(arguments[2], arguments[1]);",
	                element, "color: green; border: 2px solid green;","style");*/
	    	//element.setAttribute('style',"color: green; border: 2px solid green;");
	    	try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	//element.setAttribute('style',"color: green;border: 2px solid green;"
	    	js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
	                element, "");
	    	try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
   
   public static File captureElementBitmap(WebElement element) throws Exception {   

	//Get the WrapsDriver of the WebElement    
   	WrapsDriver wrapsDriver = (WrapsDriver) element;
   	
   	//Get the entire Screenshot from the driver of passed WebElement
   	File screen = ((TakesScreenshot)  wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
   	
   	//Create an instance of Buffered Image from captured screenshot
   	BufferedImage img = ImageIO.read(screen);
   	
   	// Get the Width and Height of the WebElement using getSize() 
   	int width = element.getSize().getWidth();
    int height = element.getSize().getHeight();

    //Create a rectangle using Width and Height
    Rectangle rect = new Rectangle(width, height);
    
    //Get the Location of WebElement in a Point. 
    //This will provide X & Y co-ordinates of the WebElement
    Point p = element.getLocation();
    
    //Create image by for element using its location and size. 
    //This will give image data specific to the WebElement
    BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width,         
                                          rect.height);
    
    //Write back the image data for element in File object
    ImageIO.write(dest, "png", screen);
    
    //Return the File object containing image data
    return screen;
   }
}
