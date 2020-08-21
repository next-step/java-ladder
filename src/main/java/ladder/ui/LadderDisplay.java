package ladder.ui;

import ladder.domain.Ladder;
import ladder.ui.result.DisplayResult;

public final class LadderDisplay {
    public static void ladderDisplay(Ladder ladder){
        display("\n사다리 결과\n");
        display(ladder);
    }

    public static void rideResultDisplay(String rideResult){
        display("\n실행 결과");
        display(rideResult + "\n");
    }

    public static void allRideResultDisplay(String rideResult){
        display("\n실행 결과");
        display(rideResult + "\n");
    }

    public static void display(DisplayResult displayResult){
        display(displayResult.toDisplay());
    }

    public static void display(String msg){
        System.out.println(msg);
    }
}
