package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LineTest {
    private final int numberOfPlayer = 4;

    @Test
    @DisplayName("Line Class 생성 테스트")
    void Given_Linker_When_New_Then_Created() {
        Linker linker = new Linker(() -> Link.CLOSE);

        assertDoesNotThrow(() -> {

            new Line(numberOfPlayer, linker);
        });
    }

    @Test
    @DisplayName("ClosedLinker가 주어졌을 때 OPEN 링크를 생성 테스트")
    void Given_ClosedLinker_When_Link_Then_OpenLink() {
        Linker closedLinker = new Linker(() -> Link.CLOSE);
        Line line = new Line(numberOfPlayer, closedLinker);

        int numberOfOpen = (int) line.link()
                .stream()
                .filter(link -> link == Link.OPEN)
                .count();
        assertThat(numberOfOpen).isEqualTo(numberOfPlayer / 2);
    }
}
