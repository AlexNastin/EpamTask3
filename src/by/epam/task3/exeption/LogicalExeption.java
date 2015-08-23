package by.epam.task3.exeption;

public class LogicalExeption extends Exception {

	private static final long serialVersionUID = -8753409650925685212L;

	public LogicalExeption(String message) {
		super(message);

	}

	public LogicalExeption(String message, Throwable e) {
		super(message, e);
	}

	public LogicalExeption(Throwable e) {
		super(e);
	}

}
