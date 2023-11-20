package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.domain.UserNames.NAME_MAX_LENGTH;

public class UserResults {
    private final List<String> results;

    public UserResults(final String userResultsText, final int size) {
        final String[] splitTexts = userResultsText.split(",");
        this.results = Arrays.stream(splitTexts)
                .filter(result -> result.length() <= NAME_MAX_LENGTH)
                .collect(Collectors.toUnmodifiableList());

        if (!isSameSize(splitTexts.length)) {
            throw new IllegalArgumentException("결과는 " + NAME_MAX_LENGTH + "글자 이하만 가능합니다.");
        }

        if (!isSameSize(size)) {
            throw new IllegalArgumentException("참여 인원수와 동일한 수의 결과를 입력해야 합니다.");
        }
    }

    private boolean isSameSize(final int size) {
        return this.results.size() == size;
    }

    public List<String> results() {
        return this.results;
    }

    public String get(final int arrivalIdx) {
        return this.results.get(arrivalIdx);
    }
}
