package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.domain.Person;
import ladder.domain.Result;

public class ResultView {
    public static void showLadder(People people, Ladder ladder) {
        System.out.println("사다리 결과");
        for (Person person : people.getPeople()) {
            System.out.print(person.toString()+" ");
        }
        System.out.println();
        System.out.println(ladder.toString());
    }

    public static void showResult(Result result) {
        System.out.println("실행 결과");
        System.out.println(result.getResult());
    }
}
