//Copyright 2020, 2021 Kevin Pember
/*
 	This file is part of Recursive.

	Recursive is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Recursive is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Recursive.  If not, see <https://www.gnu.org/licenses/>.
*/
package mainCalulatorPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import application.Main;
import customObjects.CustomFunctionPageObject;
import customObjects.MoreFuncGroupObject;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import processing.CalculatorProcessing;
import settingsPackage.SettingsControllClass;

public class MainCalulatorControllClass extends Main{
	
		@FXML
		private TabPane tabbedPane;
	
		@FXML
		private Tab mainTab;
	
	    @FXML
	    private AnchorPane mainPane;

	    @FXML
	    private AnchorPane calcButtons;
	    
	    @FXML
	    private AnchorPane extenedCalcButtons;
	    
	    @FXML
	    private Button Num1;

	    @FXML
	    private Button Num2;

	    @FXML
	    private Button Num3;

	    @FXML
	    private Button moreFunctions;

	    @FXML
	    private Button Num4;

	    @FXML
	    private Button Num5;

	    @FXML
	    private Button Num6;

	    @FXML
	    private Button backButton;

	    @FXML
	    private ImageView backButtonImageView;

	    @FXML
	    private Button Num7;

	    @FXML
	    private Button Num8;

	    @FXML
	    private Button Num9;

	    @FXML
	    private Button plusButton;

	    @FXML
	    private Button deciToFracButton;

	    @FXML
	    private Button factorialButton;

	    @FXML
	    private Button deleteHistoryButton;

	    @FXML
	    private ImageView deleteHistoryButtonImageView;

	    @FXML
	    private Button pieButton;

	    @FXML
	    private Button Num0;

	    @FXML
	    private Button pointButton;

	    @FXML
	    private Button minusButton;

	    @FXML
	    private Button sinButton;

	    @FXML
	    private Button cosButton;

	    @FXML
	    private Button tanButton;

	    @FXML
	    private Button percentButton;

	    @FXML
	    private Button parButton;

	    @FXML
	    private Button toPowerOFButton;

	    @FXML
	    private Button mutiplyButton;

	    @FXML
	    private Button cscButton;

	    @FXML
	    private Button secButton;

	    @FXML
	    private Button cotButton;

	    @FXML
	    private Button enterButton;

	    @FXML
	    private Button squaredButton;

	    @FXML
	    private Button squareRootButton;

	    @FXML
	    private Button divideButton;

	    @FXML
	    private Button logButton;

	    @FXML
	    private Button naturalLog;

	    @FXML
	    private Button NumE;

	    @FXML
	    private Line sepLine;

	    @FXML
	    private Button SettingsButton;

	    @FXML
	    private ImageView settingsButtonImageView;

	    @FXML
	    private Button moreFunctionsArrow;

	    @FXML
	    private ImageView moreFuncArrowButtonImageView;

	    @FXML
	    private Button allClearButton;

	    @FXML
	    private TextField uifCalulator;

	    @FXML
	    private TextField uifPrevious;

	    @FXML
	    private Button memRecallClearButton;

	    @FXML
	    private Button memAddButton;

	    @FXML
	    private Button modeSwitch;

	    @FXML
	    private TextArea historyTextPane;

	    @FXML
	    private Label historyLabel;

	    @FXML
	    private Label memDisplay;
	    
	    @FXML
	    private ScrollPane historyScrollPane;
	    
	    @FXML
	    private Button inverseButton;
    
        private Scene settingsScene;
        
        private Scene extendedFuncsScene;
        
        private String displayColorField;
        
        private String numsButtonsColorField;
        
        private String funcButtonsColorField;
        
        private boolean textColorField = true;
        
        private SettingsControllClass settingsController;
        
        public MoreFunctionsPage extendFuncsController;
        
        public int windowSize = 428;
        
        private boolean inverse;
        
        private CalculatorProcessing mainProcess;
        
        ArrayList<CustomFunctionPageObject> pages = new ArrayList<CustomFunctionPageObject>();
        
