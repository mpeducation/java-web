package com.educacionit.web.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainFilter {

	public static void main(String[] args) {
		
		List<Integer> enteros = new ArrayList<>();
		
		enteros.add(11);
		enteros.add(16);
		enteros.add(20);
		enteros.add(14);
		
		Integer valor = 18;
		
		// filtrar
		List<Integer> mayores = new ArrayList<>();
		for (Integer aux : enteros) {
			if (aux > valor) {
				mayores.add(aux);
			}
		}
		
		System.out.println(mayores);
		
		// Transformar a un string
		
		List<String> enterosAString = new ArrayList<>();
		
		for (Integer aux : mayores) {
			enterosAString.add("Edad " + aux);
		}
		
		System.out.println(enterosAString);
		
		System.out.println("--------------------------------");
		System.out.println("---- Con Streams (2 pasos) -----");
		System.out.println("--------------------------------");
		
		// filtro
		
		List<Integer> mayores2 = enteros.stream()
				.filter(aux -> aux > valor)
				.collect(Collectors.toList());
		
		System.out.println(mayores2);
		
		List<String> enterosAString2 = mayores.stream()
			.map(valorEntrante -> new String("Edad " + valorEntrante))
			.collect(Collectors.toList());
		
		System.out.println(enterosAString2);
		
		System.out.println("--------------------------------");
		System.out.println("---- Con Streams ---------------");
		System.out.println("--------------------------------");
		
		List<String> mayoresAString = enteros.stream()
				.filter(aux -> aux > valor) // función intermedia
				.map(valorEntrante -> new String("Edad " + valorEntrante)) // f.intermedia
				.collect(Collectors.toList()); // función terminal
		
		System.out.println(mayoresAString);
		
	}

}
