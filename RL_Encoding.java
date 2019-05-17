import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class RL_Encoding {
	
	static void method1(Scanner inFile, PrintWriter writer){
		//without zero no wrap around
		int numRows = inFile.nextInt();
		int numCols = inFile.nextInt();
		int minVal = inFile.nextInt();
		int maxVal = inFile.nextInt();
		writer.println(numRows + " " + numCols + " " + minVal + " " + maxVal);
		
		int imgAry[][] = new int[numRows][numCols];
		while (inFile.hasNextInt()){
			for (int i = 0; i < numRows; i++){
				for (int j = 0; j < numCols; j++){
					imgAry[i][j] = inFile.nextInt();
				}
			}
		}
		
		int currVal;
		int nextVal;
		int count = 0;
		int r = 0;
		int c = 0;
		currVal = imgAry[r][c];
		count = 0;
		for (int i = 0; i < numRows; i++){
			c = 0;
			count = 0;
			currVal = imgAry[r][c];
			if (currVal != 0){
			writer.print(r + " " + c + " " + currVal + " ");
			count++;
			}
			for (int j = 0; j < numCols; j++){
				c++;
				if (c == numCols){
					if (currVal != 0){
					writer.print(count);
					writer.println();
					}
					break;
				}
				nextVal = imgAry[r][c];
				if (nextVal == currVal && currVal != 0){
					count++;
				}
				else {
					if (currVal != 0){
					writer.print(count);
					writer.println();
					}
					currVal = nextVal;
					count = 1;
					if (currVal != 0){
					writer.print(r + " " + c + " " + currVal + " ");
					}
				}
			}
			r++;
			c = 0;
		}
		
		writer.close();
		
	}
	
	static void method2(Scanner inFile,PrintWriter writer){
		//without zero & wrap around
		int numRows = inFile.nextInt();
		int numCols = inFile.nextInt();
		int minVal = inFile.nextInt();
		int maxVal = inFile.nextInt();
		writer.println(numRows + " " + numCols + " " + minVal + " " + maxVal);
		int imgAry[][] = new int[numRows][numCols];
		while (inFile.hasNextInt()){
			for (int i = 0; i < numRows; i++){
				for (int j = 0; j < numCols; j++){
					imgAry[i][j] = inFile.nextInt();
				}
			}
		}
		int currVal;
		int nextVal;
		int count = 0;
		int row = 0;
		int col = 0;
		currVal = imgAry[row][col];
		count = 0;
		for (int i = 0; i < numRows; i++){
			for (int j = 0; j < numCols; j++){
				if(currVal == imgAry[i][j]){
					count++;
				}
				else if (currVal != imgAry[i][j]  ){
					if (currVal != 0){
					writer.print(count);
					writer.println();
					}
					currVal = imgAry[i][j];
					count = 1;
					if (currVal != 0)
					writer.print(i + " " + j + " " + currVal + " ");
				}
			}
		}
		writer.close();
	}
	
	static void method3(Scanner inFile, PrintWriter writer){
		//encode with zero & no wrap around
		int numRows = inFile.nextInt();
		int numCols = inFile.nextInt();
		int minVal = inFile.nextInt();
		int maxVal = inFile.nextInt();
		writer.println(numRows + " " + numCols + " " + minVal + " " + maxVal);
		int r = 0;
		int c = 0;
		int count = 0;
		int currVal;
		int nextVal;
		int imgAry[][] = new int[numRows][numCols];
		
		while (inFile.hasNextInt()){
			for (int i = 0; i < numRows; i++){
				for (int j = 0; j < numCols; j++){
					imgAry[i][j] = inFile.nextInt();
				}
			}
		}
		currVal = imgAry[r][c];
		count = 0;
		for (int i = 0; i < numRows; i++){
			c = 0;
			count = 0;
			currVal = imgAry[r][c];
			writer.print(r + " " + c + " " + currVal + " ");
			count++;
			for (int j = 0; j < numCols; j++){
				
				c++;
				if (c == numCols){
					writer.print(count);
					writer.println();
					break;
				}
				nextVal = imgAry[r][c];
				if (nextVal == currVal){
					count++;
				}
				else {
					writer.print(count);
					currVal = nextVal;
					count = 1;
					writer.println();
					writer.print(r + " " + c + " " + currVal + " ");
				}
				
			}
			r++;
			c = 0;
		}
		
		writer.close();
	
	}
	
	static void method4(Scanner inFile, PrintWriter writer){
		//with zero & wrap around
		int numRows = inFile.nextInt();
		int numCols = inFile.nextInt();
		int minVal = inFile.nextInt();
		int maxVal = inFile.nextInt();
		writer.println(numRows + " " + numCols + " " + minVal + " " + maxVal);
		int imgAry[][] = new int[numRows][numCols];
		while (inFile.hasNextInt()){
			for (int i = 0; i < numRows; i++){
				for (int j = 0; j < numCols; j++){
					imgAry[i][j] = inFile.nextInt();
				}
			}
		}
		int currVal;
		int nextVal;
		int count = 0;
		int row = 0;
		int col = 0;
		currVal = imgAry[row][col];
		count = 0;
		writer.print(row + " " + col + " " + currVal + " ");
		for (int i = 0; i < numRows; i++){
			for (int j = 0; j < numCols; j++){
				if(currVal == imgAry[i][j]){
					count++;
				}
				else if (currVal != imgAry[i][j]){
					writer.print(count);
					writer.println();
					currVal = imgAry[i][j];
					count = 1;
					writer.print(i + " " + j + " " + currVal + " ");
				}
				
			}
		}
		writer.print(count);
		writer.close();
	}

	public static void main(String[] args) {
		Scanner inFile = null;
		
		try {
			inFile = new Scanner(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Methold 1) Encode without zero and no wrap-around.");
		System.out.println("Methold 2) Encode without zero and wrap-around.");
		System.out.println("Methold 3) Encode with zero and no wrap-around.");
		System.out.println("Methold 4) Encode with zero and wrap-around.");
		System.out.println("Please enter 1-4 to choose a method: ");
		Scanner in = new Scanner(System.in);
		String method = in.nextLine();
		int m = Integer.parseInt(method);
		if (!(m >= 1 && m <= 4)){
			System.out.println("ERROR: Number not with in range 1-4");
		}
		in.close();
		
		try {
			PrintWriter writer = new PrintWriter(args[1]);
			
			if (m == 1){
				method1(inFile, writer);
			}
			else if (m == 2){
				method2(inFile,writer);
			}
			
			else if(m == 3){
				method3(inFile,writer);
			}
			else if(m == 4){
				method4(inFile,writer);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		inFile.close();
	}

}
