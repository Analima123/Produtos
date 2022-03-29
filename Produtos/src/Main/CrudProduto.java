package Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancoDeDados.ManipulaTXT;
import BancoDeDados.ManipulaXML;
import Modelos.Marca;
import Modelos.Produto;
import Util.ListaDeProdutos;
import View.ViewCrudProduto;

public class CrudProduto {


//salva os produtos
	public static void SalvarProduto(BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException {

		Produto produto = new Produto();
		Marca marca = new Marca();
		String[] dados = ViewCrudProduto.ViewSalvarProduto(reader);


		produto.setCat(dados[0]);
		produto.setNome(dados[1]);
		marca.setNomeMarca(dados[2]);
		marca.setPreco(Double.parseDouble(dados[3]));

		produto.setMarca(marca);

		//Grava o que o usuário coloca em um Arquivo

		ListaDeProdutos.getInstance().add(produto);

		ManipulaTXT.SalvarArquivoTXT();

		ManipulaXML.SalvarXML();
	}

	//mostra os produtos
	public static void ListarProdutosSalvos(int op) throws UnsupportedEncodingException, FileNotFoundException, IOException, ParserConfigurationException, SAXException {

		ListaDeProdutos.getInstance().clear();

		ManipulaXML.LerArquivoXML();
//		ManipulaTXT.LerArquivo();
		
		if(op == 0)
			ViewCrudProduto.ViewAlunosEdit();
	}

//Apaga os produtos
	public static void DeletarProdutosSalvos(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {

		int indice = ViewCrudProduto.ViewListaProduto("deletar", reader);

		//remove a linha
		ListaDeProdutos.getInstance().remove(indice);


		//atualiza a lista de produtos
		ManipulaTXT.SalvarArquivoTXT();
		ManipulaXML.SalvarXML();

	}


//Altera os prosutos
	public static void EditarProdutosSalvos(BufferedReader reader) throws NumberFormatException, IOException {


		String[]dadosEditados = {"",""};
		int indice = ViewCrudProduto.ViewListaProduto("editar", reader);

		Produto produto= ListaDeProdutos.getInstance().get(indice);

		dadosEditados = ViewCrudProduto.ViewOpcaoEdit(reader);

// Pergunta qual dado vai ser editado
		switch(Integer.parseInt(dadosEditados[0])) {

		//faz a mudança dos atributos
		case 1:

			produto.setCat(dadosEditados[1]);
			break;

		case 2:

			produto.setNome(dadosEditados[1]);
			break;


		case 3:

			produto.getMarca().setNomeMarca(dadosEditados[1]);
	
			break;

		case 4:

			produto.getMarca().setPreco(Double.parseDouble(dadosEditados[1]));
			
			break;

		default:

			ViewCrudProduto.ViewMSGFinal(6);

			break;

		}

		ListaDeProdutos.getInstance().set(indice, produto);

		//atualiza a lista de produtos
		
		ManipulaTXT.SalvarArquivoTXT();
		


		}
	}

