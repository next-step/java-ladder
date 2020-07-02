package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private Line line;

    @BeforeEach
    public void setUp() {
        line = new Line(4);
    }

    @DisplayName("입력받은 list만큼의  line생성")
    @Test
    public void createLines() {
        int userSize = 4;
        line = new Line(userSize);
        assertThat(line.getLineRow().size()).isEqualTo(userSize);

    }

    @DisplayName("랜덤으로 생성된 list사이즈 만큼의 line생성")
    @Test
    public void createLinesWithRandom() {
        MakeLineWithRandom makeLineWithRandom = new MakeLineWithRandom();

        List<Boolean> lines = new ArrayList<>();
        lines.add(makeLineWithRandom.createLine());
        lines.add(makeLineWithRandom.createLine());

    }

    @DisplayName("true값이면 다음값은 false 테스트")
    @ParameterizedTest
    @MethodSource
    public void printLine(int size, List expected) {

        line = new Line(size, new MakeLineWithTrue());
        assertThat(line.getLineRow()).isEqualTo(expected);
    }

    private static Stream<Arguments> printLine() {
        return Stream.of(
                Arguments.of(3, Arrays.asList(true, false)),
                Arguments.of(5, Arrays.asList(true, false, true, false))
        );
    }


    private class MakeLineWithTrue implements MakeLine {
        private Boolean beforeLine = false;

        @Override
        public Boolean createLine() {

            this.beforeLine = checkBeforeLine();
            return this.beforeLine;

        }

        private Boolean checkBeforeLine() {

            return beforeLine ? false : true;

        }
    }

}