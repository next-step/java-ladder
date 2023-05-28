package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayersTest {
    @Test
    @DisplayName("주어진 이름 리스트의 개수만큼 Player르 생성한다")
    void 플레이어_생성() {
        List<String> names = new ArrayList<>(Arrays.asList("ayla","jenna","andy"));
        Players players = new Players(names);
        assertThat(players.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("주어진 인덱스의 요소를 반환한다.")
    public void get() {
        List<String> names = List.of("ayla", "jenna", "andy");
        Players players = new Players(names);
        assertThat(players.get(0).getName()).isEqualTo("ayla");
    }
}
