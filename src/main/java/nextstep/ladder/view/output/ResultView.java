package nextstep.ladder.view.output;

import nextstep.ladder.Visible;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.result.MatchResult;

import java.util.Scanner;
import java.util.stream.Collectors;

public class ResultView implements Visible {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void view(MatchResult matchResult, Ladder ladder) {
        String player = "";
        StringBuilder stringBuilder = new StringBuilder();
        while (!"all".equalsIgnoreCase(player)) {
            System.out.println("\n결과를 보고 싶은 사람은?");
            player = SCANNER.nextLine();

            stringBuilder.append("\n").append("실행결과\n").append(getResult(player, matchResult));
            System.out.println(stringBuilder);
            stringBuilder.setLength(0);
        }
    }

    private String getResult(String player, MatchResult matchResult) {
        if ("all".equalsIgnoreCase(player)) {
            return allPlayerResults(matchResult);
        }
        return matchResult.playResult(player).getResult();
    }

    private String allPlayerResults(MatchResult matchResult) {
        return matchResult.allPlayResults().stream()
                .map(playerResult -> String.format("%s : %s", playerResult.getPlayerName(), playerResult.getResult()))
                .collect(Collectors.joining("\n"));
    }
}
