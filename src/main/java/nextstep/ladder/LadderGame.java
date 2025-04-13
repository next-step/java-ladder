package nextstep.ladder;

import java.util.List;

import nextstep.ladder.model.ladder.Height;
import nextstep.ladder.model.ladder.Ladder;
import nextstep.ladder.model.result.LadderResult;
import nextstep.ladder.model.player.Players;
import nextstep.ladder.model.result.Result;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
    private static final String ALL_RESULTS = "all";
    
    public static void main(final String[] args) {
        Players players = InputView.inputPlayers();
        List<Result> results = InputView.inputResults();
        Height height = InputView.inputHeight();
        
        Ladder ladder = new Ladder(players, height);
        LadderResult ladderResult = new LadderResult(players, results, ladder);
        
        ResultView.displayLadder(ladder, players, results);
        processResultQueries(players, ladderResult);
    }
    
    private static void processResultQueries(final Players players, final LadderResult ladderResult) {
        while (true) {
            String query = InputView.inputResultQuery();
            if (query.isBlank()) {
                break;
            }
            
            if (query.equalsIgnoreCase(ALL_RESULTS)) {
                ResultView.displayAllResults(ladderResult);
                continue;
            }

            ResultView.displaySingleResult(query, players, ladderResult);
        }
    }
}