        ArrayList<Tab> tabs = new ArrayList<Tab>();
    
    @FXML
    public void initialize() {
    	historyfileMember();
    	historyTextPane.positionCaret(historyTextPane.getText().length());
    }
    
    public void setSettingsScene(Scene scene) {
    	settingsScene = scene;
    }
    public void setExtendFuncsScene(Scene scene) {
    	extendedFuncsScene = scene;
    }
    public void setCalculatorProcess(CalculatorProcessing mainProcess) {
    	this.mainProcess = mainProcess;
    	settingsfileMember();
    	updateColor(displayColorField,numsButtonsColorField,funcButtonsColorField,textColorField);
    }
    public void onWindowClosed() {
    	historyFileOut(historyTextPane.getText());
    }
    
    public void matchControlClass(SettingsControllClass inputController) {
    	settingsController = inputController;
    }
    public void matchExtendedControlClass(MoreFunctionsPage inputController) {
    	extendFuncsController = inputController;
    }
    public void updateStyleSheet(String sheet){
    	tabbedPane.getStylesheets().add(sheet);
    }
    public void updateColor(String displayColor, String numsButtonsColor, String funcButtonsColor, boolean textColor) {
    	displayColorField = displayColor;
    	numsButtonsColorField = numsButtonsColor;
    	funcButtonsColorField = funcButtonsColor;
    	textColorField = textColor;
    	String fontColor;
    	if (textColor == true) {
			fontColor = "#000000";
		}else{
			fontColor = "#FFFFFF";
		}
    	tabbedPane.setStyle("-fx-displayColor: "+displayColor+"; -fx-buttonsColor: "+numsButtonsColor+"; -fx-functionsColor: "+funcButtonsColor+"; -fx-textColor: "+fontColor+";");
    	moreFuncArrowButtonImageView.setImage(new Image(iconColoration("moreFuncArrowIcon",textColor)));
    	backButtonImageView.setImage(new Image(iconColoration("backIcon",textColor)));
    	deleteHistoryButtonImageView.setImage(new Image(iconColoration("historyThrowIcon",textColor)));
    	settingsButtonImageView.setImage(new Image(iconColoration("settingsCogIcon",textColor)));
    	//tabs.forEach((n) -> n.setStyle(displayColor));
    	//mainTab.setStyle(displayColor);
    }
    
    @FXML
    void onAllClearButtonPressed(ActionEvent event) {
    	uifCalulator.setText("");
    }

    @FXML
    void onSecPressed(ActionEvent event) {
    	if(inverse == false){
    		calulatorButtons("sec(");
    	}else {
    		calulatorButtons("arcsec(");
    	}
    }

    @FXML
    void onCscPressed(ActionEvent event) {
    	if(inverse == false){
    		calulatorButtons("csc(");
    	}else {
    		calulatorButtons("arccsc(");
    	}
    }

    @FXML
    void onCotPressed(ActionEvent event) {
    	if(inverse == false){
    		calulatorButtons("cot(");
    	}else {
    		calulatorButtons("arccot(");
    	}
    }

    @FXML
    void onBackButtonPressed(ActionEvent event) {
    	backButtonMethod();
    }

    @FXML
    void onDeciToFracButton(ActionEvent event) {
    	calulatorButtons("d→f(");
    }

    @FXML
    void onDivideButtonPressed(ActionEvent event) {
    	calulatorButtons("÷");
    }

    @FXML
    void onEnterButtonPressed(ActionEvent event) {
    	enterMethod(uifCalulator.getText());
    }
    @FXML
    void onEnterKeyPressed(KeyEvent event) {
    	if (event.getCode() == KeyCode.ENTER) {
    		enterMethod(uifCalulator.getText());
        }else if(event.getCode() == KeyCode.S) {
        	Stage stages = (Stage) moreFunctionsArrow.getScene().getWindow();
        	System.out.println("Width: "+stages.getWidth()+", Height: "+stages.getHeight());
        }
    }

    @FXML
    void onFactorialButtonPressed(ActionEvent event) {
    	calulatorButtons("!");
    }

