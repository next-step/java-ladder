package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.person.People;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printPeople(People people) {
        System.out.println(people);
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }
}
