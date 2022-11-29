package FirstPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	private static final String filepath = "C:\\Users\\Amaal\\Downloads\\AmaalAljasria\\EvaluationProject\\src\\eva.txt";

	static void choicesFunction() {
		// this fuction to pearrs for user in switch case
		System.out.println("***************************");
		System.out.println("Welcome...Please Select one of the following options:");
		System.out.println("1. Consume Api and add to file");
		System.out.println("2. Search from File");
		System.out.println("4. take value from josn file");
		System.out.println("3. Exit the system ");
	}
//main 
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// call function
		choicesFunction();
		// allows user to enter which case need

		do {
			int numberOfOption = sc.nextInt();
			switch (numberOfOption) {
			case 1:
				// this case for consume Api
				// ConsumeApi MyconsumeApi=new ConsumeApi();
				URL url = new URL("https://api.artic.edu/api/v1/artworks/129884");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				StringBuilder informationString = new StringBuilder();
				int responseCode = conn.getResponseCode();
				if (responseCode != 200) {
					throw new RuntimeException("HttpresponseCode");

				}

				else {
					Scanner scanner = new Scanner(url.openStream());
					while (scanner.hasNext()) {
						informationString.append(scanner.nextLine());
					}
					scanner.close();
					System.out.println(informationString.toString());

					Path pathFile = Paths.get(filepath);
					String infoString = informationString.toString();
					Files.writeString(pathFile, infoString, StandardCharsets.UTF_8);
					System.out.println("the file is create ........");

				}

				choicesFunction();

				break;
			case 2:
				// this case to search from file
				System.out.println("========================= ( Search From json file)===================");
				System.out.println("===================================================================");
//				HashSet<String> uniqueNames = new HashSet<String>();
//				ArrayList<String> outputLines = new ArrayList<String>();
//
//				Scanner input = new Scanner(
//						new File("C:\\Users\\Amaal\\Downloads\\AmaalAljasria\\EvaluationProject\\src\\eva.txt"));
//				while (input.hasNextLine()) {
//
//					// Split a line into an array of names.
//					String[] names = input.nextLine().split(" ");
//					String edited = "";
//					for (int i = 0; i < names.length; i++) {
//
//						// If the name is already in the set, remove it.
//						if (uniqueNames.add(names[i])) {
//							edited += names[i] + " ";
//
//							char char1 = edited.charAt(i);
//
//							if ((char1 >= 'a' && char1 <= 'z') || (char1 >= 'A' && char1 <= 'Z')
//									|| (Character.isDigit(char1))) {
//								System.out.println("yas");
//								
//								edited = edited.strip(); // remove excess whitespace
//
//								// Add the final line to our output array.
//								if (!edited.equals("")) {
//									outputLines.add(edited);
//								}
//								String outputFn = "notJsonFile.txt";
//								BufferedWriter output = new BufferedWriter(new FileWriter(outputFn));
//								output.write(char1);
//								output.close();
//								System.out.println("File '" + outputFn + "' created!");
//							}
//
//						}
//					}
//				
//				}

//				// Write the output array to a file.
//				String outputFn = "withOutDuplicate.txt";
//				BufferedWriter output = new BufferedWriter(new FileWriter(outputFn));
//				output.write(String.join("\n", outputLines));
//				output.close();
//				System.out.println("File '" + outputFn + "' created!");

				/////////////////////////////////////////////////////////////////
				
				
				System.out.println("plz enter word that want to search from file");
       		 Scanner sc1=new Scanner(System.in);
	      	    String SearchForWord2= sc1.next();
	      	  File f1=new File("C:\\Users\\Amaal\\Downloads\\AmaalAljasria\\EvaluationProject\\src\\eva.txt"); //Creation of File Descriptor for input file
	          String[] words=null;  
	          FileReader fr = new FileReader(f1);  //Creation of File Reader object
	          BufferedReader br1 = new BufferedReader(fr); //Creation of BufferedReader object
	          String s;     
	          
	          int count=0;   
				
	          while((s=br1.readLine())!=null)   //Reading Content from the file
	          {
	             words=s.split(" ");  //Split the word using space
	              for (String word : words) 
	              {
	                     if (word.equals(SearchForWord2))   //Search for the given word
	                     {
	                    	 count++; 
	                    	 System.out.println("******the word found********");
	                     }
	                     else
	                     {
	                    	 System.out.println("******the word not found********");
	                     }
				
	              }
	          }
	              if(count!=0)  //Check for count not equal to zero
		          {
		             System.out.println("The given word is present for "+count+ " Times in the file");
		            
		          }
		          else
		          {
		             System.out.println("The given word is not present in the file");
		          }
		          
		             fr.close();
	                	
	               
	          
	          
				
				
				
				
				
				
				
				
				
				HashSet<String> lines = new HashSet<String>();

				File file = new File("C:\\Users\\Amaal\\Downloads\\AmaalAljasria\\EvaluationProject\\src\\txt1.txt");
				
				Scanner input1 = new Scanner(file);
				int count1 = 0;
				System.out.println("All words in file");
				System.out.println("=================");
				while (input1.hasNext()) {
					String next = input1.next();
					
					
					
					System.out.println(next);
					
					lines.add(next);
					count1++;
					
				}
				System.out.println("=================");
				input1.close();
				System.out.println("word without duplicate" + lines);
				System.out.println("Word count: " + count1);

				choicesFunction();

				break;
			case 3:
				// this case to search from file
				System.out.println("Exiting The System Bye See you Again :)!....");
				System.exit(0);
				break;
			case 4:
				
				File file1 = new File("C:\\Users\\Amaal\\Downloads\\AmaalAljasria\\EvaluationProject\\src\\eva.txt");
				Scanner in=new Scanner(file1);
				while((in.hasNextLine())) {
					System.out.println(in.next().replaceAll("[^a-zA-Z]*", ""));
					
				}
				break;
			// code block
			}
		} while (true);// close of while

	}

}
