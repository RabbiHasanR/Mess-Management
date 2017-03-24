package com.project.mess2;

public  class AccountCalculation {
	static double flatRant;
	static double eatCost;
	static double currentBill;
	static double maidCost;
	static double othersCost;
	public AccountCalculation(double flatRant ,double eatCost,double currentBill,double maidCost,double othersCost){
		AccountCalculation.flatRant=flatRant;
		AccountCalculation.eatCost=eatCost;
		AccountCalculation.currentBill=currentBill;
		AccountCalculation.maidCost=maidCost;
		AccountCalculation.othersCost=othersCost;
		
	}
	
	public static double calcultion(){
		double total=flatRant+eatCost+currentBill+maidCost+othersCost;
		return total;
	}

}
