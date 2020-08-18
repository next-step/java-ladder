package camp.nextstep.edu.rebellion.view;

import camp.nextstep.edu.rebellion.domain.Ladder;
import camp.nextstep.edu.rebellion.domain.Row;

public class ResultView {
    public static void printLadder (Ladder ladder) {
        int rows = ladder.getSizeOfRows();
        int cols = ladder.getSizeOfPoints();

        System.out.println("rows :\t" + rows + " cols :\t" + cols);

        for (int i = 0; i < rows; i++) {
            Row row = ladder.getRows().get(i);
            for (int j = 0; j < cols-1; j++) {
                System.out.print("|");
                if (row.hasHorizonLine(j)) {
                    System.out.print("-----");
                } else {
                    System.out.print("     ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
