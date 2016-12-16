package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			double rate = 0;
			try{
				rate = RateBLL.getRate(lq.getiCreditScore());
			}
			catch(RateException e){
				System.out.println(e.getLocalizedMessage());
			}
			
			double payment = RateBLL.getPayment(rate, lq.getiTerm(), lq.getiDownPayment(), 0, true);
			
			lq.setdPayment(payment);
			
			sendToAll(lq);
		}
	}
}
