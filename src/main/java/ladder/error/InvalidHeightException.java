package ladder.error;

public class InvalidHeightException extends IllegalArgumentException {

  public InvalidHeightException(String message) {
    super(message);
  }
}
