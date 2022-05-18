package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLinesTest {

    private LadderLines ladderLines;

    @BeforeEach
    void setUp() {
        final int sizeOfPerson = 3;
        List<String> testNames = createTestNames(sizeOfPerson);
        final int height = 3;

        ladderLines = new LadderLines(testNames, height, () -> true);
    }

    @DisplayName("한명, 두명 까지는 포인트가 2개인 라인으로 사다리가 만들어진다.")
    @Test
    void createTest_두명까지() {
        final int onePerson = 1;
        final int twoPerson = 2;
        List<String> testNames1 = createTestNames(onePerson);
        List<String> testNames2 = createTestNames(twoPerson);
        final int height = 3;

        LadderLines ladderLines1 = new LadderLines(testNames1, height, () -> true);
        LadderLines ladderLines2 = new LadderLines(testNames2, height, () -> true);

        assertThat(ladderLines1.lineCount()).isEqualTo(2);
        assertThat(ladderLines1.lineHeight()).isEqualTo(height);
        assertThat(ladderLines2.lineCount()).isEqualTo(2);
        assertThat(ladderLines2.lineHeight()).isEqualTo(height);
    }

    @DisplayName("세명부터는 사람 수만큼의 포인트가 있는 라인으로 사다리가 만들어진다.")
    @Test
    void createTest_세명부터() {
        final int sizeOfPerson = 1;
        List<String> testNames = createTestNames(sizeOfPerson);
        final int height = 3;

        ladderLines = new LadderLines(testNames, height, () -> true);

        assertThat(ladderLines).isNotNull();
        assertThat(ladderLines.lineCount()).isEqualTo(sizeOfPerson);
        assertThat(ladderLines.lineHeight()).isEqualTo(height);
    }

    @DisplayName("사다리타기 인원이 한명일 경우에 똑같은 인덱스로 결과가 나온다.")
    @Test
    void checkResultOf_Test() {
        assertThat(ladderLines.checkResultOf("name0")).isEqualTo(0);
    }

    @DisplayName("시작 이름을 넣으면 해당 줄의 결과가 되는 줄의 인덱스가 나온다.")
    @Test
    void resultIndexOfTest1() {
        connectLinesManually();

        assertThat(ladderLines.checkResultOf("name0")).isEqualTo(2);
        assertThat(ladderLines.checkResultOf("name1")).isEqualTo(0);
        assertThat(ladderLines.checkResultOf("name2")).isEqualTo(1);
    }

    @DisplayName("없는 이름을 넣으면 예외를 반환한다.")
    @Test
    void resultIndexOfTest2() {
        connectLinesManually();

        assertThatThrownBy(() -> ladderLines.checkResultOf("noname"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     *            part
     *              0   1   2   3   4   (start index)
     * line   0     |-------|       |
     * line   1     |       |-------|
     *              0   1   2   3   4   (result index)
     */
    private void connectLinesManually() {
        ladderLines.connectLineManually(0, 1);
        ladderLines.connectLineManually(1, 3);
    }

    private List<String> createTestNames(int sizeOfPerson) {
        return IntStream.range(0, sizeOfPerson)
            .mapToObj(operand -> "name" + operand)
            .collect(Collectors.toList());
    }

}