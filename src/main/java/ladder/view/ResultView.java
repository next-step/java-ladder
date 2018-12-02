package ladder.view;

import ladder.domain.*;

import java.util.Map;

public class ResultView {

    public static void printLadderGame(LadderGame game, Reward result) {
        System.out.println("사다리 결과");
        for (Person person : game.getPeople()) {
            System.out.print(person.toString()+" ");
        }
        System.out.println("\n");
        System.out.println(game.getLadder().toString());
        for (benefit reward : result.getRewards()) {
            System.out.print(reward.toString()+" ");
        }
    }

    public static void printReward() {
        System.out.println("\n");
        System.out.println("실행 결과");
    }

    public static void printAllReward(Reward reward, PersonPosition personPosition) {
        Map<Person, Position> personPositions = personPosition.getPersonPositions();
        for (Person person : personPositions.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(person.toString());
            stringBuilder.append(":");
            stringBuilder.append(reward.findPersonResult(personPositions.get(person)).toString());
            stringBuilder.toString();
            System.out.println(stringBuilder);
        }
    }

    public static void printPersonReward(Reward reward, PersonPosition personPosition, String person) {
        Person rPerson = Person.from(person);
        Position position = personPosition.findPersonPosition(rPerson);
        System.out.println(reward.findPersonResult(position));
    }
}
