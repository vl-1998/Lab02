package it.polito.tdp.alien;

import java.net.URL;

import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	String parolaInserita;
	//Word nuovaParola;
	String parolaAliena;
	String traduzione;
	AlienDictionary dizionario;
	//List <String> elencoTraduzioni = new ArrayList <>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClear;
    
   @FXML
   public boolean check (String p) {
		boolean check = true;
		for (int i=0; i<p.length();i++) {
			if (!Character.isLetter(p.charAt(i)) && (p.charAt(i))!=(' ')){
				check=false;
			}
		}
		return check;
	}

    @FXML
    void doTranslate(ActionEvent event) {
    	txtResult.clear();
     
    	parolaInserita = txtWord.getText().toLowerCase();
    	
    	//Verificare che non sia vuoto
    	if (parolaInserita.length()==0) {
    		txtResult.clear();
    		txtResult.appendText("Inserire testo! \n");
    		txtWord.clear();
    		
    		return;
    	}
    	
    	//verifico non ci siano numeri
    	if (this.check(parolaInserita)==false) {
    		txtResult.clear();
    		txtResult.appendText("Inserire parola valida \n");
        	txtWord.clear();

    		return;
    	}    
    	
    	//verifico ci sia lo spazio e che non ho inserito piu 
    	for (int i=0; i<parolaInserita.length(); i++) {
    		char c= parolaInserita.charAt(i);
    		if (c==' ') {
    			StringTokenizer st = new StringTokenizer(parolaInserita, " ");
    				if (st.countTokens()>2) {
    					txtResult.appendText("Inserire una sola parola nella traduzione!");
    					txtWord.clear();
    					return;
    				}
    			
    	    	parolaAliena = st.nextToken();
    	    	traduzione= st.nextToken();
    	    	dizionario.addWord(parolaAliena, traduzione);
    	    	txtResult.appendText("Parola aggiunta correttamente nel dizionario! \n");
    	    	txtWord.clear();
    	    	return;
    		}
    	}
    	
    	
    	traduzione= dizionario.translateWord(parolaInserita);
    	if (traduzione==null) {
		txtResult.appendText("Parola non presente nel dizionario \n");
		txtWord.clear();
		return;
	} else {
		txtResult.appendText("La traduzione della parola e': \n"+traduzione+"\n");
		txtWord.clear();
		return;
	}
	
    	
    	/*if (parolaInserita.contains(" ")==true) {
    	//tokenizer della parola inserita per avere la parola aliena e la traduzione
    	StringTokenizer st = new StringTokenizer(parolaInserita, " ");
    	parolaAliena = st.nextToken();
    	traduzione= st.nextToken();
    	dizionario.addWord(parolaAliena, traduzione);
    	txtWord.clear();
    	
    	}
    	else {
    		traduzione = dizionario.translateWord(parolaInserita);
    		txtResult.appendText(traduzione);
    		txtWord.clear();
    	}*/
    	
    	//Aggiungere la parola al dizionario
    	
    	

    }

    @FXML
    void soReset(ActionEvent event) {
    	txtResult.clear();
    	txtWord.clear();

    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        this.dizionario= new AlienDictionary();
    }
}

