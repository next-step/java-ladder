package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.result.MatchResult;
import nextstep.ladder.dto.PlayerResult;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    private static final String SEPARATOR = "|";
    private static final String LINE = getMark("-");
    private static final String BLANK = getMark(" ");
    private static final Scanner SCANNER = new Scanner(System.in);

    private static String getMark(String mark) {
        return Stream.of(new String[Player.NAME_LIMIT])
                .map(i -> mark)
                .collect(Collectors.joining());
    }

    public void view(MatchResult matchResult, Ladder ladder) {
        StringBuilder ladderGameInfo = new StringBuilder();
        ladderGameInfo.append("\n실행결과물\n");
        ladderGameInfo.append(getPlayerOutput(matchResult)).append(System.lineSeparator());
        ladderGameInfo.append(getLadderOutput(ladder)).append(System.lineSeparator());
        ladderGameInfo.append(getLadderResultOutput(matchResult)).append(System.lineSeparator());
        System.out.println(ladderGameInfo);

        viewLadderResult(matchResult);
    }

    private String getPlayerOutput(MatchResult matchResult) {
        List<String> playerNames = matchResult.allPlayResults().stream()
                .map(PlayerResult::getPlayerName)
                .collect(Collectors.toList());
        return viewList(playerNames);
    }

    private String viewList(Collection<String> toView) {
        return toView.stream()
                .map(name -> getWhiteSpace(name) + name)
                .collect(Collectors.joining(" "));
    }

    private String getWhiteSpace(String name) {
        return Stream.of(new String[Player.NAME_LIMIT - name.length()])
                .map(i -> " ")
                .collect(Collectors.joining());
    }

    private String getLadderOutput(Ladder ladder) {
        return ladder.ladderLines().stream()
                .map(this::getLines)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String getLines(Collection<Boolean> lines) {
        return lines.stream()
                .map(isLine -> isLine ? LINE : BLANK)
                .collect(Collectors.joining(SEPARATOR, BLANK + SEPARATOR, SEPARATOR));
    }

    private String getLadderResultOutput(MatchResult matchResult) {
        return viewList(matchResult.ladderResults());
    }

    public void viewLadderResult(MatchResult matchResult) {
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