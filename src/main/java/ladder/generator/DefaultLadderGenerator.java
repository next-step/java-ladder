package ladder.generator;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.Line;
import ladder.domain.user.LadderPlayers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLadderGenerator implements LadderGenerator {

    private final LineGenerator lineGenerator;
    private final LadderPlayers players;
    private final LadderHeight height;

    public DefaultLadderGenerator(LineGenerator lineGenerator, LadderPlayers players, LadderHeight height) {
        this.lineGenerator = lineGenerator;
        this.players = players;
        this.height = height;
    }

    @Override
    public Ladder generate() {
        List<Line> lines = IntStream.range(0, height.getHeight())
                .mapToObj(range -> lineGenerator.generate(players.size()))
                .collect(Collectors.toList());
        return Ladder.createLadder(lines);
    }

}
