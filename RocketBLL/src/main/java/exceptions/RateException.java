package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

private RateDomainModel rdm;
	
	public RateException(RateDomainModel rateDM){
		rdm = rateDM;
	}
	
	public RateDomainModel getRDM(){
		return rdm;
	}
} 