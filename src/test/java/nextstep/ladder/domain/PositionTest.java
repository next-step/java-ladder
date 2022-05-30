package nextstep.ladder.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import nextstep.ladder.generator.FixedNonProductionGenerator;
import nextstep.ladder.generator.FixedProductionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {
    @Test
    @DisplayName("위치에 대한 객체 생성을 확인한다")
    void checkedPositionGenerate() {
        // given
        boolean right = true;

        // when
        Position position = Position.first(right);

        // then
        assertAll(
                () -> assertThat(position.isLeft()).isFalse(),
                () -> assertThat(position.isRight()).isTrue()
        );
    }

    @Test
    @DisplayName("다음 위치에서 라인이 생성됨을 확인한다")
    void checkedNextPositionFixedGenerate() {
        // given
        Position position = Position.first(false);

        // when
        Position nextPosition = position.next(new FixedProductionGenerator());

        // then
        assertAll(
                () -> assertThat(nextPosition.isLeft()).isFalse(),
                () -> assertThat(nextPosition.isRight()).isTrue()
        );
    }

    @Test
    @DisplayName("다음 위치에서 라인이 생성되지 않음을 확인한다")
    void checkedNextPositionFixedNonGenerate() {
        // given
        Position position = Position.first(false);

        // when
        Position nextPosition = position.next(new FixedNonProductionGenerator());

        // then
        assertAll(
                () -> assertThat(nextPosition.isLeft()).isFalse(),
                () -> assertThat(nextPosition.isRight()).isFalse()
        );
    }

    @Test
    @DisplayName("마지막 위치의 사다리를 생성한다")
    void checkedLastPositionGenerate() {
        // given
        Position position = Position.first(true);

        // when
        Position nextPosition = position.last();

        // then
        assertAll(
                () -> assertThat(nextPosition.isLeft()).isTrue(),
                () -> assertThat(nextPosition.isRight()).isFalse()
        );
    }

    @Test
    @DisplayName("이동하지 않고 해당 사다리의 다리를 타고 내려가는 경우를 확인한다")
    void checkedRideStay() {
        // given
        Position second = Position.first(FALSE).next(FALSE);

        // when
        int position = second.ride();

        // then
        assertThat(position).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽으로 이동하는 경우를 확인한다")
    void checkedRideLeft() {
        // given
        Position second = Position.first(TRUE).next(FALSE);

        // when
        int position = second.ride();

        // then
        assertThat(position).isEqualTo(0);
    }

    @Test
    @DisplayName("오른쪽으로 이동하는 경우를 확인한다")
    void checkedRideRight() {
        // given
        Position second = Position.first(FALSE).next(new FixedProductionGenerator());

        // when
        int position = second.ride();

        // then
        assertThat(position).isEqualTo(2);
    }
}