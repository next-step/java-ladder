package ladder.domain.ladderline;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class IndexTest {

    @Test
    @DisplayName("인덱스 생성을 확인한다")
    void createStartIndex() {
        Index index = Index.ofStart();
        assertThat(index.get()).isEqualTo(Index.START_INDEX);
    }

    @Test
    @DisplayName("다음 인덱스 생성을 확인한다")
    void createNextIndex() {
        Index index = Index.ofStart().next();
        assertThat(index.get()).isEqualTo(1);
    }

    @Test
    @DisplayName("인덱스가 음수인경우 예외처리를 확인한다")
    void checkNegativeException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Index.ofStart().prev();
                }).withMessageMatching("Invalid index range");
    }

    @Test
    @DisplayName("이전 인덱스 생성을 확인한다")
    void createPrevIndex() {
        Index index = Index.ofStart().next().prev();
        assertThat(index.get()).isEqualTo(0);
    }
}
