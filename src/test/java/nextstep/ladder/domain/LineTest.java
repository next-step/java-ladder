package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.exception.LadderLineOverLapException;
import nextstep.ladder.generator.FixedNonProductionGenerator;
import nextstep.ladder.generator.FixedProductionGenerator;
import nextstep.ladder.generator.RandomProductionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LineTest {
    @Test
    @DisplayName("사다리 하나의 라인 객체 생성을 확인한다.")
    void createLadderLine() {
        // given
        int countOfPosition = 3;

        // when
        Line line = new Line(new RandomProductionGenerator(), countOfPosition);

        // then
        assertThat(line.getPositions()).hasSize(countOfPosition);
    }

    @ParameterizedTest(name = "사다리 라인이 비어있는 경우 예외처리를 한다.")
    @NullAndEmptySource
    void exceptionLadderLineNullOrEmpty(List<Boolean> positions) {
        // when & then
        assertThatThrownBy(() -> new Line(positions))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 라인이 겹쳐서 생성된 경우 예외처리를 한다.")
    void exceptionLadderLineOverlap() {
        // given
        List<Boolean> positions = Arrays.asList(false, true, true, true);

        // when & then
        assertThatThrownBy(() -> new Line(positions))
                .isInstanceOf(LadderLineOverLapException.class);
    }

    @Test
    @DisplayName("사다리 라인 생성이 True인 경우, 라인을 만들어준다")
    void checkedLineGeneratorTrueResult() {
        // given
        Line line = new Line(new FixedProductionGenerator(), 2);

        // when
        List<Boolean> positions = line.getPositions();

        // then
        assertThat(positions.get(1)).isTrue();

    }

    @Test
    @DisplayName("사다리 라인 생성이 False인 경우, 라인이 생성되지 않는다")
    void checkedLineGeneratorFalseResult() {
        // given
        Line line = new Line(new FixedNonProductionGenerator(), 2);

        // when
        List<Boolean> positions = line.getPositions();

        // then
        assertThat(positions.get(1)).isFalse();
    }

    @ParameterizedTest(name = "{0}번째 참가자가 연결된 사다리 라인을 탄 결과는 {1}이다")
    @CsvSource({"0,1", "1,0"})
    void checkedConnectedLineRideResult(int index, int expected) {
        // given
        Line line = new Line(new FixedProductionGenerator(), 2);

        // when
        int rideResult = line.ride(index);

        // then
        assertThat(rideResult).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0}번째 참가자가 연결되지 않은 사다리 라인을 탄 결과는 {1}이다")
    @CsvSource({"0,0", "1,1"})
    void checkedNonConnectedLineRideResult(int index, int expected) {
        // given
        Line line = new Line(new FixedNonProductionGenerator(), 2);

        // when
        int rideResult = line.ride(index);

        // then
        assertThat(rideResult).isEqualTo(expected);
    }
}
