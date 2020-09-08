package step04.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @DisplayName("사다리 생성 테스트")
    @RepeatedTest(10)
    void create() {
        // given
        LadderLine ladderLine = LadderLine.of(5, new RandomLadderMakeStrategy());

        // then
        System.out.print(ladderLine.getPrintableLadderLine());
    }

    @DisplayName("경로 탐색 테스트")
    @Test
    void getRouteInfo() {
        // given
        LadderLine ladderLine = LadderLine.of(5, (prev) -> Point.BLANK);

        // when
        RouteInfo<Integer> expected = new RouteInfo<>(new HashMap<>());

        // then
        assertThat(ladderLine.getRouteInfo()).isEqualTo(expected);
    }
}
