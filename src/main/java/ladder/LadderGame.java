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
        String[] rawNames = names.split(DELIMITER_NAMES);
        if (isThereTooLong(rawNames)) {
            throw new IllegalArgumentException("이름은 최대 5자까지 설정할 수 있습니다.");
        }

        return Arrays.asList(rawNames);
    }

    private boolean isThereTooLong(String[] rawNames) {
        return Arrays.stream(rawNames)
                .filter(name -> name.length() > 5)
                .findFirst()
                .isPresent();
    }
}
