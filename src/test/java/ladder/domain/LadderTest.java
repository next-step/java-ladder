package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    int lineQuantity = 5;
    int lineHeight = 3;
    Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(lineQuantity, lineHeight);
    }

    @Test
    @DisplayName("주어진 lineQuantity 만큼 level 마다 라인이 생긴다")
    void constructor() {
        Lines lines = ladder.linesByLevel(0);

        assertThat(lines.size()).isEqualTo(lineQuantity);
    }

    @Test
    @DisplayName("주어진 height 만큼 level 이 생긴다")
    void constructor2() {
        assertThat(ladder.height()).isEqualTo(lineHeight);
    }

    @Test
    @DisplayName("List<Lines> 로부터 Ladder 를 생성한다")
    void of() {
        List<Lines> linesList = new ArrayList<>();
        linesList.add(Lines.of(() -> Arrays.asList(false, true, false, true)));

        ladder = Ladder.of(linesList);
        Line trueLine = Line.of(true);
        Line falseLine = Line.of(false);

        assertThat(ladder.linesByLevel(0).getLines()).containsExactly(falseLine, trueLine, falseLine, trueLine);
    }
}
