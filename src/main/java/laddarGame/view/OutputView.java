package laddarGame.view;

import laddarGame.dto.LineDto;
import laddarGame.dto.LinesDto;
import laddarGame.dto.PlayerDto;
import laddarGame.dto.PlayersDto;

import java.util.Comparator;
import java.util.List;

public class OutputView {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int DEFAULT_LENGTH = 1;
    private static final String BLANK = " ";
    private static int maxNameLength;

    public static void print(LinesDto linesDto, PlayersDto playersDto) {
        printPlayer(playersDto);
        maxNameLength = maxNameLength(playersDto);
        linesDto.getLineDto()
                .stream()
                .map(LineDto::getLine)
                .forEach(OutputView::printLadder);
    }

    private static int maxNameLength(PlayersDto playersDto) {
        return playersDto.getPlayerList()
                .stream()
                .max(Comparator.comparing(PlayerDto::getPlayerLength))
                .map(PlayerDto::getPlayerLength)
                .orElse(DEFAULT_LENGTH);
    }

    private static void printLadder(List<Boolean> line) {
        System.out.print(BLANK.repeat(maxNameLength));
        line.forEach(point -> System.out.print(Ladder.valueOf(point)));
        System.out.print("|\n");
    }

    public static void printPlayer(PlayersDto playersDto) {
        System.out.println("실행 결과");
        System.out.print(BLANK);
        playersDto.getPlayerList()
                .stream()
                .map(OutputView::toName)
                .forEach(System.out::print);
        System.out.println();
    }

    public static String toName(PlayerDto playerDto) {
        String name = playerDto.getName();
        int blankLength = MAX_NAME_LENGTH - name.length();
        return name + BLANK.repeat(blankLength) + BLANK;
    }
}
