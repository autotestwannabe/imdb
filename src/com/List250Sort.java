/*@
 * The tests should confirm:
 * 2. The Top 250 page shows at least 1 movie for for each Options in the Sort By dropdown.
 */

package com;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;



public class List250Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("http://www.imdb.com/chart/top");
		
//		WebElement sortBy = driver.findElement(By.className("lister-sort-by"));
//		List<WebElement> rows = sortBy.findElements(By.tagName("option"));
//		System.out.println("Total value of the chart: "+rows.size());
//		//Select item = new Select(sortBy);
//	    //List<WebElement> options = item.Options;
//		java.util.Iterator<WebElement> i = rows.iterator();
//		 for(WebElement element: sortBy)  
//		    {
//		        String var2 = tdElement.getText();
//		        System.out.println(var2);
//		    }
		 
		 WebElement list250 = driver.findElement(By.className("lister-list"));
		 WebElement sortBy = driver.findElement(By.className("lister-sort-by"));
		 List<WebElement> lists = sortBy.findElements(By.tagName("option"));
		 
		     for(WebElement element: lists)  
		     {
		    	 
		    	 element.click();
		    	 List<WebElement> rows = list250.findElements(By.tagName("tr"));
		         //System.out.println(rows.size());
		    	 if(rows.size() == 0)
		    	 {
		    		 System.out.println("No movie returned in Sort by" +element.getText() +" option.");
		    	 }  
		    	 
		    	 if(rows.size() > 0)
		    	 {
		    		 System.out.println("At least 1 movie returned in Sort by " +element.getText() +" option.");
		    	 }  
		         
		         
		     }

		     driver.quit();

	}

}
