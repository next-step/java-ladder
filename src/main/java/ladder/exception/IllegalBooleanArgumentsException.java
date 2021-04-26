package ladder.exception;

public final class IllegalBooleanArgumentsException extends RuntimeException {

    private final String EXCEPTION_FORMAT_MESSAGE = "(%s, %s)는 알맞은 boolean 타입의 인자값이 아닙니다.";

    private final boolean first;
    private final boolean second;

    public IllegalBooleanArgumentsException(final boolean first, final boolean second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String getMessage() {
        return String.format(EXCEPTION_FORMAT_MESSAGE, first, second);
    }

}
