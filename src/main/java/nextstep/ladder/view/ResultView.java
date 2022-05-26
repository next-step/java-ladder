package nextstep.ladder.view;

import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.person.People;
import nextstep.ladder.domain.person.Person;
import nextstep.ladder.domain.result.Result;
import nextstep.ladder.domain.result.Results;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "\n실행결과";
    private static final String ALL = "all";

    public static void printResults(People people, Ladder ladder, Results results) {
        System.out.println(RESULT_MESSAGE);
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.append(people).append(ladder).append(results));

        printPersonAndMatchedResult(people, ladder, results);
    }

    private static void printPersonAndMatchedResult(People people, Ladder ladder, Results results) {
        while (true) {
            if (matchPersonAndResult(people, ladder, results)) {
                break;
            }
        }
    }

    private static boolean matchPersonAndResult(People people, Ladder ladder, Results results) {
        String findName = InputView.InputFindPersonName();
        if (findName.equals(ALL)) {
            ResultView.printPersonAndResult(people.people(), ladder.results(people, results));
            return true;
        }

        try {
            Person person = people.person(findName);
            Position resultPosition = ladder.move(person);
            ResultView.printMatchResult(results.result(resultPosition));
        } catch (Exception e) {
            printPersonAndMatchedResult(people, ladder, results);
        }
        return false;
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
