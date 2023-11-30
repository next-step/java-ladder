package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.engine.LineCreator;
import me.namuhuchutong.ladder.domain.implement.Row;
import me.namuhuchutong.ladder.domain.implement.wrapper.LadderExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static me.namuhuchutong.ladder.domain.implement.wrapper.LadderExpression.*;
import static org.assertj.core.api.Assertions.*;

class RowTest {

    @DisplayName("|--|--| 모양으로 연속된 사다리는 허용하지 않는다.")
    @Test
    void scaffold_should_not_be_continuous() {
        List<LadderExpression> givenLadder = List.of(HYPHEN, VERTICAL_BAR, HYPHEN);
        LineCreator lineCreator = participants -> new Row(givenLadder);

        assertThatThrownBy(() -> lineCreator.createLine(5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
