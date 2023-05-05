package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk", "pobi, honux, crong, jk"})
    @DisplayName("참가자 객체 생성 테스트")
    void createParticipantsTest(String inputNames) {
        String[] splitNames = inputNames.split(",");
        List<String> names = List.of(splitNames);
        Participants participants = Participants.from(names);

        assertThat(participants.countOfParticipants())
                .isEqualTo(4);
    }

}
