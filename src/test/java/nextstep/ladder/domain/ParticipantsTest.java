package nextstep.ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ParticipantsTest {

    @ParameterizedTest(name = "참여자의 이름은 비어있거나 5글자보다 길면 안 된다.")
    @ValueSource(strings = {"longer than 5 characters", " ", ""})
    void createParticipants(String invalidName) {
        List<String> names = List.of(invalidName);

        assertThatThrownBy(() -> Participants.createParticipants(names))
                .isInstanceOf(ParticipantNameException.class);
    }
}
