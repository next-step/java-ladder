package ladder.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IndexTest {

    @Test
    @DisplayName("현재 인덱스값을 확인한다")
    void checkIndex() {
        Index index = Index.of(1);
        assertThat(index.get()).isEqualTo(1);
    }

    @Test
    @DisplayName("시작 인덱스인지 확인한다")
    void checkIndex2() {
        Index index = Index.of(0);
        assertTrue(index.isStartIndex());
    }

    @Test
    @DisplayName("이전 인덱스값을 확인한다")
    void checkIndex3() {
        Index index = Index.of(1);
        assertThat(index.prev()).isEqualTo(0);
    }

    @Test
    @DisplayName("인덱스 값비교를 확인한다")
    void checkIndex4() {
        Index index = Index.of(1);
        assertTrue(index.isSameIndex(1));
    }

    @Test
    @DisplayName("다음 인덱스값을 확인한다")
    void checkIndex5() {
        Index index = Index.of(1);
        assertThat(index.next()).isEqualTo(2);
    }
}