    @FXML
    void onHistoryDeleteButtonPressed(ActionEvent event) {
    	historyTextPane.setText("");
    }

    @FXML
    void onLogButtonPressed(ActionEvent event) {
    	calulatorButtons("log₁₀(");
    }

    @FXML
    void onMemAddButtonPressed(ActionEvent event) {
    	memFunctions("memAdd");
    }

    @FXML
    void onMemRecallClearButtonPressed(ActionEvent event) {
    	memFunctions("memClearRecall");
    }

    @FXML
    void onMinusButtonPressed(ActionEvent event) {
    	calulatorButtons("-");
    }

    @FXML
    void onModeSwitchPressed(ActionEvent event) {
    	if(modeSwitch.getText().equals("DEG")) {
    		modeSwitch.setText("RAD");
    		mainProcess.cacMode = false;
    	}else if(modeSwitch.getText().equals("RAD")) {
    		modeSwitch.setText("DEG");
    		mainProcess.cacMode = true;
    	}
    	
    }
    @FXML
    void onMoreFunctionsArrowPressed(ActionEvent event) {
    	moreFuncArrowButtonImageView.setRotate(moreFuncArrowButtonImageView.getRotate()+180);
    	mainPane.setRightAnchor(calcButtons, null);
    	if(extendedFuncOpen == false) {
    		Stage stages = (Stage) moreFunctionsArrow.getScene().getWindow();
    		stageSceneChange(737,762,stages);
    		mainPane.setRightAnchor(calcButtons, 309.0);
    		mainPane.setRightAnchor(extenedCalcButtons,0.0);
    		windowSize = 737;
    		extendedFuncOpen = true;
    	}else if(extendedFuncOpen == true) {
    		Stage stages = (Stage) moreFunctionsArrow.getScene().getWindow();
    		mainPane.setRightAnchor(calcButtons, 0.0);
    		mainPane.setRightAnchor(extenedCalcButtons,-309.);
    		stageSceneChange(428,762,stages);
    		windowSize = 428;
    		extendedFuncOpen = false;
    	}
    	
    }

    @FXML
    void onMoreFunctionsPressed(ActionEvent event) {
    	Stage stages = (Stage) moreFunctions.getScene().getWindow();
    	stageSceneChange(428,762,stages);
    	stages.setScene(extendedFuncsScene);
    	extendFuncsController.updateColor(displayColorField,numsButtonsColorField,funcButtonsColorField,textColorField);
    }
    @FXML
    void onCosButtonPressed(ActionEvent event) {
    	if(inverse == false){
    		calulatorButtons("cos(");
    	}else {
    		calulatorButtons("arccos(");
    	}
    }

    @FXML
    void onMutiplyButtonPressed(ActionEvent event) {
    	calulatorButtons("×");
    }

    @FXML
    void onNaturalLogPressed(ActionEvent event) {
    	calulatorButtons("ln(");
    }

    @FXML
    void onNum0Pressed(ActionEvent event) {
    	calulatorButtons("0");
    }

    @FXML
    void onNum1Pressed(ActionEvent event) {
    	calulatorButtons("1");
    }

    @FXML
    void onNum2Pressed(ActionEvent event) {
    	calulatorButtons("2");
    }

    @FXML
    void onNum3Pressed(ActionEvent event) {
    	calulatorButtons("3");
    }

    @FXML
    void onNum4Pressed(ActionEvent event) {
    	calulatorButtons("4");
    }

    @FXML
    void onNum5Pressed(ActionEvent event) {
    	calulatorButtons("5");
    }

    @FXML
    void onNum6Pressed(ActionEvent event) {
    	calulatorButtons("6");
    }

    @FXML
    void onNum7Pressed(ActionEvent event) {
    	calulatorButtons("7");
    }

    @FXML
    void onNum8Pressed(ActionEvent event) {
    	calulatorButtons("8");
    }

    @FXML
    void onNum9Pressed(ActionEvent event) {
    	calulatorButtons("9");
    }

