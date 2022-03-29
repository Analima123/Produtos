package Util;

import java.util.ArrayList;
import java.util.List;

import Modelos.Produto;

// Esse m�todo serve para simplificar a chamada das listas, fazendo com que n�o haja repeti��es desnecess�rias
public class ListaDeProdutos {

	private static List<Produto> listaDeProdutos = new ArrayList<Produto>();
	
	public static List<Produto> getInstance(){
		return listaDeProdutos;
	}
}
