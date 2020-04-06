package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private Ladder ladder;
    private List<String> names;
    private List<String> prizes;
    private int height;

    @BeforeEach
    void setUp() {
        LineSelector lineSelector = (size) -> 1;
        RightDirection rightDirection = () -> true;
        ladder = Ladder.valueOf(new LadderSize(4, 5), lineSelector,
                rightDirection);

        names = Arrays.asList("boram", "rambo", "luv", "ram");
        prizes = Arrays.asList("꽝", "5000", "꽝", "3000");
        height = 5;
    }

    @DisplayName("사다리 게임을 생성한다.")
    @Test
    void create() {
        LadderGame ladderGame = LadderGame.valueOf(names, prizes, ladder);
        assertThat(ladderGame.getLadderSize()).isEqualTo(height);
        assertThat(ladderGame.getParticipantNames().size()).isEqualTo(names.size());
    }

    @DisplayName("사다리 결과를 가져온다.")
    @Test
    void getResult() {
        LadderGame ladderGame = LadderGame.valueOf(names, prizes, ladder);
        assertThat(ladderGame.prize("boram").getName()).isEqualTo("꽝");
    }
}
