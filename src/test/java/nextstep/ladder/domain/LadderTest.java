package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {

    @DisplayName("2명이면 선은 1개, 선은 그리는 것으로 하기")
    @Test
    void 전략패턴_검증() {
        List<Boolean> lines = Arrays.asList(true);
        Ladder ladder = new Ladder(lines);

        assertAll(
                () -> assertThat(ladder.getLines()).hasSize(1),
                () -> assertThat(ladder.getLines().get(0)).isTrue()
        );
    }

    @DisplayName("현재 index로 가야될 index 값 반환")
    @Test
    void search_position() {
        // 0      1      2     3     4      5      6
        //   true, false, false, true, false, false
        List<Boolean> lines = Arrays.asList(true, false, false, true, false, false);
        Ladder ladder = new Ladder(lines);
        assertAll(
                () -> assertThat(ladder.search(0)).isEqualTo(1)
                , () -> assertThat(ladder.search(1)).isEqualTo(0)
                , () -> assertThat(ladder.search(2)).isEqualTo(2)
                , () -> assertThat(ladder.search(3)).isEqualTo(4)
                , () -> assertThat(ladder.search(4)).isEqualTo(3)
                , () -> assertThat(ladder.search(5)).isEqualTo(5)
                , () -> assertThat(ladder.search(6)).isEqualTo(6)
        );
    }
}
