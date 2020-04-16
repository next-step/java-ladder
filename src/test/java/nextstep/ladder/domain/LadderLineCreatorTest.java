package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLineCreatorTest {

    @DisplayName("라인을 생성한다.")
    @Test
    void create() {
        LadderLineCreator lineCreator = new LadderLineCreator();
        LadderLine ladderLine = lineCreator.create(5);
        assertThat(ladderLine.getPoints()).hasSize(5);
    }
}
