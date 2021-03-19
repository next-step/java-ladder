package ladder;

import ladder.domain.LineList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineListTest {

    @Test
    @DisplayName("line list 생성 테스트")
    void name() {
        int height = 5;
        int countOfPerson = 6;
        LineList lineList = new LineList();
        lineList.addBulk(height, countOfPerson);

        assertThat(lineList.size()).isEqualTo(height);
    }

}
