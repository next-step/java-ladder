package ladder.domain;

import ladder.domain.code.Direction;
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
        final Player player = new Player("Jay", 1);

        assertThat(player.name()).isEqualTo("Jay");
        assertThat(player.position()).isEqualTo(1);
    }

    @Test
    @DisplayName("참가자 이름 실패 테스트 (최대 5글자)")
    void playerFailForNameTest(){
        assertThatThrownBy(() ->
                new Player("Achilles", 0)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5글자 입니다.");
    }

    @Test
    @DisplayName("참가자 위치 실패 테스트 (잘못된 위치)")
    void playerFailForPositionTest(){
        assertThatThrownBy(() ->
                new Player("Jay", -1)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자의 위치가 잘못되었습니다.");

    }

    @Test
    @DisplayName("여러 참가자 생성 테스트")
    void playersTest(){
        final List<String> playersNames = List.of("david", "J");

        Players players = PlayerFactory.create(playersNames);

        assertThat(players.count()).isEqualTo(2);

    }

    @Test
    @DisplayName("기존 참가자들 중 참가자들 조회 테스트")
    void playersOfTest(){
        final Players players = PlayerFactory.create(List.of("david", "J", "alex"));

        Players foundPlayers = players.of(List.of("david", "J"));

        assertThat(foundPlayers.count()).isEqualTo(2);

    }

    @Test
    @DisplayName("기존 참가자들 중 참가자들 조회 실패 테스트 (찾을 수 없음)")
    void playersOfFailForNotExistTest(){
        final String nonPlayer = "peter";
        final Players players = PlayerFactory.create(List.of("david", "J", "alex"));

        assertThatThrownBy(() ->
                players.of(List.of(nonPlayer)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자를 찾을 수 없습니다: " + nonPlayer);


    }

    @Test
    @DisplayName("참가자 이동 테스트")
    void playerMoveTest(){
        final Player player = new Player("david", 1);

        player.move(Direction.RIGHT);

        assertThat(player.position()).isEqualTo(2);
    }
}
