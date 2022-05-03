package nextstep.ladder.view;

import nextstep.ladder.domain.*;
import nextstep.ladder.dto.PlayersDto;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String EXISTED_LINE = "|-----";
    private static final String NOT_EXISTED_LINE = "|     ";
    private static final String BLANK = "    ";

    private void printPlayersName(PlayersDto players) {
        StringBuilder playerNameBuilder = new StringBuilder();
        System.out.println("실행 결과");
        players.getPlayers()
                .forEach(playerDto -> {
                    playerNameBuilder.append(playerDto.getPlayerName()).append(BLANK);
                });
        System.out.println(playerNameBuilder);
    }

    private void printLadders(Ladders ladders) {
        ladders.getLines()
                .stream()
                .map(Line::getPoints)
                .forEach(this::printLines);
    }

    private void printLines(List<Point> booleans) {
        StringBuilder lineBuilder = new StringBuilder();
        booleans.forEach(line -> {
            if (line.isTrue()) {
                lineBuilder.append(EXISTED_LINE);
                return;
            }
            lineBuilder.append(NOT_EXISTED_LINE);
        });
        System.out.println(lineBuilder);
    }

    private void printLaddersResults(LaddersResults laddersResults) {
        StringBuilder ladderBuilder = new StringBuilder();
        laddersResults.getLadderResults()
                .forEach(result -> ladderBuilder.append(result).append(BLANK));
        System.out.println(ladderBuilder);
    }

    public void printPlayerResult(Map<PlayerName, String> result) {
        System.out.println("실행 결과");
        StringBuilder ladderResultBuilder = new StringBuilder();
        for (Map.Entry<PlayerName, String> resultSet : result.entrySet()) {
            ladderResultBuilder
                    .append(resultSet.getKey().getPlayerName())
                    .append(" : ")
                    .append(resultSet.getValue())
                    .append("\n");
        }
        System.out.println(ladderResultBuilder);
    }

    public void printLadderStatus(PlayersDto playersDto, Ladders ladders, LaddersResults laddersResults) {
        printPlayersName(playersDto);
        printLadders(ladders);
        printLaddersResults(laddersResults);
    }
}
