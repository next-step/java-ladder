package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder = new Ladder(5, 5);
    @Test
    public void 사용자수에_맞춰_사다리를_초기화한다() {
        assertThat(ladder.getPoints()).hasSize(25);
    }

    @Test
    public void 포인트를_하나라도_가진_라인을_반환한다() {
        ladder.getLines().add(new Line(Point.of(1, 1), Point.of(2, 1)));
        ladder.getLines().add(new Line(Point.of(3, 1), Point.of(4, 1)));
        assertThat(ladder.lineExist(Point.of(1, 1))).isTrue();
    }

    @Test
    public void 조건에_부합하면_라인을_추가한다() {
        ladder.createLine(Point.of(1, 1));
        assertThat(ladder.getLines()).contains(new Line(Point.of(1, 1), Point.of(2, 1)));
    }

    @Test
    public void 포인트가_범위를_넘어가면_무시된다() {
        ladder.createLine(Point.of(5, 1));
        assertThat(ladder.getLines()).doesNotContain(new Line(Point.of(5, 1), Point.of(6, 1)));
    }

    @Test
    public void 모든_포인트를_돌며_라인을_추가한다() {
        ladder.init();
        assertThat(ladder.getLines()).hasSize(10);
    }

    @Test
    public void 포인트가_다음_포인트로_이동한다() {
        ladder.createLine(Point.of(1, 1));
        assertThat(ladder.nextPoint(Point.of(1, 1))).isEqualTo(Point.of(2, 2));
    }
}
