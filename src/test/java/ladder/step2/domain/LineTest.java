package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    public static final Line LINE = Line.of(5, () -> PartLineTest.TRUE);
    
    @Test
    @DisplayName("라인 생성")
    void create() {
        System.out.println("false true false true false false?? : " + LINE);
    }
    
    @DisplayName("라인 이동")
    @ParameterizedTest(name = "{displayName} : currentPosition => {0}, resultPosition => {1}")
    @CsvSource(value = {"4, 4", "3, 2", "2, 3", "1, 0", "0, 1"})
    void move(int currentPosition, int resultPosition) {
        assertThat(LINE.move(currentPosition)).isEqualTo(resultPosition);
    }
}
