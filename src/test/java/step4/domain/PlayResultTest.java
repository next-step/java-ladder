package step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayResultTest {
    @Test
    void 추가_테스트() {
        // given
        PlayResult playResult = new PlayResult();
        playResult.addResult(new Player(0, "dhlee"), new Prize(0, "1000"));
        playResult.addResult(new Player(1, "test"), new Prize(1, "1000"));

        // when & then
        assertThat(playResult.getResult().size()).isEqualTo(2);
    }

    @Test
    void 플레이어_이름_매칭_테스트() {
        // given
        Player player1 = new Player(0, "dhlee");
        Player player2 = new Player(1, "test");
        Prize prize1 = new Prize(0, "1000");
        Prize prize2 = new Prize(1, "2000");

        PlayResult playResult = new PlayResult();
        playResult.addResult(player1, prize1);
        playResult.addResult(player2, prize2);

        // when & then
        assertThat(playResult.matchPlayer(player1)).isEqualTo(prize1);
        assertThat(playResult.matchPlayer(player2)).isEqualTo(prize2);
    }
}
