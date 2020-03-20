package it.polito.tdp.alien;

public class Word {
	private String alienWord;
	private String translation;
	//AlienDictionary listaParole;
	
	public Word(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
		//listaParole= new AlienDictionary();
	}
		
	/*public AlienDictionary getListaParole() {
		return listaParole;
	}*/

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}

	/*public boolean equals(Object obj) {
		Word parola = (Word)obj;
		
		if (!listaParole.getDizionario().isEmpty()) {
		for (Word w: listaParole.getDizionario()) {
			if (w.getAlienWord().compareTo(parola.getAlienWord())==0){
				return true;
			}
		}
		}
		return false;	
	}*/
	
	
	
	
	
}
