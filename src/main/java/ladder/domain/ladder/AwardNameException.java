package ladder.domain.ladder;

public class AwardNameException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "상금은 1~5자만 가능합니다. 글자 길이 : %d";

    public AwardNameException(int lengthOfName) {
        super(String.format(DEFAULT_MESSAGE, lengthOfName));
    }
}
