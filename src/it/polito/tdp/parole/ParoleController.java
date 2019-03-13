package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.Parole2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtTimes;

    @FXML
    void doInsert(ActionEvent event) {
    	String parolaInserita = txtParola.getText();
    	
    	parolaInserita = parolaInserita.trim();
    	
    	if(parolaInserita.length()>0) {
    		long inizio = System.nanoTime();
    		elenco.addParola(parolaInserita);
    		txtParola.clear();
        	txtResult.clear();
        	for(String p : elenco.getElenco()) {
        		txtResult.appendText(p);
        		txtResult.appendText("\n");
        	}
        	double seconds = (double)((System.nanoTime()-inizio)/1_000_000_000.0);
        	txtTimes.appendText("Inserisci: "+seconds+" secondi\n");
    	}
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	long inizio = System.nanoTime();
    	elenco.reset();
    	txtResult.clear();
    	double seconds = (double)((System.nanoTime()-inizio)/1_000_000_000.0);
    	txtTimes.appendText("Reset: "+seconds+" secondi\n");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	long inizio = System.nanoTime();
    	String parolaDaCancellare = txtResult.getSelectedText();
    	elenco.eliminaParola(parolaDaCancellare);
    	
    	txtResult.clear();
    	for(String p : elenco.getElenco()) {
    		txtResult.appendText(p);
    		txtResult.appendText("\n");
    	}
    	double seconds = (double)((System.nanoTime()-inizio)/1_000_000_000.0);
    	txtTimes.appendText("Cancella: "+seconds+" secondi\n");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";

        elenco = new Parole() ;
        
    }
}
