package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.utils.StringUtils;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Application {
    private static final String ALL = "all";

    public static void main(String[] args) {
        Players players = getPlayers();

        Results results = getResults(players.playersCount());
        int ladderHeight = InputView.askLadderHeight();

        Lines lines = LinesFactory.of(ladderHeight, new RandomBooleanListGenerator(players.playersCount()));

        Ladder ladder = Ladder.from(lines);

        OutputView.printLadder(players, ladder, results);

        LadderResult ladderResult = LadderResult.from(players, ladder, results);


        String playerName = InputView.askResultOfPlayer();

        while (!playerName.equals(ALL)) {
            Player player = Player.from(playerName);

            Player findPlayer = players.findPlayer(player);

            Result resultOfPlayer = ladderResult.resultOfPlayer(findPlayer);

            OutputView.printResult(resultOfPlayer);

            playerName = InputView.askResultOfPlayer();
        }
        OutputView.printLadderResult(ladderResult);
    }

    private static Players getPlayers() {
        String playerssName = InputView.askPlayerssName();
        String[] names = StringUtils.split(playerssName);
        try {
            return Players.from(names);
        } catch (IllegalArgumentException e) {
            OutputView.printPlayersCountError();
            return getPlayers();
        }
    }

    private static Results getResults(int count) {
        String resultsName = InputView.askResults();
        String[] results = StringUtils.split(resultsName);

        if (results.length != count) {
            System.out.println("실행 결과의 개수는 참여자 인원만큼 입력하세요");
            return getResults(count);
        }

        return Results.from(results);
    }
}
