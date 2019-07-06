package ladder.domain;

import ladder.domain.strategy.FakeGenerator;
import ladder.domain.strategy.RandomGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String DELIMITER_INPUTS = ",";
    private static final int MAX_INPUT_NAME_LENGTH = 5;

    private Players players;
    private List<String> result;
    private int height;

    public LadderGame(String names, String result, int height) {
        this.players = generatePlayer(names);
        this.result = generateResult(result);
        this.height = height;
    }

    public void start() {
        Ladder ladder = Ladder.of(height, players.size(), new RandomGenerator());

        ResultView.printUsers(this.players);

        ResultView.printLadder(ladder, players.getMaxNameLength());

        ResultView.printResults(result);

        String answer;
        answer = InputView.promptThenString("결과를 보고 싶은 사람은?");
        while (!answer.equals("all")) {
            ResultView.printPlayerResult(getPlayerResult(answer, ladder));
            answer = InputView.promptThenString("결과를 보고 싶은 사람은?");
        }

        ResultView.printGameResult(players.getPlayersNames(), getGameResults(ladder));
    }

    private List<String> getGameResults(Ladder ladder) {
        return players.getPlayersNames().stream()
                .map(name -> getPlayerResult(name, ladder))
                .collect(Collectors.toList());
    }

    private String getPlayerResult(String playerName, Ladder ladder) {
        int move = players.move(playerName, ladder);
        return result.get(move);
    }

    private Players generatePlayer(String names) {
        String[] rawNames = names.split(DELIMITER_INPUTS);
        if (isThereTooLong(rawNames)) {
            throw new IllegalArgumentException("이름은 최대 5자까지 설정할 수 있습니다.");
        }

        return new Players(Arrays.stream(rawNames)
                .map(name -> new Player(name))
                .collect(Collectors.toList()));
    }

    private List<String> generateResult(String results) {
        String[] rawNames = results.split(DELIMITER_INPUTS);

        return Arrays.asList(rawNames);
    }

    private boolean isThereTooLong(String[] rawNames) {
        return Arrays.stream(rawNames)
                .anyMatch(name -> name.length() > MAX_INPUT_NAME_LENGTH);
    }
}
