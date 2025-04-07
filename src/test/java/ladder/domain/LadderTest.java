package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.exception.LadderInvalidException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {
    @Test
    @DisplayName("사다리 생성 시 높이와 인원 수가 유효한지 확인")
    void testConstructorValid() {
        Ladder ladder = new Ladder(5, 3);

        assertThat(ladder.getLines()).isNotNull();
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 생성 시 높이가 0 이하인 경우 예외 발생")
    void testConstructorInvalidHeight() {
        assertThrows(LadderInvalidException.class, () -> new Ladder(0, 3));
    }

    @Test
    @DisplayName("사다리 생성 시 인원 수가 1 이하인 경우 예외 발생")
    void testConstructorInvalidPersons() {
        assertThrows(LadderInvalidException.class, () -> new Ladder(5, 1));
    }
}
