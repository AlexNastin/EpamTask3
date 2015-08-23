package by.epam.task3.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.log4j.Logger;

import by.epam.task3.exeption.TechnicalExeption;
import by.epam.task3.musicalcomposition.Gener;
import by.epam.task3.musicalcomposition.Music;

public final class StaxParse {
	private static final Logger LOG = Logger.getLogger(StaxParse.class);

	public static List<Music> parse(File file) {
		List<Music> musicList = null;
		Music music = null;
		String tagContent = null;
		InputStream input = null;
		XMLStreamReader reader = null;
		XMLInputFactory factory = XMLInputFactory.newInstance();

		try {
			input = new FileInputStream(file);
			reader = factory.createXMLStreamReader(input);
		} catch (XMLStreamException | FileNotFoundException e) {
			LOG.warn(new TechnicalExeption(e));
		}
		try {
			while (reader.hasNext()) {
				int event = 0;
				try {
					event = reader.next();
				} catch (XMLStreamException e) {
					LOG.warn(new TechnicalExeption(e));
				}
				switch (event) {
				case XMLStreamConstants.START_ELEMENT:
					if ("music".equals(reader.getLocalName())) {
						music = new Music();

						music.setId(Integer.parseInt(reader
								.getAttributeValue(0).substring(2)));
						String gener = reader.getAttributeValue(1);
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
						default:
							break;
						}
					}
					if ("musicCompositions".equals(reader.getLocalName())) {
						musicList = new ArrayList<>();
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					tagContent = reader.getText().trim();
					break;
				case XMLStreamConstants.END_ELEMENT:
					switch (reader.getLocalName()) {
					case "music":
						musicList.add(music);
						break;
					case "frequency":
						music.setFrequency(Integer.parseInt(tagContent));
						break;
					case "duration":
						music.setDuration((Double.parseDouble(tagContent)));
						break;
					case "title":
						music.setTitle(tagContent);
						break;
					case "author":
						music.setAuthor(tagContent);
						break;
					}
					break;
				case XMLStreamConstants.START_DOCUMENT:
					musicList = new ArrayList<>();
					break;
				}
			}
		} catch (NumberFormatException | XMLStreamException e) {
			LOG.warn(new TechnicalExeption(e));
		}
		return musicList;
	}
}
