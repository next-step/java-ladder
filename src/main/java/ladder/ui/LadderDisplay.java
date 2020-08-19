package ladder.ui;

import ladder.domain.Ladder;
import ladder.ui.result.DisplayResult;

public class LadderDisplay {
    public static void ladderResultDisplay(Ladder ladder){
        display("실행 결과");
        display(ladder);
    }

    public static void display(DisplayResult displayResult){
        display(displayResult.toDisplay());
    }

    public static void display(String msg){
        System.out.println(msg);
    }
}
