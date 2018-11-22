package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderOptionTest {

    @Test
    public void 생성() {
        LadderOption ladderOption = LadderOption.create(5);
        assertThat(ladderOption).isNotNull();
        assertThat(ladderOption.height()).isEqualTo(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_예외처리() {
        LadderOption.create(0);
    }
}