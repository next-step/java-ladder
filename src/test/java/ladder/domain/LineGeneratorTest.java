package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineGeneratorTest {

    @Test
    @DisplayName("겹치지 않는 라인 생성 확인")
    public void getLineSuccess() {
        int countOfPerson = 5;
        int lineCount = countOfPerson - 1;
        List<Boolean> line = LineGenerator.generateRandomPoints(countOfPerson);

        for (int i = 0; i < lineCount - 1; i++) {
            if (line.get(i)) {
                assertThat(line.get(i)).isNotEqualTo(line.get(i + 1));
            }
        }
    }
}
