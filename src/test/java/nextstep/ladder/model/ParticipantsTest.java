package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("참여자들")
class ParticipantsTest {

    @Test
    @DisplayName("쉼표로 구분된 문자열로 이름들 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Participants.from("a,b,c,d"));
    }

    @ParameterizedTest(name = "[{index}] {0} 값으로 이름들 생성 불가")
    @DisplayName("문자열은 필수")
    @NullAndEmptySource
    void instance_nullOrEmpty_thrownIllegalArgumentException(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> Participants.from(name));
    }

    @Test
    @DisplayName("참여자는 2명 이상")
    void instance_lessThanTwo_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Participants.from("a"));
    }

    @ParameterizedTest(name = "[{index}] {0} 로 이름들을 생성하면 간격의 개수는 {1}")
    @DisplayName("간격 개수")
    @CsvSource(value = {"a,b;1", "a,b,c,d;3"}, delimiter = ';')
    void numberOfGaps(String names, int expected) {
        assertThat(Participants.from(names).numberOfGaps()).isEqualTo(expected);
    }

    @Test
    @DisplayName("주어진 이름 구분해서 반환")
    void list() {
        assertThat(Participants.from("a,b,c").list()).containsExactly(Participant.from("a"), Participant.from("b"), Participant.from("c"));
    }
}
