package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @DisplayName("라인의 높이를 반환한다")
    @Test
    void getHeight() {
        Lines lines = new RandomLinesGenerator(5, 5).generate();
        assertThat(lines.getHeight()).isEqualTo(5);
    }

    @DisplayName("지정한 특정 높이의 라인을 반환한다")
    @Test
    void getLine() {
        Line firstLine = new Line.LineBuilder()
                .point(false)
                .point(true)
                .point(false)
                .build();

        Line secondLine = new Line.LineBuilder()
                .point(true)
                .point(false)
                .point(true)
                .build();

        Lines lines = new ManualLinesGenerator(4, 2, List.of(firstLine, secondLine))
                .generate();

        assertThat(lines.getLine(0)).isEqualTo(firstLine);
    }

    static class ManualLinesGenerator implements LinesGenerator {
        private final int numberOfPlayers;
        private final int height;
        private final List<Line> lines;

        public ManualLinesGenerator(int numberOfPlayers, int height, List<Line> lines) {
            validate(numberOfPlayers, height, lines);

            this.numberOfPlayers = numberOfPlayers;
            this.height = height;
            this.lines = lines;
        }

        private static void validate(int numberOfPlayers, int height, List<Line> lines) {
            if (lines.size() != height) {
                throw new IllegalArgumentException("사다리 높이와 라인의 개수가 일치하지 않습니다.");
            }
            if (containsInvalidLineWidth(numberOfPlayers, lines)) {
                throw new IllegalArgumentException("사다리의 너비와 라인의 너비가 일치하지 않습니다.");
            }
        }

        private static boolean containsInvalidLineWidth(int numberOfPlayers, List<Line> lines) {
            return lines.stream().anyMatch(line -> line.width() != numberOfPlayers);
        }

        @Override
        public Lines generate() {
            return new Lines(lines);
        }
    }
}
