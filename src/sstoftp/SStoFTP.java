package sstoftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Iterator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpDirEntry;
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
		FTPscreenshots("asd1", "zxc1");
		
		//Close screenshot source 
		Driver.close();
	}
	
	public static void FTPscreenshots(String filename, String ftpfolder) {

		String username = "testuser";
		String password = "qwerty";
				
		try {
			
			FtpClient fc = FtpClient.create();
			SocketAddress addr = new InetSocketAddress("127.0.0.1", 21);
			fc.connect(addr);
			fc.login(username, password.toCharArray());
			
			File ssf = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
			InputStream fis = new FileInputStream(ssf);
			
			Iterator it = fc.listFiles("/"); 
			
			FtpDirEntry dir;
			boolean bool = false;
			
			while (it.hasNext() ) {
				dir = (FtpDirEntry) it.next();
				if (dir.getName().compareTo(ftpfolder) == 0)
					bool = true;
			};
			
			if (bool == false)
				fc.makeDirectory(ftpfolder);
						
			fc.putFile(ftpfolder + "/" + filename+".png", fis);
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (FtpProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
	}
	

}
