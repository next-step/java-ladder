package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    void 포인트_첫번째_생성_오른쪽으로_이동() {
        assertThat(Point.first(false).move()).isEqualTo(new Position(0));
        assertThat(Point.first(true).move()).isEqualTo(new Position(1));
    }

    @Test
    void 포인트_생성_오른쪽으로_이동() {
        assertThat(Point.first(false).next(true).move()).isEqualTo(new Position(2));
    }

    @Test
    void 포인트_생성_왼쪽으로_이동() {
        assertThat(Point.first(true).next(false).move()).isEqualTo(new Position(0));
    }

    @Test
    void 포인트_생성_아래쪽으로_이동() {
        assertThat(Point.first(false).next(false).move()).isEqualTo(new Position(1));
    }
}
