package nextstep.ladder2.player;

import nextstep.ladder2.domain.player.Player;
import nextstep.ladder2.domain.player.Players;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {
    @Test
    public void 정상생성_테스트() {
        assertThatNoException().isThrownBy(() -> {
            Player player1 = new Player("even");
            Player player2 = new Player("good");
            Players players = new Players(player1, player2);

            assertThat(players.count()).isEqualTo(2);
        });
    }
    
    @Test
    public void 문자열로_정상생성_테스트() {
        assertThatNoException().isThrownBy(() -> {
            Players players = new Players("even", "good");

            assertThat(players.count()).isEqualTo(2);
        });
    }

    @Test
    public void 이름의_중복이_없어야한다() {
        assertThatThrownBy(() -> {
            Player player1 = new Player("abcde");
            Player player2 = new Player("abcde");
            new Players(player1, player2);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    public void 문자열로_생성시_이름의_중복이_없어야한다() {
        assertThatThrownBy(() -> {
            new Players("abcde", "abcde");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Player의_위치를_리턴할수있어야한다() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");

        Players players = new Players(player1, player2);
        assertThat(players.indexOf(player1)).isEqualTo(0);
        assertThat(players.indexOf(player2)).isEqualTo(1);
    }
    
    @Test
    public void 문자열로_생성시_Player의_위치를_리턴할수있어야한다() {
        Players players = new Players("A", "B");
        
        Player playerA = new Player("A");
        Player playerB = new Player("B");
        
        assertThat(players.indexOf(playerA)).isEqualTo(0);
        assertThat(players.indexOf(playerB)).isEqualTo(1);
    }
}