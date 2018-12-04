package ladder.view;

import ladder.domain.*;

import java.util.Map;

public class ResultView {

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }

    public static void printPeopleList(People people) {
        System.out.println("사다리 결과");
        for (Person person : people.getPeople()) {
            System.out.print(person.toString()+" ");
        }
        System.out.println("\n");
    }

    public static void printRewardList(Reward reward) {
        for (Benefit benefit : reward.getRewards()) {
            System.out.print(benefit.toString()+" ");
        }
    }

    public static void printReward() {
        System.out.println("\n");
        System.out.println("실행 결과");
    }

    public static void printAllReward(Reward reward, PersonPosition personPosition) {
        Map<Person, Position> personPositions = personPosition.getPersonFinalPositions();
        for (Person person : personPositions.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(person.toString());
            stringBuilder.append(":");
            stringBuilder.append(reward.findPersonResult(personPositions.get(person)).toString());
            stringBuilder.toString();
            System.out.println(stringBuilder);
        }
    }

    public static void printPersonReward(Reward reward, Position position) {
        System.out.println(reward.findPersonResult(position));
    }
}
