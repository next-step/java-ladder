package nextstep.ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    private static class IndexedName {
        public IndexedName(int index, String name) {
            throw new IllegalArgumentException("이름/인덱스가 올바르지 않습니다");
        }
    }
}
