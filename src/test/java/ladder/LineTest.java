package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("인원 수 사다리 라인 테스트")
    @Test
    void getLineCount() {
        int countOfPersion = 5;
        assertThat(new Line(countOfPersion).getLineCount()).isEqualTo(countOfPersion - 1) ;
    }

}
