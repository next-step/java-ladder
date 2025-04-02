package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.User;

import java.util.List;

public class OutputView {
    public static void printGameMap(String userNames, Ladder ladder) {
        System.out.println(userNames);
        ladder.getPoints().stream()
                .map(line -> line.getLineString())
                .forEach(System.out::println);
    }
}
