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
        StringBuilder sb = new StringBuilder();
        System.out.println("실행 결과");
        players.getPlayers()
                .forEach(playerDto -> {
                    sb.append(playerDto.getPlayerName()).append(BLANK);
                });
        System.out.println(sb);
    }

    public void printLadders(Ladders ladders) {
        ladders.getLines()
                .stream()
                .map(Line::getPoints)
                .forEach(this::printLines);
    }

    private void printLines(List<Boolean> booleans) {
        StringBuilder sb = new StringBuilder();
        booleans.forEach(line -> {
            if (line) {
                sb.append(EXISTED_LINE);
                return;
            }
            sb.append(NOT_EXISTED_LINE);
        });
        System.out.println(sb);
    }

    public void printLaddersResults(LaddersResults laddersResults) {
        StringBuilder sb = new StringBuilder();
        laddersResults.getLadderResults()
                .forEach(result -> sb.append(result).append(BLANK));
        System.out.println(sb);
    }

    public void printPlayerResult(Map<PlayerName, String> result) {
        System.out.println("실행 결과");
        for (Map.Entry<PlayerName, String> resultSet : result.entrySet()) {
            System.out.println(resultSet.getKey().getPlayerName() + " : " + resultSet.getValue());
        }
    }
}
