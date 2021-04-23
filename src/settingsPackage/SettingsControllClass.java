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
package settingsPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.MathContext;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainCalulatorPackage.MainCalulatorControllClass;
import processing.CalculatorProcessing;

public class SettingsControllClass extends Main{

	@FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private VBox menuPicker;

    @FXML
    private Button backToFrontButton;

    @FXML
    private ImageView backToFrontImageView;

    @FXML
    private Button lookAndFeelMenuButton;
    
    @FXML
    private Button preferencesButton;

    @FXML
    private Button aboutMenuButton;

    @FXML
    private AnchorPane lookAndFeelAnchorPane;

    @FXML
    private Label lookNFeelLabel;

    @FXML
    private Label colorLabel;

    @FXML
    private Line colorsLine;

    @FXML
    private Rectangle displayModel;

    @FXML
    private Rectangle functionsModel;

    @FXML
    private Rectangle numsModel;

    @FXML
    private Line presetThemesLine;

    @FXML
    private ColorPicker displayColorPicker;

    @FXML
    private ColorPicker numbersColorPicker;

    @FXML
    private ColorPicker functionsColorPicker;

    @FXML
    private Label displayColorLabel;

    @FXML
    private Label numbersColorLabel;

    @FXML
    private Label funcColorLabel;

    @FXML
    private Label textColorLabel;

    @FXML
    private Label presetThemesLabel;

    @FXML
    private Label colorsTLabel;

    @FXML
    private ScrollPane presetThemesScrollPane;

    @FXML
    private AnchorPane presetThemesAnchorPane;
    
    @FXML
    private RadioButton lightThemeRadioButton;

    @FXML
    private RadioButton darkThemeRadioButton;
    
    @FXML
    private ComboBox<String> textColorChoiceBox;
    
    @FXML
    private AnchorPane aboutAnchorPane;
    
    @FXML
    private Label aboutLabel;

    @FXML
    private Line aboutLine;
    
    @FXML
    private Label aboutMainLabel;

    @FXML
    private AnchorPane preferencesAnchorPane;
    
    @FXML
    private Label preferencesLabel;
    
    @FXML
    private Label CalculationsLabel;
    
    @FXML
    private Label outputLengthLabel;
    
    @FXML
    private Line preferencesLine;
    
    @FXML
    private TextField outputLengthTextField;
    
    @FXML
    private Label defaultDomainLabel;

    @FXML
    private TextField domainBottomTextField;

    @FXML
    private TextField domainTopTextField;

    @FXML
    private Label defaultRangeLabel;

    @FXML
    private TextField rangeBottomTextField;

    @FXML
    private TextField rangeTopTextField;
    
    private Scene mainCalulatorScene;
    
    private MainCalulatorControllClass mainCalulatorController;
    
    private boolean fontColor = true;
    
    public MathContext mc = new MathContext(16);
    private CalculatorProcessing mainProcess;
    
    ObservableList<String> textOptions = FXCollections.observableArrayList("Black","White");
    
    @FXML
    public void initialize() {
    	textColorChoiceBox.setItems(textOptions);
    }
    public void setMainCalulatorScene(Scene scene) {
    	mainCalulatorScene = scene;
    }
    public void setCalculatorProcess(CalculatorProcessing mainProcess) {
    	this.mainProcess = mainProcess;
    	outputLengthTextField.setText(""+mainProcess.mc.getPrecision());
    	domainBottomTextField.setText(""+mainProcess.domainBottom);
    	domainTopTextField.setText(""+mainProcess.domainTop);
    	rangeBottomTextField.setText(""+mainProcess.rangeBottom);
    	rangeTopTextField.setText(""+mainProcess.rangeTop);
    }
    public void updateColor(String displayColor, String numsButtonsColor, String funcButtonsColor, boolean textColor) {
    	fontColor = textColor;
    	String fontColor;
    	if (textColor == true) {
			fontColor = "#000000";
		}else{
			fontColor = "#FFFFFF";
		}
    	displayColorPicker.setValue(Color.web(displayColor));
    	numbersColorPicker.setValue(Color.web(numsButtonsColor));
    	functionsColorPicker.setValue(Color.web(funcButtonsColor));
    	displayModel.setFill(Color.web(displayColor));
    	numsModel.setFill(Color.web(numsButtonsColor));
    	functionsModel.setFill(Color.web(funcButtonsColor));
    	if(textColor == true) {
    		textColorChoiceBox.setValue("Black");
    		colorsTLabel.setStyle("-fx-background-color: transparent; -fx-text-fill: #000000;");
    	}else {
    		textColorChoiceBox.setValue("White");
    		colorsTLabel.setStyle("-fx-background-color: transparent; -fx-text-fill: #FFFFFF;");
    	}
    	
    	mainAnchorPane.setStyle("-fx-displayColor: "+displayColor+"; -fx-buttonsColor: "+numsButtonsColor+"; -fx-functionsColor: "+funcButtonsColor+"; -fx-textColor: "+fontColor+";");
    	backToFrontImageView.setImage(new Image(iconColoration("moreFuncArrowIcon",textColor)));
    }
    public void matchControlClass(MainCalulatorControllClass inputController) {
    	mainCalulatorController = inputController;
    }
    
