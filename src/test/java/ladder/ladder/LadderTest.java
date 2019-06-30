package ladder.ladder;

import ladder.domain.ladder.Ladder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("[success] 파라미터로 입력된 숫자만큼의 Line 를 생성한다.")
    void makeRowsTest() {
        //Given
        int rowsSize = 5;
        int cellSize = 5;
        
        //When
        Ladder ladder = Ladder.from(rowsSize, cellSize);
        
        //Then
        Assertions.assertThat(ladder.getSize()).isEqualTo(rowsSize);
    }
}
