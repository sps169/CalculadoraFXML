module ies.luisvives.org.calculadorafxml {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.jfxtras.styles.jmetro;


	opens ies.luisvives.org.calculadorafxml to javafx.fxml;
	exports ies.luisvives.org.calculadorafxml;
}