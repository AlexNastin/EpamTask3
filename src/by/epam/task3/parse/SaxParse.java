package by.epam.task3.parse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.task3.exeption.TechnicalExeption;
import by.epam.task3.musicalcomposition.Gener;
import by.epam.task3.musicalcomposition.Music;

public final class SaxParse extends DefaultHandler {

	private static final Logger LOG = Logger.getLogger(SaxParse.class);

	private static List<Music> list = null;
	private Music music = null;

	public static List<Music> parse(File file) {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = parserFactory.newSAXParser();
			SaxParse parse = new SaxParse();
			saxParser.parse(file, parse);

		} catch (IOException | SAXException | ParserConfigurationException e) {
			LOG.warn(new TechnicalExeption(e));
		}
		return list;

	}

	private boolean bTitle = false;
	private boolean bAuthor = false;
	private boolean bFrequency = false;
	private boolean bDuration = false;

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("music")) {
			String id = attributes.getValue("id");
			String gener = attributes.getValue("gener");
			music = new Music();
			music.setId(Integer.parseInt(id.substring(2)));
			switch (gener) {
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
			if (list == null) {
				list = new ArrayList<Music>();
			}
		} else if (qName.equalsIgnoreCase("title")) {
			bTitle = true;
		} else if (qName.equalsIgnoreCase("author")) {
			bAuthor = true;
		} else if (qName.equalsIgnoreCase("frequency")) {
			bFrequency = true;
		} else if (qName.equalsIgnoreCase("duration")) {
			bDuration = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equalsIgnoreCase("music")) {
			list.add(music);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (bTitle) {
			music.setTitle(new String(ch, start, length));
			bTitle = false;
		} else if (bAuthor) {
			music.setAuthor(new String(ch, start, length));
			bAuthor = false;
		} else if (bFrequency) {
			music.setFrequency(Integer.parseInt(new String(ch, start, length)));
			bFrequency = false;
		} else if (bDuration) {
			music.setDuration(Double.parseDouble(new String(ch, start, length)));
			bDuration = false;
		}
	}

}
