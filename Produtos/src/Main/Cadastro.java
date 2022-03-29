package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import View.ViewCrudProduto;


public class Cadastro {
	
	//Onde é realizado o cadsatro dos produtos
	public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//Carrega a lista antes, pra ter os arquivos salvos
		CrudProduto.ListarProdutosSalvos(1);
		
		int menu = 0;
		while (menu < 5) {


			// Método da Interface do menu
			menu = ViewCrudProduto.ViewMenu(reader);


			try {


				switch (menu) {

				case 1:
					//Realiza Cadastro
					CrudProduto.SalvarProduto(reader);
					ViewCrudProduto.ViewMSGFinal(0);

					break;


				case 2:
					//Mostra os Cadastros
					CrudProduto.ListarProdutosSalvos(0);
					break;


				case 3:
					//Deleta os Cadastros
					CrudProduto.DeletarProdutosSalvos(reader);
					ViewCrudProduto.ViewMSGFinal(2);

					break;


				case 4:
					//Edita os Cadastros
					CrudProduto.EditarProdutosSalvos(reader);
					ViewCrudProduto.ViewMSGFinal(1);

					break;


				case 5:
					//Sai do Programa
					ViewCrudProduto.ViewMSGFinal(4);

					break;

				}

			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
	}
}


