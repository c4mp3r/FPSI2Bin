package View;

import java.net.URL;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DAO.DAOProduto;
import Entidades.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import View.*;

public class princ implements Initializable {

	int counter = 0;
	private ArrayList<Produto> listPtd = new ArrayList<>();
	
	private DAOProduto daop = new DAOProduto();
	@FXML
	private TextField name;
	
	@FXML
	private TextField desc;
	
    @FXML
    private Button rem;

    @FXML
    private Button alt;

    @FXML
    private Button pesq;

    @FXML
    private Button add;
    

    @FXML
    private Button listar;

    @FXML
    private Button sair;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> ID;

    @FXML
    private TableColumn<?, ?> Name;

    @FXML
    private TableColumn<?, ?> Prec;

    @FXML
    void Adicionar(ActionEvent event) {
    	//JOptionPane.showMessageDialog(null, "teste");
    	
    	counter++;
    	//
    	/* 
    	 *  PROFESSOR. Tentei de tudo aqui, não consigo lançar nova tela seguindo seu exemplo
    	 *  Hora ele diz que um método deve ser estático e hora diz que não deve ser. Copiando igualzinho seu exemplo
    	 *  Perdi várias horas e nada.
    	 *  FAZENDO EXATAMENTE COMO O SENHOR FEZ EM SALA, EU ACABO ABRINDO A MESMA JANELA.
    	 *   */
    	
    	/*
    	View.Principal p = new View.Principal();
    	p.start(new Stage());*/
    	
    	
    	String s1,s2;
    	s1 = JOptionPane.showInputDialog("entre com o nome");
    	s2 = JOptionPane.showInputDialog("entre com o preco");
    	
    	Produto p1 = new Produto();
    	p1.setName(s1);
    	p1.setPrec(s2);
    	int ret;
    	ret = counter;
    	//ret = daop.addProduto(p1);

    	p1.setId(ret);
    	JOptionPane.showMessageDialog(null, "ID do produto "+Integer.toString(ret));
    	
    	listPtd.add(p1);
    	
    }

    @FXML
    void Alterar(ActionEvent event) {
    /*	String s1,s2;
    	
    	s1 = JOptionPane.showInputDialog("entre com o nome do produto a ser alterado");
    	s2 = JOptionPane.showInputDialog("entre com o NOVO preço");
    	Produto p1 = new Produto();
    	p1.setName(s1);
    	p1.setPrec(s2);
    	int ret = daop.aturalizarProduto(p1);*/
    	
    	showUIAlterar();
    	
    }

    @FXML
    void Pesquisar(ActionEvent event) {
    	/*String s1;
    	s1 = JOptionPane.showInputDialog("Entre com a descricao");
    	Catalogo cat = new Catalogo(daop.ListarProdutos(s1));*/
    	showUIPesquisar();
    	

    }

    @FXML
    void Remover(ActionEvent event) {
    	//String s1;
    	//s1 = JOptionPane.showInputDialog("Entre com o nome");
    //	daop.deletarProdutoSTR(s1);
    	showUIRemover();
    }
    
    @FXML
    void Listar(ActionEvent event) {
    	/*ObservableList<Produto> observableList = FXCollections.observableArrayList(Produto);
		table.setItems(observableList);*/
		showUIPesquisar();
    }
    

