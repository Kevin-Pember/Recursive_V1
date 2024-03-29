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

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import mainCalulatorPackage.MainCalulatorControllClass;
import processing.CalculatorProcessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.MathContext;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

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
    private ImageView lockWindowImageView;

    @FXML
    private Button lookAndFeelMenuButton;
    
    @FXML
    private Button preferencesButton;

    @FXML
    private Button aboutMenuButton;
    
    @FXML
    private Button windowLockButton;

    @FXML
    private AnchorPane lookAndFeelAnchorPane;

    @FXML
    private Label lookNFeelLabel;
    
    @FXML
    public TextField windowHeightTextField;
    
    @FXML
    public TextField windowWidthTextField;

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
    private Button newThemeButton;

    @FXML
    private ImageView addObjectImageView;

    @FXML
    private Button removeThemeButton;

    @FXML
    private ImageView removeObjectImageView;

    @FXML
    private Label colorsTLabel;

    @FXML
    private ScrollPane presetThemesScrollPane;

    @FXML
    private AnchorPane presetThemesAnchorPane;
    
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
    
    @FXML
    private Button helpButton;
    
    @FXML
    private ImageView helpImageView;
    
    @FXML
    private GridPane themesGridPane;
    
    private Scene mainCalulatorScene;
    
    private MainCalulatorControllClass mainCalulatorController;
    
    private boolean fontColor = true;
    
    public MathContext mc = new MathContext(16);
    
    private CalculatorProcessing mainProcess;
    
    public boolean removeVisable = false;
    
    ObservableList<String> textOptions = FXCollections.observableArrayList("Black","White");
    
    ArrayList<ThemesObject> themesList = new ArrayList<ThemesObject>();
    
    @FXML
    public void initialize() {
    	textColorChoiceBox.setItems(textOptions);
    	newTheme("#303030»#1a1a1a»#000000»false»");
    	newTheme("#fefefe»#f2f2f2»#e3e3e3»true»");
    	themesFileMemeber();
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
    	windowHeightTextField.setText(""+mainCalulatorController.windowHeight);
    	windowWidthTextField.setText(""+mainCalulatorController.windowWidth);
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
    	lockWindowImageView.setImage(new Image(iconColoration("lockIcon",textColor)));
    	helpImageView.setImage(new Image(iconColoration("helpIcon",textColor)));
    	addObjectImageView.setImage(new Image(iconColoration("addObject",textColor)));
    	removeObjectImageView.setImage(new Image(iconColoration("minusIcon",textColor)));
    	ColorAdjust colorAdjust = new ColorAdjust();
    	if(textColor) {
    		if(mainCalulatorController.windowResizeable) {
    			colorAdjust.setBrightness(0.5);
    		}else {
    			colorAdjust.setBrightness(-0.5);
    		}
    	}else {
    		if(mainCalulatorController.windowResizeable) {
    			colorAdjust.setBrightness(-0.5);
    		}else {
    			colorAdjust.setBrightness(0.5);
    		}
    	}
    	lockWindowImageView.setEffect(colorAdjust);
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
    	stageSceneChange(Double.parseDouble(windowWidthTextField.getText()),Double.parseDouble(windowHeightTextField.getText()),mainCalulatorController.mainStage);
    	mainCalulatorController.mainStage.setScene(mainCalulatorScene);
    	mainCalulatorController.mainStage.setResizable(mainCalulatorController.windowResizeable);
    	mainCalulatorController.setLockColor(mainCalulatorController.windowResizeable);
    	mainCalulatorController.mainStage.setMinHeight(579);
    	//settingsFileOut();
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
    void onHelpPressed(ActionEvent event) {
    	mainCalulatorController.helpPageController.setBackScene(helpButton.getScene(),mainCalulatorController.mainStage.getWidth(),mainCalulatorController.mainStage.getHeight());
    	mainCalulatorController.helpPageController.updateColor("#"+displayColorPicker.getValue().toString().substring(2,8),"#"+numbersColorPicker.getValue().toString().substring(2,8),"#"+functionsColorPicker.getValue().toString().substring(2,8),fontColor);
    	mainCalulatorController.mainStage.setScene(mainCalulatorController.helpPage);
    	stageSceneChange(mainCalulatorController.windowWidth+1,mainCalulatorController.windowHeight,mainCalulatorController.mainStage);
    	mainCalulatorController.helpPageController.settingsPageAnchorPane.setVisible(true);
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
    void onNewThemeButtonPressed(ActionEvent event) {
    	String newEntry = "#"+displayColorPicker.getValue().toString().substring(2,8)+"»#"+numbersColorPicker.getValue().toString().substring(2,8)+"»#"+functionsColorPicker.getValue().toString().substring(2,8)+"»"+fontColor+"»";
    	boolean already = false;
    	for(int i = 0; i < themesList.size();i++) {
    		if(themesList.get(i).input.equals(newEntry)) {
    			already = true;
    			break;
    		}
    	}
    	if(!already) {
    		try {
  	   	      File settingsFile = new File("c:\\ProgramData\\Recursive\\themesFileOut.txt");
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
	   	      	FileWriter myWriter = new FileWriter("c:\\ProgramData\\Recursive\\themesFileOut.txt",StandardCharsets.UTF_8,true);
	   	      	if(themesList.size()-1 > 1) {
	   	      		myWriter.append("\n"+newEntry);
	   	      	}else {
	   	      		myWriter.append(newEntry);
	   	      	}
	   	      	myWriter.close();
	   	      	System.out.println("Successfully wrote equation to file");
	   	    } catch (IOException e) {
	   	    	System.out.println("An error occurred.");
	   	    	e.printStackTrace();
	   	    }
    		newTheme(newEntry);
    		themesList.get(themesList.size()-1).setRadio(true);
    	}
    }
    
    @FXML
    void onRemoveThemeButtonPressed(ActionEvent event) {
    	if(removeVisable) {
    		for(int i =0; i < themesList.size();i++){
    			if(i>1){
    				themesList.get(i).enableRemove(false);
				}
			}
    		removeVisable = false;
    	}else {
			for(int i =0; i < themesList.size();i++){
				if(i>1){
					themesList.get(i).enableRemove(true);
				}
			}
    		removeVisable = true;
    	}
    }
    @FXML
    void onOutputLengthTextFieldInput(KeyEvent event) {
    	if(event.toString().isEmpty() != true) {
    		mc = new MathContext(Integer.parseInt(outputLengthTextField.getText())); 
    	}
    }
    @FXML
    void onResizeabilityLockPressed(ActionEvent event) {
    	//lockWindowImageView.eff
    	ColorAdjust colorAdjust = new ColorAdjust();
    	if(fontColor) {
    		if(mainCalulatorController.windowResizeable) {
    			colorAdjust.setBrightness(-0.5);
    			mainCalulatorController.windowResizeable = false;
    		}else {
    			colorAdjust.setBrightness(0.5);
    			mainCalulatorController.windowResizeable = true;
    		}
    	}else {
    		if(mainCalulatorController.windowResizeable) {
    			colorAdjust.setBrightness(0.5);
    			mainCalulatorController.windowResizeable = false;
    		}else {
    			colorAdjust.setBrightness(-0.5);
    			mainCalulatorController.windowResizeable = true;
    		}
    	}
    	lockWindowImageView.setEffect(colorAdjust);
    }
    public void changeTheme(String displayColor, String numsButtonsColor, String funcButtonsColor, String textColor) {
    	displayModel.setFill(Color.web(displayColor));
    	numsModel.setFill(Color.web(numsButtonsColor));
    	functionsModel.setFill(Color.web(funcButtonsColor));
    	displayColorPicker.setValue(Color.web(displayColor));
    	numbersColorPicker.setValue(Color.web(numsButtonsColor));
    	functionsColorPicker.setValue(Color.web(funcButtonsColor));
    	if(textColor.equals("#FFFFFF")) {
    		textColorChoiceBox.setValue("White");
    	}else {
    		textColorChoiceBox.setValue("Black");
    	}
    	colorsTLabel.setStyle("-fx-background-color: transparent; -fx-text-fill: "+textColor+";");
    }
    public void radioButtonsClear() {
    	themesList.forEach((n)->{n.setRadio(false);});
    }
    public void themesFileMemeber() {
    	String fullThing = "";
    	try {
	   	      File settingsFile = new File("c:\\ProgramData\\Recursive\\themesFileOut.txt");
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
       	      File themesFile = new File("c:\\ProgramData\\Recursive\\themesFileOut.txt");
       	      Scanner myReader = new Scanner(themesFile);
       	      while (myReader.hasNextLine()) {
       	    	String line = new String (myReader.nextLine().getBytes(),StandardCharsets.UTF_8);
       	    	fullThing += line;
       	        newTheme(line);
       	      }
       	      System.out.println("This is the full themes Fileout "+fullThing);
       	      myReader.close();
       	    } catch (FileNotFoundException e) {
       	      System.out.println("An error occurred.");
       	      e.printStackTrace();
       	    }
       }
    public void newTheme(String entry) {
    	themesList.add(new ThemesObject(entry,this));
    	ColumnConstraints temp = new ColumnConstraints();
    	temp.setMaxWidth(130);
    	temp.setMinWidth(130);
    	themesGridPane.getColumnConstraints().add(temp);
    	themesGridPane.addColumn(themesList.size(), themesList.get(themesList.size()-1).getParent());
    	presetThemesAnchorPane.setPrefWidth(themesList.size()*118);
    	themesList.get(themesList.size()-1).enableRemove(removeVisable);
    }
    public void removeTheme(ThemesObject controllerClass) {
    	themesList.forEach((n)->{
    		themesGridPane.getChildren().remove(n.getParent());
    	});
    	themesList.remove(controllerClass);
    	themesGridPane.getChildren().removeAll();
    	ColumnConstraints temp = new ColumnConstraints();
    	temp.setMaxWidth(130);
    	temp.setMinWidth(130);
    	themesList.forEach((n)->{
    		themesGridPane.getColumnConstraints().add(temp);
    		themesGridPane.addColumn(themesList.indexOf(n)+1, n.getParent());
    		presetThemesAnchorPane.setPrefWidth(themesList.size()*118);
    	});
    }
}

