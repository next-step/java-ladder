package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private RightDirection rightDirection;
    private LineSelector lineSelector;

    @BeforeEach
    void setUp() {
        rightDirection = () -> true;
        lineSelector = (size) -> 1;
    }

    @DisplayName("사다리 게임을 생성한다.")
    @Test
    void create() {
        int height = 5;
        List<String> names = Arrays.asList("boram", "rambo", "luv", "ram");
        LadderGame ladderGame = new LadderGame(names, height, rightDirection,
                lineSelector);
        assertThat(ladderGame.getLadderSize()).isEqualTo(height);
        assertThat(ladderGame.getParticipants().size()).isEqualTo(names.size());
    }
}
