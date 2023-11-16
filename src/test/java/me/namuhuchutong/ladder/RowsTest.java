package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.Rows;
import me.namuhuchutong.ladder.domain.factory.ScaffoldFactory;
import me.namuhuchutong.ladder.domain.wrapper.EmptySpace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RowsTest {

    @DisplayName("사다리는 1보다 작거나 10보다 크다면 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 11})
    void throw_exception_when_create_ladder_exceed_10_height(int givenHeight) {
        //given
        int participants = 5;
        ScaffoldFactory testFactory = EmptySpace::new;

        //when, then
        assertThatThrownBy(() -> Rows.createLadder(givenHeight, participants, testFactory))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
