package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    private Players players;

    @BeforeEach
    public void init(){

        String[] playNames = {"AAA", "BBB", "CCC"};

        players = new Players(playNames);
    }

    @DisplayName("Players 생성 테스트")
    @Test
    void playersConstructorTest(){
        assertThat(players.getPlayers()).containsExactly(Player.from("AAA"), Player.from("BBB"), Player.from("CCC"));
    }

    @DisplayName("입력하지 않은 실행결과를 찾는 경우 Exception Test")
    @Test
    void searchWrongPlayerExceptionTest(){

        assertThatIllegalArgumentException().isThrownBy(() -> {

            players.searchPlayerName(4);

        }).withMessageContaining("해당 위치에 참여한 사람값이 존재하지 않습니다.");
    }
}
