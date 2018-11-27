package View;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class cadastro  implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	
	}
	
    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    void AddProd(ActionEvent event) {
    	
    	// NÃO CONSIGO LINKAR PELO XML, 
    	// NÃO RECONHECE O onAction="#Add" POR NADA NESTE MUNDO!!!

    }

}
