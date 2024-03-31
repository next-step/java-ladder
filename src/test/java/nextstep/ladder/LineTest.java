package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.infra.RandomLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    private final int lineLength = 4;

    @Test
    @DisplayName("겹치는 라인이 있을 경우 에러 발생")
    void testOverlapLine() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(lineLength, count -> Collections.nCopies(count, Boolean.TRUE)));
    }


    @ParameterizedTest
    @MethodSource("makeValidLine")
    @DisplayName("라인 생성 테스트")
    void testValidLine(List<Boolean> validLine) {
        assertThat(new Line(lineLength, count -> validLine).getLine())
                .hasSize(lineLength)
                .containsExactlyElementsOf(validLine);
    }

    @Test
    @DisplayName("랜덤 값으로 라인 생성 테스트")
    void testRandomLine() {
        assertThat(new Line(lineLength, new RandomLineGenerator()).getLine()).hasSize(lineLength);
    }

    private static Stream<List<Boolean>> makeValidLine() {
        return Stream.of(
                List.of(true, false, false, true),
                List.of(false, true, false, true),
                List.of(false, false, false, false),
                List.of(true, false, false, false)
        );
    }


}
