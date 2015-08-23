package by.epam.task3.parse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.epam.task3.exeption.TechnicalExeption;
import by.epam.task3.musicalcomposition.Gener;
import by.epam.task3.musicalcomposition.Music;

public final class DomParse {

	private static final Logger LOG = Logger.getLogger(DomParse.class);

	public static List<Music> parse(File file) {

		List<Music> listMusic = new ArrayList<Music>();

		Music music = null;

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse(file);
			document.getDocumentElement().normalize();

			NodeList nodeList = document.getElementsByTagName("music");

			for (int i = 0; i < nodeList.getLength(); i++) {

				Node node = nodeList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					music = new Music();
					music.setId(Integer.parseInt(element.getAttribute("id")
							.substring(2)));
					switch (element.getAttribute("gener")) {
					case "FOLK":
						music.setGener(Gener.FOLK);
						break;
					case "POP":
						music.setGener(Gener.POP);
						break;
					case "ROCK":
						music.setGener(Gener.ROCK);
						break;
					case "RNB":
						music.setGener(Gener.RNB);
						break;
					case "JAZZ":
						music.setGener(Gener.JAZZ);
						break;
					}
					music.setFrequency(Integer.parseInt(element
							.getElementsByTagName("frequency").item(0)
							.getTextContent()));
					music.setDuration(Double.parseDouble(element
							.getElementsByTagName("duration").item(0)
							.getTextContent()));
					music.setTitle(element.getElementsByTagName("title")
							.item(0).getTextContent());
					music.setAuthor(element.getElementsByTagName("author")
							.item(0).getTextContent());
					listMusic.add(music);
				}

			}

		} catch (SAXException | IOException | ParserConfigurationException e) {
			LOG.warn(new TechnicalExeption(e));
		}
		return listMusic;
	}

}
