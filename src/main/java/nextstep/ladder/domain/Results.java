package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Results {

    private static final String INVALID_RESULTS_COUNT = "실행 결과 개수는 참여자 수와 같아야 합니다 (플레이어수: %d / 실행 결과 수: %d)";
    private static final String DELIMITER = ",";

    private final List<Result> results;

    public Results(final Players players, final String names) {
        results = Arrays.stream(names.split(DELIMITER))
                .map(Result::new)
                .collect(toList());
        validateResultNamesCount(players);
    }

    private void validateResultNamesCount(final Players players) {
        if (results.size() != players.count()) {
            throw new IllegalArgumentException(String.format(INVALID_RESULTS_COUNT, players.count(), results.size()));
        }
    }

    public List<String> getResultNames() {
        return results.stream()
                .map(Result::getName)
                .collect(toList());
    }

    public String getName(final int position) {
        return results.get(position)
                .getName();
    }

}
