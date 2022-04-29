package nextstep.ladder;

import nextstep.ladder.dto.PlayersDto;

import java.util.List;

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
        booleans.forEach(line -> {
            if (line) {
                System.out.print(EXISTED_LINE);
                return;
            }
            System.out.print(NOT_EXISTED_LINE);
        });
        System.out.println();
    }
}
