package ies.luisvives.org.calculadorafxml;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CalculatorModel implements ICalculatorModel{
	private final IntegerProperty accumulator;

	public CalculatorModel() {
		accumulator = new SimpleIntegerProperty(0);
	}

	public void sum(int inputNumber) {
		accumulator.setValue(accumulator.getValue() + inputNumber);
		inputNumber = accumulator.getValue();
	}

	public void subtract(int inputNumber) {
		accumulator.setValue(accumulator.getValue() - inputNumber);
	}

	public void multiply (int inputNumber) {
		accumulator.setValue(accumulator.getValue() * inputNumber);
	}

	public void divide (int inputNumber) {
		if (inputNumber != 0)
			accumulator.setValue(accumulator.getValue() / inputNumber);
		else
			accumulator.setValue(Double.NaN);
	}

	public void module (int inputNumber) {
		if (inputNumber != 0)
			accumulator.setValue(accumulator.getValue() % inputNumber);
		else
			accumulator.setValue(Double.NaN);
	}

	public void clear () {
		accumulator.setValue(0);
	}

	public IntegerProperty accumulatorProperty() {
		return accumulator;
	}
}