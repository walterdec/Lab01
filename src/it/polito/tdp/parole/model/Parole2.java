package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.*;

public class Parole2{
	
	private List<String> parole = new ArrayList<String>();
		
	public Parole2() {
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole, new ComparatoreParole());
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}

	public void eliminaParola(String parolaDaCancellare) {
		boolean parolaPresente = false;
		for(String p : parole) {
			if(p.compareTo(parolaDaCancellare)==0) {
				parolaPresente = true;
				
			}
		}
		if(parolaPresente == true) {
			parole.remove(parolaDaCancellare);
		}
		
	}

}
