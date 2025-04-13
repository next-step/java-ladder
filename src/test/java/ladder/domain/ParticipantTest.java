package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {
    private static final int MAX_LENGTH = 5;

    @Test
    void 정상_생성_테스트() {
        Participant asher = new Participant("asher");
        assertThat(asher).isEqualTo(new Participant("asher"));
    }

    @Test
    void 이름_5자_넘는것_테스트() {
        assertThatThrownBy(() -> new Participant("sangha"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 " + MAX_LENGTH + "자를 초과할 수 없습니다");
    }

    @Test
    void 빈값_테스트() {
        assertThatThrownBy(() -> new Participant(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 비어 있을 수 없습니다.");
    }
}