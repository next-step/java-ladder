package ladder.domain;

import java.util.List;

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

        List<Line> lines = ladder.getLines();

        assertThat(lines).isNotNull();
        assertThat(lines.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("getLines()는 동일한 인스턴스를 반환하는지 확인")
    void getLines_shouldReturnSameInstanceOnMultipleCalls() {
        Ladder ladder = new Ladder(5, 3);
        List<Line> firstCall = ladder.getLines();
        List<Line> secondCall = ladder.getLines();

        assertThat(firstCall).isSameAs(secondCall);
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
