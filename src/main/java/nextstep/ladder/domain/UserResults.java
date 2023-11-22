package nextstep.ladder.domain;

import java.util.List;

import static nextstep.ladder.domain.UserNames.NAME_MAX_LENGTH;

public class UserResults {
    private final List<String> results;

    public UserResults(final String userResultsText, final int userNamesSize) {
        final String[] splitUserResultsTexts = userResultsText.split(",");

        validateUserResults(splitUserResultsTexts, userNamesSize);

        this.results = List.of(splitUserResultsTexts);
    }

    private void validateUserResults(final String[] splitUserResultsTexts, final int userNamesSize) {
        validateUserResultsSize(splitUserResultsTexts, userNamesSize);
        validateUserResultLength(splitUserResultsTexts);
    }

    private void validateUserResultsSize(final String[] splitUserResultsTexts, final int userNamesSize) {
        if (splitUserResultsTexts.length != userNamesSize) {
            throw new IllegalArgumentException("참여 인원수와 동일한 수의 결과를 입력해야 합니다.");
        }
    }

    private void validateUserResultLength(final String[] splitUserResultsTexts) {
        for (final String result : splitUserResultsTexts) {
            throwExceptionIfUserResultLengthIsOverMaxLength(result);
        }
    }

    private void throwExceptionIfUserResultLengthIsOverMaxLength(final String userName) {
        if (userName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("결과는 " + UserNames.NAME_MAX_LENGTH + "글자 이하만 가능합니다.");
        }
    }

    public List<String> results() {
        return this.results;
    }

    public String get(final int arrivalIdx) {
        return this.results.get(arrivalIdx);
    }
}
