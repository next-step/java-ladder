package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.LineFactory;
import nextstep.ladder.model.RandomLineGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    private LineFactory lineFactory;

    @BeforeEach
    void setting(){
        lineFactory = LineFactory.from(RandomLineGenerator.getInstance(), 3);
    }


    @DisplayName("최대 높이만큼 라인을 만듭니다.")
    @Test
    void createLines() {
        Ladder ladder = Ladder.of(5, lineFactory);
        assertThat(ladder.ladderSize()).isEqualTo(5);
    }

    @DisplayName("첫번째 사다리는 항상 거짓입니다.")
    @Test
    void alwaysFalseThatFirstLadder(){
        Ladder ladder = Ladder.of(5, lineFactory);
        ladder.lines().forEach(line -> {
            assertThat(line.line().findFirst().get().canMove()).isFalse();
        });
    }

}
