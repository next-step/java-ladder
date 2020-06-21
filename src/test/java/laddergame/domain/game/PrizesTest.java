package laddergame.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PrizesTest {

    @DisplayName("Result 리스트로 만들 String 배열이 Null 또는 길이가 0 이면 IllegalArgumentException throw")
    @Test
    void validateCreateResults() {
        assertAll(
                () -> assertThatThrownBy(() -> new Prizes(null))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력한 실행 결과들이 Null 또는 빈 배열입니다."),
                () -> assertThatThrownBy(() -> new Prizes(new String[0]))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력한 실행 결과들이 Null 또는 빈 배열입니다.")
        );

    }

    @DisplayName("인자로 받은 열 번호와 일치하는 Result를 반환한다.")
    @Test
    void findByColumn() {
        int findColumn = 2;
        String[] resultNames = new String[]{"꽝", "2000", "꽝"};
        Prizes prizes = new Prizes(resultNames);

        Prize findPrize = prizes.findByColumn(findColumn);
        Prize expectedPrize = new Prize("2000", 2);

        assertThat(findPrize).isEqualTo(expectedPrize);
    }

    @DisplayName("인자로 받은 열 번호와 일치하는 Result가 없다면 IllegalArgumentsException throw")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void findByColumnFailsThrowException(int findColumn) {
        String[] resultNames = new String[]{"꽝", "2000", "꽝"};
        Prizes prizes = new Prizes(resultNames);

        assertThatThrownBy(() -> prizes.findByColumn(findColumn))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("일치하는 열 번호가 없습니다. - " + findColumn);
    }
}
