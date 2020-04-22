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

        for (int i = 1; i < lineCount; i++) {
            assertThat(line.isLineExist(i)).isEqualTo(line.isLineExist(i - 1));
        }
    }

}
