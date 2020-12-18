package step3_renewal.exception;

public class MinimumNumberOfPersonException extends IllegalArgumentException {
    public MinimumNumberOfPersonException(final int minNumber) {
        super("참여하는 사람은 최소 " + minNumber + "명입니다.");
    }
}
