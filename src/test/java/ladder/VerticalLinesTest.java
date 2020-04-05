package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class VerticalLinesTest {

    private List<VerticalLine> testVerticalLineList;
    private VerticalLines testVerticalLines;

    @BeforeEach
    void setUp() {
        this.testVerticalLineList = new ArrayList<>(Arrays.asList(
                new VerticalLine(0), new VerticalLine(1), new VerticalLine(2))
        );
        this.testVerticalLines = new VerticalLines(testVerticalLineList);

    }

    @Test
    @DisplayName("VerticalLines 에서 해당 넘버 가져오기 테스트")
    void getLineTest() {
        assertThat(testVerticalLines.getLine(0)).isEqualTo(testVerticalLineList.get(0));
    }

    @Test
    @DisplayName("VerticalLine의 오른쪽 라인 가져오기 테스트")
    void getRightLineTest() {
        assertThat(testVerticalLines.getRightLine(testVerticalLines.getLine(0))).isEqualTo(testVerticalLineList.get(1));
    }

    @Test
    @DisplayName("VerticalLine의 오른쪽 라인 가져오기 실패 테스트")
    void failGetRightLineTest() {
        assertThat(testVerticalLines.getRightLine(testVerticalLines.getLine(2))).isEqualTo(null);
    }

    @Test
    @DisplayName("VerticalLine의 왼쪽 라인 가져오기 테스트")
    void getLeftLineTest() {
        assertThat(testVerticalLines.getLeftLine(testVerticalLines.getLine(1))).isEqualTo(testVerticalLineList.get(0));
    }

    @Test
    @DisplayName("VerticalLine의 왼쪽 라인 가져오기 실패 테스트")
    void failGetLeftLineTest() {
        assertThat(testVerticalLines.getLeftLine(testVerticalLines.getLine(0))).isEqualTo(null);
    }

    @Test
    @DisplayName("라인 그리기 테스트")
    void drawSideLineTest() {
        testVerticalLines.drawSideLine(testVerticalLines.getLine(0), 1);

        assertAll(
                () -> assertThat(testVerticalLines.getLine(0).getPoint(1)).isNotNull(),
                () -> assertThat(testVerticalLines.getLine(1).getPoint(1)).isNotNull()
        );
    }
}
