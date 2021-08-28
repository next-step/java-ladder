package step2.view;

import java.util.List;

public class ResultView {
    public void printLadderResult(List<Boolean> points, int countOfPerson) {
        for (Boolean point: points) {
            printLadderLine(point, countOfPerson);

        }
        System.out.print("|");
    }

    public void printLadderLine(Boolean point, int countOfPerson) {
        System.out.print("|");
        if (point) {
            System.out.print("-----");
            return;
        }
        System.out.print("     ");
        return;
    }
}
