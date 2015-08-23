package by.epam.task3.parse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import by.epam.task3.musicalcomposition.Music;

public final class ManaderParse {

	public static List<Music> parse(String nameParse, File fileName) {
		List<Music> musicList = new ArrayList<Music>();

		switch (nameParse) {
		case "DOM":
			musicList = DomParse.parse(fileName);
			break;
		case "SAX":
			musicList = SaxParse.parse(fileName);
			break;
		case "StAX":
			musicList = StaxParse.parse(fileName);
			break;
		}
		return musicList;

	}

}
