package sstoftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.jibble.simpleftp.*;

public class SStoFTP {

	static WebDriver Driver;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Go to some where to take screenshot
//		Driver = new FirefoxDriver();
//		String BaseUrl = "http://www.bing.com/";
//		Driver.get(BaseUrl);
		
		//Using our method
		FTPscreenshots("asd1", "zxc");
		
		//Close screenshot source 
//		Driver.close();
	}
	
	
	public static void FTPscreenshots(String filename, String ftpfolder) {

		String username = "testuser";
		String password = "qwerty";
		
		FTPClient client = new FTPClient();
				
		try {
//			client.connect("127.0.0.1", 21);
//			client.login(username, password);
				
			//File ftpfile = new File(filename +".png");
//			File ssf = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
//			File localfile = new File(filename+"xxx.png");
//			FileUtils.copyFile(ssf, localfile, true);
//						
//			InputStream inputStream = new FileInputStream(localfile);
//			
//						
//			String ftpaddr = filename+".png";
//			client.storeFile(ftpaddr, inputStream);
			
//			String file = "55555.jpg";
//			File localfive = new File(file);
//			InputStream inputfive = new FileInputStream(localfive);
//			
//			client.storeFile(file, inputfive);	
		
			
			SimpleFTP ftp = new SimpleFTP();
			ftp.connect("127.0.0.1", 21, "username", "password");
			ftp.stor(new File("avatar.jpg"));
			
			//http://www.jibble.org/simpleftp/
								
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
		
	
        
        
       
	}
	

}
