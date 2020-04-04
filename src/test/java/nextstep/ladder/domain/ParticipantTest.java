package nextstep.ladder.domain;

import nextstep.ladder.domain.exception.IllegalMaxLengthValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParticipantTest {
    @DisplayName("생성하고 이름을 얻을 수 있다.")
    @Test
    void createAndGet() {
        String name = "김보람보람";
        Participant participant = new Participant(name);
        assertThat(participant.getName()).isEqualTo(name);
    }

    @DisplayName("최대 길이가 넘는 이름을 입력하면 에러발생")
    @Test
    void maxLengthError() {
        assertThatExceptionOfType(IllegalMaxLengthValueException.class)
                .isThrownBy(() -> new Participant("김보람보람보"));
    }

}
