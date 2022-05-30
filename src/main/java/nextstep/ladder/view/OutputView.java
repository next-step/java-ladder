package nextstep.ladder.view;

import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.member.Members;
import nextstep.ladder.domain.runresult.RunResult;
import nextstep.ladder.domain.runresult.RunResults;

public class OutputView {
    public static void outputLadder(Members members, Lines lines, RunResults runResults) {
        System.out.println(members.getPrettyString());
        System.out.println(lines.getPoints());
        System.out.println(runResults);
    }

    public static void output(RunResult runResult) {
        System.out.println(runResult);
    }

    public static void outputRunResults(RunResults runResults, Members members) {
        runResults.printResults(members);
    }
}
