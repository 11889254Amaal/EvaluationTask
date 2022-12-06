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
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.runner.manipulation.Ordering.Context;

public class Main {
	private static final String filepath = "C:\\Users\\Amaal\\Downloads\\AmaalAljasria\\EvaluationProject\\src\\eva.txt";
	private static final String pathFile1 = "C:\\Users\\Amaal\\Downloads\\AmaalAljasria\\EvaluationProject\\src\\eva1.txt";

	static void choicesFunction() {
		// this fuction to pearrs for user in switch case
		System.out.println("***************************");
		System.out.println("Welcome...Please Select one of the following options:");
		System.out.println("1. Consume Api and add to file");
		System.out.println("2. Search from File");
		System.out.println("4. take value from josn file and Translate");
		System.out.println("3. Exit the system ");
	}

//main -====
	static void choicesFunction1() {
		System.out.println("Welcome...Please Select one of the following options:");
		System.out.println("1-txt format");
		System.out.println("2-pdf format");
		System.out.println("3-Exit from Sub menu");
	}

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
				choicesFunction1();
				do {
					int numberOfOption1 = sc.nextInt();
					switch (numberOfOption1) {
					case 1:
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
						choicesFunction1();
						break;
					case 2:
						URL url1 = new URL("https://api.artic.edu/api/v1/artworks/129884");
						HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
						conn1.setRequestMethod("GET");
						conn1.connect();
						StringBuilder informationString1 = new StringBuilder();
						int responseCode1 = conn1.getResponseCode();
						if (responseCode1 != 200) {
							throw new RuntimeException("HttpresponseCode");

						}

						else {
							Scanner scanner = new Scanner(url1.openStream());
							while (scanner.hasNext()) {
								informationString1.append(scanner.nextLine());
							}
							scanner.close();
							// System.out.println(informationString1.toString());
						}

						try {

							////////////////////////////////////////
							// Creating file instance
							File file = new File(
									"C:\\Users\\Amaal\\Downloads\\AmaalAljasria\\EvaluationProject\\src\\AmaalAljasria.pdf");
							// Loading pdf file
							PDDocument document = PDDocument.load(file);

							PDFTextStripper pdfStripper = new PDFTextStripper();
							// Fetching PDF document
							System.out.println("plz enter word you want to search");
							String word = sc.next();
							PDFTextStripper findPhrase = new PDFTextStripper();
							String text = findPhrase.getText(document);
							String PDF_content = text;
							String result = PDF_content.contains(word) ? "Yes" : "No";
							System.out.println(result);

							System.out.println("plz enter from where you want to search");
							System.out.println("1- (Desktop)===>Des");
							System.out.println("2- (Documents)====>Doc");
							System.out.println("3- (c)");
							String options = sc.next();
							if (options.contains("Des")) {
								File directory = new File("C:\\Users\\Amaal\\OneDrive\\Desktop");
								  
						        // store all names with same name
						        // with/without extension
						        String[] flist = directory.list();
						        int flag = 0;
						        if (flist == null) {
						            System.out.println("Empty directory.");
						        }
						        else {
						  
						            // Linear search in the array
						            for (int i = 0; i < flist.length; i++) {
						                String filename = flist[i];
						                if (filename.endsWith(".pdf")) {
						                    System.out.println(filename + " found");
						                    flag = 1;
						                    
						                    File file2 = new File(
						                    		filename);
											// Loading pdf file
											PDDocument document2 = PDDocument.load(file);

											PDFTextStripper pdfStripper2 = new PDFTextStripper();
											// Fetching PDF document
											System.out.println("plz enter word you want to search");
											System.out.println("net");
											System.out.println("Html");
											System.out.println("java");
											String word2 = sc.next();
											PDFTextStripper findPhrase2 = new PDFTextStripper();
											String text2 = findPhrase.getText(document);
											String PDF_content2 = text2;
											
											String result2 = PDF_content.contains(word2) ? "Yes" : "No";
											System.out.println(result2);
											
						                }
						                
						            }
						        }
						  
						        if (flag == 0) {
						            System.out.println("File Not Found");
 						        }
							} else if (options.contains("Doc")) {

							} else {
								System.out.println("plaze enter 0 or 1 only");
							}

							document.close();

						} catch (Exception e) {
							System.out.println(e);
						}

						choicesFunction1();
						break;

					case 3:

						choicesFunction();
						break;

					}

				} while (true);
			case 2:
				// this case to search from file
				System.out.println("========================= ( Search From json file)===================");
				System.out.println("===================================================================");

				System.out.println("plz enter word that want to search from file");
				Scanner sc1 = new Scanner(System.in);
				String SearchForWord2 = sc1.next();
				System.out.print("Please enter the number of strings you want to enter: ");
				// takes an integer input
				String[] string = new String[sc.nextInt()];
				// consuming the <enter> from input above
				sc.nextLine();
				for (int i = 0; i < string.length; i++) {
					string[i] = sc.nextLine();
				}
				System.out.println("\nYou have entered: ");
				// for-each loop to print the string
				for (String str : string) {
					if (str.contains(SearchForWord2)) {
						System.out.println("DUPLICATE value");
					}
				}

				File f1 = new File("C:\\Users\\Amaal\\Downloads\\AmaalAljasria\\EvaluationProject\\src\\eva.txt"); // Creation
																													// of
																													// File
																													// Descriptor
																													// for
																													// input
																													// file
				String[] words = null;
				FileReader fr = new FileReader(f1); // Creation of File Reader object
				BufferedReader br1 = new BufferedReader(fr); // Creation of BufferedReader object
				String s;

				int count = 0;
				String s1;
				while ((s = br1.readLine()) != null) // Reading Content from the file
				{
					s1 = s.replaceAll("\\W", " ");
					words = s.split(" "); // Split the word using space
					for (String word : words) {
						if (word.contains(SearchForWord2)) // Search for the given word
						{
							count++;
						}

					}
				}
				if (count != 0) // Check for count not equal to zero
				{
					System.out.println("The given word is present for " + count + " Times in the file");

				} else {
					System.out.println("The given word is not present in the file");
				}

				fr.close();

				choicesFunction();

				break;
			case 3:
				// this case to search from file
				System.out.println("Exiting The System Bye See you Again :)!....");
				System.exit(0);
				break;
			case 4:

				File f11 = new File("C:\\Users\\Amaal\\Downloads\\AmaalAljasria\\EvaluationProject\\src\\eva.txt"); // Creation
																													// of
																													// File
																													// Descriptor
																													// for
																													// input
																													// file
				String[] words1 = null;
				FileReader fr1 = new FileReader(f11); // Creation of File Reader object
				BufferedReader br11 = new BufferedReader(fr1); // Creation of BufferedReader object

				int count11 = 0;

				while ((s1 = br11.readLine()) != null) // Reading Content from the file
				{
					words1 = s1.split(" "); // Split the word using space
					System.out.println("==================================================");
					for (String word : words1) {
						// System.out.println(word);
						if (word.contains(":")) // Search for the given word
						{
							String a1 = word.replaceAll("\\W", " ");

							System.out.println(a1);

						}
						Path pathFile = Paths.get(pathFile1);
						Files.writeString(pathFile, word.replaceAll("\\W", " "), StandardCharsets.UTF_8);

					}
					System.out.println("==================================================");
					System.out.println("=========================Json File Translate========================");
				}

				fr1.close();

				choicesFunction();
				break;
			// code block
			}
		} while (true);// close of while

	}

}
