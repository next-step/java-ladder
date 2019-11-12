package nextstep.ladder.domain;

import nextstep.ladder.view.LadderInputView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTestd {
    @Test
    void 객체_생성() {
        LadderLine line = new LadderLine(4);
        assertThat(line).isEqualTo(new LadderLine(4));
    }

    @Test
    void 사다리_라인_생성() {
        LadderLine line = new LadderLine(4);
        line.create();
        assertThat(line).isNotEqualTo(new LadderLine(4));
    }
}