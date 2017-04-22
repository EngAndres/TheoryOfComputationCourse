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
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * This class represents the behavior of Task Practical.4
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class Taller_4 {

	private String input;
	
	/**
	 * Constructor of the class
	 */
	public Taller_4(String input) 
	{
		this.input = input;
	}

	/**
	 * This method simulates the behavior of the string on the automata 
	 * @return
	 */
	public boolean validation()
	{
		boolean accepted_state = true; //As an initial assumption, the input is accepted and just the automata can shows if input must be rejected
		int size = input.length; //Get the length or size of the input
		int index = 0; //Index of the read-unit over the tape

		//starts in q0
		if(index < size && input.charAt(index) == 'b')
		{
		    //move to q1
		    index += 1; //move unit one step forward
		    
		    while(index < size && input.charAt(index) == 'b')
		        //loop in q1
		        index += 1; //move unit one step forward
		    
		    if(index < size && input.charAt(index) == 'a')
		    {
		        //move to q2
		        index += 1; //move unit one step forward
		        
		        if(index < size && input.charAt(index) == 'b')
		        {
		        	//move to q3
		            index += 1; //move unit one step forward
		        
		            while(index < size && input.charAt(index) == 'b')
		                //loop in q3
		                index += 1 //move unit one step forward
		        }
		    } 
		    else
		    	accepted_state = false; //Symbol with no valid transition
		}
		else
			accepted_state = false; //Symbol with no valid transition


		//Validate if all the input had been processed by the automata. 
		//In index is equal to input' size it means that all the input was processed by the automata
		if(index != size) //If index is different to size, the input must be rejected
		    accepted = false;

		
		return accepted_state;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		BufferedReader br = new BufferedReader( new InputStreamReader (System.in) ); //Buffer to read from console
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter (System.out) ); //Buffer to write on console
		
		try
		{
			String input = br.readLine(); //Read input string of the automata
			Taller_4 demo = new Taller_4(input); //Create abstract machine and gives parameter
			
			
			if(demo.validation()) //If input is accepted
				bw.write("Cadena aceptada\n");
			else //Input is rejected
				bw.write("Cadena rechazada\n");
			
			bw.flush();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}