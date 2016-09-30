//package AuctionHouse;

import java.io.IOException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServerLauncher {
	static final int ServerPort1 = 6666;
	static final int ServerPort2 = 6667;
	static final int ServerPort3 = 6668;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		String confFile = getConfFile(args);
		if (confFile == null) 
			return;
		
		Lock lock = new ReentrantLock();
		Subject syncObject = new Subject();
		CyclicBarrier barrier = new CyclicBarrier(3);		
		
		Auctioneer Server1 = new Auctioneer(ServerPort1,syncObject,"Server1",barrier,confFile,lock);
		Thread t1 = new Thread(Server1);
        t1.start();
		Auctioneer Server2 = new Auctioneer(ServerPort2,syncObject,"Server2",barrier,confFile,lock);
		Thread t2 = new Thread(Server2);
        t2.start();
		Auctioneer Server3 = new Auctioneer(ServerPort3,syncObject,"Server3",barrier,confFile,lock);
		Thread t3 = new Thread(Server3);
        t3.start();
	}
	
	private static String getConfFile(String[] args)
	{
		if (args.length != 1) {
			System.out.println("Usage: java ServerLauncher <configuration file>");
			return null;
		} else {
			return args[0];
		}
	}

}
