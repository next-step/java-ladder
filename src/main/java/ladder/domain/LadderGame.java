package ladder.domain;

import ladder.domain.strategy.LineEvenStrategy;
import ladder.domain.strategy.LineOddStrategy;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String DELIMITER_NAMES = ",";

    private Players players;
    private int height;

    public LadderGame(String names, int height) {
        this.players = generatePlayer(names);
        this.height = height;
    }

    public void start() {
        Ladder ladder = generate();

        ResultView.printUsers(this.players);
        ResultView.printLadder(players.getMaxNameLength(), ladder);
    }

    public Ladder generate() {
        ArrayList lines = new ArrayList<>();
        for (int i = 0 ; i < height ; i++ ) {
            Line line = new Line(players.size() - 1, getStrategy(i));

            lines.add(line);
        }

        return new Ladder(lines);
    }

    private LineStrategy getStrategy(int lineNo) {
        if (lineNo % 2 == 0) {
            return new LineEvenStrategy();
        }

        return new LineOddStrategy();
    }

    private Players generatePlayer(String names) {
        String[] rawNames = names.split(DELIMITER_NAMES);
        if (isThereTooLong(rawNames)) {
            throw new IllegalArgumentException("이름은 최대 5자까지 설정할 수 있습니다.");
        }

        return new Players(Arrays.stream(rawNames)
                .map(name -> new Player(name))
                .collect(Collectors.toList()));
    }

    private boolean isThereTooLong(String[] rawNames) {
        return Arrays.stream(rawNames)
                .anyMatch(name -> name.length() > 5);
    }
}
