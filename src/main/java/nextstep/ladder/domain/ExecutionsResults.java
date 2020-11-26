package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExecutionsResults {
    public static final String INVALID_SIZE_ERR_MSG = "실행 결과값은 참가자 수와 같아야 합니다.";
    private final List<String> executionResults;

    private ExecutionsResults(List<String> executionResults, Participants participants) {
        this.executionResults = executionResults;
        validateSize(participants);
    }

    private void validateSize(Participants participants) {
        if (executionResults.size() != participants.getNumberOfParticipants().getValue()) {
            throw new IllegalArgumentException(INVALID_SIZE_ERR_MSG);
        }
    }

    public static ExecutionsResults of(Participants participants, List<String> executionResultInput) {
        return new ExecutionsResults(executionResultInput, participants);
    }

    public static ExecutionsResults of(Participants participants, String... executionResultInput) {
        return new ExecutionsResults(Arrays.asList(executionResultInput), participants);
    }

    public int size() {
        return executionResults.size();
    }

    public String get(int i) {
        return executionResults.get(i);
    }

    public void forEach(Consumer<String> consumer) {
        executionResults.forEach(consumer);
    }
}
