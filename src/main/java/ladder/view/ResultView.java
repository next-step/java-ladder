package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.ParticipatePeople;

public class ResultView {
    private static final String RESULT_COMMENT = "실행 결과";

    public static void printResultComment() {

        System.out.println(RESULT_COMMENT);
    }

    public static void printParticipatePeople(ParticipatePeople participatePeople) {
        participatePeople.getList().stream()
                .forEach(person -> System.out.print("  " + person));
        System.out.println();
    }

    public static void drawLadder(Ladder ladder) {

        for(int row = 0 ; row < ladder.getLadderHeight(); row++){
            for(int column = 0; column < ladder.getLadderWidth(); column++) {
                if(ladder.isDraw(row, column)) {
                    System.out.print("-----|");
                }
                else{
                    System.out.print("     |");
                }

            }
            System.out.println();
        }
    }
}
