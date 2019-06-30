package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String DELIMITER_NAMES = ",";

    private List<Player> players;
    private int height;

    public LadderGame(String names, int height) {
        this.players = generatePlayer(names);
        this.height = height;
    }

    public Ladder generate(LineStrategy strategy) {
        ArrayList lines = new ArrayList<>();
        for (int i = 0 ; i < height ; i++ ) {
            Line line = new Line(players.size(), strategy);

            lines.add(line);
        }

        return new Ladder(lines);
    }

    private List<Player> generatePlayer(String names) {
        String[] rawNames = names.split(DELIMITER_NAMES);
        if (isThereTooLong(rawNames)) {
            throw new IllegalArgumentException("이름은 최대 5자까지 설정할 수 있습니다.");
        }

        return Arrays.stream(rawNames)
                .map(name -> new Player(name))
                .collect(Collectors.toList());
    }

    private boolean isThereTooLong(String[] rawNames) {
        return Arrays.stream(rawNames)
                .anyMatch(name -> name.length() > 5);
    }
}
