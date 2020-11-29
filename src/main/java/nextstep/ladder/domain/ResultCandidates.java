package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ResultCandidates {
    public static final String INVALID_SIZE_ERR_MSG = "실행 결과값은 참가자 수와 같아야 합니다.";
    private final List<ResultCandidate> value;

    private ResultCandidates(List<String> value, NumberOfParticipants numberOfParticipants) {
        this.value = getResultsValue(value);
        validateSize(numberOfParticipants);
    }

    private List<ResultCandidate> getResultsValue(List<String> value) {
        return value.stream()
                .map(ResultCandidate::valueOf)
                .collect(Collectors.toList());
    }

    private void validateSize(NumberOfParticipants numberOfParticipants) {
        if (value.size() != numberOfParticipants.getValue()) {
            throw new IllegalArgumentException(INVALID_SIZE_ERR_MSG);
        }
    }

    public static ResultCandidates of(NumberOfParticipants numberOfParticipants, List<String> resultsInput) {
        return new ResultCandidates(resultsInput, numberOfParticipants);
    }

    public static ResultCandidates of(NumberOfParticipants numberOfParticipants, String... resultsInput) {
        return new ResultCandidates(Arrays.asList(resultsInput), numberOfParticipants);
    }

    public int size() {
        return value.size();
    }

    public ResultCandidate get(int index) {
        return value.get(index);
    }

    public void forEach(Consumer<String> consumer) {
        value.forEach(r -> r.accept(consumer));
    }
}
