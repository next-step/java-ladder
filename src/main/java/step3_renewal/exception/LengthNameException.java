package step3_renewal.exception;

public class LengthNameException extends IllegalArgumentException {
    public LengthNameException(int maxLength) {
        super("참여할 사람 이름 최대 길이는 " + maxLength + "글자 입니다.");
    }
}