    @FXML
    void backToFrontPressMethod(ActionEvent event) {
    	mc = new MathContext(Integer.parseInt(outputLengthTextField.getText()));
    	mainProcess.mc = mc;
    	mainProcess.domainBottom = Double.parseDouble(domainBottomTextField.getText());
    	mainProcess.domainTop = Double.parseDouble(domainTopTextField.getText());
    	mainProcess.rangeBottom = Double.parseDouble(rangeBottomTextField.getText());
    	mainProcess.rangeTop = Double.parseDouble(rangeTopTextField.getText());
    	Stage stages = (Stage) backToFrontButton.getScene().getWindow();
    	stageSceneChange(mainCalulatorController.windowSize,762,stages);
    	stages.setScene(mainCalulatorScene);
    	settingsFileOut();
    	mainCalulatorController.updateColor("#"+displayColorPicker.getValue().toString().substring(2,8),"#"+numbersColorPicker.getValue().toString().substring(2,8),"#"+functionsColorPicker.getValue().toString().substring(2,8),fontColor);
    }

    @FXML
    void displayColorUpdate(ActionEvent event) {
    	radioButtonsClear();
    	System.out.println(displayColorPicker.getValue());
    	String color = displayColorPicker.getValue().toString().substring(2,8);
    	displayModel.setFill(Color.web(color));
    	System.out.println(mainAnchorPane.getStyle());
    }

    @FXML
    void functionsColorUpdate(ActionEvent event) {
    	radioButtonsClear();
    	System.out.println(functionsColorPicker.getValue());
    	String color = functionsColorPicker.getValue().toString().substring(2,8);
    	functionsModel.setFill(Color.web(color));
    }

    @FXML
    void numsColorUpdate(ActionEvent event) {
    	radioButtonsClear();
    	System.out.println(numbersColorPicker.getValue());
    	String color = numbersColorPicker.getValue().toString().substring(2,8);
    	numsModel.setFill(Color.web(color));
    }
    @FXML
    void textComboBoxUpdate(ActionEvent event) {
    	radioButtonsClear();
    	if(textColorChoiceBox.getValue() == "Black") {
    		fontColor = true;
    		colorsTLabel.setStyle("-fx-background-color: transparent; -fx-text-fill: #000000;");
    	}else {
    		fontColor = false;
    		colorsTLabel.setStyle("-fx-background-color: transparent; -fx-text-fill: #FFFFFF;");
    	}
    }
    @FXML
    void onlookNFeelMenuButtonPressed(ActionEvent event) {
    	lookAndFeelAnchorPane.setVisible(true);
    	aboutAnchorPane.setVisible(false);
    	preferencesAnchorPane.setVisible(false);
    }
    @FXML
    void onAboutMenuButtonPressed(ActionEvent event) {
    	aboutAnchorPane.setVisible(true);
    	lookAndFeelAnchorPane.setVisible(false);
    	preferencesAnchorPane.setVisible(false);
    }
    @FXML
    void onPreferencesButtonPressed(ActionEvent event) {
    	preferencesAnchorPane.setVisible(true);
    	lookAndFeelAnchorPane.setVisible(false);
    	aboutAnchorPane.setVisible(false);
    }
    @FXML
    void onDarkThemeRadioButtonPressed(ActionEvent event) {
    	if(lightThemeRadioButton.isSelected() == true) {
    		lightThemeRadioButton.setSelected(false);
    	}
    	displayModel.setFill(Color.web("#363636"));
    	numsModel.setFill(Color.web("#000000"));
    	functionsModel.setFill(Color.web("#444444"));
    	displayColorPicker.setValue(Color.web("#363636"));
    	numbersColorPicker.setValue(Color.web("#000000"));
    	functionsColorPicker.setValue(Color.web("#444444"));
    	textColorChoiceBox.setValue("White");
    	colorsTLabel.setStyle("-fx-background-color: transparent; -fx-text-fill: #FFFFFF;");
    	darkThemeRadioButton.setSelected(true);
    }

    @FXML
    void onLightThemeRadioButtonPressed(ActionEvent event) {
    	if(darkThemeRadioButton.isSelected() == true) {
    		darkThemeRadioButton.setSelected(false);
    	}
    	displayModel.setFill(Color.web("#fefefe"));
    	numsModel.setFill(Color.web("#f2f2f2"));
    	functionsModel.setFill(Color.web("#e3e3e3"));
    	displayColorPicker.setValue(Color.web("#fefefe"));
    	numbersColorPicker.setValue(Color.web("#f2f2f2"));
    	functionsColorPicker.setValue(Color.web("#e3e3e3"));
    	textColorChoiceBox.setValue("Black");
    	colorsTLabel.setStyle("-fx-background-color: transparent; -fx-text-fill: #000000;");
    	lightThemeRadioButton.setSelected(true);
    }
    @FXML
    void onOutputLengthTextFieldInput(KeyEvent event) {
    	if(event.toString().isEmpty() != true) {
    		mc = new MathContext(Integer.parseInt(outputLengthTextField.getText())); 
    	}
    }
    public void radioButtonsClear() {
    	lightThemeRadioButton.setSelected(false);
    	darkThemeRadioButton.setSelected(false);
    }
    public void settingsFileOut() {
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
	   	      myWriter.write("displayColor:"+"#"+displayColorPicker.getValue().toString().substring(2,8));
	   	      myWriter.append("\nnumbersColor:"+"#"+numbersColorPicker.getValue().toString().substring(2,8));
	   	      myWriter.append("\nfunctionsColor:"+"#"+functionsColorPicker.getValue().toString().substring(2,8));
	   	      myWriter.append("\ntextColor:"+fontColor);
	   	      myWriter.append("\noutputLength:"+outputLengthTextField.getText());
	   	      myWriter.append("\ndefaultDomain:"+domainBottomTextField.getText()+","+domainTopTextField.getText());
	   	      myWriter.append("\ndefaultRange:"+rangeBottomTextField.getText()+","+rangeTopTextField.getText());
	   	      myWriter.close();
	   	      System.out.println("Successfully wrote settings to file");
	   	    } catch (IOException e) {
	   	      System.out.println("An error occurred.");
	   	      e.printStackTrace();
	   	    }
	   }
}

