package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	List <WordEnhanced> dizionario;

	public AlienDictionary() {
		dizionario = new ArrayList <>();
	}
	
	public List<WordEnhanced> getDizionario() {
		return dizionario;
	}

	public void addWord (String alienWord, String translation) {
		
		int posizione = this.dizionario.indexOf(new WordEnhanced (alienWord,null));
		if (posizione !=-1) { //hai trovato pTemp dentro il dizionario
			WordEnhanced pTemp = this.dizionario.get(posizione);
			for (String sTemp: pTemp.getTraduzioni()) {
				if (sTemp.compareTo(translation)==0) {
					return;
				}
			}
			
			this.dizionario.get(posizione).addTraduzione(translation);;
		}
		else {
			WordEnhanced pTemp = new WordEnhanced (alienWord, null);
			pTemp.addTraduzione(translation);
			dizionario.add(pTemp);
		}
		
	}
	
		public String translateWord (String alienWord) {
		/*for (Word w: dizionario) {
			if (w.getAlienWord().compareTo(alienWord)==0 && w!=null) {
				return w.getTranslation();
			}
		}*/
		
		String sTemp = "";
		int posizione = this.dizionario.indexOf(new WordEnhanced (alienWord, null));
		if (posizione !=-1) { //hai trovato pTemp dentro il dizionario
			List <String> lTemp = this.dizionario.get(posizione).getTraduzioni();
			for (String s:lTemp) {
    			if (sTemp == "")
    			{
    				sTemp=s;
    			}
    			else
    			{
    				sTemp+="\n" +s;
    			}
    			
    		}
    		return sTemp;
		}
		
		return null;
	}
		
		
	
	
}
