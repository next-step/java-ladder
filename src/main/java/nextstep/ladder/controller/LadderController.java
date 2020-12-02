package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

    public static final String ALL = "all";

    public static Players getPlayers() {
        String names = InputView.getNames();
        return Players.from(names);
    }

    public static int getHeight() {
        return InputView.getHeight();
    }

    public static Lines createLines(Players players, int height) {
        return Lines.fromHeight(players.getSize() - 1, height, new ConnectionCreationStrategyImpl());
    }

    public static void showPlayers(Players players) {
        OutputView.showPlayers(players);
    }

    public static void showLines(Lines lines) {
        OutputView.showLines(lines);
    }

    public static Results getResults(int size) {
        return Results.from(size, InputView.getResults());
    }

    public static void showResults(Results results) {
        OutputView.showResults(results);
    }

    public static PlayersOnLine climb(Players players, Lines lines) {
        LadderClimber ladderClimber = new LadderClimber(players, lines);
        return ladderClimber.climb().getLast();
    }

    public static Matches match(PlayersOnLine lastPlayersOnLine, Results results) {
        return ResultMatcher.match(lastPlayersOnLine, results);
    }

    public static String getNameToFind() {
        return InputView.getNameToFind();
    }

    public static void showMatchResult(Matches matches, String nameToFind) {
        OutputView.showMatchResult();

        if (nameToFind.equals(ALL)) {
            OutputView.showMatches(matches);
            return;
        }
        Result result = matches.find(nameToFind);
        OutputView.showMatch(result);
    }
}
