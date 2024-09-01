package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Conversor;
import model.MoedasOptions;


public class ControllerTelaDeConversao implements Initializable {

    @FXML
    private Button btnConverter;

    @FXML
    private Button btnRestaurar;

    @FXML
    private ComboBox<MoedasOptions> escolherMoedaDestino;
    private List<MoedasOptions> listMoedaDestino = new ArrayList<>();
    private ObservableList<MoedasOptions> obsMoedaDestino;

    @FXML
    private ComboBox<MoedasOptions> escolherMoedaOrigem;
    private List<MoedasOptions> listMoedaOrigem = new ArrayList<>();
    private ObservableList<MoedasOptions> obsMoedaOrigem;

    @FXML
    private Label labelDescricaoMoedaDestino;

    @FXML
    private Label labelDescricaoMoedaOrigem;

    @FXML
    private Label labelEm;

    @FXML
    private Label labelMoedaDestino;

    @FXML
    private Label labelMoedaOrigem;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private TextField txtFieldMoedaDestino;

    @FXML
    private TextField txtFieldMoedaOrigem;

    @FXML
    private Text txtTitulo;

    @FXML
    void onClickBtnConverter(ActionEvent event) {
    	MoedasOptions opcaoOrigemSelecionada = escolherMoedaOrigem.getSelectionModel().getSelectedItem(); // Retorna todo o objeto
		MoedasOptions opcaoDestinoSelecionada = escolherMoedaDestino.getSelectionModel().getSelectedItem();
		
		System.out.printf("Moeda de origem selecionada: %s  |  Moeda de destino selecionada: %s\n", opcaoOrigemSelecionada.getSigla(),
				opcaoDestinoSelecionada.getSigla());
		
		double valorOrigem = Double.valueOf(txtFieldMoedaOrigem.getText());
		
		Conversor conversor = new Conversor(opcaoOrigemSelecionada.getSigla(), opcaoDestinoSelecionada.getSigla(), valorOrigem);
		double valorDestino = conversor.converterMoeda();
		
		txtFieldMoedaDestino.setText(String.valueOf(valorDestino));
		labelDescricaoMoedaOrigem.setText(opcaoOrigemSelecionada.getSigla());
		labelDescricaoMoedaDestino.setText(opcaoDestinoSelecionada.getSigla());
    }

    @FXML
    void onClickBtnRestaurar(ActionEvent event) {
    	txtFieldMoedaOrigem.setText(new String("0"));
    	txtFieldMoedaDestino.setText(new String());
    	
    	labelDescricaoMoedaOrigem.setText("BRL");
    	labelDescricaoMoedaDestino.setText("USD");
    	
    	escolherMoedaOrigem.getSelectionModel().select(0);
		escolherMoedaDestino.getSelectionModel().select(5);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setOptions();
		escolherMoedaOrigem.getSelectionModel().select(0);
		escolherMoedaDestino.getSelectionModel().select(5);
		txtFieldMoedaOrigem.setText(new String("0"));
	}
	
	
	public void setOptions() {
		MoedasOptions moedaOption1 = new MoedasOptions("BRL"); // Real
		MoedasOptions moedaOption2 = new MoedasOptions("EUR"); // Euro
		MoedasOptions moedaOption3 = new MoedasOptions("GBP"); // Libras
		MoedasOptions moedaOption4 = new MoedasOptions("JPY"); // Iene
		MoedasOptions moedaOption5 = new MoedasOptions("RUB"); // Rublo
		MoedasOptions moedaOption6 = new MoedasOptions("USD"); // Dólar
		
		listMoedaOrigem.add(moedaOption1);
		listMoedaOrigem.add(moedaOption2);
		listMoedaOrigem.add(moedaOption3);
		listMoedaOrigem.add(moedaOption4);
		listMoedaOrigem.add(moedaOption5);
		listMoedaOrigem.add(moedaOption6);
		
		obsMoedaOrigem = FXCollections.observableArrayList(listMoedaOrigem);
		escolherMoedaOrigem.setItems(obsMoedaOrigem);
		
		listMoedaDestino.add(moedaOption1);
		listMoedaDestino.add(moedaOption2);
		listMoedaDestino.add(moedaOption3);
		listMoedaDestino.add(moedaOption4);
		listMoedaDestino.add(moedaOption5);
		listMoedaDestino.add(moedaOption6);
		
		obsMoedaDestino = FXCollections.observableArrayList(listMoedaDestino);
		escolherMoedaDestino.setItems(obsMoedaDestino);
	}

}
