package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("최대 높이만큼 라인을 만듭니다.")
    @Test
    void createLines() {
        Ladder ladder = Ladder.of(5, 3);
        assertThat(ladder.ladderSize()).isEqualTo(5);
    }

    @DisplayName("첫번째 사다리는 항상 거짓입니다.")
    @Test
    void alwaysFalseThatFirstLadder(){
        Ladder ladder = Ladder.of(5, 3);
        ladder.lines().forEach(line -> {
            assertThat(line.line().get(0)).isFalse();
        });
    }

}
