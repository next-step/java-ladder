package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StairTest {
    @DisplayName("첫 계단은 존재하지 않는다.")
    @Test
    void first() {
        Stair actual = new Stair().first();

        assertThat(actual.getStair()).isFalse();
    }

    @DisplayName("계단이 존재하는지 확인한다.")
    @Test
    void isExist() {
        Stair prev = new Stair().first();
        Stair next = new Stair(true);

        assertThat(prev.isExist()).isFalse();
        assertThat(next.isExist()).isTrue();
    }
}