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
 * This class represents the behavior of a Standard Pushdown Automata
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class PushdownAutomata {

	/**
	 * Main method of the class
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//First, we create the buffers to read and write on the console
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter (System.out) ); //Buffer to write
		BufferedReader br = new BufferedReader( new InputStreamReader (System.in) ); //Buffer to read
		
		
		String input;  //This variable is used to save the input of the Turing Machine
		String stack = "z0"; /*This is used to represents the behavior of a stack. For the purpose of this exercise, we use a String 
							   to model the Stack, adding and removing characters to the string	*/
		int i = 0, j = 0; //Index used for loops in the simulation
		String top = ""; //Variable used to save the top of the stack
		boolean accepted = false; //State of the input. False is rejected, True is accepted
		String current_state = "q0"; //This variable saves the current state on the simulation. In the first time, q0 is the initial state.
		String current_symbol = ""; //Current symbol on the tape under the reader-unit
		String[] final_states = {"q2"}; //Set of final states of the automata
		String [][]transition_function = {{"q0", "a", "z0", "q0", "Az0"},
										{"q0", "b", "z0", "q0", "Bz0"}};  //Transitions of the automata. Each row is a specific transition.
		
		try 
		{
			input = br.readLine(); //Read the input from the console
			
			for(i = 0; i < input.length(); i++)
			{
				top = pop(stack); //Here we remove the top of the stack
				current_symbol = input.charAt(i) + ""; //Here we read the symbol on the tape depending of the position of read-unit
				
				//Using current state, symbol on the tape, and top of the stack as parameters, we need to search for a valid transition in the function
				for(j = 0; j < transition_function.length; j++) //Move through each row of Function of Transitions
				{
					if(current_state.equals( transition_function[j][0] )) //Validate the state in the function
					{
						if(current_symbol.equals( transition_function[j][1] )) //Validate the symbol in the function
						{
							if(top.equals( transition_function[j][2] )) //Validate the stack' top in the function
							{
								//If we are here it means that we found the right transition using the given parameters 
								current_state = transition_function[j][3]; //Update the state where the automata is moved
								stack = push( stack, transition_function[j][4] ); //Add to the stack all the elements defined on transition
								
								break; //Like we found the right transition, it is not necessary to search more in the function
							}
						}
					}
				}
				
				if(j == transition_function.length)
					break; // There is not exists any valid transition. So the automata must to reject the input.
			}
			
			
			//If the index and the input size are the same, it means that the input has been successful processed
			if(i == input.length())
			{
				for(int k = 0; k < final_states.length; k++)
				{
					if(current_state.equals( final_states[k] ))
						accepted = true;
				}
			}
			
			//The Automata responses if the input is accepted or not
			if(accepted)
				bw.write("Cadena Aceptada");
			else
				bw.write("Cadena Rechazada");
			
			//Send the buffer to the console
			bw.flush();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
	
	
	/**
	 * This method is used to add an element on the top of the Stack used in the Pushdown Automata
	 * @param stack
	 * @param add
	 * @return stack updated
	 */
	public static String push(String stack, String add)
	{
		return add + stack; //Add a new element to the top of the stack, i.e., add in the beginning of the string
	}
	
	
	/**
	 * This method is used to remove an element on the top of the Stack used in the Pushdown Automata
	 * @param stack
	 * @return element on the top of the stack
	 */
	public static String pop(String stack)
	{
		String top = ""; //Variable to save the element on the top of the stack
		
		top = stack.substring(0,1); //Get the element on the top, i.e., first element on the string
		stack = stack.substring(1); //Remove the element on the top of the stack
		
		return top; //Return top of the stack
	}

}
