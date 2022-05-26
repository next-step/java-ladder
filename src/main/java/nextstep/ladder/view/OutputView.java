package nextstep.ladder.view;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.RunResults;

public class OutputView {
    public static void outputLadder(Members members, Lines lines, RunResults runResults) {
        System.out.println(members.getPrettyString());
        System.out.println(lines.getPoints());
        System.out.println(runResults);
    }
}
