package ladder.domain;

import ladder.domain.Ladder;
import ladder.domain.LadderLine;
import ladder.domain.Rope;
import ladder.exception.InvalidRopeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @DisplayName("사다리 정상 생성")
    @Test
    void ctorTest() {
        LadderLine line = new LadderLine(
                Stream.of(true, false, true)
                        .map(Rope::of)
                        .collect(Collectors.toList())
        );

        assertThatCode(() ->
                new Ladder(
                        Arrays.asList(line, line, line, line)
                )
        ).doesNotThrowAnyException();
    }

    @DisplayName("사다리의 로프 갯수가 다를 경우 오류")
    @Test
    void validateRopeSizeOfLadderLineTest() {
        LadderLine threeRopeLine = new LadderLine(
                Stream.of(true, false, true)
                        .map(Rope::of)
                        .collect(Collectors.toList())
        );
        LadderLine fourRopeLine = new LadderLine(
                Stream.of(true, false, true, false)
                        .map(Rope::of)
                        .collect(Collectors.toList())
        );

        assertThatThrownBy(() ->
                new Ladder(
                        Arrays.asList(threeRopeLine, fourRopeLine, threeRopeLine, fourRopeLine)
                )
        ).isInstanceOf(InvalidRopeException.class);
    }

    @DisplayName("사다리 자동 생성 테스트")
    @CsvSource({
            "10,100",
            "20,200"
    })
    @ParameterizedTest
    void generate(int ropeSize, int lineHeight) {
        assertThatCode(() -> Ladder.generate(ropeSize, lineHeight))
                .doesNotThrowAnyException();
    }
}