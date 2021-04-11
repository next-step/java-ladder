package nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static nextstep.constant.Constant.PER_DOT;
import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("라인마킹테스트")
    void mark() {
        int countOfPerson = 3;
        Line line = new Line(countOfPerson);
        line.mark(2);
        List<Boolean> aspected = new ArrayList<>();
        for (int i = 0; i < countOfPerson * PER_DOT; i++) {
            if (i >= 10 && i <= 15) {
                aspected.add(true);
            } else {
                aspected.add(false);
            }
        }
        assertThat(line.getPoints()).isEqualTo(aspected);
    }
}
