package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    void create() {
        LadderGame ladderGame = new LadderGame("pobi, oby, start", 5);
        assertThat(ladderGame).isEqualTo(new LadderGame(new Members("pobi, oby, start"), new Layer(5)));
    }

    @Test
    void 멤버_조회() {
        LadderGame ladderGame = new LadderGame("pobi, oby, start", 5);
        assertThat(ladderGame.getMembers()).isEqualTo(new Members("pobi, oby, start"));
    }
}
