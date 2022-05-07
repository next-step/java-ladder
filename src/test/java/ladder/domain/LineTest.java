package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LineTest {
    @Test
    public void 랜덤_불리언_생성_테스트() {
        assertTrue(Line.createTrueOrFalse(() -> true));
        assertFalse(Line.createTrueOrFalse(() -> false));
    }

    @ParameterizedTest
    @CsvSource({"3,2", "4,3", "6,5"})
    public void 사람수에_따른_라인_생성_테스트(int countOfPerson, int countOfLine) {
        assertThat(new Line(countOfPerson).getLine().size()).isEqualTo(countOfLine);
    }

    @Test
    public void 이전_불리언에_따른_불리언_생성_테스트() {
        Line line = new Line(3);
        assertTrue(line.addValueComparedToPreviousValue(true) == false);
        Boolean currentValue= line.addValueComparedToPreviousValue(false);
        assertTrue(currentValue == false || currentValue == true);    }
}