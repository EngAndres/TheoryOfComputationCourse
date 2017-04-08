input = raw_input("")
accepted = True

size = len(input)
index = 0

#starts in q0
if(index < size and input[index]=='b'):
    #move to q1
    index += 1
    
    while(index < size and input[index]=='b'):
        #loop in q1
        index += 1
    
    if(index < size and input[index]=='a'):
        #move to q2
        index += 1
        
        if(index < size and input[index]=='b'):
            #move to q3
            index += 1
        
            while(index < size and input[index]=='b'):
                #loop in q3
                index += 1
         
    else:
        accepted = False
else:
    accepted = False

if index != size:
    accepted = False


if accepted:
    print("Cadena Aceptada")
else:
    print("Cadena Rechazada")