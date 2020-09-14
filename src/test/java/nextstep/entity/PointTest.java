package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.BDDAssertions.then;

class PointTest {

    @ParameterizedTest
    @DisplayName("좌측 페달 여부 확인")
    @CsvSource(value = {"true,false,true", "false,true,false"})
    void hasLeftPedal(boolean leftPedal, boolean rightPedal, boolean expected) {
        then(Point.of(0, leftPedal, rightPedal).hasLeftPedal()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("우측 페달 여부 확인")
    @CsvSource(value = {"true,false,false", "false,true,true"})
    void hasRightPedal(boolean leftPedal, boolean rightPedal, boolean expected) {
        then(Point.of(0, leftPedal, rightPedal).hasRightPedal()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "true,false,1,0",
            "false,false,1,1",
            "false,true,1,2"
    })
    void play(boolean leftPedal, boolean rightPedal, int index, int expected) {
        Point point = Point.of(index, leftPedal, rightPedal);
        then(point.play()).isEqualTo(expected);
    }

    @Test
    @DisplayName("인스턴스 생성 메소드 검증")
    void next() {
        Point point = Point.of(0, false, true);
        then(point.next(true).hasLeftPedal()).isTrue();
        then(point.next(true).hasRightPedal()).isFalse();
    }

    @Test
    @DisplayName("시작 페달 생성 메소드 검증")
    void getStartPoint() {
        Point point = Point.getStartPoint(true);
        then(point.hasLeftPedal()).isFalse();
        then(point.hasRightPedal()).isTrue();
    }

    @Test
    @DisplayName("마지막 페달 생성 메소드 검증")
    void getLastPoint() {
        Point point = Point.of(0, false, true).getLastPoint();
        then(point.hasLeftPedal()).isTrue();
        then(point.hasRightPedal()).isFalse();
    }

    @Test
    @DisplayName("단일 페달 생성 메소드 검증")
    void getSinglePoint() {
        Point point = Point.getSinglePoint();
        then(point.hasLeftPedal()).isFalse();
        then(point.hasRightPedal()).isFalse();
    }

    @Test
    @DisplayName("인스턴스 생성 메소드 예외처리 검증")
    void of() {
        assertThatThrownBy(() -> Point.of(0, true, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌측과 우측 모두 페달을 생성할 수 없습니다.");
    }
}
