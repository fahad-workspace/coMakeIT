package co.make.it;

public class NonUniqueException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NonUniqueException(String str) {
		super(str);
	}
}
