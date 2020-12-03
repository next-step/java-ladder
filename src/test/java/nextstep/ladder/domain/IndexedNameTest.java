package nextstep.ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;

public class IndexedNameTest {
    @Test
    void notNullAndNoNegativeIndex() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new IndexedName(0, null))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new IndexedName(-1, "name"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void nameLength() {
        assertThatThrownBy(() -> new IndexedName(0, "nameWithLengthOverSix"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getIndex() {
        assertThat(new IndexedName(0, "red").getIndex()).isEqualTo(0);
    }

    @Test
    void toStringWithName() {
        assertThat(new IndexedName(0, "red").toString()).isEqualTo("red");
    }

    @Test
    void wrap() {
        assertThat(IndexedName.wrap(asList("red", "blue")))
                .containsExactly(new IndexedName(0, "red"),
                                 new IndexedName(1, "blue"));
    }

    @Test
    void unwrap() {
        assertThat(IndexedName.unwrap(asList(new IndexedName(0, "red"), new IndexedName(1, "blue"))))
                .containsExactly("red", "blue");
    }
}
