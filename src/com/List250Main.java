

/*@
 * The tests should confirm:
 * 1. The Top 250 (http://www.imdb.com/chart/top) page returns at least 1 movie​, in the list.
 */

package com;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;


public class List250Main {
	
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException  {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://www.imdb.com/chart/top");
			
			WebElement top250list = driver.findElement(By.className("lister-list"));
			List<WebElement> rows = top250list.findElements(By.tagName("tr"));
			//System.out.println("Total value of the chart: "+rows.size());
			if(rows.size() == 0)
			{
				System.out.println("No movie found.");
			}
			if(rows.size() > 0)
			{
				System.out.println("At least one movie found in IMDB Top 250 Chart");
			}
			
			driver.quit();
		
	}

}
