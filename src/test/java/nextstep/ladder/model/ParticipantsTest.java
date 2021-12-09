package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    @ParameterizedTest
    @DisplayName("참석자 이름 입력했을 때 생성하는 검증 로직")
    @CsvSource(value = {"lee,kim,oh:3", "lee,kim:2"}, delimiter = ':')
    void createTest(String inputData, int sizeResult) {
        Participants participants = Participants.from(inputData);

        assertThat(participants.size()).isEqualTo(sizeResult);
    }
}
