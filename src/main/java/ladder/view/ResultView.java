package ladder.view;

import ladder.domain.*;

import java.util.Map;

public class ResultView {

    public static void printLadder(LadderGame ladderGame, Result result) {
        System.out.println("사다리 결과");
        for (Person person : ladderGame.getPeople()) {
            System.out.print(person.toString()+" ");
        }
        System.out.println("\n");
        System.out.println(ladderGame.getLadder().toString());
        for (Reward reward : result.getRewards()) {
            System.out.print(reward.toString()+" ");
        }
    }

    public static void printReward(Result result, PersonPosition personPosition, String personName) {
        System.out.println("\n");
        System.out.println("실행 결과");
        if ("all".equals(personName)) {
            Map<Person, Position> personPositions = personPosition.getPersonPositions();
            for (Person person : personPositions.keySet()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(person.toString());
                stringBuilder.append(":");
                stringBuilder.append(result.findPersonResult(personPositions.get(person)).toString());
                stringBuilder.toString();
                System.out.println(stringBuilder);
            }
        } else {
            Person resultPerson = Person.from(personName);
            Position position = personPosition.findPersonPosition(resultPerson);
            System.out.println(result.findPersonResult(position));
        }
    }
}
