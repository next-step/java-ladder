package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayersTest {

    private Players players;

    @BeforeEach
    void setUp() {
        players = new Players(Arrays.asList("AAA", "BBB"));
    }

    @DisplayName("플레이어들 이름이 같으면 동일 객체")
    @Test
    void create() {
        assertThat(players)
                .isEqualTo(new Players(Arrays.asList("AAA", "BBB")));
    }

    @DisplayName("결과 입력값과 플레이어 수가 같으면 true, 다르면 false")
    @Test
    void isSameSize() {
        assertThat(players.isSameSize(new Results(Arrays.asList("꽝", "1000")))).isTrue();
        assertThat(players.isSameSize(new Results(Arrays.asList("꽝")))).isFalse();
    }

    @DisplayName("참여자들 인덱스에 맞는 참여자 이름을 반환한다.")
    @Test
    void indexOf() {
        assertThat(players.indexOf(1)).isEqualTo("BBB");
        assertThat(players.indexOf(0)).isEqualTo("AAA");
    }
}