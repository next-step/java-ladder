package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.exception.LadderLineOverLapException;
import nextstep.ladder.generator.RandomProductionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
    void exceptionLadderLineNullOrEmpty(List<Position> positions) {
        // when & then
        assertThatThrownBy(() -> new Line(positions))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 라인이 겹쳐서 생성된 경우 예외처리를 한다.")
    void exceptionLadderLineOverlap() {
        // given
        List<Position> positions = Arrays.asList(new Position(false), new Position(true), new Position(true),
                new Position(true));

        // when & then
        assertThatThrownBy(() -> new Line(positions))
                .isInstanceOf(LadderLineOverLapException.class);
    }
}