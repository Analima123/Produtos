package Util;

import java.util.ArrayList;
import java.util.List;

import Modelos.Produto;

// Esse método serve para simplificar a chamada das listas, fazendo com que não haja repetições desnecessárias
public class ListaDeProdutos {

	private static List<Produto> listaDeProdutos = new ArrayList<Produto>();
	
	public static List<Produto> getInstance(){
		return listaDeProdutos;
	}
}
