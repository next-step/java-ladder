package ladder.domain;

import ladder.domain.strategy.RandomGenerator;
import ladder.view.ResultView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String DELIMITER_NAMES = ",";
    private static final int MAX_INPUT_NAME_LENGTH = 5;

    private Players players;
    private int height;

    public LadderGame(String names, int height) {
        this.players = generatePlayer(names);
        this.height = height;
    }

    public void start() {
        Ladder ladder = Ladder.of(height, players.size(), new RandomGenerator());

        ResultView.printUsers(this.players);
        ResultView.printLadder(ladder, players.getMaxNameLength());
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
                .anyMatch(name -> name.length() > MAX_INPUT_NAME_LENGTH);
    }
}
