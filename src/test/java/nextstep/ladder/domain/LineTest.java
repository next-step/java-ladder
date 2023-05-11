package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("라인 생성 테스트")
    void createLineTest(boolean input) {
        Line line = new Line(input);

        assertThat(line.hasLine())
                .isEqualTo(input);
    }

    @Test
    @DisplayName("오른쪽 이동 판단 테스트")
    void moveRightTest() {
        Line previousLine = new Line(true);
        Line currentLine = new Line(false);

        assertThat(currentLine.judgeDirection(previousLine))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽 이동 판단 테스트")
    void moveLeftTest() {
        Line previousLine = new Line(false);
        Line currentLine = new Line(true);

        assertThat(currentLine.judgeDirection(previousLine))
                .isEqualTo(-1);
    }

    @Test
    @DisplayName("이동하지 않음 판단 테스트")
    void stayTest() {
        Line previousLine = new Line(false);
        Line currentLine = new Line(false);

        assertThat(currentLine.judgeDirection(previousLine))
                .isEqualTo(0);
    }

}
