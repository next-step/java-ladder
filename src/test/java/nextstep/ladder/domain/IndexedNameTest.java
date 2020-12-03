package nextstep.ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    private static class IndexedName {
        private final int index;
        private final String name;

        public IndexedName(int index, String name) {
            if (index < 0 || name == null) {
                throw new IllegalArgumentException("이름/인덱스가 올바르지 않습니다");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException(String.format("이름은 %d자 이하여야 합니다.", 5));
            }
            this.index = index;
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
