package ladder;


import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.LadderResults;
import ladder.io.InputHandler;
import ladder.io.OutputHandler;

import java.util.List;

public class LadderGame {

    public static final String ALL = "all";
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public LadderGame(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        // 참여하는 사람 이름 입력
        outputHandler.showCommentForNamesOfPlayers();
        List<String> namesOfPeopleFromUser = inputHandler.getNamesOfPlayersFromUser();
        Players players = Players.of(namesOfPeopleFromUser);

        // 실행 결과 입력
        outputHandler.showCommentForPlayResults();
        List<String> playResultsFromUser = inputHandler.getPlayResultsFromUser();
        LadderResults ladderResults = LadderResults.of(playResultsFromUser);

        // 사다리 높이 입력
        outputHandler.showCommentForHeightOfLadder();
        int heightOfLadder = inputHandler.getHeightOfLadderFromUser();
        Ladder ladder = Ladder.of(heightOfLadder, namesOfPeopleFromUser.size());

        // 사다리 결과 출력
        outputHandler.showLadderGameResult(players, ladder, ladderResults);

        // 결과 출력
        ladderResults.processLadderGameOutcomes(players, ladder);
        while (processResultRequest(ladderResults)) {}
    }

    private boolean processResultRequest(LadderResults ladderResults) {
        outputHandler.showCommentForWhoseResultWantToSee();
        String playerName = inputHandler.getPlayerNameForResultFromUser();
        if (isRequestForAllResults(playerName)) {
            outputHandler.showAllResults(ladderResults);
            return false;
        }
        outputHandler.showResultForPlayer(playerName, ladderResults);
        return true;
    }

    private boolean isRequestForAllResults(String playerName) {
        return playerName.equals(ALL);
    }

}
