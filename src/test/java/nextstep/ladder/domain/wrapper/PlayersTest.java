package nextstep.ladder.domain.wrapper;

import nextstep.ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @DisplayName("플레이어들의 이름을 가져온다.")
    @Test
    void playersName() {
        // given
        String[] names = {"홍길동", "전창길", "코난"};

        Players players = new Players(IntStream.range(0, names.length)
            .mapToObj(i -> Player.PlayerBuilder.builder()
                .name(names[i])
                .widthPosition(i)
                .heightPosition(1)
                .build())
            .collect(Collectors.toList()));

        // when & then
        assertThat(players.names()).isEqualTo("홍길동   전창길   코난    ");
    }
}
