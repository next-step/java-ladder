package nextstep.ladder.view;

import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.model.ladder.Ladder;
import nextstep.ladder.model.result.LadderResult;
import nextstep.ladder.model.player.Player;
import nextstep.ladder.model.player.Players;
import nextstep.ladder.model.result.Result;

public class ResultView {
    
    public static void displayLadder(final Ladder ladder, final Players players, final List<Result> results) {
        System.out.println("\n사다리 결과\n");
        LadderPrinter.print(ladder, players);
        System.out.println(results.stream().map(Result::getValue).collect(Collectors.joining("    ")));
    }
    
    public static void displaySingleResult(final String playerName, final Players players, final LadderResult ladderResult) {
        System.out.println("\n실행 결과");
        players.findByName(playerName)
                .ifPresentOrElse(
                        player -> System.out.println(ladderResult.getResult(player).getValue()),
                        () -> System.out.println("해당하는 참가자를 찾을 수 없습니다."));
    }
    
    public static void displayAllResults(final LadderResult ladderResult) {
        System.out.println("\n실행 결과");
        ladderResult.getAllResults()
                .forEach((key, value) -> System.out.println(key.getName() + " : " + value.getValue()));
    }
}
