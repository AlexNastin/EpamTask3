package by.epam.task3.main;

import java.io.File;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import by.epam.task3.musicalcomposition.Music;
import by.epam.task3.parse.ManaderParse;

public class Main {
	static {
		new DOMConfigurator().doConfigure("log4j.xml",
				LogManager.getLoggerRepository());
	}

	public static void main(String[] args) {

		final Logger LOG = Logger.getLogger(Main.class);

		File file = new File("C:/Java/workspace/EpamTask3AlexNastin/Musics.xml");

		
		
		
		List<Music> list = ManaderParse.parse("DOM", file);
		for (Music m : list) {
			LOG.warn(m);
		}
		List<Music> list3 = ManaderParse.parse("SAX", file);
		for (Music g : list3) {
			LOG.warn(g);
		}
		List<Music> list2 = ManaderParse.parse("StAX", file);
		for (Music d : list2) {
			LOG.warn(d);
		}

	}
}
