package nextstep.ladder.model.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {
    
    @Test
    @DisplayName("Players 생성 테스트")
    void createPlayers() {
        List<Player> playerList = Arrays.asList(
                new Player("pobi"),
                new Player("crong"),
                new Player("honux")
        );
        
        Players players = Players.from(playerList);
        
        assertThat(players.count()).isEqualTo(3);
        assertThat(players.getNames()).containsExactly("pobi", "crong", "honux");
    }
    
    @Test
    @DisplayName("빈 Players 생성 시 예외 발생 테스트")
    void createEmptyPlayers() {
        assertThatThrownBy(() -> Players.from(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자 목록은 비어있을 수 없습니다");
    }
    
    @Test
    @DisplayName("최소 인원수 미만 Players 생성 시 예외 발생 테스트")
    void createInsufficientPlayers() {
        assertThatThrownBy(() -> Players.from(List.of(new Player("pobi"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자 수는 최소 2명 이상이어야 합니다");
    }
    
    @Test
    @DisplayName("이름으로 Player 찾기 테스트")
    void findPlayerByName() {
        Players players = Players.from(Arrays.asList(
                new Player("pobi"),
                new Player("crong"),
                new Player("honux")
        ));

        Optional<Player> result = players.findByName("pobi");

        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getName()).isEqualTo("pobi");
        assertThat(players.findByName("notExist")).isEmpty();
    }
    
    @Test
    @DisplayName("인덱스로 Player 가져오기 테스트")
    void getPlayerByIndex() {
        Players players = Players.from(Arrays.asList(
                new Player("pobi"),
                new Player("crong"),
                new Player("honux")
        ));
        
        assertThat(players.get(0).getName()).isEqualTo("pobi");
        assertThat(players.get(1).getName()).isEqualTo("crong");
        assertThat(players.get(2).getName()).isEqualTo("honux");
    }
    
    @Test
    @DisplayName("참가자 수 및 포인트 수 테스트")
    void countAndPointCount() {
        Players players = Players.from(Arrays.asList(
                new Player("pobi"),
                new Player("crong"),
                new Player("honux")
        ));
        
        assertThat(players.count()).isEqualTo(3);
    }
} 
