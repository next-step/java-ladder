package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Ladder;

public class OutputView {

    public static final String EXECUTION_RESULT_MESSAGE = "실행결과\n";

    public void printLadderExecutionResult(List<String> participantsName, Ladder ladder) {
        System.out.println(EXECUTION_RESULT_MESSAGE);
        for (String name : participantsName) {
            System.out.print(name + "  ");
        }

    }


}
