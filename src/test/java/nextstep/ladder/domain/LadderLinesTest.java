package nextstep.ladder.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.exception.NotExistNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLinesTest {

    private LadderLines ladderLines;
    private final int sizeOfPerson = 3;
    private final int height = 2;
    @BeforeEach
    void setUp() {
        List<String> testNames = createTestNames(sizeOfPerson);

        ladderLines = new LadderLines(testNames, height);
    }

    @DisplayName("최소라인인 2개 라인으로 사다리가 만들어진다.")
    @Test
    void createTest_두명() {
        final int twoPerson = 2;
        List<String> testNames2 = createTestNames(twoPerson);
        LadderLines ladderLines2 = new LadderLines(testNames2, height);

        assertThat(ladderLines2.lineCount()).isEqualTo(2);
        assertThat(ladderLines2.lineHeight()).isEqualTo(height);
    }

    @DisplayName("사다리타기 할 인원 수만큼의 포인트가 있는 라인으로 사다리가 만들어진다.")
    @Test
    void createTest_세명부터() {
        assertThat(ladderLines).isNotNull();
        assertThat(ladderLines.lineCount()).isEqualTo(sizeOfPerson);
        assertThat(ladderLines.lineHeight()).isEqualTo(height);
    }

    @DisplayName("사다리타기 인원이 두명 이상이 아닐 경우에 사다리 예외 발생한다.")
    @Test
    void checkResultOf_Test() {
        final int onePerson = 1;
        List<String> testNames = createTestNames(onePerson);

        assertThatThrownBy(() -> {
            new LadderLines(testNames, height);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리타기의 시작 이름을 넣으면 해당 줄의 결과가 되는 줄의 인덱스가 나온다.")
    @Test
    void resultIndexOfTest1() {
        handleLinesManually();

        System.out.println(ladderLines);

        assertThat(ladderLines.checkResultOf("name0")).isEqualTo(2);
        assertThat(ladderLines.checkResultOf("name1")).isEqualTo(0);
        assertThat(ladderLines.checkResultOf("name2")).isEqualTo(1);
    }

    @DisplayName("없는 이름을 넣으면 예외를 반환한다.")
    @Test
    void resultIndexOfTest2() {
        handleLinesManually();

        assertThatThrownBy(() -> ladderLines.checkResultOf("noname"))
            .isInstanceOf(NotExistNameException.class);
    }

    /**
     * LadderLine(line)
     * Point(|)
     *
     * 참가자:      name0   name1   name2
     *              0       1       2   (start index)
     * line   0     |-------|       |
     * line   1     |       |-------|
     *              0       1       2   (result index)
     */
    private void handleLinesManually() {
        ladderLines.handlePointManually(0, 0, Direction.of(FALSE, TRUE));
        ladderLines.handlePointManually(0, 1, Direction.of(TRUE, FALSE));
        ladderLines.handlePointManually(0, 2, Direction.of(FALSE, FALSE));
        ladderLines.handlePointManually(1, 0, Direction.of(FALSE, FALSE));
        ladderLines.handlePointManually(1, 1, Direction.of(FALSE, TRUE));
        ladderLines.handlePointManually(1, 2, Direction.of(TRUE, FALSE));
    }

    private List<String> createTestNames(int sizeOfPerson) {
        return IntStream.range(0, sizeOfPerson)
            .mapToObj(operand -> "name" + operand)
            .collect(Collectors.toList());
    }

}