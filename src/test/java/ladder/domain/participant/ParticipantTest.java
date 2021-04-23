package ladder.domain.participant;

import ladder.exception.InvalidIdentifierNameException;
import ladder.exception.InvalidNameSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    @DisplayName("Participant 인스턴스 생성 테스트")
    @Test
    void 생성() {
        // given
        String name = "wojir";

        // when
        Participant participant = Participant.of(name);

        // then
        assertThat(participant).isNotNull();
    }

    @DisplayName("Participant 인스턴스가 5글자 초과의 값 주입시 예외처리 여부 테스트")
    @Test
    void 검증_5글자_초과() {
        // given
        String name = "woojae";

        // when and then
        assertThatThrownBy(() -> Participant.of(name))
                .isInstanceOf(InvalidNameSizeException.class)
                .hasMessage("(woojae)와 같이 5글자가 초과된 이름은 사용할 수 없습니다.");
    }

    @DisplayName("Participant 인스턴스가 특정 명령어 주입시 예외처리 여부 테스트")
    @Test
    void 검증_특정_명령어() {
        // given
        String name = "all";

        // when and then
        assertThatThrownBy(() -> Participant.of(name))
                .isInstanceOf(InvalidIdentifierNameException.class)
                .hasMessage("(all)과 같은 특정 명령어는 이름으로 사용할 수 없습니다.");
    }

    @DisplayName("Participant 인스턴스가 이름을 반환하는지 테스트")
    @Test
    void 반환_이름() {
        // given
        String expected = "wojir";

        // when and then
        Participant participant = Participant.of(expected);
        String actual = participant.name();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Participant 인스턴스가 동일한 이름을 같다고 비교하는지 테스트")
    @Test
    void 비교_동일한_이름() {
        // given
        String name = "wojir";

        // when and then
        Participant actual = Participant.of(name);
        Participant expected = Participant.of(name);

        assertThat(actual).isEqualTo(expected);
    }
}