    @FXML
    void onNumEPressed(ActionEvent event) {
    	calulatorButtons("e");
    }

    @FXML
    void onParButtonPressed(ActionEvent event) {
    	parButtonInput();
    }

    @FXML
    void onPercentButtonPressed(ActionEvent event) {
    	calulatorButtons("%");
    }

    @FXML
    void onPieButtonPressed(ActionEvent event) {
    	calulatorButtons("π");
    }

    @FXML
    void onPlusButtonPressed(ActionEvent event) {
    	calulatorButtons("+");
    }

    @FXML
    void onPointButtonPressed(ActionEvent event) {
    	calulatorButtons(".");
    }

    @FXML
    void onSettingsPress(ActionEvent event) {
    	Stage stages = (Stage) SettingsButton.getScene().getWindow();
    	stageSceneChange(867,507,stages);
    	stages.setScene(settingsScene);
    	settingsController.updateColor(displayColorField,numsButtonsColorField,funcButtonsColorField,textColorField);
    }

    @FXML
    void onSinButtonPressed(ActionEvent event) {
    	if(inverse == false){
    		calulatorButtons("sin(");
    	}else {
    		calulatorButtons("arcsin(");
    	}
    }
    @FXML
    void onSquareRootButtonPressed(ActionEvent event) {
    	calulatorButtons("√");
    }

    @FXML
    void onSquaredButtonPressed(ActionEvent event) {
    	calulatorButtons("²");
    }

    @FXML
    void onTanButtonPressed(ActionEvent event) {
    	if(inverse == false){
    		calulatorButtons("tan(");
    	}else {
    		calulatorButtons("arctan(");
    	}
    }

    @FXML
    void onToPowerOFButtonPressed(ActionEvent event) {
    	calulatorButtons("^");
    }
    @FXML
    void onInverseButtonPressed(ActionEvent event) {
    	if(inverseButton.getText().equals("arc")) {
    		inverse = true;
    		inverseButton.setText("reg");
    		sinButton.setText("arcsin");
        	cosButton.setText("arccos");
        	tanButton.setText("arctan");
        	cscButton.setText("arccsc");
        	secButton.setText("arcsec");
        	cotButton.setText("arccot");
    	}else {
    		inverse = false;
    		inverseButton.setText("arc");
    		sinButton.setText("sin");
        	cosButton.setText("cos");
        	tanButton.setText("tan");
        	cscButton.setText("csc");
        	secButton.setText("sec");
        	cotButton.setText("cot");
    	}
    }
   public void newTab(String Name, String cs) {
	    //System.out.println(mainCalulatorScene.getX());
	    pages.add(new CustomFunctionPageObject(cs));
	    pages.get(pages.size()-1).setCalculatorProcess(mainProcess);
   		tabs.add(new Tab(Name,pages.get(pages.size()-1).getRoot()));
   		pages.get(pages.size()-1).updateColors(displayColorField, numsButtonsColorField, funcButtonsColorField, textColorField);
   		tabbedPane.getTabs().add(tabs.get(tabs.size()-1));
   		tabbedPane.getSelectionModel().select(tabs.get(tabs.size()-1));
   		//System.out.println(mainCalulatorScene.getX());
   }
   public void backButtonMethod() {
   	int badIdea = uifCalulator.getCaretPosition();
   	uifCalulator.setText(uifCalulator.getText().substring(0,uifCalulator.getCaretPosition() - 1) + uifCalulator.getText().substring(uifCalulator.getCaretPosition()));
   	uifCalulator.positionCaret(badIdea - 1);
   }
   public void calulatorButtons(String input) {
   	 uifCalulator.requestFocus();
   	 int badIdea = uifCalulator.getCaretPosition();
   	 uifCalulator.setText(uifCalulator.getText().substring(0,uifCalulator.getCaretPosition()) + input + uifCalulator.getText().substring(uifCalulator.getCaretPosition()));
   	 uifCalulator.positionCaret(badIdea + input.length());
   }
   public void enterMethod(String fullInput) {
   	 uifPrevious.setText(fullInput);
   	 System.out.println("adding to history");
   	 historyTextAdd(fullInput);
   	 uifCalulator.setText(mainProcess.solve(fullInput));
   	 uifCalulator.positionCaret(uifCalulator.getText().length());
   	 historyTextPane.positionCaret(historyTextPane.getText().length());
   	 
   }

