package View;

import java.io.BufferedReader;
import java.io.IOException;

import Modelos.Produto;
import Util.ListaDeProdutos;

public class ViewCrudProduto {

	//Responsável pela geração do menu na interface
	public static int ViewMenu(BufferedReader reader) throws NumberFormatException, IOException {

		System.out.println(" ===========================================");
		System.out.println("||Digite 1 para Cadastrar um Produto       ||");
		System.out.println("||Digite 2 para Mostrar a Lista de Produtos||");
		System.out.println("||Digite 3 Para Deletar Produto            ||");
		System.out.println("||Digite 4 para Editar Produto             ||");
		System.out.println("||Digite 5 para Sair                       ||");
		System.out.println(" ===========================================");

		return Integer.parseInt(reader.readLine());
	}

	//Salva os cadastros
	public static String[] ViewSalvarProduto(BufferedReader reader) throws IOException {
		String[] menuProduto= { "Categoria do Produto:","Nome do Produto:", "Marca:", "Preço:"};
		String[] dadosProduto={"","","",""};

		for(int i=0;i<dadosProduto.length;i++) {
			System.out.println(menuProduto[i]);
			dadosProduto[i] = reader.readLine();
		}

		return dadosProduto;
	}

	//Mostra uma lista de cadastros com um indice começando do zero
	public static int ViewListaProduto (String deletarEditar, BufferedReader reader) throws NumberFormatException, IOException {

		for(int i=0;i<ListaDeProdutos.getInstance().size();i++) {

			System.out.println(i + " - " + ListaDeProdutos.getInstance().get(i));
		}

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o número do Produto que deseja" + deletarEditar);

		return Integer.parseInt(reader.readLine());
	}

	//Pega o indice do atributo a ser editado
	public static String[] ViewOpcaoEdit(BufferedReader reader) throws IOException {

		String[] dadosEditados = {"", ""};

		System.out.println("Escolha o atributo que deseja alterar:");
		System.out.println("[1]- Categoria");
		System.out.println("[2]- Produto");
		System.out.println("[3]- Marca");
		System.out.println("[4]- Preço");

		dadosEditados[0] = reader.readLine();

		System.out.println("Escreva o novo do atributo:");

		dadosEditados[1] = reader.readLine();

		return dadosEditados;
	}

	//Pega os atributos e edita
	public static void ViewAlunosEdit() {

		for(Produto a : ListaDeProdutos.getInstance()){
			System.out.println("___________________________________________");
			System.out.println("Nome: " + a.getCat());
			System.out.println("CPF: " + a.getNome());
			System.out.println("Curso: " + a.getMarca().getNomeMarca());
			System.out.println("Rua: " + a.getMarca().getPreco());
			System.out.println("__________________________________________");
		}
	}
	
	//Apresenta uma mensagem de alerta/sucesso ao usuário
	public static void ViewMSGFinal(int op) {
		String[] msg = {"Produto salvo com sucesso!",
				"Cadastro alterado!",
				"Cadastro Removido!",
				"Caractere Invalido!",
				"Fim do Programa!",
				"Voltando ao Menu...."};
		
		System.out.println(msg[op]);
		}
	}