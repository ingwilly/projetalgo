public class Arbre{
	private String x;
	private Arbre filsgauche, filsdroit;
	
	 public Arbre(){	 }
	 public Arbre(String val){
		 this.x = val;
	 }
	 
	   // ACCESSEURS
	    public String getValeur() {
	        return(x);
	    }
	 
	 public Arbre getSousArbreGauche() {
	        return(filsgauche);
	    }   

	    public Arbre getSousArbreDroit() {
	        return(filsdroit);
	    }
	 
	 public void setfilsgauche(Arbre arbr){
		 this.filsgauche = arbr;
	 }
	 
	 public void setfilsdroit(Arbre arbr){
		 this.filsdroit = arbr;
	 }
	 
	// AFFICHAGE
	    public String toString() {
	        return toString("\t");
	    }

	    public String toString(String s) {
		if (filsgauche!=null) {
		if (filsdroit!=null) 
		    return(s+"_("+x+")___\n"+filsgauche.toString(s+"\t")+filsdroit.toString(s+"\t"));
		else
		    return(s+x+"\n"+filsgauche.toString(s+"\t")+"\n");
	        }
	        else 
		if (filsdroit!=null) 
		    return(s+x+"\n\n"+filsdroit.toString(s+"\t"));
		else
		    return(s+x+" \n");
	    }
}