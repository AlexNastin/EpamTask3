package by.epam.task3.musicalcomposition;

public abstract class Sound {

	private int id;
	private double frequency;

	public Sound(int id, double frequency) {
		this.id = id;
		this.frequency = frequency;
	}

	public Sound() {
	}

	public double getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(frequency);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(id);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Sound other = (Sound) obj;
		if (Double.doubleToLongBits(frequency) != Double
				.doubleToLongBits(other.frequency)) {
			return false;
		}
		if (Double.doubleToLongBits(id) != Double
				.doubleToLongBits(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" id=" + id + ", frequency="
				+ frequency);
		return stringBuilder.toString();
	}
}
