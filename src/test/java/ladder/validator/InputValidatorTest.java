package ladder.validator;

import ladder.exception.InvalidInputSizeException;
import ladder.model.ExecutionResult;
import ladder.model.ExecutionResults;
import ladder.model.Participant;
import ladder.model.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    @DisplayName("입력 수가 다를 경우, 예외를 반환한다")
    void validateSize() {
        Participants participants = Participants.create(List.of(
                Participant.create("user1"),
                Participant.create("user2")
        ));

        ExecutionResults executionResults = ExecutionResults.create(List.of(ExecutionResult.create("result1")));

        assertThatThrownBy(() -> InputValidator.validate(participants, executionResults))
                .isInstanceOf(InvalidInputSizeException.class);
    }
}