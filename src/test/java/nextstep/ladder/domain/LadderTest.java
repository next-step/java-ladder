package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("기본 생성자 동작 확인")
    void create() {
        String[] participants = {"p1", "p2", "p3"};
        assertThat(new Ladder(5, participants)).isInstanceOf(Ladder.class);
    }

    @Test
    @DisplayName("참여자 이름 저장/Get 기능 확인")
    void names_test() {
        String[] participants = {"p1", "p2", "p3"};
        assertThat(new Ladder(5, participants).getNames()).isEqualTo(participants);
    }

    @Test
    @DisplayName("사다리에 대한 유효성 검사, 높이만큼 & 참여자에 맞게 생성되었는지 확인")
    void line_test() {
        String[] participants = {"p1", "p2", "p3"};
        Ladder ladder = new Ladder(5, participants);
        assertThat(ladder.getLines().size()).isEqualTo(5);
        ladder.getLines().forEach(line -> {
            assertThat(line.getBridgeStatus().size()).isEqualTo(participants.length - 1);
        });
    }
}
