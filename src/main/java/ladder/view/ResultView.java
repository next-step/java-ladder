package ladder.view;

import ladder.domain.Ladder;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printNameList(List<String> nameList) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(nameList);
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(System.out::println);
    }
}
