package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void 참여할_사람_이름과_최대_사다리_높이_등록() {
        // given
        final String[] playerNames = {"pobi", "honux", "crong", "jk"};
        final int height = 5;
        final LinesGenerator linesGenerator = new DefaultLinesGenerator(playerNames.length, height);

        // when
        final LadderGame ladderGame = new LadderGame(playerNames, linesGenerator);

        // then
        assertThat(ladderGame).isNotNull();
    }
}