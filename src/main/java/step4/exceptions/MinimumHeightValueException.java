package step4.exceptions;

public class MinimumHeightValueException extends IllegalArgumentException {

    private static final String HEIGHT_VALUE = "height의 최소값은 1입니다.";

    public MinimumHeightValueException() {
        super(HEIGHT_VALUE);
    }
}