   boolean frontPar = false;
   public void parButtonInput() {
   	 uifCalulator.requestFocus();
   	 int badIdea = uifCalulator.getCaretPosition();
   	 int lazyAfterthought = 0;
   	  for (int i = 0; i < uifCalulator.getText().length(); i++) {
   		  if (uifCalulator.getText().charAt(i) == '(') {
   			  lazyAfterthought = lazyAfterthought + 1;
   		  }
   		  if (uifCalulator.getText().charAt(i) == ')') {
   			  lazyAfterthought = lazyAfterthought - 1;
   		  }
   	  }
     if (lazyAfterthought == 0 || uifCalulator.getText().charAt(uifCalulator.getCaretPosition()-1)  == '(') {
     	badIdea = uifCalulator.getCaretPosition();
     	uifCalulator.setText(uifCalulator.getText().substring(0,uifCalulator.getCaretPosition()) + "(" + uifCalulator.getText().substring(uifCalulator.getCaretPosition()));
     	uifCalulator.positionCaret(badIdea + 1);
     	lazyAfterthought = lazyAfterthought + 1;
     	System.out.println();
     }else if (lazyAfterthought > 0 && uifCalulator.getText().charAt(uifCalulator.getCaretPosition()-1)  != '(') {
     	badIdea = uifCalulator.getCaretPosition();
     	uifCalulator.setText(uifCalulator.getText().substring(0,uifCalulator.getCaretPosition()) + ")" + uifCalulator.getText().substring(uifCalulator.getCaretPosition()));
     	uifCalulator.positionCaret(badIdea + 1);
     	lazyAfterthought = lazyAfterthought - 1;
     }
   	  
   }

