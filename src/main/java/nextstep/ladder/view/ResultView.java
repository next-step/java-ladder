package nextstep.ladder.view;

import nextstep.ladder.dto.LadderDto;
import nextstep.ladder.dto.LineDto;
import nextstep.ladder.dto.NameDto;
import nextstep.ladder.dto.NamesDto;

import java.util.List;

public class ResultView {
    public static void printNames(NamesDto dto) {
        List<NameDto> names = dto.getNames();
        for (NameDto name : names) {
            System.out.printf("%6s", name.getName());
        }
        System.out.println();
    }

    public static void printLadder(LadderDto dto) {
        List<LineDto> ladder = dto.getLadder();
        for (LineDto lineDto : ladder) {
            printLine(lineDto);
        }
    }

    private static void printLine(LineDto lineDto) {
        List<Boolean> line = lineDto.getLine();
        StringBuilder sb = new StringBuilder();
        sb.append("     |");
        for (Boolean point : line) {
            sb.append(pointToString(point));
            sb.append("|");
        }
        System.out.println(sb);
    }

    private static String pointToString(Boolean point) {
        if (point) {
            return "-----";
        }
        return "     ";
    }
}
