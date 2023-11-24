package nextstep.step4.responsibility.domain;

import java.util.List;

public class UserResults implements UserInputProvider {
    public static final int MIN_SIZE = 2;
    public static final int MAX_RESULT_LENGTH = 5;
    private final List<String> results;

    public UserResults(final String resultTexts) {
        final String[] results = resultTexts.split(",");

        validateUserResults(results);

        this.results = List.of(results);
    }

    private void validateUserResults(final String[] results) {
        if (results.length < MIN_SIZE) {
            throw new IllegalArgumentException("결과는 " + MIN_SIZE + "개 이상이어야 합니다.");
        }

        for (final String result : results) {
            throwExceptionIfUserResultLengthIsOverMaxLength(result);
        }
    }

    private void throwExceptionIfUserResultLengthIsOverMaxLength(final String userResult) {
        if (userResult.length() > MAX_RESULT_LENGTH) {
            throw new IllegalArgumentException("결과는 " + MAX_RESULT_LENGTH + "글자 이하만 가능합니다.");
        }
    }

    @Override
    public String get(final int index) {
        return this.results.get(index);
    }

    @Override
    public int size() {
        return this.results.size();
    }
}
