package by.epam.task3.musicalcomposition;

public class Music extends MusicalSound implements Comparable<Music> {

	private String title;
	private String author;
	private Gener gener;

	public Music(int id, double frequency, int duration, String title, String author, Gener gener) {
		super(id, frequency, duration);
		this.title = title;
		this.author = author;
		this.gener = gener;
	}

	public Music() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Gener getGener() {
		return gener;
	}

	public void setGener(Gener gener) {
		this.gener = gener;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((gener == null) ? 0 : gener.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Music other = (Music) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (gener != other.gener) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" title=" + title + ", author=" + author
				+ ", gener=" + gener + super.toString());
		return stringBuilder.toString();
	}

	@Override
	public int compareTo(Music o) {
		int result = this.gener.compareTo(o.gener);
		return result;
	}

}
