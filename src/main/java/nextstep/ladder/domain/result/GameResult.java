package nextstep.ladder.domain.result;

import nextstep.ladder.utils.StringUtils;

public class GameResult {
    private static final int MAX_LENGTH_OF_RESULT = 5;

    private final String result;

    private GameResult(String result) {
        validate(result);

        this.result = result;
    }

    private void validate(String result) {
        if (StringUtils.isEmpty(result)) {
            throw new IllegalArgumentException("result는 null이거나 비어있을수 없습니다.");
        }

        if (result.length() > MAX_LENGTH_OF_RESULT) {
            throw new IllegalArgumentException("결가값은 최대 " + MAX_LENGTH_OF_RESULT + " 입니다.");
        }
    }

    public static GameResult of(String result) {
        return new GameResult(result);
    }

    public String result() {
        return result;
    }

}
