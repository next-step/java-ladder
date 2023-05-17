package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LadderGeneratorTest {

    @Test
    @DisplayName("옆 라인과 겹치게 다리를 지을 수 없다.")
    void testBridgeDoesNotOverlapWithAdjacentBridges() {
        GameUsers users = getGameUsers();
        int height = 5;
        Ladder ladder = new Ladder(height, users.getUserCount());
        LadderGenerator ladderGenerator = new LadderGenerator(() -> true);

        Ladder result = ladderGenerator.buildBridges(ladder);
        ArrayList<Line> lines = result.getLines();

        IntStream.range(1, lines.size())
                .forEach(i -> IntStream.range(0, height)
                        .forEach(h -> {
                            System.out.println(lines.get(i - 1));
                            assertFalse(lines.get(i - 1).isPresent(h) && lines.get(i).isPresent(h));
                        }));
    }

    private GameUsers getGameUsers() {
        return new GameUsers(
                Arrays.asList("name1", "name2", "name3")
        );
    }
}
