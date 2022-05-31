package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    void move() {
        Node node = Node.first(false);
        List<Link> links = Arrays.asList(
                new Link(0, node),
                new Link(1, node.next(true)),
                new Link(2, node.next(false))
        );
        Row row = new Row(links);
        assertThat(row.move(1)).isEqualTo(2);
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
