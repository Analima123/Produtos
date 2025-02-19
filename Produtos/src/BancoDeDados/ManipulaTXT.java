package BancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Modelos.Produto;
import Util.ListaDeProdutos;

public class ManipulaTXT {

	//� usado para que n�o se repita a chama��o de cadastro atoa
	public static String nomeDoArquivo = "CadastroProduto.txt" ;


	public static void SalvarArquivoTXT() throws IOException {

		try(BufferedWriter buffer= new BufferedWriter(new FileWriter(nomeDoArquivo))){
			PrintWriter pw= new PrintWriter(buffer);
			for(Produto a : ListaDeProdutos.getInstance())
				pw.println(a);
		}
	}


	//� usado para que n�o se repita a chamados atoa
	public static void LerArquivo() throws FileNotFoundException, IOException {

		try(FileWriter arq = new FileWriter(nomeDoArquivo,true)){};

		String line;

		try(BufferedReader reader = new BufferedReader(new FileReader(nomeDoArquivo)))
		{
			while((line= reader.readLine())!=null && !"".equals(line))
			{
				Produto produto= new Produto(line);
				ListaDeProdutos.getInstance().add(produto);

			}
		}
	}
}

