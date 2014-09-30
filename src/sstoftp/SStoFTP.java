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
		
	//Go to some where to take screenshot
		Driver = new FirefoxDriver();
		String BaseUrl = "http://www.bing.com/";
		Driver.get(BaseUrl);
		
	//Using our method
		FTPscreenshots("asd_filename", "qqq/fff/zxc/abc");
		
	//Close screenshot source 
		Driver.close();
		
		}
	
	public static void FTPscreenshots(String filename, String ftpfolder) {

		String username = "testuser";
		String password = "qwerty";
		String ftpAddr = "127.0.0.1";
		int ftpPort = 21;
				
		try {
	// Connection to FTP
			FtpClient fc = FtpClient.create();
			SocketAddress addr = new InetSocketAddress(ftpAddr, ftpPort);
			fc.connect(addr);
			fc.login(username, password.toCharArray());
			
	//Taking screenshot
			File ssf = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
			InputStream fis = new FileInputStream(ssf);
			
	// Path analyse, create and go into ftp directory
			
			String[] way =  ftpfolder.split("[/]");
			
			boolean dirExists = false;
			FtpDirEntry dir;
			Iterator <FtpDirEntry> it;
			String currentDir = "/";
			
			for (int i=0; i<way.length; i++)
			{
				
				it = fc.listFiles(currentDir);
								
				dirExists = false;
				
				while (it.hasNext() ) {
					dir = (FtpDirEntry)it.next();
					if (dir.getName().compareTo(way[i]) == 0)
						dirExists = true;
				};
				
				if (dirExists == false)
					fc.makeDirectory(way[i]);
			
				fc.changeDirectory(way[i]);
				currentDir += "/" + way[i];
				
			}	
			
	//Put screenshot to folder on ftp
			
			fc.putFile(filename + ".png", fis);
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (FtpProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}
	
	static void gotoFolder(String path) {
		
		String[] way =  path.split("[/]");
		for (int i=0; i<way.length; i++)
		{
			System.out.println(way[i]);
		}
	}

}
