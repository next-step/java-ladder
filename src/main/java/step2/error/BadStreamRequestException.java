package step2.error;

public class BadStreamRequestException extends RuntimeException {
  public static final String DEFAULT_MESSAGE = "잘못된 스트림 요청입니다.";

  public BadStreamRequestException() {
    super(DEFAULT_MESSAGE);
  }

  public BadStreamRequestException(String message) {
    super(message);
  }
}
