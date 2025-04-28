package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.name.Name;
import nextstep.ladder.domain.name.Names;

public class ResultView {
    public static void result(Names names, Ladder ladder) {
        System.out.println("\n실행결과\n");
        for(Name name: names.values()) {
            System.out.printf("%-5s ", name.toString());
        }

        names.values()
                .stream()
                .map(name -> System.out.printf("%-5s ", name));

        System.out.println("");

        for(Line line: ladder.values()) {
            System.out.println("    " + line.toString());
        }
    }
}
