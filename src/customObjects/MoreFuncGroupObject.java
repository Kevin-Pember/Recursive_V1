package customObjects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import mainCalulatorPackage.MainCalulatorControllClass;
import mainCalulatorPackage.MoreFunctionsPage;
import processing.CalculatorProcessing;

public class MoreFuncGroupObject {
	protected FXMLLoader buttonElementLoader;
	public Parent buttonElementRoot;
	protected moreFuncGroup MoreFuncElementController;
	public String compileString;
	public MainCalulatorControllClass mainClass;
	public Scene main;
	private CalculatorProcessing mainProcess;
	private boolean removeVisablity = true;
	private MoreFunctionsPage extendFuncsController;
	//Constructor for this class that takes a string
	public MoreFuncGroupObject(String cs,MainCalulatorControllClass mainClass, Scene main) {
		compileString = cs;
		this.mainClass = mainClass;
		this.main = main;
		this.extendFuncsController = mainClass.extendFuncsController;
		loadElement();
	}
	// The accessor method that returns the button element the object holds
	public Parent buttonLoader() {
		return buttonElementRoot;
	}
	public void setCalculatorProcess(CalculatorProcessing mainProcess) {
    	this.mainProcess = mainProcess;
    }
	//Used to send color variables to the element Controller
	public void updateColors(String displayColor, String numsButtonsColor, String funcButtonsColor, boolean textColor) {
		MoreFuncElementController.updateColor(displayColor, numsButtonsColor, funcButtonsColor, textColor);
	}
	public String returnElementID() {
		System.out.println(buttonElementRoot.getId());
		return buttonElementRoot.getId();
	}
	public void setRemoveVisability() {
		if(removeVisablity) {
			MoreFuncElementController.removeButton(true);
			removeVisablity = false;
		}else {
			MoreFuncElementController.removeButton(false);
			removeVisablity = true;
		}
	}
	public void loadElement() {
		try {
			buttonElementLoader = new FXMLLoader(getClass().getResource("/moreFuncGroup.fxml"));
			System.out.println("Element Loaded");
			buttonElementRoot = buttonElementLoader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		MoreFuncElementController = (moreFuncGroup) buttonElementLoader.getController();
		MoreFuncElementController.textOfElement(compileString);
		MoreFuncElementController.mainAdd(mainClass);
		MoreFuncElementController.mainSceneAdd(main);
		MoreFuncElementController.setController(this);
		//MoreFuncElementController.setCalculatorProcess(mainProcess);
	}
	public void removeMoreFuncGroup(String compileString){
		extendFuncsController.removeFunctionFileOut(compileString);
	}
}
