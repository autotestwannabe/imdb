/*@
 * The tests should confirm:
 * 3. The Top 250 page shows at least 1 movie when Western Genre selected.
 */

package com;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ListGenre {
	
	public static void main(String args[])
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("http://www.imdb.com/chart/top");
		driver.findElement(By.linkText("Western")).click();
		
		WebElement list250Genre = driver.findElement(By.className("results"));
		List<WebElement> rows = list250Genre.findElements(By.tagName("tr"));
		//System.out.println(rows.size());
		if(rows.size() == 0)
		{
			System.out.println("No movie returned in Western Genre");
		} else 
			if(rows.size() > 0)
			{
				System.out.println("At least 1 movie returned in Western Genre");
			}		
	
		driver.quit();
	}

}
