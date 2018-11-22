package ladderTDD.view;



import ladderTDD.domain.Ladder;
import ladderTDD.domain.Result;
import ladderTDD.player.People;
import ladderTDD.player.Person;

import java.util.Map;

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

    public static void showAllResult(Map<Person, Result> resultMap) {
        for (Person person : resultMap.keySet()) {
            System.out.println(person.getName() + " : " + resultMap.get(person).getResult());
        }
    }
}
