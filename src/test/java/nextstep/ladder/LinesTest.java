package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.LineCreationStrategy;
import nextstep.ladder.domain.Lines;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    LineCreationStrategy trueLineCreationStrategy;
    LineCreationStrategy falseLineCreationStrategy;

    @BeforeEach
    void setUp() {
        trueLineCreationStrategy = new LineCreationStrategy() {
            @Override
            public boolean createLine() {
                return true;
            }

            @Override
            public boolean isOrNoneDrawLines(Line line) {
                return false;
            }
        };

        falseLineCreationStrategy = new LineCreationStrategy() {
            @Override
            public boolean createLine() {
                return false;
            }

            @Override
            public boolean isOrNoneDrawLines(Line line) {
                return false;
            }
        };
    }

    @Test
    @DisplayName("사다리 줄 생성 true")
    void makeLineTest() {
        int height = 5;

        for(int i = 0; i < height; i++) {
            Lines lines = Lines.of(Line.initLine(), 4, trueLineCreationStrategy);
            assertThat(lines).isEqualTo(Lines.of(Line.initLine(), 4, trueLineCreationStrategy));
        }
    }

    @Test
    @DisplayName("사다리 줄 생성 false")
    void makeLineFalseTest() {
        int height = 5;

        for(int i = 0; i < height; i++) {
            Lines lines = Lines.of(Line.initLine(), 3, falseLineCreationStrategy);
            assertThat(lines).isEqualTo(Lines.of(Line.initLine(), 3, falseLineCreationStrategy));
        }
    }

}
