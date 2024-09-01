package application;
	
import controller.ControllerTelaDeConversao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Conversor de Moedas");
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ConversorTela.fxml"));
			Parent arquivoXML = loader.load();
			
			Scene conversaoScene = new Scene(arquivoXML);
			primaryStage.setScene(conversaoScene);
			
			ControllerTelaDeConversao telaDeConversao = loader.getController();
			
			primaryStage.setOnCloseRequest(e->{
				if(ControllerTelaDeConversao.onCloseQuery()) System.exit(0);
				else e.consume();
			});
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
