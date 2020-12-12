package step3_renewal.exception;

public class MinHeightException extends IllegalArgumentException {
    public MinHeightException(int minHeight) {
        super("사다리 다리는 최소 " + minHeight + "부터 입니다.");
    }
}
