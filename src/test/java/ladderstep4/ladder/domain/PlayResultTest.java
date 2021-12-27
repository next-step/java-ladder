package ladderstep4.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayResultTest {
    @Test
    void 사다리의_시작점과_결과점_입력하고_출력하기() {
        PlayResult playResult = new PlayResult();
        playResult.put(new Position(0), new Position(1));

        assertThat(playResult.get(new Position(0))).isEqualTo(new Position(1));
    }
}
