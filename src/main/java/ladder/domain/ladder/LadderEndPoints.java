package ladder.domain.ladder;

import static ladder.util.StringUtil.splitByComma;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import ladder.domain.user.Users;

public class LadderEndPoints {

    private static final String INVALID_RESULTS_COUNT_ERROR_MESSAGE = "사람 수와 동일한 수의 결과가 입력되어야 한다.";

    private final List<String> endPoints;

    public LadderEndPoints(List<String> endPoints) {
        this.endPoints = endPoints;
    }

    public static LadderEndPoints from(String input, Users users) {
        checkResultsCount(input, users);

        return new LadderEndPoints(Arrays.stream(splitByComma(input))
            .collect(Collectors.toList()));
    }

    private static void checkResultsCount(String input, Users users) {
        if (splitByComma(input).length != users.userCount()) {
            throw new IllegalArgumentException(INVALID_RESULTS_COUNT_ERROR_MESSAGE);
        }
    }

    public String getByPosition(int position) {
        return endPoints.get(position);
    }

    public List<String> value() {
        return Collections.unmodifiableList(endPoints);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderEndPoints that = (LadderEndPoints) o;
        return Objects.equals(endPoints, that.endPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endPoints);
    }

}
