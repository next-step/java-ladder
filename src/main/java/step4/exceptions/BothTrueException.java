package step4.exceptions;

public class BothTrueException extends IllegalArgumentException {

    private static final String BOTH_TRUE = "사다리 타기 게임에서 양쪽 모두 가지가 존재할 수는 없습니다.";

    public BothTrueException() {
        super(BOTH_TRUE);
    }
}