    @FXML
    void Sair(ActionEvent event) {

		System.out.println("Sair");
		View.Principal.getPrimaryStage().close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	

	private void showUIPesquisar()
	{
		JFrame frame = new JFrame();
		frame.setLayout(null);
	    frame.setTitle("Pesquisar");
	    frame.setSize(550,500);
	    
	    JButton bt= new JButton();
	    JLabel lb = new JLabel();
	    JLabel lb2 = new JLabel();
	    JLabel lb3 = new JLabel();
	    lb.setText("nome ou preço a pesquisar(vazio = tds)");
	    
	    lb.setBounds(15,20,350,25);
	    lb.setVisible(true);
	    
	    lb2.setText("produtos encontrados");
	    lb2.setBounds(15,50,350,25);
	    
	    JButton btPesq = new JButton();
	    btPesq.setBounds(15,80,500,30);
	    btPesq.setText("pesquisar");
	    
	    JTextArea txtAr = new JTextArea();
	    txtAr.setBounds(10, 100, 400, 400);
	    
	    bt.setBounds(400, 20, 75, 75);
	    bt.setText("O.K!");
	    txtAr.setText("");
	    
	    JTextField txtFilt=new JTextField();
	    txtFilt.setBounds(300,15,100,20);
	    bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(txtFilt.getText().equals("")) {
            	//JOptionPane.showMessageDialog(null, "evento add");
        	    String temp;
            	temp = txtAr.getText();
            	temp = temp + listPtd.toString();
            	
            	txtAr.setText(temp);}
            	else
            	{
            		String filt;
            		filt = txtFilt.getText();
            		int i = 0;
            		String t2;
            		t2 = txtAr.getText();
            		
            		for(i=0;i<listPtd.size();i++)
            		{
            			if(listPtd.get(i).getName().equals(filt) || listPtd.get(i).getPrec().equals(filt))
            					{
            						t2 = t2 + listPtd.get(i).toString();
            					}
            		}
            		
            		txtAr.setText("");
            		txtAr.setText(t2);
            	}
            	
           }
             
         });
	

	    
	    frame.add(lb);
	    frame.add(lb2);
	    frame.add(txtAr);
	    frame.add(bt);
	    frame.add(txtFilt);
	    frame.setVisible(true);
	    frame.show();
		
	}
	
	
	private void showUIAlterar()
	{
		
		JFrame frame = new JFrame();
		frame.setLayout(null);
	    frame.setTitle("Alterar");
	    frame.setSize(550,500);
	    
	    JButton bt= new JButton();
	    JLabel lb = new JLabel();
	    JLabel lb2 = new JLabel();
	    JLabel lb3 = new JLabel();
	    
	    
	    lb3.setText("ID do produto a ser ATLERADO");
	    lb3.setBounds(5,5,350,30);
	    
	    lb.setText("nome do produto a");
	    
	    lb.setBounds(5,50,350,25);
	    lb.setVisible(true);
	    
	    lb2.setText("nova descricao");
	    lb2.setBounds(5,100,350,25);
	    
	    JButton btPesq = new JButton();
	    btPesq.setBounds(15,120,500,30);
	    btPesq.setText("pesquisar");
	    
	    JTextField txtAlt = new JTextField();
	    txtAlt.setBounds(220,50,120,20);
	    
	    JTextField txtNome = new JTextField();
	    txtNome.setBounds(220,100,120,20);
	    
	    
	    JTextArea txtAr = new JTextArea();
	    txtAr.setBounds(10, 150, 400, 400);
	    
	    bt.setBounds(400, 20, 75, 75);
	    bt.setText("ALTERAR");
	    txtAr.setText("");
	    
	    JTextField txtID = new JTextField();
	    txtID.setBounds(220,5,120,20);
	    
	  //JOptionPane.showMessageDialog(null, "evento add");
	    String temp;
    	temp = txtAr.getText();
    	temp = temp + listPtd.toString();
    	
    	txtAr.setText(temp);
    	
	    bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int id_prod = -1;
            	String nome;
            	String prec;
            	int flagAlterou = -1;
            	id_prod = Integer.parseInt(txtID.getText());
            	nome = txtNome.getText();
            	prec = txtAlt.getText();
            	int c = 0;

            	Produto p = new Produto();
            	for (c = 0; c<listPtd.size();c++)
            	{
            		if(id_prod==listPtd.get(c).getId())
            		{
            			listPtd.get(c).setName(nome);
            			listPtd.get(c).setPrec(prec);
            			flagAlterou=1;

                    	p.setPrec(prec);
                    	p.setId(c);
                    	//daop.aturalizarProduto(p);
            		}
            	}
            	if (flagAlterou!=1) {JOptionPane.showMessageDialog(null, "ID não encontrado");return;}
            	p.setName(nome);
            	
           }
             
         });
	

	    
	    frame.add(lb);
	    frame.add(lb2);
	    frame.add(txtAr);
	    frame.add(bt);
	    frame.add(txtNome);
	    frame.add(txtAlt);
	    frame.add(lb3);
	    frame.add(txtID);

	    frame.setVisible(true);
	    frame.show();
		
	}
	
	public void showUIRemover()
	{
		JFrame frame = new JFrame();
		frame.setLayout(null);
	    frame.setTitle("Remover");
	    frame.setSize(550,500);
	    
	    JButton bt= new JButton();
	    JLabel lb = new JLabel();
	    lb.setText("ID do produto a ser removido");
	    
	    lb.setBounds(15,20,350,25);
	    lb.setVisible(true);
	    
	    JTextField txtExc = new JTextField();
	    txtExc.setBounds(200, 25, 100, 20);
	    
	    JButton btPesq = new JButton();
	    btPesq.setBounds(15,80,500,30);
	    btPesq.setText("Excluir");
	    
	    JTextArea txtAr = new JTextArea();
	    txtAr.setBounds(10, 100, 400, 400);
	    
	    bt.setBounds(400, 20, 75, 75);
	    bt.setText("O.K!");
	  //JOptionPane.showMessageDialog(null, "evento add");
	    String temp;
    	temp = txtAr.getText();
    	temp = temp + listPtd.toString();
    	
    	txtAr.setText(temp);
	    bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int id_exc;
            	int id_a=-1;
            	id_a = Integer.parseInt(txtExc.getText());
            	id_exc=Integer.parseInt(JOptionPane.showInputDialog("entre com o ID do produto para confirmar exclusao"));;
            	if (id_exc!= id_a) {JOptionPane.showMessageDialog(null, "EXCLUSÃO NÃO EFETUADA\nATENÇAÕ - ENTRE COM O ID DO PRODUTO A SER EXCLUÍDO!!!");return;}
            	
            	
           }
             
         });
	
	    frame.add(lb);
	    frame.add(txtAr);
	    frame.add(bt);
	    frame.add(txtExc);
	    frame.setVisible(true);
	    frame.show();
	}
	
	




}









