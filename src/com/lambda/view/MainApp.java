package com.lambda.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.lambda.interfaces.AlReves;
import com.lambda.interfaces.ValorPi;

public class MainApp {

	public static void main(String[] args) {
		
		
		//---- FASE 1 ----
		System.out.println ("---- FASE 1 ----");
		
		
		
		//Tenint una llista de cadenes de noms propis, escriu un mètode que retorne una llista de totes les cadenes que comencen amb la lletra 'a' (mayuscula) 
		//i tenen exactament 3 lletres. Imprimeix el resultat.
		List<String> names = Arrays.asList("Xavi","Ami","Aritz","Ali","Ina", "ana");
		System.out.println("\n Se imprimiran las palabras de la lista que tengan 3 caracteres y empiecen por 'A'");
		System.out.println(threeCharsA(names));
		
		
		
		//Escriu un mètode que retorne una cadena separada per comes basada en una llista d’Integers. 
		//Cada element hauria d'anar precedit per la lletra "e" si el nombre és parell, i precedit de la lletra "o" si el nombre és imparell. 
		//Per exemple, si la llista d'entrada és (3,44), la sortida hauria de ser "o3, e44". Imprimeix el resultat.
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
		System.out.println("\n\n Se imprimiran los números de la lista precedidos de 'e' si son pares y de 'o' si son impares");
		System.out.println(oddsEvensLetter(nums));

		
		
	
		//Tenint una llista de Strings, escriu un mètode que retorne una llista de totes les cadenes que continguen la lletra ‘o’ i imprimeix el resultat
		List<String> words = Arrays.asList("Hola","Bola","Cara","Filmar");
		System.out.println("\n\n Se imprimiran las palabras de la lista que contengan almenos una 'o'");
		System.out.println(containsO(words));
		

		
		
		//Has de fer el mateix que en el punt anterior, però retornant una llista que incloga els elements amb més de 5 lletres. Imprimeix el resultat.
		System.out.println("\n\n Retornamos las palabras de la lista con más de 5 letras");
		System.out.println(containsOandFive(words));

		
		
		// Crea una llista amb els nombs dels mesos de l’any. Imprimeix tots els elements de la llista amb una lambda.
		
		System.out.println("\n\n Imprimimos la lista de meses del año");
		List<String> months = Arrays.asList("Enero","Febrebro","Marzo","Abril","Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
		months.forEach(x -> System.out.print(x + ", "));
		
		
		//Has de fer la mateixa impressió del punt anterior però fent-ho mitjançant method reference.
		System.out.println("\n\n Imprimimos la lista de meses del año (method reference)");
		months.forEach(System.out::println);
		
		
		
		
		//---- FASE 2 ----
		System.out.println ("\n\n ---- FASE 2 ----");
		
		ValorPi pi = (p) -> p;  // Es lo mismo que { return p }    // Expresión lambda
		System.out.println(pi.getPiValue(3.1415));  // Uso de la expresión lambda
		
		

		//---- FASE 3 ----
		System.out.println ("\n\n---- FASE 3 ----");
		
		AlReves agirar = (cadena) -> { 
			
			String cadena_girada = "";
			
			for (int i=cadena.length()-1; i>= 0; i--) {
				cadena_girada += cadena.charAt(i);
			}
			return cadena_girada;
		};
		
		System.out.println(agirar.reverse("XAVIGONZALEZ"));
	
	}
	
	
	static List<String> threeCharsA (List <String> list) {
		
		return list.stream()
		.filter(x -> x.length() == 3 && x.charAt(0)=='A')
		.collect(Collectors.toList());		
	}
	
	
	static List<String> oddsEvensLetter (List<Integer> list) {
		
		return list.stream()
		.map((Object x) -> {
			
			String salida = ""; 
			
			if ((int)x%2 == 0) salida = "e"+ x.toString();
			else salida = "o"+ x.toString();
		
			return salida;
		})
		.collect(Collectors.toList());
	}

	
	static List<String> containsO (List<String> list) {
		return list.stream()
		.filter(x -> x.contains("o"))
		.collect(Collectors.toList());
	}
	
	
	static List<String> containsOandFive (List<String> list) {		
		return list.stream()
		.filter(x -> x.length()>5)
		.collect(Collectors.toList());
	}
}
