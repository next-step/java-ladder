package step2.error;

public class InvalidNameException extends IllegalArgumentException {
  public InvalidNameException(String message) {
    super(message);
  }
}
