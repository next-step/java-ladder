package nextstep.ladder.domain;

import static nextstep.ladder.domain.Height.MAXIMUM_LADDER_HEIGHT;
import static nextstep.ladder.domain.Height.MINIMUM_LADDER_HEIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class HeightTest {

    @Test
    void 유효한_길이_생성() {
        Height height1 = new Height(MINIMUM_LADDER_HEIGHT);
        Height height2 = new Height(MAXIMUM_LADDER_HEIGHT);

        assertThat(height1.get()).isEqualTo(MINIMUM_LADDER_HEIGHT);
        assertThat(height2.get()).isEqualTo(MAXIMUM_LADDER_HEIGHT);
    }

    @Test
    void 짧아서_유효하지_않은_길이_생성() {
        assertThatThrownBy(() -> {
            new Height(MINIMUM_LADDER_HEIGHT-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길어서_유효하지_않은_길이_생성() {
        assertThatThrownBy(() -> {
            new Height(MAXIMUM_LADDER_HEIGHT+1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}