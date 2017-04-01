/*
# Solution for a class exercise.
#
# Created by Msc. Carlos Andres Sierra on February 2017.
# Copyright (c) 2017  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of TheoryOfComputation course.
#
# DataStructureCourse is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 2.
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * This class represents the behavior of a Standard Pushdown Automata
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class PushdownAutomata {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter (System.out) );
		BufferedReader br = new BufferedReader( new InputStreamReader (System.in) );
		
		try {
			String w = br.readLine();
			String stack = "z0";
			int i = 0, j = 0;
			String top = "";
			boolean accepted = false;
			String current_state = "q0";
			String current_symbol = "";
			String[] final_states = {"q2"};
			String [][]transition_function = {{"q0", "a", "z0", "q0", "Az0"},
											{"q0", "b", "z0", "q0", "Bz0"}};
			
			for(i = 0; i < w.length(); i++)
			{
				top = pop(stack); //Aca deben obtener el tope de la pila
				current_symbol = w.charAt(i)+"";
				
				for(j = 0; j < transition_function.length; j++)
				{
					if(current_state.equals( transition_function[j][0] ))
					{
						if(current_symbol.equals( transition_function[j][1] ))
						{
							if(top.equals( transition_function[j][2] ))
							{
								current_state = transition_function[j][3];
								stack = push( stack, transition_function[j][4] );
								
								break;
							}
						}
					}
				}
				
				if(j == transition_function.length)
					break;
			}
			
			if(i == w.length())
			{
				for(int k = 0; k < final_states.length; k++)
				{
					if(current_state.equals( final_states[k] ))
						accepted = true;
				}
			}
			
			if(accepted)
				bw.write("Cadena Aceptada");
			else
				bw.write("Cadena Rechazada");
			
			bw.flush();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
	
	public static String push(String stack, String add)
	{
		return add + stack;
	}
	
	public static String pop(String stack)
	{
		String top = "";
		
		top = stack.substring(0,1);
		stack = stack.substring(1);
		
		return top;
	}

}
