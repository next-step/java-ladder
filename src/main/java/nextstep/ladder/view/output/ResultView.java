package nextstep.ladder.view.output;

import nextstep.ladder.Visible;
import nextstep.ladder.domain.MatchResult;
import nextstep.ladder.dto.ViewDto;

import java.util.Scanner;
import java.util.stream.Collectors;

public class ResultView implements Visible {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void view(ViewDto viewDto) {
        String player = "";
        MatchResult matchResult = viewDto.getLadderResult();
        while (!"all".equalsIgnoreCase(player)) {
            System.out.println();
            System.out.println("결과를 보고 싶은 사람은?");
            player = SCANNER.nextLine();

            System.out.println();
            System.out.println("실행결과");
            System.out.println(getResult(player, matchResult));
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
