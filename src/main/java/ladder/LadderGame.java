package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {
    private static final String DELIMITER_NAMES = ",";

    private List<String> players;
    private int height;

    public LadderGame(String names, int height) {
        this.players = generatePlayer(names);
        this.height = height;
    }

    public List<Line> generate(LineStrategy strategy) {
        ArrayList ladder = new ArrayList<>();
        for (int i = 0 ; i < height ; i++ ) {
            Line line = new Line(players.size(), strategy);

            ladder.add(line);
        }

        return ladder;
    }

    private List<String> generatePlayer(String names) {
        return Arrays.asList(names.split(DELIMITER_NAMES));
    }
}
