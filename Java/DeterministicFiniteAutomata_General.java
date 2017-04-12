/*
# Solution for a class exercise.
#
# Created by Msc. Carlos Andres Sierra on February 2017.
# Copyright (c) 2017  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of TheoryOfComputation course.
#
# TheoryOfComputationCourse is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 2.
*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * This class represents the behavior of a Standard Finite Automata based on the Table of Transitions.
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class DeterministicFiniteAutomata_General {

	/**
	 * Main method of the class
	 */
	public static void main(String args[])
	{
		//Here we define the Function of Transition, each row is a new transition.
		String[][] function = {
				{"", "a", "b"}, 
				{"q0", "q1", "q0"},
				{"q1", "q0", "q1"}}; 
				
		//It is defined the initial state; traditionally, it is defined as q0
		String current_state = "q0";
		
		//We define the set of acceptance states of the automata, each one is separated by colons
		String[] acceptance_states = {"q0"};
		
		//These are two buffers, respectively to read and write, that works with the console
		BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
		BufferedWriter bw = new BufferedWriter ( new OutputStreamWriter (System.out) );
		
		//The input is reject until the automata shoes that the simulation finish on a acceptance state
		boolean accepted = false;
		
		String input; //Variable to save the input 
		int row = 0, column = 0; //Row and column where is located the next state in each transition' change
		
		
		try 
		{
			input = br.readLine(); //Read the input string from the console
			
			for(int i = 0; i < input.length(); i++) //This loop is used to simulate the movement of the read-unit over the tape
			{
				//We need to search in the column 0 to seek the row that corresponds at the current state of the automata
				for(int j = 0; j < function.length; j++) 
				{
					if(current_state.equals( function[j][0] )) //Si el estado actual ha sido encontrado en la tabla
					{
						row = j; //It is saved the row that correspond to the state of reference
						break; //It is not necessary to search more states in the column
					}
				}
				
				//We need to search in the row 0 to seek the column that corresponds at the symbol on the tape
				for(int j = 0; j < function[0].length; j++)
				{
					if(function[0][j].equals( input.charAt(i)+"" )) //Check if the symbol of the table is equal to the symbol on the tape
					{
						column = j; //It is saved the column that correspond to the symbol of reference
						break; //It is not necessary to search more symbols in the row
					}
				}
				
				//Using the Function of Transitions, with the row and column gathered as parameters, we define the next state of the automata
				current_state = function[row][column];
				
				//If the result of function' evaluation is null, the input can't be completely processed by the automata
				if( current_state.equals("null") )
				{
					break;
				}
			} //End of loop to move across the tape
			
			//It is compared the last state of the automata with the acceptance states set
			for(int i = 0; i < acceptance_states.length; i++)
			{
				if(current_state.equals( acceptance_states[i] )) //It determines if the last state of the simulation is of acceptance
				{
					accepted = true; //Like the input finished in a acceptance state, the input is accepted
					break; //It is not necessary search more states in the set
				}
			}
			
			//It is printed on the console the result of the automata
			if( accepted )
				bw.write("Cadena aceptada");
			else
				bw.write("Cadena rechazada");
		
			bw.flush();
		} 
		catch (IOException e) {}
	}
}