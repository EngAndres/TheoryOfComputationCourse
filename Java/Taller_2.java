import java.io.*;

/**
 * @author carlosandressierra
 *
 */
public class Taller_2 {

	private String input;
	
	/**
	 * Constructor of the class
	 */
	public Taller_2(String input) 
	{
		this.input = input;
	}

	/**
	 * This method simulates the behavior of the string on the automata 
	 * @return
	 */
	public boolean validation()
	{
		int size = input.length();
		int index = 0;
		boolean accepted_state = true; 
		
		//Starts in q0
		if(index < size && input.charAt(index) == 'b') //q0
		{
			//Move to q4
			index += 1;
			
			if(index < size && input.charAt(index) == 'a') //q4
				//Move to q2
				index += 1;
			else
			{
				if(index < size && input.charAt(index) == 'b') //q4
				{
					//Move to q3
					index += 1;
					
					while(index < size && input.charAt(index) == 'b') //q3
						//Loop in q3
						index += 1;
					
					if(index < size && input.charAt(index) == 'a') //q3
					{
						//Move to q1
						index += 1;
						
						if(index < size && input.charAt(index) == 'a') //q1
							//Move to q2
							index += 1;
						else
							//Wrong symbol!
							accepted_state = false;
					}
					else
						//Wrong symbol!
						accepted_state = false;
				}
				else
					//Wrong symbol!
					accepted_state = false;
			}
			
			//q2
			while(accepted_state && index < size &&  (input.charAt(index) == 'a' || input.charAt(index) == 'b'))
				//Loop in q2
				index += 1;
			
			if(index != size)
				accepted_state = false;
		}
		else
		{
			//Wrong symbol!
			accepted_state = false;
		}
		
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
			Taller_2 demo = new Taller_2(input); //Create abstract machine and gives parameter
			
			
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
