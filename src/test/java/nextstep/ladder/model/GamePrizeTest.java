package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GamePrizeTest {
    private GamePrize gamePrize;

    @BeforeEach
    void setUp() {
        gamePrize = new GamePrize("1000, 꽝, 2000, 메로나열개");
    }

    @DisplayName("Players 이름 중 다섯 자리 초과 존재 시, 예외 발생")
    @Test
    void splitNameTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new GamePrize("1000, 꽝, 비비빅열두개");
        });
    }

    @DisplayName("실행결과에 LPAD(6자리 공백) 포함 한 줄 출력")
    @Test
    void getFormattedResultTest() {
        assertThat(gamePrize.getFormattedResult()).isEqualTo("  1000     꽝  2000 메로나열개");
    }

    @DisplayName("지정한 자리의 경품 출력")
    @Test
    void getPrizeTest() {
        final int MELONA_TEN = 3;
        assertThat(gamePrize.getPrize(MELONA_TEN)).isEqualTo("메로나열개");
    }
}
