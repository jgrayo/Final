package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException
	{
		
		ArrayList<RateDomainModel> RDMList = RateDAL.getAllRates();
		
		double varRate = 0;
		for(int x = 0; x<RDMList.size(); x++){
			if(GivenCreditScore >= RDMList.get(x).getiMinCreditScore()){
				varRate = 0.01*RDMList.get(x).getdInterestRate();
			}
		}
		  
		if(varRate == 0){
			RateException noRate = new RateException(null);
			return 0; 
		}
		return varRate;
		
	}
	
	
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
