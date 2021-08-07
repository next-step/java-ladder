package ladder.domain;

import ladder.domain.line.LadderLine;
import ladder.domain.line.FakeDirectionCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @CsvSource({"0,1", "1,0", "2,3", "3,2", "4,5", "5,4"})
    @DisplayName("3개의 라인과 6개의 포인트를 사용해 move 테스트")
    @ParameterizedTest
    void moveTest(int index, int correctIndex) {
        int lineSize = 3;
        int pointSize = 6;

        Ladder ladder = newLadder(lineSize, pointSize);
        int expert = ladder.move(index);
        assertThat(expert)
                .isEqualTo(correctIndex);
    }

    private Ladder newLadder(int lineHeight, int pointSize) {
        return Stream.generate(() -> newLadderLine(pointSize))
                .limit(lineHeight)
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toList(), Ladder::new
                        )
                );
    }

    private LadderLine newLadderLine(int pointSize) {
        return LadderLine.builder()
                .auto(new FakeDirectionCreateStrategy())
                .pointSize(pointSize)
                .build();
    }
}
