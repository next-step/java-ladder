package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.name.Name;
import nextstep.ladder.domain.name.Names;

import java.util.stream.Collectors;

public class ResultView {
    public static void result(Names names, Ladder ladder) {
        System.out.println("\n실행결과\n");
        for(Name name: names.values()) {
            System.out.printf("%-5s ", name.toString());
        }

        for(Line line: ladder.values()) {
            System.out.println("    " + line.toString());
        }

        ladder.values()
                .stream()
                .map(line -> "    " + viewLine(line));

    }

    private static String viewLine(Line line) {
        return line.values().stream()
                .map(b -> b ? "|-----" : "|     ")
                .collect(Collectors.joining())
                + "|";
    }
}
