package rocket.app.view;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;
import exceptions.RateException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;


public class MortgageController {

	private MainApp mainApp;
	 
	// RocketClient.RocketMainController
	
	//	Create private instance variables for:
	@FXML 
	 private TextField txtIncome;
	//	TextBox  - 	txtIncome
	@FXML 
	private TextField txtExpenses;
	//		TextBox  - 	txtExpenses
	private TextField txtCreditScore;
	//		TextBox  - 	txtCreditScore
	private TextField txtHouseCost;
	//		TextBox  - 	txtHouseCost
	private ComboBox cmbTerm;
	//		ComboBox -	loan term... 15 year or 30 year
	private Label lblMortgagePayment;
	private Label lblIncome;
	private Label lblExpenses;
	private Label lblCreditScore;
	private Label lblHouseCost;
	//		Labels   -  various labels for the controls
	private Button calcPayment;
	//		Button   -  button to calculate the loan payment
	private Label lblShowError;
	//		Label    -  to show error messages (exception throw, payment exception)

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		//			RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq

		a.setLoanRequest(lq);
		lq.setdIncome(Integer.parseInt(txtIncome.getText()));
		lq.setdExpenses(Double.parseDouble(txtExpenses.getText()));
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		
		lq.setiTerm(Integer.parseInt((String) cmbTerm.getValue()));
		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
		
	
	}
}