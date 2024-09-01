module ConversorDeMoedasJava02 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.money;
	requires javafx.graphics;
	requires javafx.base;

	
	opens application to javafx.graphics, javafx.fxml, javafx.controls;
	opens controller to javafx.graphics, javafx.fxml, javafx.controls;
}
