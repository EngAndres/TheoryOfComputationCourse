'''
# Solution for a class exercise.
#
# Created by Msc. Carlos Andres Sierra on March 2017.
# Copyright (c) 2017  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of TheoryOfComputation course.
#
# DataStructureCourse is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 2.
'''

input = raw_input("") #Read the input from the console
accepted = True #As an initial assumption, the input is accepted and just the automata can shows if input must be rejected

size = len(input) #Get the length or size of the input
index = 0 #Index of the read-unit over the tape

############### AUTOMATA SIMULATION ###################
#starts in q0
if(index < size and input[index]=='b'): 
    #move to q1
    index += 1 #move unit one step forward
    
    while(index < size and input[index]=='b'):
        #loop in q1
        index += 1 #move unit one step forward
    
    if(index < size and input[index]=='a'):
        #move to q2
        index += 1 #move unit one step forward
        
        if(index < size and input[index]=='b'):
            #move to q3
            index += 1 #move unit one step forward
        
            while(index < size and input[index]=='b'):
                #loop in q3
                index += 1 #move unit one step forward
         
    else:
        accepted = False #Symbol with no valid transition
else:
    accepted = False #Symbol with no valid transition


#Validate if all the input had been processed by the automata. 
#In index is equal to input' size it means that all the input was processed by the automata
if index != size: #If index is different to size, the input must be rejected
    accepted = False


#Print the result of simulate a given input into the automata
if accepted:
    print("Cadena Aceptada")
else:
    print("Cadena Rechazada")