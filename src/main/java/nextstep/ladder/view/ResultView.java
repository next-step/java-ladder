package nextstep.ladder.view;

import nextstep.ladder.domain.Ladders;
import nextstep.ladder.domain.LaddersResults;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.PlayerName;
import nextstep.ladder.dto.PlayersDto;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String EXISTED_LINE = "|-----";
    private static final String NOT_EXISTED_LINE = "|     ";
    private static final String BLANK = "    ";

    public void printPlayersName(PlayersDto players) {
        StringBuilder playerNameBuilder = new StringBuilder();
        System.out.println("실행 결과");
        players.getPlayers()
                .forEach(playerDto -> {
                    playerNameBuilder.append(playerDto.getPlayerName()).append(BLANK);
                });
        System.out.println(playerNameBuilder);
    }

    public void printLadders(Ladders ladders) {
        ladders.getLines()
                .stream()
                .map(Line::getPoints)
                .forEach(this::printLines);
    }

    private void printLines(List<Boolean> booleans) {
        StringBuilder lineBuilder = new StringBuilder();
        booleans.forEach(line -> {
            if (line) {
                lineBuilder.append(EXISTED_LINE);
                return;
            }
            lineBuilder.append(NOT_EXISTED_LINE);
        });
        System.out.println(lineBuilder);
    }

    public void printLaddersResults(LaddersResults laddersResults) {
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
}
