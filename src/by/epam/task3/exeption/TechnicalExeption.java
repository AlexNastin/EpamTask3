package by.epam.task3.exeption;

public class TechnicalExeption extends Exception {

	private static final long serialVersionUID = 5485911830849939048L;

	public TechnicalExeption(String message) {
		super(message);

	}

	public TechnicalExeption(String message, Throwable e) {
		super(message, e);
	}

	public TechnicalExeption(Throwable e){
		super(e);
	}

}
