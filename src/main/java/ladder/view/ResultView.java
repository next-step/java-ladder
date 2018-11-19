package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.domain.Person;

public class ResultView {
    public static void showLadder(People people, Ladder ladder) {
        System.out.println("실행결과");
        for (Person person : people.getPeople()) {
            System.out.print(person.toString()+" ");
        }
        System.out.println();
        System.out.println(ladder.toString());
    }
}
