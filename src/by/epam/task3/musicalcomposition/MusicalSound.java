package by.epam.task3.musicalcomposition;

public abstract class MusicalSound extends Sound {

	private double duration;

	public MusicalSound(int id, double frequency, double duration) {
		super(id, frequency);
		this.duration = duration;
	}

	public MusicalSound() {
		super();
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = (int) (prime * result + duration);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		MusicalSound other = (MusicalSound) obj;
		if (duration != other.duration) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" duration=" + duration + super.toString());
		return stringBuilder.toString();
	}
}
