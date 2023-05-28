package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderTest {

    @DisplayName("사다리 게임 결과 테스트")
    @Test
    public void ladderTest() {
        // 테스트 케이스 사다리 모양
//        |-----|     |-----|
//        |     |-----|     |
//        |-----|     |     |
//        |     |-----|     |
//        |-----|     |-----|
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))));
        Assertions.assertThat(ladder.findPositionByIndex(0)).isEqualTo(0);
        Assertions.assertThat(ladder.findPositionByIndex(1)).isEqualTo(3);
        Assertions.assertThat(ladder.findPositionByIndex(2)).isEqualTo(2);
        Assertions.assertThat(ladder.findPositionByIndex(3)).isEqualTo(1);
    }
}
