package nextstep.ladder.view;

import java.util.Map;
import java.util.Map.Entry;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.dto.CommaSeparatedResult;
import nextstep.ladder.dto.ResultDto;

public class OutputView {

    private static final String EMPTY = "     ";
    private static final String LINE = "-----";
    private static final String HORIZONTAL_LINE = "|";
    private static final String ALL = "all";
    private static final int NAME_PADDING = 6;
    private static final int RESULT_PADDING = 5;

    public static void renderLadder(CommaSeparatedResult names, Ladder ladder, CommaSeparatedResult results) {
        System.out.println("사다리 결과");
        renderName(names);
        renderLadder(ladder);
        renderResult(results);
    }

    private static void renderName(CommaSeparatedResult commaSeparatedResult) {
        for (String name : commaSeparatedResult.getValuesByString()) {
            System.out.printf(" ".repeat(NAME_PADDING - name.length()) + name);
        }
        System.out.println();
    }

    private static void renderLadder(Ladder ladder) {
        for (Lines lines : ladder.getLines()) {
            System.out.print(EMPTY);
            System.out.print(HORIZONTAL_LINE);
            renderLine(lines);
            System.out.println();
        }
    }

    private static void renderResult(CommaSeparatedResult commaSeparatedResult) {
        for (String result : commaSeparatedResult.getValuesByString()) {
            System.out.printf(" " + result + " ".repeat(RESULT_PADDING - result.length()));
        }
        System.out.println();
    }

    private static void renderLine(Lines lines) {
        for (Boolean point : lines.getLines()) {
            System.out.print(pointFormat(point));
            System.out.print(HORIZONTAL_LINE);
        }
    }

    private static String pointFormat(Boolean line) {
        if (line) {
            return LINE;
        }
        return EMPTY;
    }

    public static void renderResult(ResultDto resultDto, String name) {
        System.out.println("실행결과");
        if (name.equalsIgnoreCase(ALL)) {
            renderAllResult(resultDto);
            return;
        }
        renderNameResult(resultDto.findResult(name));
    }

    private static void renderAllResult(ResultDto resultDto) {
        Map<String, String> map = resultDto.allResult();
        for (Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
        }
    }

    private static void renderNameResult(String result) {
        System.out.println(result);
    }
}
