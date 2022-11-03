package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultLinesGeneratorTest {

    @DisplayName("생성할 때")
    @Nested
    class Create {

        @DisplayName("라인 수, 사다리높이, 스틱결정전략을 받을 수 있다.")
        @Test
        void create_by() {
            DefaultLinesGenerator expected = new DefaultLinesGenerator(new NumberOfLine(4), new LadderHeight(5), new RandomStickDecisionStrategy());

            DefaultLinesGenerator actual = new DefaultLinesGenerator(4, 5, new RandomStickDecisionStrategy());

            assertThat(expected).isEqualTo(actual);
        }
    }

    @DisplayName("라인 수와 사다리 높이, 스틱결정전략으로 라인들을 생성한다.")
    @Test
    void generate() {
        int numberOfLine = 4;
        int ladderHeight = 5;
        DefaultLinesGenerator defaultLinesGenerator = new DefaultLinesGenerator(numberOfLine, ladderHeight, () -> true);
        List<Line> expected = createLines(numberOfLine, ladderHeight);

        List<Line> actual = defaultLinesGenerator.generate();

        assertThat(actual).isEqualTo(expected);
    }

    private List<Line> createLines(int numberOfLine, int ladderHeight) {
        return IntStream.range(0, numberOfLine)
                .mapToObj(index -> createLine(index, ladderHeight))
                .collect(Collectors.toList());
    }

    private Line createLine(int index, int ladderHeight) {
        if (index % 2 == 0) {
            return Line.from(createBooleans(true, ladderHeight));
        }
        return Line.from(createBooleans(false, ladderHeight));
    }

    private List<Boolean> createBooleans(boolean stickValue, int size) {
        return IntStream.range(0, size)
                .mapToObj(index -> stickValue)
                .collect(Collectors.toList());
    }
}
