package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ParticipatesTest {

    @Test
    public void 참여자_이름은_최대_5글까지_부여할_수_있음() {
        assertThatThrownBy(() -> {
            new Participates(List.of("somin", "intellij"));
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 최대 5글자까지 부여할 수 있습니다.");
    }

    @Test
    public void 참여자_목록_생성() {
        Participates participates = new Participates(List.of("somin", "jojo"));
        assertThat(participates.countParticipants()).isEqualTo(2);
    }
}
