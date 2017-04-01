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
 * This class represents the behavior of a Standard Pushdown Automata
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class Taller_1 {

private String input;
	
	/**
	 * Constructor of the class
	 */
	public Taller_1(String input) 
	{
		this.input = input;
	}
	
	public boolean validation()
	{
		int index = 0, size = 0; //Index over the string, and size of the string
		boolean accepted = true; //State of the string
		
		size = this.input.length(); //Get size of the string
		
		//Starts in q0
		if(index < size &&  input.charAt(index) == '0')
		{
			index += 1; //Move to q1
			
			while(index < size &&  input.charAt(index) == '0')
				index += 1; //Loop in q1
			
			if(index < size &&  input.charAt(index) == '1')
				index += 1; //Move to q2
			else
				accepted = false; //Bad transition
		}
		else
		{
			if(index < size &&  input.charAt(index) == '1')
				index += 1; //Move to q2
			else
				accepted = false; //Wrong symbol!
		}
		
		//Starts on q2
		while(index < size)
		{
			if(input.charAt(index) == '0')
				 index += 1; //Move to q3
			else
			{
				//Break
				accepted = false;
				break;
			}
			
			while(index < size &&  input.charAt(index) == '0')
				index += 1; //Loop in q3 
				
			if(index < size &&  input.charAt(index) == '1')
				index += 1; //Move to q4
			else
			{
				accepted = false; //Wrong Symbol
				break;
			}
				
			
			if(index < size &&  input.charAt(index) == '0')
			{
				index += 1; //Move to q5
				
				while(index < size &&  input.charAt(index) == '0')
					index += 1; //Loop in q5
				
				if(index < size &&  input.charAt(index) == '1')
					index += 1; //Move to q4
				else
				{
					//Wrong symbol
					accepted = false;
					break;
				}
			}
			else
			{
				if(index < size &&  input.charAt(index) == '1')
					index += 1; //Move to q2
				else
				{
					//Wrong symbol
					accepted = false;
					break;
				}
			}
		}
		
		return accepted;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader( new InputStreamReader (System.in) ); //Buffer to read from console
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter (System.out) ); //Buffer to write on console
		
		try
		{
			String input = br.readLine(); //Read input string of the automata
			Taller_1 demo = new Taller_1(input); //Create abstract machine and gives parameter
			
			
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
