package laddarGame.view;

import laddarGame.dto.LineDto;
import laddarGame.dto.LinesDto;
import laddarGame.dto.PlayerDto;
import laddarGame.dto.PlayersDto;

import java.util.List;

public class OutputView {

    private static final int MAX_NAME_LENGTH = 5;
    
    public static void print(LinesDto linesDto, PlayersDto playersDto) {
        printPlayer(playersDto);
        List<LineDto> lineDtoList = linesDto.getLineDto();
        for (LineDto lineDto : lineDtoList) {
            List<Boolean> line = lineDto.getLine();
            printLadder(line);
        }
    }

    private static void printLadder(List<Boolean> line) {
        for (Boolean point : line) {
            System.out.print(Ladder.valueOf(point));
        }
        System.out.println();
    }

    public static void printPlayer(PlayersDto playersDto) {
        System.out.println("실행 결과");
        System.out.print(" ");
        playersDto.getPlayerList()
                .stream()
                .map(OutputView::toName)
                .forEach(System.out::print);
        System.out.println();
    }

    public static String toName(PlayerDto playerDto) {
        String name = playerDto.getName();
        int blankLength = MAX_NAME_LENGTH - name.length();
        return name + " ".repeat(blankLength) + " ";
    }
}
