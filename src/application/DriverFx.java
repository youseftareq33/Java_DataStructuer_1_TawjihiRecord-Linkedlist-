package application;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.ButtonGroup;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent; 


public class DriverFx extends Application {
	
	static LinkedList<String> l = new LinkedList<>();
	static LinkedList<String> l1 = new LinkedList<>();
	static Scanner in=new Scanner(System.in);
	
	static int seat_num;
	static String branch;
	static double avg;
	
	static Student stud=new Student(seat_num, branch, avg);
	
	public void start(Stage s) throws IOException {
		BorderPane bp1=new BorderPane();
		GridPane gp=new GridPane();
		VBox vb1=new VBox();
		HBox hb1=new HBox();
		
		RadioButton r1 = new RadioButton("WestBank");
        RadioButton r2 = new RadioButton("Gaza");
		
        DropShadow shadow = new DropShadow();
        
        
        ToggleGroup tg1=new ToggleGroup();
        tg1.getToggles().add(r1);
        tg1.getToggles().add(r2);
        r1.setSelected(false);
        
        RadioButton r3 = new RadioButton("All Brunch");
        RadioButton r4 = new RadioButton("Literary");
        RadioButton r5 = new RadioButton("Scientific");
       
        ToggleGroup tg2=new ToggleGroup();
        tg2.getToggles().add(r3);
        tg2.getToggles().add(r4);
        tg2.getToggles().add(r5);
        
        Label f1=new Label(" || Welcome to TawjihiRecord_2022 Simulatour || ");
		
		Text t1=new Text("Please choose the file you want:");
		Text t2=new Text("Please choose the Branch you want:");
		
		Button b0=new Button("next ->");
		Button b1=new Button("Insert New Tawjihi Record");
		Button b2=new Button("Delete A Tawjihi Record");
		Button b3=new Button("Search In A Tawjihi Record");
		Button b4=new Button("Display The Top Ten Student");
		Button b5=new Button("Display The Mean(Average)");
		Button b6=new Button("Display The Mode");
		Button b7=new Button("Above Or Equal Specific Grade");
		Button b8=new Button("Display The Student");
		Button b9=new Button("Return To The Main Page");
		////////////////////////////////////////////--- First scene ---////////////////////////////////////////////
		//first page style.
		bp1.setStyle("-fx-border-width: 2; -fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN");
		////////////////////
		//first page style.
				gp.setStyle("-fx-border-width: 2; -fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN");
				gp.setHgap(10);
				gp.setVgap(20);
				
				//label (f1) style.
				f1.setPrefSize(350, 25);
				f1.setStyle("-fx-border-color: OLIVEDRAB;-fx-font-size:15;-fx-font-weight:bold;-fx-background-color: OLIVEDRAB;");
				gp.add(f1, 2, 0);
				
				//text (t1) style.
				t1.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
				gp.add(t1, 1, 2);
				
				//radio buttons.
				gp.add(r1, 1, 3);
				gp.add(r2, 1, 4);
				
				//text (t2) style.
				t2.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
				gp.add(t2, 1, 6);
				
				//radio buttons.
				hb1.getChildren().addAll(r3,r4,r5);
				hb1.setSpacing(18);
				gp.add(hb1, 1, 7);
				
				//buttons.
				b0.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
				gp.add(b0, 7, 10);
				
				Scene scene1=new Scene(gp,900,400);
				b0.setOnAction(e0->{
					
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////
					//file------------
					File f=null;
					Text t3=new Text("Select one of these files !!!");
					Text t4=new Text("Select one of these choices !!!");
					
					
					if(r1.isSelected()!=true && r2.isSelected()!=true) {
						
						t3.setFill(Color.RED); 
						gp.add(t3, 1, 5);
					}
					else if(r1.isSelected()==true || r2.isSelected()==true){
						File westbank_file=new File("WestBank_2022.csv");
						File gaza_file=new File("Gaza_2022.csv");
						
						if(r1.isSelected()==true) {
							f=westbank_file;
						}
						else if(r2.isSelected()==true) {
							f=gaza_file;
						}
					}
					
					
					
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////
					//branch------------
					if(r3.isSelected()!=true && r4.isSelected()!=true && r5.isSelected()!=true) {
						
						t4.setFill(Color.RED);
						gp.add(t4, 1, 8);
					}
					else if(r3.isSelected()==true || r4.isSelected()==true || r5.isSelected()==true) {
						try {
							String x[];
							String literary[];
							String scientific[];
							Scanner scan_tawjihi=new Scanner(f);
							
							while(scan_tawjihi.hasNextLine()) {
							    x=scan_tawjihi.nextLine().split(",");
							    if(r3.isSelected()==true) {
							    	
							    	stud.setSeat_num(Integer.parseInt(x[0]));
								    stud.setBranch(x[1]);
								    stud.setAvg(Double.parseDouble(x[2]));
								    
								    l1.traverseinsertsorted(stud.getAvg()+","+stud.getBranch()+","+stud.getSeat_num());
								    l.insertatlast(stud.toString());
							    	 							    	
							    }
							    else if(r4.isSelected()==true && x[1].equals("Literary")) {
							    	
							    	
							    	literary=x;
							    	stud.setSeat_num(Integer.parseInt(literary[0]));
								    stud.setBranch(literary[1]);
								    stud.setAvg(Double.parseDouble(literary[2]));
							    	
								    l1.traverseinsertsorted(stud.getAvg()+","+stud.getBranch()+","+stud.getSeat_num());
							    	l.insertatlast(stud.toString());
							    	 
							    }
							    else if(r5.isSelected()==true && x[1].equals("Scientific")) {
							    	
							    	scientific=x;
							    	stud.setSeat_num(Integer.parseInt(scientific[0]));
								    stud.setBranch(scientific[1]);
								    stud.setAvg(Double.parseDouble(scientific[2]));
								    
								    l1.traverseinsertsorted(stud.getAvg()+","+stud.getBranch()+","+stud.getSeat_num());
							    	l.insertatlast(stud.toString());
							    	
							    }
							}
							
							
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					
					
					
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					// thhhhheeee   second scene.............................................
					if((r1.isSelected()==true || r2.isSelected()==true) && (r3.isSelected()==true || r4.isSelected()==true || r5.isSelected()==true)) {
						GridPane gp1=new GridPane();
						VBox vb2=new VBox();
						Scene scene2=new Scene(vb2,600,600);
						//vb2 style.
						vb2.setSpacing(20);
						vb2.setStyle("-fx-border-width: 2; -fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN");
						vb2.setPadding(new Insets(10,10,10,135));
						
						
						
						//////////////////////////////////---------- inserrrrrrrtt --------------////////////////////////////////////////////////
						// b1 style
						b1.setPrefSize(320, 43);
						b1.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
								+ "-fx-Border-width:2;-fx-font-weight:bold;");
						b1.addEventHandler(MouseEvent.MOUSE_ENTERED,
						        new EventHandler<MouseEvent>() {
						          @Override
						          public void handle(MouseEvent e) {
						            b1.setEffect(shadow);
						            b1.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
						            		+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
						          }
						        });
						b1.addEventHandler(MouseEvent.MOUSE_EXITED,
						        new EventHandler<MouseEvent>() {
						          @Override
						          public void handle(MouseEvent e) {
						            b1.setEffect(null);
						            b1.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						            		+ "-fx-Border-width:2;-fx-font-weight:bold;");
						          }
						        });
					
						vb2.getChildren().add(b1);
						
						//////////////////////////////////////////////////////////////////////
						
						b1.setOnAction(e1->{
							GridPane gp3=new GridPane();
							Scene sceneadd=new Scene(gp3,700,320);
							gp3.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
							gp3.setHgap(30);
							gp3.setVgap(8);
							//////////////////////////////////
							Text c0=new Text("Student Number :");
							c0.setStyle("-fx-font-size:13;-fx-font-weight:bold;");
							gp3.add(c0, 2, 5);
							TextField ct0=new TextField();
							ct0.setPromptText("123,(8-digit),....itc");
							ct0.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
							gp3.add(ct0, 3, 5);
							/////////////////////////////////
							Text c1=new Text("Student Brunch :");
							TextField ct2=new TextField();
							TextField ct1=new TextField();
							
							
							if(r4.isSelected()==true) {
								ct1.setText("Literary");
								
								Text c2=new Text("Student average :");
								c2.setStyle("-fx-font-size:13;-fx-font-weight:bold;");
								gp3.add(c2, 2, 6);
								
								ct2.setPromptText("60,88,...itc");
								ct2.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
								gp3.add(ct2, 3, 6);
							}
							
							else if(r5.isSelected()==true) {
								ct1.setText("Scientific");
								Text c2=new Text("Student average :");
								c2.setStyle("-fx-font-size:13;-fx-font-weight:bold;");
								gp3.add(c2, 2, 6);
								
								ct2.setPromptText("60,88,...itc");
								ct2.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
								gp3.add(ct2, 3, 6);
							}
							else {
								
								c1.setStyle("-fx-font-size:13;-fx-font-weight:bold;");
								gp3.add(c1, 2, 6);
								
								ct1.setPromptText("Literary,Scientific");
								ct1.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
								gp3.add(ct1, 3, 6);
								/////////////////////////////////////////////
								Text c2=new Text("Student average :");
								c2.setStyle("-fx-font-size:13;-fx-font-weight:bold;");
								gp3.add(c2, 2, 7);
								
								ct2.setPromptText("60,88,...itc");
								ct2.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
								gp3.add(ct2, 3, 7);
							}
							
							///////////////////////////////////////////
							///////////////////////////////////////////
							Button b_add=new Button("Add");
							b_add.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
							gp3.add(b_add, 7, 9);
							gp3.setHalignment(b_add, HPos.RIGHT);
							b_add.setOnAction(ac0->{
								Label er = new Label("");
					            gp3.add(er, 3, 8);
					           // double x=1+2;
					            //int x;
					            if(r4.isSelected()==true || r5.isSelected()==true) {
					            	if (ct0.getText().equals("") == true || ct2.getText().equals("") == true) {
						                er.setText("    Error:  please fill all the text fields  :*( ");
						                	
						                er.setPrefSize(260, 60);
										er.setStyle("-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
												+ "-fx-text-fill:#ff0000");
						            }
					            	else {
										//System.out.println("hh");
										l.insertsorted(ct0.getText()+","+ct1.getText()+","+ct2.getText());
										l1.traverseinsertsorted(ct0.getText()+","+ct1.getText()+","+ct2.getText());
										//System.out.println(ct0.getText()+","+ct1.getText()+","+ct2.getText());
										ct0.setText("");
					                    ct1.setText("");
					                    ct2.setText("");
					                    ct0.setPromptText(" ");
					                    ct1.setPromptText(" ");
					                    ct2.setPromptText(" ");
					                    ct0.setEditable(false);
					                    ct1.setEditable(false);
					                    ct2.setEditable(false);
					                    //l.insertatlast(ct0.getText()+","+ct1.getText()+","+ct2.getText());
					                    System.out.println(ct0.getText()+","+ct1.getText()+","+ct2.getText());
						            	Label add=new Label("the Student was insert successfully : )");
										gp3.add(add, 3, 8);
										add.setPrefSize(260, 60);
										
										add.setStyle("-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
												+ "-fx-text-fill:MEDIUMSPRINGGREEN");
										add.setAlignment(Pos.CENTER);
						            }
					            }
					            else if(r3.isSelected()==true){
					            	if (ct0.getText().equals("") == true || ct1.getText().equals("") == true || ct2.getText().equals("") == true) {
						                er.setText("    Error:  please fill all the text fields  :*( ");
						                	
						                er.setPrefSize(260, 60);
										er.setStyle("-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
												+ "-fx-text-fill:#ff0000");
						            }
					            	else {
										//System.out.println("hh");
										l.insertsorted(ct0.getText()+","+ct1.getText()+","+ct2.getText());
										l1.traverseinsertsorted(ct0.getText()+","+ct1.getText()+","+ct2.getText());
										//System.out.println(ct0.getText()+","+ct1.getText()+","+ct2.getText());
										ct0.setText("");
					                    ct1.setText("");
					                    ct2.setText("");
					                    ct0.setPromptText(" ");
					                    ct1.setPromptText(" ");
					                    ct2.setPromptText(" ");
					                    ct0.setEditable(false);
					                    ct1.setEditable(false);
					                    ct2.setEditable(false);
					                    //l.insertatlast(ct0.getText()+","+ct1.getText()+","+ct2.getText());
					                    System.out.println(ct0.getText()+","+ct1.getText()+","+ct2.getText());
						            	Label add=new Label("the Student was insert successfully : )");
										gp3.add(add, 3, 8);
										add.setPrefSize(260, 60);
										
										add.setStyle("-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
												+ "-fx-text-fill:MEDIUMSPRINGGREEN");
										add.setAlignment(Pos.CENTER);
						            }
					            }
					          
						
								
								
								
							});
							Button b_back=new Button("Back");
							b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
							gp3.add(b_back, 6, 9);
							b_back.setOnAction(e12->{
								s.setScene(scene2);
							});
							gp3.setHalignment(b_back, HPos.CENTER);
							s.setScene(sceneadd);
							/////////////////////////////lllllllllllllllllllllllllllllllllllllllloooooooooooooooooooooooooooooooooooooooooo
						});
						//////////
						//////////////////////////////////---------- delllleeeete --------------////////////////////////////////////////////////
						
						b2.setPrefSize(320, 43);
						b2.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
								+ "-fx-Border-width:2;-fx-font-weight:bold;");
						b2.addEventHandler(MouseEvent.MOUSE_ENTERED,
						        new EventHandler<MouseEvent>() {
						          @Override
						          public void handle(MouseEvent e) {
						            b2.setEffect(shadow);
						            b2.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
						            		+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
						          }
						        });
						b2.addEventHandler(MouseEvent.MOUSE_EXITED,
						        new EventHandler<MouseEvent>() {
						          @Override
						          public void handle(MouseEvent e) {
						            b2.setEffect(null);
						            b2.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						            		+ "-fx-Border-width:2;-fx-font-weight:bold;");
						          }
						        });
						vb2.getChildren().add(b2);
						
						///////////////////////////////////////////////////////////////////////////////////////
						
						b2.setOnAction(e2->{
/////////////////////////////lllllllllllllllllllllllllllllllllllllllloooooooooooooooooooooooooooooooooooooooooo
					GridPane gp4=new GridPane();
					Scene scenedell=new Scene(gp4,600,320);
					gp4.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
					gp4.setHgap(30);
					gp4.setVgap(8);
					////////////////////////////////////////
					Label c0=new Label("Student Number :");
					c0.setStyle("-fx-font-size:13;-fx-font-weight:bold;");
					gp4.add(c0, 2, 5);
					TextField ct0=new TextField();
					ct0.setPromptText("123,(8-digit),....itc");
					ct0.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
					gp4.add(ct0, 3, 5);
					//////////////////////////////////////
					
					Button b_del=new Button("Delete");
					b_del.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
					gp4.add(b_del, 4, 11);
					gp4.setHalignment(b_del, HPos.RIGHT);
					b_del.setOnAction(ac0->{
						Label er = new Label("");
			            gp4.add(er, 3, 8);
			            
						if (ct0.getText().equals("") == true) {
			                er.setText("Error: there isn't data filled in text fields\n "
			                		+ "  please fill the text fields  :*(");
			                er.setPrefSize(260, 60);
							er.setStyle("-fx-border-color: DARKCYAN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
									+ "-fx-text-fill:#ff0000");
			            }
						
						else {
						String studInfo=l.search(ct0.getText());
						if(studInfo==null) {
							 er.setText("Error: there is no student have this seat number");
				                er.setPrefSize(290, 60);
								er.setStyle("-fx-border-color: DARKCYAN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
										+ "-fx-text-fill:#ff0000");
						}
						else {
							System.out.println(studInfo);
							l.delete(studInfo);
							ct0.setText("");
							ct0.setPromptText(" ");
							Label delete=new Label("the Student was deleted successfully");
							gp4.add(delete, 3, 8);
							delete.setPrefSize(260, 60);
							gp4.setHalignment(delete, HPos.LEFT);
							delete.setStyle("-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
								+"-fx-text-fill:MEDIUMSPRINGGREEN");
							delete.setAlignment(Pos.CENTER);
						}
						
						}
					});
					
					Button b_back=new Button("Back");
					b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
					gp4.add(b_back, 3, 11);
					gp4.setHalignment(b_back, HPos.CENTER);
					b_back.setOnAction(e21->{
						s.setScene(scene2);
					});
					
					
					
					
					
					s.setScene(scenedell);
					
					/////////////////////////////lllllllllllllllllllllllllllllllllllllllloooooooooooooooooooooooooooooooooooooooooo
				});
				

						//////////////////////////////////---------- searccccch --------------////////////////////////////////////////////////
									
						b3.setPrefSize(320, 43);
						b3.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						+ "-fx-Border-width:2;-fx-font-weight:bold;");
						b3.addEventHandler(MouseEvent.MOUSE_ENTERED,
						new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
						  b3.setEffect(shadow);
						  b3.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
						  		+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
						}
						});
						b3.addEventHandler(MouseEvent.MOUSE_EXITED,
						new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
						  b3.setEffect(null);
						  b3.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						  		+ "-fx-Border-width:2;-fx-font-weight:bold;");
						}
						});
						vb2.getChildren().add(b3);
						
						//////////////////////////////////
						b3.setOnAction(e31->{
					/////////////////////////////lllllllllllllllllllllllllllllllllllllllloooooooooooooooooooooooooooooooooooooooooo
					GridPane gp5=new GridPane();
					Scene scenesearch=new Scene(gp5,600,320);
					gp5.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
					gp5.setHgap(30);
					gp5.setVgap(8);
					Label ps=new Label("Please enter student number : ");
					ps.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
					gp5.add(ps, 2, 1);
					Label s_id=new Label("Student Number : ");
					s_id.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
					gp5.add(s_id, 2, 5);
					TextField ct0=new TextField();
					ct0.setPromptText("123,(8-digit),....itc");
					ct0.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
					gp5.add(ct0, 3, 5);
					
					Button b_search_next=new Button("Next");
					b_search_next.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
					gp5.add(b_search_next, 3,11);
					gp5.setHalignment(b_search_next, HPos.RIGHT);
					b_search_next.setOnAction(n->{
							Label er = new Label("");
							gp5.add(er, 3, 8);
							String studInfo=l.search(ct0.getText());
							if (ct0.getText().equals("") == true) {
				                er.setText("Error: there isn't data filled in text fields\n "
				                		+ "  please fill the text fields  :*(");
				                er.setPrefSize(260, 60);
								er.setStyle("-fx-border-color: DARKCYAN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
										+ "-fx-text-fill:#ff0000");
				            }
							if(studInfo==null) {
								
								 er.setText("Error: there is no student have this seat number");
					                er.setPrefSize(290, 60);
									er.setStyle("-fx-border-color: DARKCYAN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
											+ "-fx-text-fill:#ff0000");
							}
							else {
								////////////////////////////////////////////////////////////////////////
								GridPane gp6=new GridPane();
								gp6.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
								Scene sceneinfosearch=new Scene(gp6,600,320);
								gp6.setHgap(30);
								gp6.setVgap(8);
								Label p_id=new Label("Student information");
								p_id.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
								gp6.add(p_id, 2, 1);
								TextArea ta=new TextArea();
								ta.setText("     "+studInfo);
								ta.setStyle("-fx-border-color:FORESTGREEN;");
								ta.setWrapText(true);
								ta.setEditable(false);////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
								
								gp6.add(ta, 2, 4);
								
								Button b_back=new Button("Back");
								b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
								gp6.add(b_back, 2, 9);
								gp6.setHalignment(b_back, HPos.LEFT);
								
								b_back.setOnAction(searchbacccc->{
								s.setScene(scenesearch);
								});
								s.setScene(sceneinfosearch);
							}
						
						
						
						
					});
					
					Button b_back=new Button("Back");
					b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
					gp5.add(b_back, 3, 11);
					b_back.setOnAction(kl->{
						s.setScene(scene2);
					});
					gp5.setHalignment(b_back, HPos.CENTER);
//					
					s.setScene(scenesearch);
					/////////////////////////////lllllllllllllllllllllllllllllllllllllllloooooooooooooooooooooooooooooooooooooooooo
						});
						
						//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						//////////////////////////////////---------- top 10stud  --------------////////////////////////////////////////////////
									
						b4.setPrefSize(320, 43);
						b4.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						+ "-fx-Border-width:2;-fx-font-weight:bold;");
						b4.addEventHandler(MouseEvent.MOUSE_ENTERED,
						new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
						b4.setEffect(shadow);
						b4.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
						+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
						}
						});
						b4.addEventHandler(MouseEvent.MOUSE_EXITED,
						new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
						b4.setEffect(null);
						b4.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						+ "-fx-Border-width:2;-fx-font-weight:bold;");
						}
						});
						vb2.getChildren().add(b4);
						
						b4.setOnAction(e4->{
							GridPane gp44=new GridPane();
							gp44.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
							Scene scenetop=new Scene(gp44,700,600);
							gp44.setHgap(30);
							gp44.setVgap(8);
							Label p_id=new Label("Top 10 Student");
							p_id.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
							gp44.add(p_id, 2, 1);
							TextArea ta=new TextArea();
							
							ta.setText(l1.topTenstud());
							ta.setStyle("-fx-border-color:FORESTGREEN;");
							ta.setWrapText(true);
							ta.setEditable(false);////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
							//ta.setText(l.toString());
							gp44.add(ta, 2, 4);
							
							Button b_back=new Button("Back");
							b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
							gp44.add(b_back, 2, 9);
							b_back.setOnAction(k->{
								s.setScene(scene2);
							});
							gp44.setHalignment(b_back, HPos.LEFT);
							
							s.setScene(scenetop);
						});
						//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						
						//////////////////////////////////---------- mean  --------------////////////////////////////////////////////////
									
						b5.setPrefSize(320, 43);
						b5.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						+ "-fx-Border-width:2;-fx-font-weight:bold;");
						b5.addEventHandler(MouseEvent.MOUSE_ENTERED,
						new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
						b5.setEffect(shadow);
						b5.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
						+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
						}
						});
						b5.addEventHandler(MouseEvent.MOUSE_EXITED,
						new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
						b5.setEffect(null);
						b5.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						+ "-fx-Border-width:2;-fx-font-weight:bold;");
						}
						});
						vb2.getChildren().add(b5);
						
						b5.setOnAction(e51->{
							GridPane gp55=new GridPane();
							gp55.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
							Scene scenemean=new Scene(gp55,700,600);
							gp55.setHgap(30);
							gp55.setVgap(8);
							Label p_id=new Label("Student mean");
							p_id.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
							gp55.add(p_id, 2, 1);
							TextArea ta=new TextArea();
							ta.setText("  The Mean: "+l.mean());
							ta.setStyle("-fx-border-color:FORESTGREEN;");
							ta.setWrapText(true);
							ta.setEditable(false);////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
							//ta.setText(l.toString());
							gp55.add(ta, 2, 4);
							
							Button b_back=new Button("Back");
							b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
							gp55.add(b_back, 2, 9);
							b_back.setOnAction(k->{
								s.setScene(scene2);
							});
							gp55.setHalignment(b_back, HPos.LEFT);
							
							s.setScene(scenemean);
						});
						//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						
						//////////////////////////////////---------- mode  --------------////////////////////////////////////////////////
									
						b6.setPrefSize(320, 43);
						b6.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						+ "-fx-Border-width:2;-fx-font-weight:bold;");
						b6.addEventHandler(MouseEvent.MOUSE_ENTERED,
						new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
						b6.setEffect(shadow);
						b6.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
						+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
						}
						});
						b6.addEventHandler(MouseEvent.MOUSE_EXITED,
						new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
						b6.setEffect(null);
						b6.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						+ "-fx-Border-width:2;-fx-font-weight:bold;");
						}
						});
						vb2.getChildren().add(b6);
						
						b6.setOnAction(e6->{
							GridPane gp664=new GridPane();
							gp664.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
							Scene scenemode=new Scene(gp664,700,600);
							gp664.setHgap(30);
							gp664.setVgap(8);
							Label p_id=new Label("Student mode");
							p_id.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
							gp664.add(p_id, 2, 1);
							TextArea ta=new TextArea();
							ta.setText("  The Mode: "+l.mode());
							ta.setStyle("-fx-border-color:FORESTGREEN;");
							ta.setWrapText(true);
							ta.setEditable(false);////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
							//ta.setText(l.toString());
							gp664.add(ta, 2, 4);
							
							Button b_back=new Button("Back");
							b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
							gp664.add(b_back, 2, 9);
							b_back.setOnAction(k->{
								s.setScene(scene2);
							});
							gp664.setHalignment(b_back, HPos.LEFT);
							
							s.setScene(scenemode);
						});
						//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						
						//////////////////////////////////---------- above or equal  --------------////////////////////////////////////////////////
									
						b7.setPrefSize(320, 43);
						b7.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						+ "-fx-Border-width:2;-fx-font-weight:bold;");
						b7.addEventHandler(MouseEvent.MOUSE_ENTERED,
						new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
						b7.setEffect(shadow);
						b7.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
						+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
						}
						});
						b7.addEventHandler(MouseEvent.MOUSE_EXITED,
						new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
						b7.setEffect(null);
						b7.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						+ "-fx-Border-width:2;-fx-font-weight:bold;");
						}
						});
						vb2.getChildren().add(b7);
						
						/////////////////////
						b7.setOnAction(e75->{
/////////////////////////////lllllllllllllllllllllllllllllllllllllllloooooooooooooooooooooooooooooooooooooooooo
					GridPane gp77=new GridPane();
					Scene sceneaboveeq=new Scene(gp77,600,320);
					gp77.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
					gp77.setHgap(30);
					gp77.setVgap(8);
					Label ps=new Label("Please enter the grade : ");
					ps.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
					gp77.add(ps, 2, 1);
					Label s_id=new Label("grade : ");
					s_id.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
					gp77.add(s_id, 2, 5);
					TextField ct0=new TextField();
					ct0.setPromptText("123,(8-digit),....itc");
					ct0.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
					gp77.add(ct0, 3, 5);
					
					Button b_above_next=new Button("Next");
					b_above_next.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
					gp77.add(b_above_next, 3,11);
					gp77.setHalignment(b_above_next, HPos.RIGHT);
					b_above_next.setOnAction(n->{
							Label er = new Label("");
							gp77.add(er, 3, 8);
							
							if (ct0.getText().equals("") == true) {
				                er.setText("Error: there isn't data filled in text fields\n "
				                		+ "  please fill the text fields  :*(");
				                er.setPrefSize(260, 60);
								er.setStyle("-fx-border-color: DARKCYAN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
										+ "-fx-text-fill:#ff0000");
				            }
							
							else {
								////////////////////////////////////////////////////////////////////////
								GridPane gp67=new GridPane();
								gp67.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
								Scene sceneinfosearch=new Scene(gp67,600,320);
								gp67.setHgap(30);
								gp67.setVgap(8);
								Label p_id=new Label("Student information");
								p_id.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
								gp67.add(p_id, 2, 1);
								
								TextArea ta=new TextArea();
								int x=Integer.parseInt(ct0.getText());
								double count_spesific_stud=l.count_spesificStud(x);
								double count_stud=l.count_brunch();
								Text tl=new Text("Number of students whom grade above or equal ("+ct0.getText()+") :  "+(int)count_spesific_stud);
								gp67.add(tl, 2, 4);
								Text tl2=new Text("Percentage of those student in their brunch: "+(count_spesific_stud/count_stud)*100+"%");
								gp67.add(tl2, 2, 6);
								Button b_back=new Button("Back");
								b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
								gp67.add(b_back, 4, 20);
								gp67.setHalignment(b_back, HPos.RIGHT);
								
								b_back.setOnAction(searchbacccc->{
								s.setScene(sceneaboveeq);
								});
								s.setScene(sceneinfosearch);
							}
						
						
						
						
					});
					
					Button b_back=new Button("Back");
					b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
					gp77.add(b_back, 3, 11);
					b_back.setOnAction(kl->{
						s.setScene(scene2);
					});
					gp77.setHalignment(b_back, HPos.CENTER);
//					
					s.setScene(sceneaboveeq);
						});
						//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////---------- display the student  --------------////////////////////////////////////////////////
						
	b8.setPrefSize(320, 43);
	b8.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
	+ "-fx-Border-width:2;-fx-font-weight:bold;");
	b8.addEventHandler(MouseEvent.MOUSE_ENTERED,
	new EventHandler<MouseEvent>() {
	@Override
	public void handle(MouseEvent e) {
	b8.setEffect(shadow);
	b8.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
	+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
	}
	});
	b8.addEventHandler(MouseEvent.MOUSE_EXITED,
	new EventHandler<MouseEvent>() {
	@Override
	public void handle(MouseEvent e) {
	b8.setEffect(null);
	b8.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
	+ "-fx-Border-width:2;-fx-font-weight:bold;");
	}
	});
	vb2.getChildren().add(b8);
	
	/////////////////////
	
	b8.setOnAction(e8->{
		GridPane gpl8=new GridPane();
		gpl8.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
		Scene scene8=new Scene(gpl8,700,600);
		gpl8.setHgap(30);
		gpl8.setVgap(8);
		Label p_id=new Label("Student information");
		p_id.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
		gpl8.add(p_id, 2, 1);
		TextArea ta=new TextArea();
		ta.setText(l.showFx());
		ta.setStyle("-fx-border-color:FORESTGREEN;");
		ta.setWrapText(true);
		ta.setEditable(false);////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//ta.setText(l.toString());
		gpl8.add(ta, 2, 4);
		
		Button b_back=new Button("Back");
		b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;");
		gpl8.add(b_back, 2, 9);
		b_back.setOnAction(k->{
			s.setScene(scene2);
		});
		gpl8.setHalignment(b_back, HPos.LEFT);
		
		s.setScene(scene8);
	});
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						
						
						//////////////////////////////////---------- return to main page  --------------////////////////////////////////////////////////
									
						b9.setPrefSize(320, 43);
						b9.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						+ "-fx-Border-width:2;-fx-font-weight:bold;");
						b9.addEventHandler(MouseEvent.MOUSE_ENTERED,
						new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
						b9.setEffect(shadow);
						b9.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
						+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
						}
						});
						b9.addEventHandler(MouseEvent.MOUSE_EXITED,
						new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
						b9.setEffect(null);
						b9.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						+ "-fx-Border-width:2;-fx-font-weight:bold;");
						}
						});
						vb2.getChildren().add(b9);
						
						////////////////////////
						b9.setOnAction(e9->{
							s.setScene(scene1);
							if(!l.isEmpty()) {
					    		l.deleteAll();
					    		if(!l1.isEmpty()) {
					    			l1.deleteAll();
					    		}
					    	}
//							r1.setSelected(false);
//							r2.setSelected(false);
//							r3.setSelected(false);
//							r4.setSelected(false);
//							r5.setSelected(false);
							//t1.setText("");
						});
//						//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//						//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						s.setScene(scene2);
//					}
//					
//	
					}
				});
		
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//final button next0
		
		
		
		
		
		
		
		
		
		
		
		s.setScene(scene1);
		s.setTitle("TawjihiRecords_2022 Simulatour");
		s.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
