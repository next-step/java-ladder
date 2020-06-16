package domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 플레이어_이름과_높이를_입력하여_게임을_만든다() {
        new Ladder(new String[]{"abc", "aaaa", "bcdef"}, 3);
    }

    @Test
    public void 플레이어_이름을_가져온다() {
        Ladder ladder = new Ladder(new String[]{"abc", "aaaa", "bcdef"}, 3);

        assertThat(ladder.getPlayerNames()).isEqualTo(" abc aaaa bcdef");
    }
}