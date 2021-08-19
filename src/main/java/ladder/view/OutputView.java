package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.stream.Collectors;

public class OutputView {
    private static final String LINE_FLAG = "-----";
    private static final String LINE_BLANK = "     ";
    private static final String LINE_DELIMITER = "|";

    public static void printNames() {

    }

    public void printLadder(Ladder ladder) {
        /*for (int i = 0; i < ladder.getLadder()
                                  .size(); i++) {
            for (int j = 0; j < ladder.getLadder()
                                      .get(0)
                                      .getPoints()
                                      .size(); j++) {
                if (ladder.getLadder()
                          .get(i)
                          .getPoints()
                          .get(j)) {
                    System.out.print(LINE_FLAG);
                } else {
                    System.out.print(LINE_BLANK);
                }

                System.out.print(LINE_DELIMITER);
            }
            System.out.println();
        }*/
        ladder.getLadder()
              .stream()
              .map(this::generateLine)
              .forEach(System.out::println);
    }

    public String generateLine(Line line) {
        return line.getPoints()
                   .stream()
                   .map(flag -> flag ? LINE_FLAG : LINE_BLANK)
                   .collect(Collectors.joining(LINE_DELIMITER))+"|";

    }
}
