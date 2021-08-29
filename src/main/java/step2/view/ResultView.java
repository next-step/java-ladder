package step2.view;

import step2.domain.Line;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String LADDER_HORIZON = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final String NAME_SPACE = "   ";
    private static final String GUIDE_HEAD_LINE = "실행 결과";

    public void printHeader() {
        System.out.println(GUIDE_HEAD_LINE);
    }

    public void printParticipant(List<String> participantNameList) {
        participantNameList.stream()
                .map(s -> s + NAME_SPACE)
                .forEach(System.out::print);
        System.out.println();
    }

    public void printLadderResult(List<Line> lines) {
        lines.stream()
                .map(this::printByLine)
                .forEach(System.out::println);
    }



    public String printByLine(Line line) {
        return line.getPoints()
                .stream()
                .map(this::printByPoint)
                .collect(Collectors.joining(LADDER_VERTICAL_LINE, LADDER_VERTICAL_LINE, LADDER_VERTICAL_LINE));
    }

    public String printByPoint(Boolean point) {
        if (point) {
            return LADDER_HORIZON;
        }
        return LADDER_EMPTY;
    }
}
