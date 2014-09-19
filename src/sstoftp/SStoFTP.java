package sstoftp;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

public class SStoFTP {

	static WebDriver Driver;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Go to some where to take screenshot
		Driver = new FirefoxDriver();
		String BaseUrl = "http://www.bing.com/";
		Driver.get(BaseUrl);
		
		//Using our method
		FTPscreenshots("asd1", "zxc");
		
		//Close screenshot source 
		Driver.close();
	}
	
	
	public static void FTPscreenshots(String filename, String ftpfolder) {

		String username = "username";
		String password = "password";
		
		FTPClient client = new FTPClient();
				
		try {
			client.connect("someftp.com", 8080);
			client.login(username, password);
			
			File ftpfile = new File(client.getPassiveHost() + "/" + filename +".png");
			File ssfile = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(ssfile, ftpfile, true);
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
		
		File ssf = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
        try {
			FileUtils.copyFile(ssf, new File(filename+".png"), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
       
	}
	

}
