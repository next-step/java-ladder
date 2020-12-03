package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IndexedNameTest {
    @Test
    void notNull() {
        assertThatThrownBy(() -> new IndexedName(0, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static class IndexedName {
        public IndexedName(int index, String name) {
            throw new IllegalArgumentException("이름이 반드시 제공되어야 한다");
        }
    }
}
