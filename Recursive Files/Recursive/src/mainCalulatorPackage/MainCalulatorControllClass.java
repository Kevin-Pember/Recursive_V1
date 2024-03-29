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

import application.Main;
import helpPackage.HelpController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import moreFunctionsPackage.MoreFunctionsPage;
import processing.CalculatorProcessing;
import settingsPackage.SettingsControllClass;
import v1CustomFunctionsPackage.V1CustomFunctionPageObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.MathContext;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class MainCalulatorControllClass extends Main{
	
		@FXML
		public TabPane tabbedPane;
	
		@FXML
		public Tab mainTab;
	
	    @FXML
	    private AnchorPane mainPane;

	    @FXML
	    private AnchorPane calcButtons;
	    
	    @FXML
	    private AnchorPane extenedCalcButtons;
	    
	    @FXML
	    private GridPane dividerGridPane;
	    
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
	    private Button superscriptUp;
	    
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
	    private ImageView helpImageView;

	    @FXML
	    private Button allClearButton;

	    @FXML
	    private TextArea uifCalulator;

	    @FXML
	    private Button memRecallClearButton;

	    @FXML
	    private Button memAddButton;

	    @FXML
	    private Button modeSwitch;
	    
	    @FXML
	    private Button helpButton;

	    @FXML
	    private Label historyLabel;

	    @FXML
	    private Label memDisplay;
	    
	    @FXML
	    private Button inverseButton;
	    
	    @FXML
	    private Button absoluteButton;
	    
	    @FXML
	    private Button modButton;
	    
	    @FXML
	    private Button graphButton;
	    
	    @FXML
	    private Button functionButton;
	    
	    @FXML
	    private Button lockButton;
	    
	    @FXML
	    private ColumnConstraints zeroColum;

	    @FXML
	    private ColumnConstraints oneColum;
	    
	    @FXML
	    private ImageView mainLockImageView;
    
        private Scene settingsScene;
        
        private Scene extendedFuncsScene;
        
        public Scene helpPage;
        
        public String displayColorField;
        
        public String numsButtonsColorField;
        
        public String funcButtonsColorField;
        
        public boolean textColorField = true;
        
        private SettingsControllClass settingsController;
        
        public MoreFunctionsPage extendFuncsController;
        
        public HelpController helpPageController;
        
        public double windowWidth = 333;
        
        public double windowHeight = 579;
        
        public boolean windowResizeable = true;
        
        private boolean inverse;
        
        private boolean superscript = false;
        
        private CalculatorProcessing mainProcess;
        
        public Stage mainStage = null;
        
        ArrayList<V1CustomFunctionPageObject> pages = new ArrayList<V1CustomFunctionPageObject>();
        
        ArrayList<Tab> tabs = new ArrayList<Tab>();
        
        TextInputDialog dialog = new TextInputDialog("");
        
        ImageView Graphic = new ImageView(new Image("file:icons/mainIcon.png"));
    
    @FXML
    public void initialize() {
    	uifCalulator.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
    	    if (event.getCode() == KeyCode.BACK_SPACE && uifCalulator.getCaretPosition() <= uifCalulator.getText().indexOf('ㅤ')+2 && uifCalulator.getText().indexOf(uifCalulator.getSelectedText()) < uifCalulator.getText().indexOf('ㅤ')+2) {
    	        System.out.println("Spacebar key detected!");
    	        event.consume();
    	    }
    	});
    	historyfileMember();
    	uifCalulator.positionCaret(uifCalulator.getText().length());
    	dialog.getDialogPane().getStyleClass().add("myDialog");
    	dialog.getDialogPane().getStylesheets().add("application/applicationSkin.css");
    	Graphic.setFitHeight(40);
    	Graphic.setFitWidth(40);
    	dialog.setGraphic(Graphic);
    	Stage dialogStage = (Stage) dialog.getDialogPane().getScene().getWindow();
    	dialogStage.getIcons().add(new Image("icons/mainIcon.png"));
    }
    
    public void setSettingsScene(Scene scene,Stage mainStage) {
    	settingsScene = scene;
    	this.mainStage = mainStage;
    	
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
    	historyFileOut(uifCalulator.getText());
    	settingsFileOut();
    }
    
    public void matchControlClass(SettingsControllClass inputController) {
    	settingsController = inputController;
    }
    public void matchExtendedControlClass(MoreFunctionsPage inputController) {
    	extendFuncsController = inputController;
    }
    public void matchHelp(HelpController inputController, Scene helpPage) {
    	helpPageController = inputController;
    	this.helpPage = helpPage;
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
    	helpImageView.setImage(new Image(iconColoration("helpIcon",textColor)));
		mainLockImageView.setImage(new Image(iconColoration("lockIcon",textColor)));
    	//tabs.forEach((n) -> n.setStyle(displayColor));
    	//mainTab.setStyle(displayColor);
    }
    
    @FXML
    void onAllClearButtonPressed(ActionEvent event) {
    	String fullInput = uifCalulator.getText();
    	System.out.println(uifCalulator.getText().substring(0,(uifCalulator.getText().indexOf("‎‎‎‎‎‎‎‎‎‎‎‎‎ㅤ")+2)));
    	uifCalulator.setText(fullInput.substring(0,fullInput.indexOf("ㅤ")+2));//+"ㅤ\n");
    	uifCalulator.positionCaret(uifCalulator.getText().length());
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
    void onHelpPressed(ActionEvent event) {
    	windowHeight = mainStage.getHeight();
    	windowWidth = mainStage.getWidth();
    	helpPageController.setBackScene(helpButton.getScene(),windowWidth,windowHeight);
    	helpPageController.updateColor(displayColorField, numsButtonsColorField, funcButtonsColorField, textColorField);
    	mainStage.setScene(helpPage);
    	mainStage.setWidth(windowWidth+1);
    	helpPageController.mainCalculatorPageAnchorPane.setVisible(true);
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
    	if(event.getCode() == KeyCode.D) {
        	System.out.println("Primary Functions Size Width: " + mainPane.getWidth()+ " Height: "+ mainPane.getHeight());
        	System.out.println("Secondary Functions Size Width: " + extenedCalcButtons.getWidth()+ " Height: "+ extenedCalcButtons.getHeight());
        	System.out.println("Stage Width: "+mainStage.getWidth()+", Height: "+mainStage.getHeight());
        	System.out.println("Num1 width: "+Num1.getWidth()+ ", d→f width: "+deciToFracButton.getWidth());
        	System.out.println("Num1 height: "+Num1.getHeight()+ ", d→f height: "+deciToFracButton.getHeight());
        }else if(event.getCode() == KeyCode.A) {
        	uifCalulator.setText("");
        }
    }
    
    @FXML
    void onFactorialButtonPressed(ActionEvent event) {
    	calulatorButtons("!");
    }

    @FXML
    void onHistoryDeleteButtonPressed(ActionEvent event) {
    	uifCalulator.setText(uifCalulator.getText().substring(uifCalulator.getText().indexOf("‎‎‎‎‎‎‎‎‎‎‎‎‎ㅤ")));
    	uifCalulator.positionCaret(uifCalulator.getLength());
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
    	if(superscript) {
    		calulatorButtons("⁻");
    	}else {
    		calulatorButtons("-");
    	}
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
    	windowHeight = mainStage.getHeight();
    	windowWidth = mainStage.getWidth();
    	//mainPane.setRightAnchor(calcButtons, null);
    	if(extendedFuncOpen == false) {
    		System.out.println("Defalut width"+windowWidth);
    		windowWidth = (windowWidth*100)/66.45161290322581;
    		System.out.println("Window Width "+ windowWidth);
    		dividerGridPane.setVisible(true);
    		dividerGridPane.add(calcButtons, 0, 0);
    		mainPane.setRightAnchor(dividerGridPane, 0.0);
    		sepLine.toFront();
    		stageSceneChange(windowWidth,windowHeight,mainStage);
    		mainStage.setMinWidth(487.0);
    		extendedFuncOpen = true;
    	}else if(extendedFuncOpen == true) {
    		windowWidth = (windowWidth * 66.45161290322581)/100;
    		System.out.println("Window Width "+ windowWidth);
    		dividerGridPane.setVisible(false);
    		mainPane.getChildren().add(dividerGridPane.getChildren().remove(dividerGridPane.getChildren().indexOf(calcButtons)));
    		mainPane.setRightAnchor(calcButtons, 0.0);
    		mainPane.setRightAnchor(dividerGridPane, null);
    		sepLine.toBack();
    		stageSceneChange(windowWidth,windowHeight,mainStage);
    		mainStage.setMinWidth(330);
    		extendedFuncOpen = false;
    	}
    	
    }

    @FXML
    void onMoreFunctionsPressed(ActionEvent event) {
    	windowHeight = mainStage.getHeight();
    	windowWidth = mainStage.getWidth();
    	stageSceneChange(windowWidth+1,windowHeight,mainStage);
    	//mainStage.setMinWidth(334);
    	mainStage.setScene(extendedFuncsScene);
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
    	if(superscript) {
    		calulatorButtons("⁰");
    	}else {
    		calulatorButtons("0");
    	}
    }

    @FXML
    void onNum1Pressed(ActionEvent event) {
    	if(superscript) {
    		calulatorButtons("¹");
    	}else {
    		calulatorButtons("1");
    	}
    	System.out.println();
    }

    @FXML
    void onNum2Pressed(ActionEvent event) {
    	if(superscript) {
    		calulatorButtons("²");
    	}else {
    		calulatorButtons("2");
    	}
    }

    @FXML
    void onNum3Pressed(ActionEvent event) {
    	if(superscript) {
    		calulatorButtons("³");
    	}else {
    		calulatorButtons("3");
    	}
    }

    @FXML
    void onNum4Pressed(ActionEvent event) {
    	if(superscript) {
    		calulatorButtons("⁴");
    	}else {
    		calulatorButtons("4");
    	}
    }

    @FXML
    void onNum5Pressed(ActionEvent event) {
    	if(superscript) {
    		calulatorButtons("⁵");
    	}else {
    		calulatorButtons("5");
    	}
    }

    @FXML
    void onNum6Pressed(ActionEvent event) {
    	if(superscript) {
    		calulatorButtons("⁶");
    	}else {
    		calulatorButtons("6");
    	}
    }

    @FXML
    void onNum7Pressed(ActionEvent event) {
    	if(superscript) {
    		calulatorButtons("⁷");
    	}else {
    		calulatorButtons("7");
    	}
    }

    @FXML
    void onNum8Pressed(ActionEvent event) {
    	if(superscript) {
    		calulatorButtons("⁸");
    	}else {
    		calulatorButtons("8");
    	}
    }

    @FXML
    void onNum9Pressed(ActionEvent event) {
    	if(superscript) {
    		calulatorButtons("⁹");
    	}else {
    		calulatorButtons("9");
    	}
    }

    @FXML
    void onNumEPressed(ActionEvent event) {
    	Stage stages = (Stage) moreFunctionsArrow.getScene().getWindow();
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
    	if(superscript) {
    		calulatorButtons("⁺");
    	}else {
    		calulatorButtons("+");
    	}
    }

    @FXML
    void onPointButtonPressed(ActionEvent event) {
    	calulatorButtons(".");
    }

    @FXML
    void onSettingsPress(ActionEvent event) {
    	windowHeight = mainStage.getHeight();
    	windowWidth = mainStage.getWidth();
    	stageSceneChange(867,507,mainStage);
    	mainStage.setScene(settingsScene);
    	mainStage.setMinHeight(0);
    	mainStage.setResizable(false);
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
    void onsuperscriptUpPressed(ActionEvent event) {
    	if(superscript) {
    		superscript = false;
    		superscriptUp.setRotate(0);
    		Num1.setText("1");
    		Num2.setText("2");
    		Num3.setText("3");
    		Num4.setText("4");
    		Num5.setText("5");
    		Num6.setText("6");
    		Num7.setText("7");
    		Num8.setText("8");
    		Num9.setText("9");
    		plusButton.setText("+");
    		minusButton.setText("-");
    		Num0.setText("0");
    		parButton.setText("( )");
    	}else {
    		superscript = true;
    		superscriptUp.setRotate(180);
    		Num1.setText("¹");
    		Num2.setText("²");
    		Num3.setText("³");
    		Num4.setText("⁴");
    		Num5.setText("⁵");
    		Num6.setText("⁶");
    		Num7.setText("⁷");
    		Num8.setText("⁸");
    		Num9.setText("⁹");
    		plusButton.setText("⁺");
    		minusButton.setText("⁻");
    		Num0.setText("⁰");
    		parButton.setText("⁽ ⁾");
    	}
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
    @FXML
    void onModButtonPressed(ActionEvent event) {
    	calulatorButtons("mod(");
    }
    @FXML
    void onAbsoluteButtonPressed(ActionEvent event) {
    	calulatorButtons("|");
    }
    @FXML
    void onFunctionButtonPressed(ActionEvent event) {
    	dialog.setTitle("Custom Function");
    	dialog.setHeaderText("Enter Function Name");
    	dialog.setContentText("Please enter name:");
    	Optional<String> result = dialog.showAndWait();
    	result.ifPresent(name -> {
    		String newEntry = name+"»";
    	 	   if(uifCalulator.getText().substring(uifCalulator.getText().indexOf("ㅤ")+2).contains("=")) {
    	 		  newEntry +=  uifCalulator.getText().substring(uifCalulator.getText().indexOf("ㅤ")+2) + "»";
    	 	   }else {
    	 		  newEntry +=  uifCalulator.getText().substring(uifCalulator.getText().indexOf("ㅤ")+2) + "=o" + "»";
    	 	   }
    	 	   newEntry += "v1»";
    	 	   newEntry += "Function»";
    	 	   extendFuncsController.newFunction(newEntry);
    	 	   newTab(name,newEntry);
    	});
    }

    @FXML
    void onGraphButtonPressed(ActionEvent event) {
    	dialog.setTitle("Custom Graph");
    	dialog.setHeaderText("Enter Graph Name");
    	dialog.setContentText("Please enter name:");
    	Optional<String> result = dialog.showAndWait();
    	result.ifPresent(name -> {
    		String newEntry = name+"»";
    	       newEntry +=  uifCalulator.getText().substring(uifCalulator.getText().indexOf("ㅤ")+2) + "»";
    	  	   newEntry += "v1»";
    	  	   newEntry += "Graph»";
    	  	   extendFuncsController.newFunction(newEntry);
    	  	   newTab(name,newEntry);
    	});
    }
    @FXML
    void onLockButtonPressed(ActionEvent event) {
    	if(windowResizeable) {
    		mainStage.setResizable(false);
    		setLockColor(false);
    		windowResizeable = false;
    	}else {
    		mainStage.setResizable(true);
    		setLockColor(true);
    		windowResizeable = true;
    	}
    }
   public void setLockColor(boolean onOff) {
	ColorAdjust colorAdjust = new ColorAdjust();
   	if(textColorField) {
   		if(onOff) {
   			colorAdjust.setBrightness(0.5);
   		}else {
   			colorAdjust.setBrightness(-0.5);
   		}
   	}else {
   		if(onOff) {
   			colorAdjust.setBrightness(-0.5);
   		}else {
   			colorAdjust.setBrightness(0.5);
   		}
   	}
   	mainLockImageView.setEffect(colorAdjust);
   }
   public void newTab(String Name, String cs) {
	    pages.add(new V1CustomFunctionPageObject(cs));
	    pages.get(pages.size()-1).setCalculatorProcess(mainProcess,this);
   		tabs.add(new Tab(Name,pages.get(pages.size()-1).getRoot()));
   		pages.get(pages.size()-1).updateColors(displayColorField, numsButtonsColorField, funcButtonsColorField, textColorField);
   		tabbedPane.getTabs().add(tabs.get(tabs.size()-1));
   		tabbedPane.getSelectionModel().select(tabs.get(tabs.size()-1));
   		//System.out.println(mainCalulatorScene.getX());
   }
   public void backButtonMethod() {
    	if(!(uifCalulator.getCaretPosition() <= uifCalulator.getText().indexOf('ㅤ')+2)){
			int badIdea = uifCalulator.getCaretPosition();
			uifCalulator.setText(uifCalulator.getText().substring(0,uifCalulator.getCaretPosition() - 1) + uifCalulator.getText().substring(uifCalulator.getCaretPosition()));
			uifCalulator.positionCaret(badIdea - 1);
		}
   }
   public void calulatorButtons(String input) {
   	 uifCalulator.requestFocus();
   	 int badIdea = uifCalulator.getCaretPosition();
   	 uifCalulator.setText(uifCalulator.getText().substring(0,uifCalulator.getCaretPosition()) + input + uifCalulator.getText().substring(uifCalulator.getCaretPosition()));
   	 uifCalulator.positionCaret(badIdea + input.length());
   }
   public void enterMethod(String fullInput) {
	 DateTimeFormatter historyOutTimeDate = DateTimeFormatter.ofPattern("MMM dd,yyyy hh:mm");
	 String TimeDate = historyOutTimeDate.format(LocalDateTime.now());
   	 uifCalulator.setText(fullInput.substring(0,fullInput.indexOf("‎‎‎‎‎‎‎‎‎‎‎‎‎ㅤ"))+"\n" + historyOutTimeDate.format(LocalDateTime.now())+ "\n"+fullInput.substring(fullInput.indexOf("ㅤ")+2)+"="+mainProcess.solve(fullInput.substring(fullInput.indexOf("ㅤ")+2),true)+"\n‎‎‎‎‎‎‎‎‎‎‎‎‎ㅤ\n");
   	 //historyTextAdd(fullInput);
   	 uifCalulator.positionCaret(uifCalulator.getText().length());
   	 
   }

   boolean frontPar = false;
   public void parButtonInput() {
   	 uifCalulator.requestFocus();
   	 int badIdea = uifCalulator.getCaretPosition();
   	 int lazyAfterthought = 0;
   	 int superscriptAfterthought = 0;
   	  for (int i = 0; i < uifCalulator.getText().length(); i++) {
   		  if (uifCalulator.getText().charAt(i) == '(') {
   			  lazyAfterthought = lazyAfterthought + 1;
   		  }
   		  if (uifCalulator.getText().charAt(i) == ')') {
   			  lazyAfterthought = lazyAfterthought - 1;
   		  }
   		  if (uifCalulator.getText().charAt(i) == '⁽') {
   			  superscriptAfterthought = superscriptAfterthought + 1;
 		  }
   		  if (uifCalulator.getText().charAt(i) == '⁾') {
   			  superscriptAfterthought = superscriptAfterthought - 1;
		  }
   	  }
     if ((lazyAfterthought == 0 || uifCalulator.getText().charAt(uifCalulator.getCaretPosition()-1)  == '(')&& superscript == false) {
     	badIdea = uifCalulator.getCaretPosition();
     	uifCalulator.setText(uifCalulator.getText().substring(0,uifCalulator.getCaretPosition()) + "(" + uifCalulator.getText().substring(uifCalulator.getCaretPosition()));
     	uifCalulator.positionCaret(badIdea + 1);
     	lazyAfterthought = lazyAfterthought + 1;
     }else if (lazyAfterthought > 0 && uifCalulator.getText().charAt(uifCalulator.getCaretPosition()-1)  != '(' && superscript == false) {
     	badIdea = uifCalulator.getCaretPosition();
     	uifCalulator.setText(uifCalulator.getText().substring(0,uifCalulator.getCaretPosition()) + ")" + uifCalulator.getText().substring(uifCalulator.getCaretPosition()));
     	uifCalulator.positionCaret(badIdea + 1);
     	lazyAfterthought = lazyAfterthought - 1;
     }else if((superscriptAfterthought == 0 || uifCalulator.getText().charAt(uifCalulator.getCaretPosition()-1)  == '⁽')&& superscript) {
    	badIdea = uifCalulator.getCaretPosition();
      	uifCalulator.setText(uifCalulator.getText().substring(0,uifCalulator.getCaretPosition()) + "⁽" + uifCalulator.getText().substring(uifCalulator.getCaretPosition()));
      	uifCalulator.positionCaret(badIdea + 1);
      	superscriptAfterthought = superscriptAfterthought + 1;
     }else if(superscriptAfterthought > 0 && uifCalulator.getText().charAt(uifCalulator.getCaretPosition()-1) != '⁽' && superscript) {
    	badIdea = uifCalulator.getCaretPosition();
      	uifCalulator.setText(uifCalulator.getText().substring(0,uifCalulator.getCaretPosition()) + "⁾" + uifCalulator.getText().substring(uifCalulator.getCaretPosition()));
      	uifCalulator.positionCaret(badIdea + 1);
      	superscriptAfterthought = superscriptAfterthought - 1;
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
   	 memRecord = mainProcess.solve(memRecord,true);
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
   	        String data = new String (myReader.nextLine().getBytes(),StandardCharsets.UTF_8);
   	        uifCalulator.setText(uifCalulator.getText() + data);
   	        if(myReader.hasNextLine()) {
   	        	uifCalulator.setText(uifCalulator.getText() + "\n");
   	        }
   	      }
   	      System.out.println(uifCalulator.getText());
   	      String thing = uifCalulator.getText();
   	      if(uifCalulator.getText().indexOf('ㅤ') == -1 ) {
			  uifCalulator.setText(uifCalulator.getText()+"\n‎‎‎‎‎‎‎‎‎‎‎‎‎ㅤ\n");
   	      }else if(uifCalulator.getText().length()-1 == uifCalulator.getText().indexOf('ㅤ')){
			  uifCalulator.setText(uifCalulator.getText()+"\n");
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
   	      FileWriter myWriter = new FileWriter("c:\\ProgramData\\Recursive\\HistoryFileout.txt",StandardCharsets.UTF_8);
   	      myWriter.write(uifCalulator.getText());
   	      myWriter.close();
   	      System.out.println("Successfully wrote equation to file");
   	    } catch (IOException e) {
   	      System.out.println("An error occurred.");
   	      e.printStackTrace();
   	    }
   }
   public void settingsFileOut() {
	   	Stage stages = mainStage;
	   	try {
	   	      File settingsFile = new File("c:\\ProgramData\\Recursive\\settingsFile.txt");
	   	      if (settingsFile.createNewFile()) {
	   	        System.out.println("Settings File created: " + settingsFile.getName());
	   	      } else {
	   	        System.out.println("History File already exists");
	   	      }
	   	    } catch (IOException e) {
	   	      System.out.println("Error loading History File");
	   	      e.printStackTrace();
	   	    }
	   	try {
	   	      FileWriter myWriter = new FileWriter("c:\\ProgramData\\Recursive\\settingsFile.txt",StandardCharsets.UTF_8);
	   	      myWriter.write("displayColor:"+displayColorField);
	   	      myWriter.append("\nnumbersColor:"+numsButtonsColorField);
	   	      myWriter.append("\nfunctionsColor:"+funcButtonsColorField);
	   	      myWriter.append("\ntextColor:"+textColorField);
	   	      myWriter.append("\noutputLength:"+mc.getPrecision());
	   	      myWriter.append("\ndefaultDomain:"+mainProcess.domainBottom+","+mainProcess.domainTop);
	   	      myWriter.append("\ndefaultRange:"+mainProcess.rangeBottom+","+mainProcess.rangeTop);
	   	      if(stages.getScene() == settingsScene) {
	   	    	myWriter.append("\nwindowWidth:"+settingsController.windowWidthTextField.getText());
		   	    myWriter.append("\nwindowHeight:"+settingsController.windowHeightTextField.getText());
		   	    myWriter.append("\nwindowResizeable:"+windowResizeable);
	   	      }else {
	   	    	myWriter.append("\nwindowWidth:"+stages.getWidth());
		   	    myWriter.append("\nwindowHeight:"+stages.getHeight());
		   	    myWriter.append("\nwindowResizeable:"+stages.isResizable());
	   	      }
	   	      myWriter.append("\nextendedFunctions:"+extendedFuncOpen);
	   	      myWriter.close();
	   	      System.out.println("Successfully wrote settings to file");
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
	   	        data = new String (myReader.nextLine().getBytes(),StandardCharsets.UTF_8);
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
	   	        } else if (data.contains("windowWidth:")) {
	   	        	mainStage.setWidth(windowWidth = Double.parseDouble(data.substring(data.indexOf(':')+1)));
	   	        } else if (data.contains("windowHeight:")) {
	   	        	mainStage.setHeight(windowHeight = Double.parseDouble(data.substring(data.indexOf(':')+1)));
	   	        } else if (data.contains("windowResizeable:")) {
	   	        	mainStage.setResizable(windowResizeable = Boolean.parseBoolean(data.substring(data.indexOf(':')+1)));
	   	        	setLockColor(Boolean.parseBoolean(data.substring(data.indexOf(':')+1)));
	   	        } else if (data.contains("extendedFunctions:")) {
	   	        	extendedFuncOpen = Boolean.parseBoolean(data.substring(data.indexOf(':')+1));
	   	        	if(extendedFuncOpen == true) {
	   		    		dividerGridPane.setVisible(true);
	   		    		dividerGridPane.add(calcButtons, 0, 0);
	   		    		mainPane.setRightAnchor(dividerGridPane, 0.0);
	   		    		mainStage.setMinWidth(486.0);
	   		    	}
	   	        }
	   	      }
	   	      myReader.close();
	   	    } catch (FileNotFoundException e) {
	   	      System.out.println("An error occurred.");
	   	      e.printStackTrace();
	   	    }
	   }
   
   public void historyTextAdd(String enteredMath) {
	   System.out.println("History pane Start");
   	DateTimeFormatter historyOutTimeDate = DateTimeFormatter.ofPattern("MMM dd,yyyy hh:mm");
   	String TimeDate = historyOutTimeDate.format(LocalDateTime.now());
   	uifCalulator.setText(uifCalulator.getText() +"\n\n"+ TimeDate+"\n"+ enteredMath +" = "+mainProcess.solve(enteredMath,true));
   	System.out.println("History pane out");
   }
   
}
