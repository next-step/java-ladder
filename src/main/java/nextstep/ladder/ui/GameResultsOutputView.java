package nextstep.ladder.ui;

import nextstep.ladder.domain.gameresult.GameResults;

import java.util.stream.Collectors;

public class GameResultsOutputView {
    private static final String RESULT_HEAD_COMMENT =  System.lineSeparator() + "실행 결과" + System.lineSeparator();
    private static final String ALL_RESULT_SEPARATOR = " : ";
    private GameResults gameResults;

    public GameResultsOutputView(GameResults gameResults) {
        this.gameResults = gameResults;
    }

    public String parseIndividualResult(String userName) {
        return RESULT_HEAD_COMMENT + gameResults.findByPlayerName(userName).getRewardName();
    }

    public String parseAllResults() {
        return RESULT_HEAD_COMMENT + this.gameResults.getValues().stream()
                .map(gameResult -> gameResult.getPlayerName() +
                        ALL_RESULT_SEPARATOR + gameResult.getRewardName() + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
