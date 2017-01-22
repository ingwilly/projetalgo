
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{

	private static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arbre aux,courant, racine;
		
		 sc = new Scanner(System.in);
		  System.out.println("Entrer l'expression postfixée--->");
		  ArrayList<String> list ; 
		  String PostEntre = sc.nextLine();
		  
		  list = new ArrayList<>(Arrays.asList(PostEntre.split(" ")));
		  
		  ArrayDeque<Arbre> pil = new ArrayDeque<Arbre>();
		  for (String s : list){
			  courant = new Arbre(s);
			  if (isOperator(s)){
				 aux =  pil.pop();
				 courant.setfilsgauche(pil.pop());
				 courant.setfilsdroit(aux);
			  }
			  pil.push(courant);
			  
		  }
		  racine = pil.pop();
		  System.out.println("L'arbre est : " );
		  System.out.println(racine + "\n" );
		 
		  
		  //----------------------------to prefix------------------------
		  String s1,s2,sor;
		  
		  ArrayDeque<String> operst = new ArrayDeque<String>();
		  for (String n : list){
			  if (!isOperator(n))
				  operst.push(n);
			  else{
				s2  = operst.pop();
			  	s1  = operst.pop();
			  	sor = n +" "+ s1 +" "+ s2;
			            operst.push(sor);
			  }
			            			  
		  }
		  System.out.println("L'expression prefixee donne: ");
		  System.out.println(operst.pop()+"\n");
		  //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		  
		  
		  //-----------------------------evaluation-----------------------
		  Double oper1, oper2,result;
		  ArrayDeque<Double> abc = new ArrayDeque<Double>();
		  for (String n : list){
			  if (!isOperator(n))
				  abc.push(Double.valueOf(n));			
			  else{
				  oper2 = abc.pop();			  	
				  oper1 = abc.pop();
			  	result = operate(oper1,oper2,n);			           
			  		abc.push(result);
			  }
			            			  
		  }
		  System.out.println("l'evaluation donne: ");
		  System.out.println(abc.pop());
		  //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

	}
	
		
	 private static double operate(Double a, Double b, String op){
	        //Log.d("Calc", "w " +"operrrrr");
	        switch (op){
	            case "+": return Double.valueOf(a) + Double.valueOf(b);
	            case "-": return Double.valueOf(a) - Double.valueOf(b);
	            case "*": return Double.valueOf(a) * Double.valueOf(b);
	            case "/": try{
	                return Double.valueOf(a) / Double.valueOf(b);
	            }catch (Exception e){
	                 e.getMessage();
	            }
	            default: return -1;
	        }
	    }
	 
	//method
	    private static boolean isOperator(String op){
	        switch (op){
	            case "+":
	            case "-":
	            case "*":
	            case "/":return true;
	            default: return false;
	        }
	    }

}
