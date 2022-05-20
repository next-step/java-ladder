package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {
    @Test
    @DisplayName("Participant 객체를 생성한다.")
    void Participant_참가자_생성() {
        assertThat(new Participant("wu2ee")).isNotNull().isInstanceOf(Participant.class);
    }

    @ParameterizedTest
    @DisplayName("이름 길이가 5자를 초과하는 경우 예외가 발생한다.")
    @ValueSource(strings = {"wu2eee", "wu2eeeeeeee"})
    void Participant_이름_길이_5자_초과(String name) {
        assertThatThrownBy(() -> new Participant(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사람 이름이 null 또는 비어있는 경우, 예외가 발생한다.")
    void Participant_사람이름_null(String name) {
        assertThatThrownBy(() -> new Participant(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "wu2ee, 5",
            "pobi, 4",
            "mbc, 3"
    })
    @DisplayName("이름의 길이를 정상적으로 반환한다.")
    void length_이름_길이(String name, int length) {
        assertThat(new Participant(name).nameLength()).isEqualTo(length);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "wu2ee,pobi,false",
            "wu2ee,wu2ee,true",
            "wu2ee,Wu2Ee,true"
    })
    void isParticipant(String expectedName, String actualName, boolean trueOrFalse) {
        assertThat(new Participant(actualName).isParticipant(expectedName)).isEqualTo(trueOrFalse);
    }
}