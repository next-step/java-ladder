package nextstep.ladder;

import java.util.List;

import nextstep.ladder.model.ladder.Height;
import nextstep.ladder.model.ladder.Ladder;
import nextstep.ladder.model.ladder.LadderFactory;
import nextstep.ladder.model.result.LadderResult;
import nextstep.ladder.model.player.Players;
import nextstep.ladder.model.result.Result;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
    
    public static void main(final String[] args) {
        Players players = InputView.inputPlayers();
        List<Result> results = InputView.inputResults();
        Height height = InputView.inputHeight();
        
        Ladder ladder = LadderFactory.create(players, height);
        LadderResult ladderResult = new LadderResult(players, results, ladder);
        
        ResultView.displayLadder(ladder, players, results);
        processResultQueries(players, ladderResult);
    }
    
    private static void processResultQueries(final Players players, final LadderResult ladderResult) {
        String query = InputView.inputResultQuery();
        while (!query.isBlank()) {
            processQuery(query, players, ladderResult);
            query = InputView.inputResultQuery();
        }
    }
    
    private static void processQuery(String query, Players players, LadderResult ladderResult) {
        if (query.equalsIgnoreCase(InputView.ALL_RESULTS)) {
            ResultView.displayAllResults(ladderResult);
            return;
        }

        ResultView.displaySingleResult(query, players, ladderResult);
    }
}
