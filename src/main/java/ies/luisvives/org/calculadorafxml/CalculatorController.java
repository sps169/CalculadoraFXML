package ies.luisvives.org.calculadorafxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
	@FXML
	private Label label;
	@FXML
	private Button zero, one, two, three, four, five, six, seven, eight, nine;
	@FXML
	private Button sum, subtract, multiply, divide, module, execute, clear;
	private ICalculatorModel model;
	private int inputNumber;
	private char operation;
	private boolean reset = false;

	public CalculatorController(ICalculatorModel model) {
		this.model = model;
		this.inputNumber = 0;
	}

	private void operationHandler(char op) {
		if (model.accumulatorProperty().getValue() == 0)
			model.accumulatorProperty().setValue(inputNumber);
		inputNumber = 0;
		print(" " + op + " ");

	}

	public void sumHandler(ActionEvent event) {
		operation = '+';
		operationHandler(operation);
	}

	public void subtractHandler(ActionEvent event) {
		operation = '-';
		operationHandler(operation);
	}

	public void multiplyHandler(ActionEvent event) {
		operation = '*';
		operationHandler(operation);
	}

	public void divideHandler(ActionEvent event) {
		operation = '/';
		operationHandler(operation);
	}

	public void moduleHandler(ActionEvent event) {
		operation = '%';
		operationHandler(operation);
	}

	public void executeHandler(ActionEvent event) {
		switch(operation) {
			case '+':
				model.sum(inputNumber);
				break;
			case '-':
				model.subtract(inputNumber);
				break;
			case '*':
				model.multiply(inputNumber);
				break;
			case '/':
				model.divide(inputNumber);
				break;
			case '%':
				model.module(inputNumber);
				break;
		}
		inputNumber = 0;
		print(" = " + model.accumulatorProperty().getValue());
		reset = true;
	}

	public void clearHandler (ActionEvent event) {
		model.clear();
		label.setText("");
	}

	public void numberHandler (ActionEvent event) {
		checkReset();
		if (inputNumber * 10 + 9 > Integer.MIN_VALUE / 10) {
			this.inputNumber = this.inputNumber * 10 + Integer.parseInt(((Button)event.getSource()).getText());
			print(((Button)event.getSource()).getText());
		} else {
			label.setText("Int Overflow :(");
			inputNumber = 0;
			reset = true;
		}

	}

	private void print (String printable) {
		label.setText(label.getText() + printable);
	}

	private void checkReset() {
		if (reset) {
			label.setText("");
			model.clear();
			reset = false;
		}
	}
}
