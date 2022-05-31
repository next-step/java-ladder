package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

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
    void move() {
        Row row = Row.createManual(Arrays.asList(false, true, false));
        System.out.println(row);
        assertThat(row.move(0)).isEqualTo(0);
        assertThat(row.move(1)).isEqualTo(2);
        assertThat(row.move(2)).isEqualTo(1);
    }

    @Test
    void createRow() {
        Row row = Row.createRandom(5);
        assertThat(row.size()).isEqualTo(5);
    }
}


/*
0, false true, 1, false, true

false false false
false true false
*/
