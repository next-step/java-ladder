package ladder;

import ladder.domain.Line;
import ladder.domain.Link;
import ladder.domain.Linker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

        int numberOfOpen = (int) line.links()
                .stream()
                .filter(link -> link == Link.OPEN)
                .count();
        assertThat(numberOfOpen).isEqualTo((numberOfPlayer - 1) / 2);
    }

    @Test
    @DisplayName("생성된 링크 개수는 '플레이어수-1' ")
    void When_Link_Then_NumberOfLinkIsOneLessThanNumberOfPlayer() {
        Linker closedLinker = new Linker(() -> Link.CLOSE);
        Line line = new Line(numberOfPlayer, closedLinker);

        assertThat(line.links().size()).isEqualTo(numberOfPlayer - 1);
    }

    @Test
    @DisplayName("Link 유무에 따라 Point가 이동하는지 테스트")
    void When_EndPoint_Then_() {
        Line line = new Line(Arrays.asList(Link.CLOSE, Link.OPEN));

        assertThat(line.endPoint(0)).isEqualTo(1);
        assertThat(line.endPoint(1)).isEqualTo(0);
        assertThat(line.endPoint(2)).isEqualTo(2);
    }
}
