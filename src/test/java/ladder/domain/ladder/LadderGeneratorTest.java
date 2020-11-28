package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import ladder.domain.Position;
import ladder.domain.direction.DirectionStrategy;
import ladder.domain.line.LineGenerator;
import ladder.domain.model.LadderGameInfo;
import ladder.domain.point.PointGenerator;
import ladder.domain.user.User;
import ladder.domain.user.Users;
import org.junit.jupiter.api.Test;

class LadderGeneratorTest {

    private final LineGenerator lineGenerator = new LineGenerator(new PointGenerator(new DirectionStrategy(() -> 1)));
    private final LadderGenerator ladderGenerator = new LadderGenerator(lineGenerator);

    @Test
    void generateLadder() {
        User participant1 = User.of("a", new Position(0));
        User participant2 = User.of("b", new Position(1));
        Users participants = new Users(Arrays.asList(participant1, participant2));

        LadderHeight ladderHeight = new LadderHeight(1);

        LadderGameInfo ladderGameInfo = new LadderGameInfo(participants, ladderHeight);

        assertThat(ladderGenerator.generateLadder(ladderGameInfo))
            .isEqualTo(new Ladder(Arrays.asList(lineGenerator.generateLine(participants))));
    }
}