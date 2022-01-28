package ies.luisvives.org.calculadorafxml;

import javafx.beans.property.IntegerProperty;

public interface ICalculatorModel {
	public void sum(int inputNumber);

	public void subtract(int inputNumber);

	public void multiply (int inputNumber);

	public void divide (int inputNumber);

	public void module (int inputNumber);

	public void clear ();

	public IntegerProperty accumulatorProperty();
}
