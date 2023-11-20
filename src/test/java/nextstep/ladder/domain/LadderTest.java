package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("시작점을 기준으로 끝을 알 수 있다")
    void findEndPoint() {
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(Point.first(true), Point.first(true).last())),
                new Line(List.of(Point.first(false), Point.first(false).last()))));

        int actual = ladder.findEndPoint(1);
        int expected = 0;

        assertThat(actual).isEqualTo(expected);
    }
}
