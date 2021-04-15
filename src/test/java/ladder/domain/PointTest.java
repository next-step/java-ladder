package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {

    @Test
    @DisplayName("인덱스 음수값 입력")
    void create_negativeIndex() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Point(-1, new Direction(false, true)))
                .withMessageMatching("인덱스 값은 최소 0 이어야 합니다.");
    }

    @Test
    @DisplayName("방향정보 미입력")
    void create_directionIsNull() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Point(1, null))
                .withMessageMatching("방향 정보를 입력해 주세요.");
    }

    @Test
    @DisplayName("첫 번째 포인트는 좌측 라인을 가질 수 없음")
    void first_canNotHaveLeftLine() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Point(0, new Direction(true, false)))
                .withMessageMatching("첫 번째 포인트는 좌측 선을 가질 수 없습니다.");
    }

    @Test
    @DisplayName("첫 번째 포인트 생성 테스트 - 정상생성")
    void first() {
        // given when
        Point firstHasLine = Point.first(true);
        Point firstEmpty = Point.first(false);

        // then
        assertThat(firstHasLine.hasRightLine()).isTrue();
        assertThat(firstEmpty.hasRightLine()).isFalse();
    }

    @Test
    @DisplayName("다음 포인트 생성 테스트")
    void next() {
        // given
        Point pointHasRight = new Point(1, new Direction(false, true));
        Point pointHasLeft = new Point(1, new Direction(true, false));
        Point pointEmpty = new Point(1, new Direction(false, false));

        // when
        Point pointHasRight_nextTrue = pointHasRight.next(true);
        Point pointHasLeft_nextTrue = pointHasLeft.next(true);
        Point pointEmpty_nextTrue = pointEmpty.next(true);

        Point pointHasRight_nextFalse = pointHasRight.next(false);
        Point pointHasLeft_nextFalse = pointHasLeft.next(false);
        Point pointEmpty_nextFalse = pointEmpty.next(false);

        // then
        assertThat(pointHasRight_nextTrue.hasRightLine()).isFalse();
        assertThat(pointHasLeft_nextTrue.hasRightLine()).isTrue();
        assertThat(pointEmpty_nextTrue.hasRightLine()).isTrue();

        assertThat(pointHasRight_nextFalse.hasRightLine()).isFalse();
        assertThat(pointHasLeft_nextFalse.hasRightLine()).isFalse();
        assertThat(pointEmpty_nextFalse.hasRightLine()).isFalse();
    }

    @Test
    @DisplayName("마지막 포인트 생성 테스트")
    void last() {
        // given
        Point pointHasRight = new Point(1, new Direction(false, true));
        Point pointHasLeft = new Point(1, new Direction(true, false));
        Point pointEmpty = new Point(1, new Direction(false, false));

        // when
        Point pointHasRight_last = pointHasRight.last();
        Point pointHasLeft_last = pointHasLeft.last();
        Point pointEmpty_last = pointEmpty.last();

        // then
        assertThat(pointHasRight_last.hasRightLine()).isFalse();
        assertThat(pointHasLeft_last.hasRightLine()).isFalse();
        assertThat(pointEmpty_last.hasRightLine()).isFalse();
    }

    @Test
    @DisplayName("포인트 이동 테스트")
    void move() {
        // given
        Point pointHasRight = new Point(1, new Direction(false, true));
        Point pointHasLeft = new Point(1, new Direction(true, false));
        Point pointEmpty = new Point(1, new Direction(false, false));

        // when
        assertThat(2).isEqualTo(pointHasRight.move());
        assertThat(0).isEqualTo(pointHasLeft.move());
        assertThat(1).isEqualTo(pointEmpty.move());
    }
}