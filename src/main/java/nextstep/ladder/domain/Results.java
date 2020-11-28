package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Results {
    public static final String INVALID_SIZE_ERR_MSG = "실행 결과값은 참가자 수와 같아야 합니다.";
    private final List<Result> value;

    private Results(List<String> value, NumberOfParticipants numberOfParticipants) {
        this.value = getResultsValue(value);
        validateSize(numberOfParticipants);
    }

    private List<Result> getResultsValue(List<String> value) {
        return value.stream()
                .map(Result::valueOf)
                .collect(Collectors.toList());
    }

    private void validateSize(NumberOfParticipants numberOfParticipants) {
        if (value.size() != numberOfParticipants.getValue()) {
            throw new IllegalArgumentException(INVALID_SIZE_ERR_MSG);
        }
    }

    public static Results of(NumberOfParticipants numberOfParticipants, List<String> resultsInput) {
        return new Results(resultsInput, numberOfParticipants);
    }

    public static Results of(NumberOfParticipants numberOfParticipants, String... resultsInput) {
        return new Results(Arrays.asList(resultsInput), numberOfParticipants);
    }

    public int size() {
        return value.size();
    }

    public Result get(int index) {
        return value.get(index);
    }

    public void forEach(Consumer<String> consumer) {
        value.forEach(r -> r.accept(consumer));
    }
}
