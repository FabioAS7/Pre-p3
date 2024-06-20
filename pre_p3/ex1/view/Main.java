package view;

import java.io.IOException;

import javax.swing.JOptionPane;
import controller.MetodosArq;

public class Main 
{
	public static void main(String args[])
	{
		String unit = JOptionPane.showInputDialog("Digite o valor unit a ser encontrado: ").toUpperCase();
		MetodosArq met = new MetodosArq();
		try 
		{
			met.lerArquivo(unit);
		} catch (IOException e) 
		{
			System.err.println(e.getMessage());
		}
	}

}
