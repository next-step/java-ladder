package step4.view;

import java.util.List;

import step4.domain.LadderLine;
import step4.domain.Player;
import step4.domain.Point;
import step4.domain.Prize;
import step4.dto.LaddersDto;
import step4.dto.PlayersDto;
import step4.dto.PrizesDto;

public class ResultView {
    private static final String MESSAGE_RESULT = "실행결과";
    private static final String CONNECT = "-----|";
    private static final String DIS_CONNECT = "     |";

    private ResultView() {
    }

    public static void printLadderView(LaddersDto laddersDto, PlayersDto playersDto, PrizesDto prizesDto) {
        printPlayerNames(playersDto.getPlayers());
        printLadder(laddersDto.getLadderLines());
        printPrize(prizesDto.getPrizes());
    }

    public static void printPlayerNames(List<Player> players) {
        System.out.println(MESSAGE_RESULT);
        players.stream().forEach(player -> {
            System.out.print(String.format("%6s", player.playerName()));
        });
        System.out.println();
    }

    public static void printLadder(List<LadderLine> lines) {
        lines.forEach(line -> {
            line.points().stream()
                .map(Point::direction)
                .forEach(direction -> System.out.print(direction.isRight() ? CONNECT : DIS_CONNECT));
            System.out.println();
        });
    }

    public static void printPrize(List<Prize> prizes) {
        prizes.stream().forEach(prize -> {
            System.out.print(String.format("%6s", prize.prize()));
        });
        System.out.println();
    }
}
