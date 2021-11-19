package nextstep.ladder.domain;

import nextstep.ladder.doamin.Ladder;
import nextstep.ladder.doamin.Line;
import nextstep.ladder.doamin.value.Location;
import nextstep.ladder.doamin.value.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderTest {

    private List<Line> lines;

    /**
     * 0     1     2     3
     * |     |-----|     |
     * |-----|     |-----|
     * |     |     |-----|
     * |-----|     |     |
     * 0     1     2     3
     */
    @BeforeEach
    void setup() {
        lines = Arrays.asList(
                Line.from(Arrays.asList(Point.from(false), Point.from(false), Point.from(true), Point.from(false))),
                Line.from(Arrays.asList(Point.from(false), Point.from(true), Point.from(false), Point.from(true))),
                Line.from(Arrays.asList(Point.from(false), Point.from(false), Point.from(false), Point.from(true))),
                Line.from(Arrays.asList(Point.from(false), Point.from(true), Point.from(false), Point.from(false))));
    }

    @Test
    @DisplayName("사다리 정상 생성 검증")
    void create() {
        assertDoesNotThrow(
                () -> Ladder.from(lines));
    }

    @Test
    @DisplayName("라인 정보가 빈값이거나 null인 경우 예외 발생 검증")
    void create_exception() {
        assertAll(() -> {
            assertThatIllegalArgumentException().isThrownBy(() -> Ladder.from(Collections.emptyList()));
            assertThatIllegalArgumentException().isThrownBy(() -> Ladder.from(null));
        });
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0      |0",
            "1      |2",
            "2      |1",
            "3      |3"
    }, delimiter = '|')
    @DisplayName("사다리 결과값 검증")
    void getLadderResult(Integer currentLocation, Integer lastLocation) {
        Ladder ladder = Ladder.from(lines);
        Location result = ladder.getLadderResult(Location.from(currentLocation));
        assertThat(result).isEqualTo(Location.from(lastLocation));
    }
}
