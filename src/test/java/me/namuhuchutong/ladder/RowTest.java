package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.engine.LineCreator;
import me.namuhuchutong.ladder.domain.engine.ScaffoldFactory;
import me.namuhuchutong.ladder.domain.implement.RowCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static me.namuhuchutong.ladder.domain.implement.wrapper.LadderExpression.*;
import static org.assertj.core.api.Assertions.*;

class RowTest {

    @DisplayName("|--|--| 모양으로 연속된 사다리는 허용하지 않는다.")
    @Test
    void scaffold_should_not_be_continuous() {
        LineCreator lineCreator = new RowCreator();
        ScaffoldFactory testFactory = () -> HYPHEN;

        assertThatThrownBy(() -> lineCreator.createLine(5, testFactory))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
