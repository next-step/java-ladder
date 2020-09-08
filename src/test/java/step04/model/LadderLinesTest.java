package step04.model;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLinesTest {

    @DisplayName("출력 테스트")
    @Test
    void print() {
        // given
        LadderLines ladderLines = LadderLines.of(5, 5, new RandomLadderMakeStrategy());

        // when
        System.out.println(ladderLines.getPrintableString());
    }

    @DisplayName("경로 탐색 테스트")
    @Test
    void getRouteInfo() {
        // given
        LadderLine ladderLine = LadderLine.of(5, (prev) -> Point.BLANK);

        // when
        RouteInfo<Integer> expected = new RouteInfo<>(
                ImmutableMap.of(0, 0,
                        1, 1,
                        2, 2,
                        3, 3,
                        4, 4));

        // then
        assertThat(ladderLine.getRouteInfo()).isEqualTo(expected);
    }
}
