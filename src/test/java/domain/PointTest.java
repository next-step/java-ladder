package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void 첫번째_point_생성() {
        assertThat(Point.first().isLeft()).isFalse();
    }

    @Test
    public void 이전_point가_true일때_다음_point는_flase() {
        assertThat(Point.next(true).isRight()).isFalse();
    }

    @Test
    public void point가_true면_false생성() {
        assertThat(Point.generatePoint(true)).isFalse();
    }

    @Test
    public void 마지막_point_생성() {
        assertThat(Point.last(true).isRight()).isFalse();
    }
}
