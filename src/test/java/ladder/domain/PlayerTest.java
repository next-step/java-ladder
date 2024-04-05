package ladder.domain;

import ladder.domain.factory.PlayerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @Test
    @DisplayName("참가자 생성 테스트")
    void playerTest(){
        Player player = new Player("Jay");

        assertThat(player.name()).isEqualTo("Jay");

        assertThatThrownBy(() ->
                new Player("Achilles")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5글자 입니다.");

    }

    @Test
    @DisplayName("여러 참가자 생성 테스트")
    void playersTest(){
        final List<String> playersNames = List.of("david", "J");
        Players players = PlayerFactory.create(playersNames);
        assertThat(players.count()).isEqualTo(2);

    }
}
