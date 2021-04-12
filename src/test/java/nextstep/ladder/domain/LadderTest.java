package nextstep.ladder.domain;

import nextstep.ladder.domain.generator.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        List<Line> lines = new ArrayList<Line>(){
            {
                add(new Line(4, () -> true));
                add(new Line(4, () -> false));
                add(new Line(4, () -> false));
                add(new Line(4, () -> false));
            }
        };
        ladder = new Ladder(lines);
    }

    @ParameterizedTest
    @DisplayName(value = "사다리 객체 생성")
    @CsvSource(value = {"3:3", "4:4", "5:5"}, delimiter = ':')
    void ladderCreate(int input, int result) {
        assertThat(Ladder.of(2, input)
                .size())
                .isEqualTo(result);
    }

    @Test
    @DisplayName(value = "허용 되지 않은 인자값")
    void ladderArgumentsException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Ladder.of(2, 0);
                }).withMessageMatching("사다리의 최소 높이는 1보다 커야 합니다.");
    }

    @ParameterizedTest
    @DisplayName(value = "사다리 출발 위치의 결과")
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2"}, delimiter = ':')
    void resultPosition(int startPosition, int result) {
        assertThat(ladder.resultPosition(startPosition))
                .isEqualTo(result);
    }
}