package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersTest {
    private Players players;

    @BeforeEach
    void setUp() {
        players = new Players("Jack, Jim, Loen, Su, Rocky", "1000, 꽝, 2000, 메로나열개");
    }

    @DisplayName("Players 이름 중 다섯 자리 초과 존재 시, 예외 발생")
    @Test
    void splitNameTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Players("Jack, Samuel, Loen", "1000, 2000, 3000"));
    }

    @DisplayName("Players 이름에 LPAD(6자리 공백) 포함 한 줄 출력")
    @Test
    void getFormattedNameTest() {
        assertThat(players.getFormattedName()).isEqualTo("  Jack   Jim  Loen    Su Rocky");
    }

    @DisplayName("실행결과에 LPAD(6자리 공백) 포함 한 줄 출력")
    @Test
    void getFormattedPrizeTest() {
        assertThat(players.getFormattedPrize()).isEqualTo("  1000     꽝  2000 메로나열개");
    }

    @DisplayName("이름으로 List 위치 찾기")
    @Test
    void getPositionTest() {
        assertThat(players.getPosition("Jim")).isEqualTo(1);
    }

    @DisplayName("지정한 자리의 경품 출력")
    @Test
    void getPrizeTest() {
        final int MELONA_TEN = 3;
        assertThat(players.getPrize(MELONA_TEN)).isEqualTo("메로나열개");
    }
}
