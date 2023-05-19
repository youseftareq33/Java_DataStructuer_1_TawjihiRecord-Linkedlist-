package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Driver {
	
	static Scanner in=new Scanner(System.in).useLocale(Locale.US);
	
	//- attributes -//
	static int seat_num;
	static String branch;
	static double avg;
	/////////////////
	
	// to store data inside datalist
	static ObservableList<Student> student_dataList = FXCollections.observableArrayList();
			
	
	
	
	public static void main(String[] args) throws IOException {
		/////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.print("                                                    "
				+ "|| Welcome to Tawjihi_2022 Records Simulatour ||\n");
		System.out.print("                                                    "		// introduction print. 
				+ "================================================\n");
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		int choice_1 = 0; //to choose the way u want edit the data (first question).
		
		int choice_2; // to choose the file u want (second question).
		
		int choice_3=0; // to choose the brunch u want (third question).

		int menu = 0; // to choose ur operation (forth question).

		String [] x = null;   //
		String [] literary;   //
		String [] scientific; // those string array to save the data in itself. 
		
		
		
		
		Student stud=new Student(seat_num, branch, avg); // the object.
		
		LinkedList<String> l = new LinkedList<>(); // the linked list.
		LinkedList<String> l1 = new LinkedList<>();
		
		///////////////////////////////-- WestBank Records file --//////////////////////////////////////
		File westbank_file=new File("WestBank_2022.csv");
		//
		FileWriter westbank_write=new FileWriter("WestBank_2022.csv",true);
		//those open the file of west bank record inside the program and write inside it.
		
		
		/////////////////////////////////-- Gaza Records file --///////////////////////////////////////
		File gaza_file=new File("Gaza_2022.csv");
		//
		FileWriter gaza_write=new FileWriter("Gaza_2022.csv",true);
		//those open the file of gaza record inside the program and write inside it.
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n   "+"Please choose the way you want to edit the data: \n\n"
				+"   "+"1-Linked list.\n"
				+"   "+"2-file.\n");
		System.out.print("\n   "+"Choice number: ");
		choice_1=in.nextInt();
		choice_1=invalid_choice_way(choice_1); // ((first question)) to check if the input is correct ( (input: choice_1) one of these choices ).
		
		
		 
		
		System.out.println("   "+"===============================================================================");
		///////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n   "+"The file u want open: \n\n"
				+"   "+"1-West Bank.\n"
				+"   "+"2-Gaza.\n");
		System.out.print("\n   "+"Choice number: ");
		
		choice_2=in.nextInt();
		choice_2=invalid_choices_file(choice_2); // ((second question)) to check if the input is correct ( (input: choice_2) one of these choices ).
		
		
		if(westbank_file.exists()==false) {
			System.out.println("   "+"There is no WestBank file !!!"); // to check if the file exist. 
		}
		
		if(gaza_file.exists()==false) {
			System.out.println("   "+"There is no Gaza file !!!"); // to check if the file exist. 
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		try {
			/////////////////////////////////////////////////////////////////////////////////////////
			File file_chosen = null;
			FileWriter write_chosen = null;
			
			if(westbank_file.exists()==true && choice_2==1) {
				file_chosen=westbank_file;
				write_chosen=westbank_write;
			}
			else if(gaza_file.exists()==true && choice_2==2) {
				file_chosen=gaza_file;
				write_chosen=gaza_write;
			}
			// to select the file u want edit in it :) .
			///////////////////////////////////////////////////////////////////////////////////////////
			
			System.out.println("   "+"===============================================================================");
			System.out.print("\n   "+"The branch u want: \n\n"
					+"   "+"1-All brunch.\n"
					+"   "+"2-Literary.\n"
					+"   "+"3-Scientific.\n");
			System.out.print("\n   "+"Choice number: ");
			choice_3=in.nextInt();  
			choice_3=invalid_choices_branch(choice_3); //((third question)) to check if the input is correct ( (input: choice_3) one of these choices ).
			
			
			//if the file has the data then -> ask users what brunch they search for.
			///////////////////////////////////////////////////////////////////////////////////////////
			for(;;) {
			Scanner scan_tawjihi=new Scanner(file_chosen);
			if(file_chosen.length()>0) {	
					
						if(menu==0) {
						System.out.println("   "+"-------------------------- Tawjihi Records ---------------------------\n");					
					
						
						while(scan_tawjihi.hasNextLine()) {
						    x=scan_tawjihi.nextLine().split(","); // to save the value inside (array x) in row. 
						    
						    
						    ////////////////////////////////////-- All brunch data --////////////////////////////////////////
						    
						    ///////////////////-- Linked list way --///////////////////////
						    if(choice_1==1 && choice_3==1) {
						    	stud.setSeat_num(Integer.parseInt(x[0]));
							    stud.setBranch(x[1]);
							    stud.setAvg(Double.parseDouble(x[2]));
							    
							    l1.traverseinsertsorted(stud.getAvg()+","+stud.getBranch()+","+stud.getSeat_num());
						    	l.insertatlast(stud.toString());   // insert the all brunch data to linked list.
						    } 
						    
							//////////////////////-- file way --//////////////////////////
						    else if(choice_1==2 && choice_3==1) {
						    	student_dataList.add(new Student(Integer.parseInt(x[0]), x[1], Double.parseDouble(x[2])));
						    	
						    	if(x[1].equals("Literary")) {
						    		System.out.println("   "+"Student   SeatNumber: "+x[0]+" | Branch: "+x[1]+"  "+" | AVG: "+Double.parseDouble(x[2])+" ("+grade(Double.parseDouble(x[2]))+")\n");
						    	}
						    	else {
						    		System.out.println("   "+"Student   SeatNumber: "+x[0]+" | Branch: "+x[1]+" | AVG: "+Double.parseDouble(x[2])+" ("+grade(Double.parseDouble(x[2]))+")\n");
						    	}
						    }
						    //
						    // if choice_1 = 2(file) -> print data for all brunch.
						    
						    //////////////////////////////////////-- Literary data --////////////////////////////////////////
						    
						    ///////////////////-- Linked list way --///////////////////////
						     if(x[1].equals("Literary") && choice_3==2 && choice_1==1) {
						    	literary=x;
						    	stud.setSeat_num(Integer.parseInt(literary[0]));
							    stud.setBranch(literary[1]);
							    stud.setAvg(Double.parseDouble(literary[2]));
						    	
							    l1.traverseinsertsorted(stud.getAvg()+","+stud.getBranch()+","+stud.getSeat_num());
						    	l.insertatlast(stud.toString());	//insert the literary data to linked list.
						    }
						     
							//////////////////////-- file way --//////////////////////////
						    else if(x[1].equals("Literary") && choice_3==2 && choice_1==2) {
						    	 	literary=x;
						    	 	
						    	 	student_dataList.add(new Student(Integer.parseInt(literary[0]), literary[1], Double.parseDouble(literary[2])));
							    	System.out.println("   "+"Student   SeatNumber: "+literary[0]+" | Branch: "+literary[1]+" | AVG: "+Double.parseDouble(literary[2])+" ("+grade(Double.parseDouble(x[2]))+")\n");
						     }
						    //
						    // if choice_1 = 2(file) -> print data for literary.
						     
						    ///////////////////////////////////////-- Scientific data--////////////////////////////////////////
						    
						    ///////////////////-- Linked list way --///////////////////////
						    if(x[1].equals("Scientific") && choice_3==3 && choice_1==1) {
						    	scientific=x;
						    	stud.setSeat_num(Integer.parseInt(scientific[0]));
							    stud.setBranch(scientific[1]);
							    stud.setAvg(Double.parseDouble(scientific[2]));
							    
							    l1.traverseinsertsorted(stud.getAvg()+","+stud.getBranch()+","+stud.getSeat_num());
						    	l.insertatlast(stud.toString());	//also, insert the scientific data to linked list.
						    	
						    }
						    
							//////////////////////-- file way --//////////////////////////
						    else if(x[1].equals("Scientific") && choice_3==3 && choice_1==2) {
						    	scientific=x;
						    	
						    	student_dataList.add(new Student(Integer.parseInt(scientific[0]), scientific[1], Double.parseDouble(scientific[2])));
					    	 	System.out.println("   "+"Student   SeatNumber: "+scientific[0]+" | Branch: "+scientific[1]+" | AVG: "+Double.parseDouble(scientific[2])+" ("+grade(Double.parseDouble(x[2]))+")\n");
					     }
						    //
						    // if choice_1 = 2(file) -> print data for scientific.
						     
						    ///////////////////////////////////////////////////////////////////////////////////////////  
						}
						
							if(choice_1==1) {
								l.show(); 
							} // if choice_1 = 1(linked list) -> print data in linked list style.
				
							/////////////////////////////////////////////////////////////////////////////////////////// 
							if(choice_2==1) {
								if(choice_3==1) {
									System.out.println("\n   "+"All WestBank tawjihi records was loaded successfully :)");
								}
								else if(choice_3==2) {
									System.out.println("\n   "+"All WestBank tawjihi records of literary branch was loaded successfully :)");
								}
								else if(choice_3==3) {
									System.out.println("\n   "+"All WestBank tawjihi records of scientific branch was loaded successfully :)");
								}
							}
						
							///////////////////////////////
							else if(choice_2==2){
								if(choice_3==1) {
									System.out.println("\n   "+"All Gaza tawjihi records was loaded successfully :)");
								}
								else if(choice_3==2) {
									System.out.println("\n   "+"All Gaza tawjihi records of literary branch was loaded successfully :)");
								}
								else if(choice_3==3) {
									System.out.println("\n   "+"All Gaza tawjihi records of scientific branch was loaded successfully :)");
								}
							}
						
						
						// after print the data, print sentence said the data was loaded.	
					
						}
					
						
				
			}
			else {
				if(choice_2==1) {
					System.out.println("   "+"WestBank record file is empty !!!");
				}
				else {
					System.out.println("   "+"Gaza record file is empty !!!");
				}
				 // if there aren't data in the file.
			}
			
			///////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println("===============================================================================");
			String s="" ;
			if(choice_3==1) {
				s="";
			}
			else if(choice_3==2) {
				s=" on Literary brunch";
			}
			else if(choice_3==3) {
				s=" on scientific brunch";
			}
			
			
			String s2;
			if(choice_2==1) {
				s2="Westbank";
			}
			else {
				s2="Gaza";
			}
			System.out.println("                         "
					+ "--- "+s2+" Records Operation"+" ---\n");
			System.out.println("Please enter whats do you want to do"+s+": \n");
		 	System.out.print("1-Insert New Tawjihi Record.\n"
		 			+ "2-Delete A Tawjihi Record.\n"
		 			+ "3-Search In A Tawjihi Record.\n"
		 			+ "4-Display The Top ten Student.\n"
		 			+ "5-Calculate And Display The Mean(Average).\n"
		 			+ "6-Calculate And Display The Mode(Average).\n"
		 			+ "7-Number And Percentage Of Students Whom Grade Above Or Equal A Specific Grade.\n"
		 			+ "8-Save And Close the Program.\n");
		 	
		 	System.out.print("\nOperation number: ");
		 	menu=in.nextInt();
		 	menu=invalid_operation(menu); //((forth question)) to check if the input is correct ( (input: menu) one of these operation ).
		 	
		 	
		 /////////////////////////////////////////////////////////////////////////////////////////////////
		 	
		 	
		 	
		 	System.out.println("-----------------------------------------------------------------");
		 	switch(menu) {
		 	case 1:{
		 		insertSortedRecord_case1(choice_1,choice_3,write_chosen,l,stud); // to insert new data inside record in sorted way.
		 		break;
		 	}
		 	case 2:{
		 		deleteRecord_case2(choice_1,choice_2,choice_3,write_chosen,l,stud); // to delete data inside record.
		 		break;
		 	}
		 	case 3:{
		 		searchRecord_case3(choice_1,choice_3,l,stud); // to search data inside record.
		 		break;
		 	}
		 	case 4:{
		 		topTenStudRecord_case4(choice_1,l1,stud); // to review top 10 student grade.
		 		break;
		 	}
		 	case 5:{
		 		avgRecord_case5(choice_1,choice_2,choice_3,l,stud); // to calculate the average of student. 
		 		break;
		 	}
		 	case 6:{
		 		modeRecord_case6(choice_1,l); // to calculate the mode of student.
		 		break;
		 	}
		 	case 7:{
		 		numAndPerAboveRecord_case7(choice_1,choice_2,choice_3,l); // to review number and percentage of student who above or equal special grade.
		 		break;
		 	}
		 }
		 	
		}
				
		
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		catch (FileNotFoundException e) {
			System.out.println("   "+"Tawjihi record file is empty !!!");
		} 
	
	}
	
	
	
	
	
	
	
	
	
	
	
	/////////////////////////////--- Operation method ---////////////////////////////////
	
	public static void insertSortedRecord_case1(int choice_1,int choice_3,FileWriter write_chosen,LinkedList<String> l,Student stud) throws IOException{
		
		System.out.println("\ninsert operation:>\n\n");
		
		
		////////////////////////////////////////////- seat number -////////////////////////////////////////
		
		
	
			System.out.print("Please enter student seat number: ");
			seat_num=in.nextInt();
			
			
			seat_num=invalid_seatNum(seat_num);
			
			
			boolean z=l.duplicate_seatnum(seat_num+"");
			while(z==true) {
				System.out.print("this seat number ("+seat_num+") is duplicate number !!!\n"
						+ "please re-enter a new seat number: ");
				seat_num=in.nextInt();
				seat_num=invalid_seatNum(seat_num);
			}
		

		System.out.println("-------------------------------\n");
		
		///////////////////////////////////////////- branch -/////////////////////////////////////////////
		
		if(choice_3==1) {
			System.out.print("Please enter student branch( literary/scientific ): ");
			branch=in.next();
			branch=invalid_branch(branch);
			System.out.println("-------------------------------\n");
		}

		/////////////////////////////////////////
		else if(choice_3==2) {
			branch="Literary"; // literary brunch
		}

		/////////////////////////////////////////
		else if(choice_3==3) {
			branch="Scientific"; // scientific brunch
		}

		//////////////////////////////////////////////- average -///////////////////////////////////////
		System.out.print("Please enter student average: ");
		avg=in.nextDouble();
		avg=invalid_avg(avg);

		///////////////////////////////////////////////////////////////////////////////////////////////
		//Student op1=new Student(seat_num,branch,avg);
		stud=new Student(seat_num,branch,avg);
		System.out.println("===============================================================================");
		
		
		
		
		
		
		
		
		///////////////////-- Linked list way --///////////////////////
		if(choice_1==1) {
			l.insertsorted(stud.toString());
		}
		
		//////////////////////-- file way --//////////////////////////
		else if(choice_1==2){
			student_dataList.add(stud);
			write_chosen.write(stud.toString()+"\n");
		}
		//////////////////////////////////////////////////////////////
		
		
		System.out.println("\n\n   "+"---------------------- The New Tawjihi Records -----------------------\n");
		for (Student student : student_dataList) {
			if(student.getBranch().equals("Literary")) {
		    	System.out.println("   "+"Student   SeatNumber: "+student.getSeat_num()+" | Branch: "+student.getBranch()+"  "+" | AVG: "+student.getAvg()+" ("+grade(student.getAvg())+")\n");
	    	}
	    	else if(student.getBranch().equals("Scientific")) {
	    		System.out.println("   "+"Student   SeatNumber: "+student.getSeat_num()+" | Branch: "+student.getBranch()+" | AVG: "+student.getAvg()+" ("+grade(student.getAvg())+")\n");
	    	}
		}
	}
	
	public static void deleteRecord_case2(int choice_1,int choice_2,int choice_3,FileWriter write_chosen,LinkedList<String> l,Student stud) throws IOException{
		
		System.out.println("\ndelete operation:>\n\n");
		
		System.out.print("please enter seat number of the student u want to delete: ");
		seat_num=in.nextInt();
		seat_num=invalid_seatNum(seat_num);
		
		
		String s = null;
		if(choice_3==1) {
			s="All brunch";
		}
		else if(choice_3==2) {
			s="Literary brunch";
		}
		else if(choice_3==3) {
			s="Scientific brunch";
		}
		
		
		///////////////////-- Linked list way --///////////////////////
		if(choice_1==1) {
			
			String studInfo=l.search(seat_num+"");
			if(studInfo != null) {
				l.delete(studInfo);
				System.out.println("\n\nthe student who have this seat number ("+seat_num+") has been deleted successfully.\n\n");
			}
			else {
				System.out.println("\nthere is no student have this seat number !!!");
			}
		}
		
		
		//////////////////////-- file way --//////////////////////////
		else if(choice_1==2) {
			
			boolean stud_exist=false;
			for (Student student : student_dataList) {
				if(student.getSeat_num()==seat_num) {
					student_dataList.remove(student);
					System.out.println("\n\nthe student who have this seat number ("+seat_num+") has been deleted successfully.\n\n");
					stud_exist=true;
					break;
				}
			}
			
			if(stud_exist==false) {
				System.out.println("\nthere is no student have this seat number !!!");
			}
			
			
					
		}
		
		System.out.println("===============================================================================");
		
		System.out.println("\n\n   "+"---------------------- The New Tawjihi Records -----------------------\n");
		for (Student student : student_dataList) {
			if(student.getBranch().equals("Literary")) {
		    	System.out.println("   "+"Student   SeatNumber: "+student.getSeat_num()+" | Branch: "+student.getBranch()+"  "+" | AVG: "+student.getAvg()+" ("+grade(student.getAvg())+")\n");
	    	}
	    	else if(student.getBranch().equals("Scientific")) {
	    		System.out.println("   "+"Student   SeatNumber: "+student.getSeat_num()+" | Branch: "+student.getBranch()+" | AVG: "+student.getAvg()+" ("+grade(student.getAvg())+")\n");
	    	}
		}
	}
	
	public static void searchRecord_case3(int choice_1,int choice_3,LinkedList<String> l,Student stud) throws IOException{
		
		System.out.println("\nsearch operation:>\n\n");
		
        System.out.print("please enter seat number of the student u search for: ");
 		seat_num=in.nextInt();
 		seat_num=invalid_seatNum(seat_num);
 		
 		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		String s = null;
		
		
		if(choice_3==1) {
			s="All brunch";
		}
		else if(choice_3==2) {
			s="Literary brunch";
		}
		else if(choice_3==3) {
			s="Scientific brunch";
		}
				
				
		///////////////////-- Linked list way --///////////////////////
		if(choice_1==1) {
			String studInfo = l.search(seat_num+"");
			
			if (studInfo != null) {
				System.out.println("\nThe Student: " + studInfo + "\n");
			}
			else if (studInfo == null) {
				System.out.println("\nthere isn't student have this seat number in " + s + ".\n");
			}	
		}
		
		//////////////////////-- file way --//////////////////////////
		else if(choice_1==2) {
			
			for (Student student : student_dataList) {
				if(student.getSeat_num()==seat_num) {
						System.out.println("\n"+"Student   SeatNumber: "+student.getSeat_num()+" | Branch: "+student.getBranch()+" | AVG: "+student.getAvg()+" ("+grade(student.getAvg())+")\n");
					}				
				}
			
			}
			
			
		}
		
	public static void topTenStudRecord_case4(int choice_1,LinkedList<String> l1,Student stud) throws IOException{
		
		System.out.println("\ntop 10 student operation:>\n\n");
		
		System.out.println("The Student: \n");
		
		
		///////////////////-- Linked list way --///////////////////////
		if(choice_1==1) {
			System.out.println(l1.topTenstud());
		}
		
		
		
		///////////////////-- Linked list way --///////////////////////
		else if(choice_1==2) {
			FXCollections.sort(student_dataList, (s1, s2) -> Double.compare(s2.getAvg(), s1.getAvg()));
			
			for (int i = 0; i < 10; i++) {
	            stud = student_dataList.get(i);
	           
	            System.out.println("stud   SeatNumber: "+stud.getSeat_num()+" | Branch: "+stud.getBranch()+" | AVG: "+stud.getAvg()+" ("+grade(stud.getAvg())+")\n");
	        }
		}
		

		
}
	
	public static void avgRecord_case5(int choice_1,int choice_2,int choice_3,LinkedList<String> l,Student stud) throws IOException{
		
		System.out.println("\ncalculate mean(average) operation:>\n\n");
		
		double res=0;
		///////////////////-- Linked list way --///////////////////////
		
		if(choice_1==1) {
			res=l.mean();
		}
		
		
		
		//////////////////////-- file way --//////////////////////////
		else if (choice_1 == 2) {

			double sum = 0; //
			int count = 0; // those to calculate the average.

			for (Student student : student_dataList) {
				sum += student.getAvg();
				count++;
			}

			res = sum / count;

		}
		///////////////////////////////////////////////////////////////////////////////////
		
		
		String s;
		if(choice_2==1) {
			s="WestBank";
		}
		else{
			s="Gaza";
		}
		System.out.println("Mean of "+s+" Records\n");
		
		
		if(choice_3==1) {
			System.out.println("All Brunch Mean: "+res);
		}
		else if(choice_3==2) {
			System.out.println("Literary Mean: "+res);
		}
		else if(choice_3==3) {
			System.out.println("Scientific Mean: "+res);
		}
		
		
		
		
	}
	
	public static void modeRecord_case6(int choice_1, LinkedList<String> l) throws IOException{
		System.out.println("\ncalculate Mode operation:>\n\n");
		
		
		if(choice_1==1) {
			System.out.println("\n\n The Mode: "+l.mode());
		}
		else if(choice_1==2) {
			int maxCount = 0;
	        double mode = 0;

	        for (Student student : student_dataList) {
	            double currentAverage = student.getAvg();
	            int currentCount = 1;

	            for (Student otherStudent : student_dataList) {
	                if (otherStudent != student && otherStudent.getAvg() == currentAverage) {
	                    currentCount++;
	                }
	            }

	            if (currentCount > maxCount) {
	                maxCount = currentCount;
	                mode = currentAverage;
	            }
	        }
	        
			System.out.println("\n\n The Mode: "+mode);
		}
	}
	
 	public static void numAndPerAboveRecord_case7(int choice_1,int choice_2,int choice_3,LinkedList<String> l) throws IOException{
		
		System.out.println("\nnumber and percentage of student operation:>\n\n");
		
		double grade;
		System.out.print("please enter the grade: ");
		grade=in.nextDouble();
		grade=invalid_avg(grade);
		
		double count=0;
		double count_brunch=0;
		
		///////////////////-- Linked list way --///////////////////////
		
		if(choice_1==1) {
			count=l.count_spesificStud(grade);
			count_brunch=l.count_brunch();
		}
		
		//////////////////////-- file way --//////////////////////////
		
		else if(choice_1==2) {
			
			for (Student student : student_dataList) {
				if(student.getAvg()==grade) {
					count++;
				}
			}
			
			count_brunch=student_dataList.size();
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n------------------------------");
		
		String s = null;
		
		if(choice_3==1) {
			s="All brunch";
		}
		else if(choice_3==2) {
			s="Literary brunch";
		}
		else if(choice_3==3) {
			s="Scientific brunch";
		}
		
		String s1;
		if(choice_2==1) {
			s1="WestBank";
		}
		else{
			s1="Gaza";
		}
		
		
		System.out.println(s1+" Records\n");
		
			System.out.println("Number of students whom grade above or equal ("+grade+") on "+s+": "+count);
			System.out.println("\nPercentage of those student: "+(count/count_brunch)*100+"%");
		
		
		
		
	}
	
 	
 	//////////////////////////////////////////////////////////////////////////////////////**************************************************
	
	
	
	
	
	
	
	
	////////////////////////////////--- invalid method ---/////////////////////////////////
 	
 	public static int invalid_choice_way(int choice_1) {
 		while(choice_1<1 || choice_1>2) {
			System.out.println("   "+"############################################################");
			System.out.println("\n"+"   "+"Wrong entered(There isn't choice Number "+choice_1+") !!!!\n");
			System.out.println("   "+"You should enter one of these choices:\n");
			System.out.println("   "+"1-Linked list.\n"
							  +"   "+"2-File.\n");
			System.out.print("\n   "+"Please re-enter choice number: ");
			choice_1=in.nextInt();
		}
		System.out.println("\n");
		return choice_1;
 	}
	
 	// if the user enter invalid way choice number in the first question.
 	
	public static int invalid_choices_file(int choice_2) {
		while(choice_2<1 || choice_2>2) {
			System.out.println("   "+"############################################################");
			System.out.println("\n"+"   "+"Wrong entered(There isn't choice Number "+choice_2+") !!!!\n");
			System.out.println("   "+"You should enter one of these choices:\n");
			System.out.println("   "+"1-West Bank.\n"
					+"   "+"2-Gaza.\n");
			System.out.print("   "+"Please re-enter choice number: ");
			choice_2=in.nextInt();
		}
		System.out.println("\n");
		return choice_2;

	}

	// if the user enter invalid file choice number in the second question.
	
	
	public static int invalid_choices_branch(int choice_3) {
		while (choice_3<=0 || choice_3>3) {
			System.out.println("   "+"############################################################");
			System.out.println("\n"+"   "+"Wrong entered(There isn't choice Number "+choice_3+") !!!!\n");
			System.out.println("   "+"You should enter one of these choices:\n");
			System.out.println("   "+"1-All brunch.\n"
					+"   "+"2-Literary.\n"
					+"   "+"3-Scientific.\n");
			System.out.print("   "+"Please re-enter choice number: ");
			choice_3=in.nextInt();
		}
		System.out.println("\n");
		return choice_3;

	}

	// if the user enter invalid brunch choice number in the third question.


	public static int invalid_operation(int menu) {
		while (menu<=0 || menu>7) {
			System.out.println("############################################################");
			System.out.println("\nWrong entered(There isn't operation Number "+menu+") !!!!\n");
			System.out.println("You should enter one of these operation:\n");
			System.out.println("1-Insert New Tawjihi Record.\n"
		 			+ "2-Delete A Tawjihi Record.\n"
		 			+ "3-Search In A Tawjihi Record.\n"
		 			+ "4-Display The Top ten Student.\n"
		 			+ "5-Calculate And Display The Mean(Average).\n"
		 			+ "6-Calculate And Display The Mode(Average).\n"
		 			+ "7-Number and percentage of students whom grade above or equal a specific grade.\n");
			System.out.print("Please re-enter Operation number: ");
			menu=in.nextInt();
		}
		return menu;
	}

	// if the user enter invalid operation number in the forth question.
	
	
   ///////////////////////////--- in operation method ---///////////////////////////////////
	
	
	        	       ///// -- case 1 -- /////
	
		    public static int invalid_seatNum(int seat_num) {
			    while(seat_num<10000000 || seat_num>99999999) {
					 System.out.println("########################################################");
				     System.out.println("\nInvalid seat number (It's should contains 8 digit) !!!"); // seat number
					 System.out.print("\nPlease re-enter seat number: ");
					 seat_num=in.nextInt();
				  }
			    return seat_num;
		    }
		  
		    // if the user enter invalid seat number.
		    
		    public static String invalid_branch(String branch) {
		    	while(!branch.equals("Literary") && !branch.equals("literary") && !branch.equals("Scientific") && !branch.equals("scientific")) {
					System.out.println("#############################################################");
					System.out.println("\nInvalid branch (It's should be Literary or Scientific) !!!");
					System.out.print("\nPlease re-enter branch: ");  // all brunch
					branch=in.next();
				}
		    	return branch;
		    }
	
		    //if the user enter invalid branch.
		    
		    public static double invalid_avg(double avg) {
		    	while(avg<0 || avg>100) {
					System.out.println("###############################################################");
					System.out.println("\nInvalid average value (It's should be between (0 - 100) ) !!!");
					System.out.print("\nPlease re-enter average: ");  // avg
					avg=in.nextDouble();
				}
		    	return avg;
		    }
		    
		    //if the user enter invalid average.
		    
		    
		    
		    
		    
	//////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
		    
		    
		    
	///////////////////////////--- grade method(Pass\Fail) ---////////////////////////////
	
	public static String grade(double x) {

		if(x>=50) {
			return "Pass";
		}
		else {
			return "Fail";
		}
	}

	// to set pass or fail according to grade.
	//////////////////////////////////////////////////////////////////////////////////////

}
