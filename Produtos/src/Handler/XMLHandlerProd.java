package Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Modelos.Marca;
import Modelos.Produto;
import Util.ListaDeProdutos;


//Esse método faz o papel de manipular os dados que serão inseridos no cadastro dos produtos, de modo que não haja repetições desnecessárias


public class XMLHandlerProd extends DefaultHandler{
	private StringBuilder texto;
	Produto produto;
	Marca marca;

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void endDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if(qName.equals("produto")) {

			produto = new Produto();
			marca = new Marca();
		} else {
			texto = new StringBuilder();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub

		if(qName.equals("Categoria")) {
			produto.setCat(texto.toString());

		} else if(qName.equals("Produto")){
			produto.setNome(texto.toString());


		}else if(qName.equals("NomeDaMarca")){
			marca.setNomeMarca(texto.toString());

		}else if(qName.equals("Preco")){
			marca.setPreco(Double.parseDouble(texto.toString()));

			produto.setMarca(marca);
			ListaDeProdutos.getInstance().add(produto);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		texto.append(ch, start, length);

	}

	@Override
	public void error(SAXParseException e) throws SAXException {

	}
}
