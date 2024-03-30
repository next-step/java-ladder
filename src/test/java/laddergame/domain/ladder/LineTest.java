package laddergame.domain.ladder;

import laddergame.domain.Players;
import laddergame.domain.ladder.strategy.LinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static laddergame.domain.ladder.Link.UNLINKED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class LineTest {
    @Nested
    @DisplayName("Line 인스턴스 생성 테스트")
    class InstanceCreationTest {
        LinkStrategy linkStrategyStub = () -> true;

        @Test
        @DisplayName("생성된 Line 인스턴스에서 links의 크기는 numberOfPlayers - 1 과 같다.")
        void testNumberOfPoints() {
            Players players = Players.newPlayers("a", "b", "c", "d");
            Line line = Line.newLine(players, linkStrategyStub);

            assertThat(line.links().size()).isEqualTo(players.numberOfPlayers() - 1);
        }

        @Test
        @DisplayName("생성된 Line 인스턴스에서 links는 LINKED를 연속으로 가질 수 없다.")
        void testNonOverlap() {
            Players players = Players.newPlayers("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
            List<Link> links = Line.newLine(players, linkStrategyStub)
                    .links();

            IntStream.range(1, players.numberOfPlayers() - 1)
                    .forEach(i -> {
                        Link now = links.get(i);
                        Link before = links.get(i - 1);
                        assumingThat(now.isLinked(), () -> assertThat(before).isEqualTo(UNLINKED));
                    });
        }
    }
}