   String memRecord = "";
   public void memFunctions(String func) {
   	 switch(func) {
   	 case("memAdd"):
   	    memRecord = memDisplay.getText();
   	    System.out.println("HEllo there");
   	    if(memRecord.equals("")) {
   		    memRecord = uifCalulator.getText();
   		    System.out.println(memRecord);
         }else if(((int) uifCalulator.getText().charAt(0)> 47 && (int) uifCalulator.getText().charAt(0) < 58) || uifCalulator.getText().charAt(0) == '.') {
   	        memRecord = memRecord + "+" + uifCalulator.getText();
   		    System.out.println(memRecord);
   	    } else {
   		    memRecord = memRecord + uifCalulator.getText();
   		    System.out.println(memRecord);
   	 }
   	 memRecord = mainProcess.solve(memRecord);
   	 System.out.println("printing mem");
   	 memDisplay.setText(memRecord);
   	 System.out.println(memDisplay.getText());
   	 break;
   	 case("memClearRecall"):
   		 memRecord = memDisplay.getText();
   	    if(uifCalulator.getText().equals(memDisplay.getText())) {
   	        memRecord = "";
   	        memDisplay.setText("");
   	        uifCalulator.setText("");
   		    System.out.println(memRecord);
   	    } else {
   	    	int badIdea = uifCalulator.getCaretPosition();
   			uifCalulator.setText(uifCalulator.getText().substring(0,uifCalulator.getCaretPosition()) + memDisplay.getText() + uifCalulator.getText().substring(uifCalulator.getCaretPosition()));
   			uifCalulator.positionCaret(badIdea + memDisplay.getText().length());
   		    System.out.println(memRecord);
   	 }
   	 break;
   }
   }
   public void decimalsToFractions() {
   	 double bottomNum = Math.pow(10, uifCalulator.getText().substring(uifCalulator.getText().indexOf('.')+1).length());
   	 System.out.println(bottomNum);
   }
   public void historyfileMember() {
   	try {
   	      File historyFile = new File("c:\\ProgramData\\Recursive\\HistoryFileout.txt");
   	      Scanner myReader = new Scanner(historyFile);
   	      while (myReader.hasNextLine()) {
   	        String data = myReader.nextLine();
   	        historyTextPane.setText(historyTextPane.getText() + data + "\n");
   	      }
   	      myReader.close();
   	    } catch (FileNotFoundException e) {
   	      System.out.println("An error occurred.");
   	      e.printStackTrace();
   	    }
   }
   public void historyFileOut(String recordedText) {
   	try {
   	      File historyFile = new File("c:\\ProgramData\\Recursive\\HistoryFileout.txt");
   	      if (historyFile.createNewFile()) {
   	        System.out.println("History File created: " + historyFile.getName());
   	      } else {
   	        System.out.println("History File already exists");
   	      }
   	    } catch (IOException e) {
   	      System.out.println("Error loading History File");
   	      e.printStackTrace();
   	    }
   	try {
   	      FileWriter myWriter = new FileWriter("c:\\ProgramData\\Recursive\\HistoryFileout.txt");
   	      myWriter.write(historyTextPane.getText());
   	      myWriter.close();
   	      System.out.println("Successfully wrote equation to file");
   	    } catch (IOException e) {
   	      System.out.println("An error occurred.");
   	      e.printStackTrace();
   	    }
   }
   public void settingsfileMember() {
	   	try {
	   	      File settingsFile = new File("c:\\ProgramData\\Recursive\\settingsFile.txt");
	   	      Scanner myReader = new Scanner(settingsFile);
	   	      String data = "";
	   	      while (myReader.hasNextLine()) {
	   	        data = myReader.nextLine();
	   	        if(data.contains("displayColor:")) {
	   	        	displayColorField = data.substring(data.indexOf(':')+1);
	   	        	System.out.println(displayColorField);
	   	        }else if(data.contains("numbersColor:")) {
	   	        	numsButtonsColorField = data.substring(data.indexOf(':')+1);
	   	        	System.out.println(numsButtonsColorField);
	   	        }else if(data.contains("functionsColor:")) {
	   	        	funcButtonsColorField = data.substring(data.indexOf(':')+1);
	   	        	System.out.println(funcButtonsColorField);
	   	        }else if(data.contains("textColor:")) {
	   	        	if(data.charAt(data.indexOf(':')+1) == 't') {
	   	        		textColorField = true;
	   	        	}else {
	   	        		textColorField = false;
	   	        	}
	   	        	System.out.println(textColorField);
	   	        } else if(data.contains("outputLength:")) {
	   	        	mainProcess.mc = new MathContext(Integer.parseInt(data.substring(data.indexOf(':')+1)));
	   	        } else if (data.contains("defaultDomain:")) {
	   	        	mainProcess.domainBottom = Double.parseDouble(data.substring(data.indexOf(':')+1,data.indexOf(',')));
	   	        	mainProcess.domainTop = Double.parseDouble(data.substring(data.indexOf(',')+1));
	   	        } else if (data.contains("defaultRange:")) {
	   	        	mainProcess.rangeBottom = Double.parseDouble(data.substring(data.indexOf(':')+1,data.indexOf(',')));
	   	        	mainProcess.rangeTop = Double.parseDouble(data.substring(data.indexOf(',')+1));
	   	        }
	   	      }
	   	      myReader.close();
	   	    } catch (FileNotFoundException e) {
	   	      System.out.println("An error occurred.");
	   	      e.printStackTrace();
	   	    }
	   }
   
   public void historyTextAdd(String enteredMath) {
   	DateTimeFormatter historyOutTimeDate = DateTimeFormatter.ofPattern("MMM dd,yyyy hh:mm");
   	String TimeDate = historyOutTimeDate.format(LocalDateTime.now());
   	historyTextPane.setText(historyTextPane.getText() +"\n\n"+ TimeDate+"\n"+ enteredMath +" = "+mainProcess.solve(enteredMath));
   }
   
}
