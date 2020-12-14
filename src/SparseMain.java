import java.util.*;
import java.io.*;
public class SparseMain {
	
	public static void main (String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int rows= 5;
		int cols= 6;
	    int[][] init= new int[rows][cols];   //initial array before sparse
		System.out.println("How many rows do you want?");
		rows = keyboard.nextInt();
		System.out.println("How many columns do you want?");
		cols = keyboard.nextInt();
		
		int temp_row = -1; //need these 3 variables as containers
		int temp_col = -1;
		int value = -1;
		int select = -1; //to inform while loop when to stop 
		while(true)
		{
			if(select != 0)
			{
				while(temp_row== -1 || temp_row < -1 || temp_row> rows)
				{
					System.out.println("What is the row of the cell to edit?");
		   		    temp_row = keyboard.nextInt();
				}
				while(temp_col== -1 || temp_col < -1 || temp_col> cols)
				{
				System.out.println("And the column?");
				temp_col = keyboard.nextInt();
				}
				System.out.println("What is the value you want there?");
				value = keyboard.nextInt();
				init[temp_row][temp_col]= value;
			}
			else
			{
			  break;	
			}
			System.out.println("Press 0 to exit?");
			select = keyboard.nextInt();
			temp_row = -1;
			temp_col= -1;
			
		}
		//the following arraylists are what the sparse matrix consists of
		ArrayList<Integer> ROW = new ArrayList<>();
		ArrayList<Integer> COL = new ArrayList<>();
		ArrayList<Integer> VALUE = new ArrayList<>();
		sparse(init,ROW, COL, VALUE);// matrix is put in and the "output": arraylists are updated
		//the for loop that simply prints out initial matrix
		for(int i =0; i<rows; i++ )
		    for (int j =0; j< cols; j++)
		      {
		    	 System.out.print(init[i][j] + " ");
		         if(j== cols-1)
		    	   System.out.println();
		      }
		
		//need to create the actual sparse matrix
		int [][] sparsed= new int[3][ROW.size()];
		int ind = -1;
		for(int r =0; r<sparsed.length; r++ )
		{	
			ind = 0;
		    for (int c =0; c<sparsed[0].length; c++)
		      {
		    	if(r== 0)
		           sparsed[r][c] = ROW.get(ind);
		    	else if(r==1)
		    		sparsed[r][c] = COL.get(ind);
		    	else if(r==2)
		    	    sparsed[r][c] = VALUE.get(ind);
		        ind++;
		      }
		}
		//Now the Sparse matrix is printed out		
		System.out.println();
		System.out.println("Row, then col, then value.");
		System.out.println(ROW.toString());
		System.out.println(COL.toString());
		System.out.println(VALUE.toString());
		
	/*	for(int i =0; i<sparsed.length; i++ )
		    for (int j =0; j<sparsed[0].length; j++)
		      {
		    	 System.out.print(sparsed[i][j] + " ");
		         if(j== sparsed[0].length-1)
		    	   System.out.println();
		      }
		      //this is how sparsed would look printed out, but the other way is just neater
		*/ 
	}
	public static void sparse(int[][] raw, ArrayList<Integer> ROW, ArrayList<Integer> COL, ArrayList<Integer> VALUE )
	{
		for(int i =0; i<raw.length; i++ )
		    for (int j =0; j<raw[0].length; j++)
		      {
		    	if(raw[i][j] != 0)
		    	{
		    		ROW.add(i);
		    		COL.add(j);
		    		VALUE.add(raw[i][j]);
		    	}
		      }
	}
}
