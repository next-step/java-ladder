package nextstep.ladder.view;

import nextstep.ladder.dto.*;

import java.util.List;
import java.util.Map;

public class ResultView {

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

    public static void printGamers(GamersDto dto) {
        List<GamerDto> gamers = dto.getGamers();
        for (GamerDto gamer : gamers) {
            System.out.printf("%6s", gamer.getName());
        }
        System.out.println();
    }

    public static void printResultTarget(ExecutionResultDto dto, String target) {
        Map<String, String> results = dto.getResults();
        if ("all".equals(target)) {
            printResultAll(dto);
            return;
        }
        System.out.println("실행결과");
        System.out.println(results.get(target));
    }

    private static void printResultAll(ExecutionResultDto dto) {
        Map<String, String> results = dto.getResults();
        StringBuilder sb = new StringBuilder();
        System.out.println("실행결과");
        for (Map.Entry<String, String> entry : results.entrySet()) {
            sb.append(entry.getKey());
            sb.append(" : ");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void printResult(List<String> results) {
        for (String result : results) {
            System.out.printf("%6s", result);
        }
        System.out.println();
    }
}
