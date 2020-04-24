package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("겹치지 않는 라인 생성 확인")
    public void getLineSuccess() {
        int countOfPerson = 5;
        int lineCount = countOfPerson - 1;
        Line line = new Line(countOfPerson);

        for (int i = 0; i < lineCount - 1; i++) {
            if (line.isPointExist(i)) {
                assertThat(line.isPointExist(i)).isNotEqualTo(line.isPointExist(i + 1));
            }
        }
    }

}
