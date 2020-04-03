package ladder;

import ladder.model.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {
    @DisplayName("이전 값이 true면, 다음 값은 true가 오지 않는 Row 객체를 생성한다.")
    @Test
    void createTest() {
        //given
        int playerCount = 5;

        //when
        Row row = Row.create(playerCount);

        //then
        for (int i = 1; i < playerCount - 2; i++) {
            assertThat(row.getRowElement(i))
                    .isNotEqualTo(row.getRowElement(i + 1));
        }
    }
}
