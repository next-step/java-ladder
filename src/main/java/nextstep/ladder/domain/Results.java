package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Results {
    public static final String INVALID_SIZE_ERR_MSG = "실행 결과값은 참가자 수와 같아야 합니다.";
    private final List<String> value;

    private Results(List<String> value, Participants participants) {
        this.value = value;
        validateSize(participants);
    }

    private void validateSize(Participants participants) {
        NumberOfParticipants numberOfParticipants = participants.getNumberOfParticipants();
        if (value.size() != numberOfParticipants.getValue()) {
            throw new IllegalArgumentException(INVALID_SIZE_ERR_MSG);
        }
    }

    public static Results of(Participants participants, List<String> executionResultInput) {
        return new Results(executionResultInput, participants);
    }

    public static Results of(Participants participants, String... executionResultInput) {
        return new Results(Arrays.asList(executionResultInput), participants);
    }

    public int size() {
        return value.size();
    }

    public String get(int index) {
        return value.get(index);
    }

    public void forEach(Consumer<String> consumer) {
        value.forEach(consumer);
    }
}
