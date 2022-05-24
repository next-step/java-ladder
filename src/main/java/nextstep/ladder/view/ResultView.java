package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.person.People;
import nextstep.ladder.domain.person.Person;
import nextstep.ladder.domain.result.Result;
import nextstep.ladder.domain.result.Results;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "\n실행결과";

    public static void printResults(People people, Ladder ladder, Results results) {
        System.out.println(RESULT_MESSAGE);
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.append(people).append(ladder).append(results));
    }

    public static void printMatchResult(Result result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(result + "\n");
    }

    public static void printPersonAndResult(List<Person> people, List<Result> results) {
        System.out.println(RESULT_MESSAGE);
        for (int index = 0; index < people.size(); index++) {
            System.out.println(people.get(index) + " : " + results.get(index));
        }
    }
}
