package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.implement.Row;
import me.namuhuchutong.ladder.domain.implement.Rows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

class RowsTest {

    @DisplayName("사다리는 1보다 작거나 10보다 크다면 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    void throw_exception_when_create_ladder_exceed_10_height(int givenHeight) {
        assertThatThrownBy(() -> createDummyRows(givenHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private Rows createDummyRows(int givenHeight) {
        return Stream.generate(() -> new Row(EMPTY_LIST))
                     .limit(givenHeight)
                     .collect(collectingAndThen(toUnmodifiableList(), Rows::new));
    }
}
