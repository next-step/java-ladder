package nextstep.ladder.exception;

public class NullParameterException extends IllegalArgumentException {

    private static String NULL_PARAMETER_FORMAT = "%s의 파라미터는 null이 될 수 없습니다.";

    public NullParameterException(Object object) {
        super(String.format(NULL_PARAMETER_FORMAT, object.getClass().getName()));
    }

}
