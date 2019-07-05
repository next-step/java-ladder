package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BarTest {
    @Test
    void 사다리_기둥_사이를_잇는_Bar를_생성한다() {
        boolean doesBarExist = true;
        Bar bar = Bar.from(doesBarExist);

        assertThat(bar.isExist()).isTrue();
    }
}
