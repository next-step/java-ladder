package ladder.view;

import ladder.domain.Ladder;

public class OutputView {
    private static final String MSG_RESULT = "실행 결과";
    private static final String LINE_TRUE = "|-----";
    private static final String LINE_FALSE = "|     ";
    private static final String LINE_END = "|";

    public void printResult(Ladder ladder) {
        System.out.println(MSG_RESULT);

        ladder.getPlayers().forEach(name -> System.out.printf("%5s ", name));
        System.out.println();

        ladder.getLines().forEach(line -> {
            System.out.print("  ");
            for (int i = 0; i < line.size(); i++) {
                if (line.point(i)) {
                    System.out.print(LINE_TRUE);
                } else {
                    System.out.print(LINE_FALSE);
                }
            }
            System.out.println(LINE_END);
        });
    }
}
