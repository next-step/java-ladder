package step2.view;

import step2.domain.ExecutionResults;
import step2.domain.Ladder;

public class OutputView {

    public void printLadder(Ladder ladder, ExecutionResults executionResults) {
        System.out.println("\n사다리 결과\n");
        System.out.print(ladder.print());
        System.out.println(executionResults.print());
    }

}
