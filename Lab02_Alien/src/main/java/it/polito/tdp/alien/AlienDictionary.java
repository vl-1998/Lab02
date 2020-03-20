package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	List <Word> dizionario;

	public AlienDictionary() {
		dizionario = new ArrayList <Word>();
	}
	
	public List<Word> getDizionario() {
		return dizionario;
	}

	public void addWord (String alienWord, String translation) {
		Word pTemp= new Word (alienWord, translation);
		/*if (dizionario.isEmpty()==true) {
			dizionario.add(pTemp);
		}
		
		for (Word w: dizionario) {
			/*if (w.equals(pTemp)==true && w!=null) {
				w.setTranslation(translation);
			}
			
			if (w!=null) {
				if (w.getAlienWord().compareTo(pTemp.getAlienWord())==0) {
					w.setTranslation(translation);
				}
			}
		}*/
	
		int posizione = this.dizionario.indexOf(pTemp);
		if (posizione !=-1) { //hai trovato pTemp dentro il dizionario
			this.dizionario.get(posizione).setTranslation(translation);
		}
		else {
			dizionario.add(pTemp);
		}
		
	}
	
	public String translateWord (String alienWord) {
		for (Word w: dizionario) {
			if (w.getAlienWord().compareTo(alienWord)==0 && w!=null) {
				return w.getTranslation();
			}
		}
		
		int posizione = this.dizionario.indexOf(new Word (alienWord, ""));
		if (posizione !=-1) { //hai trovato pTemp dentro il dizionario
			this.dizionario.get(posizione).getTranslation();
		}
		
		return null;
	}
	
}
