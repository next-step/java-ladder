package ladder.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IndexTest {

    @DisplayName("인덱스를 초기화 할 수 있다")
    @Test
    void init() {
        assertThat(Index.init()).isEqualTo(Index.of(0));
    }

    @DisplayName("인덱스는 음수를 가질 수 없다")
    @Test
    public void initNegative() {
        assertThatThrownBy(() -> Index.of(-1))
                .isInstanceOf(NegativeIndexException.class)
                .hasMessageContaining("인덱스는 음수가 될 수 없습니다.");
    }

    @DisplayName("인덱스를 증가 시킬때마다 1 만큼 증가한다")
    @Test
    public void increase() {
        assertThat(Index.of(0)).satisfies(index -> {
            assertThat(index.increase()).isEqualTo(Index.of(1));
            assertThat(index.increase().increase()).isEqualTo(Index.of(2));
        });
    }

    @DisplayName("인덱스를 감소 시킬때마다 1 만큼 증가한다")
    @Test
    public void decrease() {
        assertThat(Index.of(2)).satisfies(index -> {
            assertThat(index.decrease()).isEqualTo(Index.of(1));
            assertThat(index.decrease().decrease()).isEqualTo(Index.of(0));
        });
    }


}
