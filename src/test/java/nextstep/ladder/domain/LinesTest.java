package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {

    private Lines lines = new Lines(3, 2);

    @Test
    void createTest() {
        Lines lines = new Lines(2, 2);

        assertThat(lines.getLines()).hasSize(2);
    }

    @DisplayName("세로줄 시작 인덱스를 넣으면 해당 줄의 결과가 되는 세로줄 인덱스가 나온다.")
    @Test
    void resultIndexOfTest1() {
        connectLinesManually();

        assertThat(lines.resultIndexOf(0)).isEqualTo(4);
        assertThat(lines.resultIndexOf(2)).isEqualTo(0);
        assertThat(lines.resultIndexOf(4)).isEqualTo(2);
    }

    @DisplayName("세로줄 시작 인덱스가 유효하지 않으면 예외를 반환한다.")
    @Test
    void resultIndexOfTest2() {
        connectLinesManually();

        assertThatThrownBy(() -> lines.resultIndexOf(-1))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lines.resultIndexOf(1))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lines.resultIndexOf(3))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lines.resultIndexOf(5))
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
        lines.connectLineManually(0, 1);
        lines.connectLineManually(1, 3);
    }

}