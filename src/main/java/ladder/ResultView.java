package ladder;

import java.util.List;

public class ResultView {

    public void printLadder(List<Name> names, List<Line> ladder) {
        System.out.println("실행결과");
        System.out.println();

        names.forEach(name -> System.out.print(name.getName() + " "));
        System.out.println();
        for (Line line : ladder) {
            for (Boolean point : line.getPoints()) {
                System.out.print("|");
                if (point) {
                    System.out.print("-----");
                }
                else {
                    System.out.print("     ");
                }
            }
            System.out.println();
        }
    }
}
