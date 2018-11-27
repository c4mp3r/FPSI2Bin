package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.*;
import conexao.*;

public class DAOProduto {
	
	private int counter;
	
	public void resetCounter()
	{
		counter = 0;
	}
	
	
	public DAOProduto() 
	{
		/*if (counter == 0)
		{
			counter++;
			String prepare;
			prepare = "CREATE TEMPORARY TABLE produtos(\r\n" + 
					"	nome varchar(255),\r\n" + 
					"	prec varchar(255),\r\n" + 
					"	id varchar(255)\r\n" + 
					")";
			
			try (

					Connection conn = new CNXHSQLDB().conectar();
					PreparedStatement pst = conn.prepareStatement(prepare);)
				{
					
					pst.executeUpdate();

				}
				 catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Erro ao executar  " + e.toString());
				}
		}*/
		
	}

	// Add
	public int addProduto(Produto p) {
		counter++;

		String NOVO = 	"INSERT INTO produtos (nome, prec, id) VALUES (?, ?, ?)";
		try (

			Connection conn = new CNXHSQLDB().conectar();
			PreparedStatement pst = conn.prepareStatement(NOVO);)
		{
			pst.setString(1, p.getName());
			pst.setString(2, p.getPrec());
			pst.setString(3, Integer.toString(counter));
			pst.executeUpdate();

		}
		 catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar  " + e.toString());
		}
		return counter;
	}

	// Ler tudo
	public ArrayList<Produto> ListarTodosOsProdutos() {
		ArrayList<Produto> listContacts = new ArrayList<>();
		Produto p2;
		String LER_TD = 	"SELECT * FROM AGENDA";
		try (Connection conn = new CNXHSQLDB().conectar();
				PreparedStatement pst = conn.prepareStatement(LER_TD);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				p2 = new Produto();
				p2.setId(rs.getInt("id"));
				p2.setName(rs.getString("name"));
				listContacts.add(p2);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao executar o Statement" + e.toString());
		}

		return listContacts;
	}
	
	// Ler se
	public ArrayList<Produto> ListarProdutos(String NOME) {
		ArrayList<Produto> listaRetorna = new ArrayList<>();
		Produto p;
		String LER_SE = 	"SELECT * FROM produtos WHERE NAME="+NOME;
		try (Connection conn = new CNXHSQLDB().conectar();
				PreparedStatement pst = conn.prepareStatement(LER_SE);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				p = new Produto();
				p.setId(rs.getInt("ID"));
				p.setName(rs.getString("NAME"));
				p.setPrec(rs.getString("PRECO"));
				listaRetorna.add(p);
			}
			
			return listaRetorna;


		} catch (SQLException e) {
			System.out.println("Erro ao executar o Statement" + e.toString());
		}
		return null;

	}
	// Alterar
	public int aturalizarProduto(Produto p) {
		String CHANGE =	"UPDATE produtos SET PRECO=?, NOME=? ";
		try (Connection conn = new CNXHSQLDB().conectar(); 
				PreparedStatement pst = conn.prepareStatement(CHANGE);) {

			pst.setString(1, p.getPrec());
			pst.setString(2, p.getName());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o Statment " + e.toString());
			return 0;
		}
		return 1;
	}
	// Remover
	public void deletarProdutoID(Produto p) {
		String DELETE = 	"DELETE FROM produtos WHERE ID=?";
		try (Connection conn = new CNXHSQLDB().conectar(); 
				PreparedStatement pst = conn.prepareStatement(DELETE);) {
			pst.setInt(1, p.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o Statment " + e.toString());
		}
	}
	
	public void deletarProdutoSTR(String s) {
		String DELETE = 	"DELETE FROM produtos WHERE NAME=?";
		try (Connection conn = new CNXHSQLDB().conectar(); 
				PreparedStatement pst = conn.prepareStatement(DELETE);) {
			pst.setString(1, s);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o Statment " + e.toString());
		}
	}
}
