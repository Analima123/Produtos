package BancoDeDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Handler.XMLHandlerProd;
import Modelos.Produto;
import Util.ListaDeProdutos;

public class ManipulaXML {

	private static String nomeDoArquivo = "CadastroProduto.xml";

	//Pelo XML, os dados são salvos agrupados e divididos
	public static void SalvarXML() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc = db.newDocument();

		Element produtosTag = doc.createElement("Produtos");
		doc.appendChild(produtosTag);

		for(Produto a : ListaDeProdutos.getInstance()) {

			
			//busca o "Produto"
			
			Element produtoTag = doc.createElement("produto");
			produtoTag.setAttribute("id", "1");
			produtosTag.appendChild(produtoTag);

			Element catTag = doc.createElement("Categoria");
			catTag.setTextContent(a.getCat());
			produtosTag.appendChild(catTag);

			Element nomeTag = doc.createElement("Produto");
			nomeTag.setTextContent(a.getNome());
			produtosTag.appendChild(nomeTag);

			
			//busca a "Marca"
			
			Element marcaTag = doc.createElement("Marca");
			produtosTag.appendChild(marcaTag);

			Element nomemarcaTag = doc.createElement("NomeDaMarca");
			nomemarcaTag.setTextContent(a.getMarca().getNomeMarca());
			marcaTag.appendChild(nomemarcaTag);

			Element precoTag = doc.createElement("Preco");
			precoTag.setTextContent(String.valueOf(a.getMarca().getPreco()));
			marcaTag.appendChild(precoTag);

		}

		//Aplica a formatação na hora de salvar o XML
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();

		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		trans.setOutputProperty("{htpp://xml.apache.org/xslt}indent-amount", "4");

		DOMSource source = new DOMSource(doc);

		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo),"ISO-8859-1")){ 

			StreamResult result = new StreamResult(osw);

			trans.transform(source, result);

		}
	}

	//Mostra os s dados com base no XML
	public static void LerArquivoXML() throws UnsupportedEncodingException, FileNotFoundException, IOException, ParserConfigurationException, SAXException {

		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parse = spf.newSAXParser() ;

		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeDoArquivo),"ISO-8859-1")){

			InputSource source = new InputSource(isr);
			XMLHandlerProd handler = new XMLHandlerProd();
			
			parse.parse(source, handler);

		}
	}
}
