package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {
    @DisplayName("pobi,honux,crong,jk 쉼표(,)로 구분된 사람 이름들 텍스트로 참가자들(Participants)객체를 생성한다. ")
    @ParameterizedTest
    @CsvSource(value = {"pobi,honux,crong,jk/4", "aaa,bbb,ccc/3"}, delimiter = '/')
    void create(String text, int expectedSize) {
        Participants participants = new Participants(text);
        assertThat(participants.size()).isEqualTo(expectedSize);
        assertThat(participants.getParticipantNames()).hasSize(expectedSize);
    }

    @DisplayName("사람에 이름을 최대 5글자까지 부여할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,######,crong", "123,bbbbbb,ccc"})
    void exception(String text) {
        assertThatThrownBy(() -> new Participants(text)).isInstanceOf(IllegalArgumentException.class);
    }
}
