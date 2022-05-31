package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RowTest {
//    @Test
//    void consecutiveTrueIsNotAllowed() {
//        assertThatThrownBy(() -> new Row(Arrays.asList(true, true, false, true))).isInstanceOf(RuntimeException.class);
//    }
//
//    @Test
//    void withoutConsecutiveTrueCanCreateRow() {
//        assertThat(new Row(Arrays.asList(true, false, false, true))).isInstanceOf(Row.class);
//    }
//
//    @Test
//    void validateThrowErrorWithConsecutiveTrue() {
//        assertThatThrownBy(() -> Row.validate(Arrays.asList(false, true, true))).isInstanceOf(RuntimeException.class);
//    }
//
//    @Test
//    void nextOfTrueReturnsFalse() {
//        assertThat(Row.next(true)).isFalse();
//    }


    @Test
    void name() {
        Row row = new Row(Arrays.asList(new Link(0, Node.first(true)), new Link(0, Node.first(true))));
    }
}
