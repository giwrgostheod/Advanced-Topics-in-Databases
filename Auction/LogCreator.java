//package AuctionHouse;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogCreator {
	
	public Logger logger;
	public LogCreator(String logFile) throws SecurityException, IOException{
		logger = Logger.getLogger("MyLog");
		FileHandler fhandler = new FileHandler("/home/george/Desktop/logs/"+logFile);
		logger.addHandler(fhandler);
		logger.setUseParentHandlers(false);
		SimpleFormatter formatter = new SimpleFormatter();  
		fhandler.setFormatter(formatter);
	}
	
	public Logger returnLogger(){
		return this.logger;
	}
}
