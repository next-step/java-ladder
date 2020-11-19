package nextstep.ladder.view;

import nextstep.ladder.Ladder;

public class ConsoleResultView implements ResultView {
    @Override
    public void printLadder(Ladder ladder) {
        ladder.repeatAsHeight(() -> System.out.println("|"), (point) -> {
            System.out.print("|");
            if(point) {
                System.out.print("-----");
                return;
            }

            System.out.print("     ");
        });
    }
}
