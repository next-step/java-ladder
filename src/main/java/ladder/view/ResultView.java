package ladder.view;

import ladder.domain.*;

public class ResultView {

    public static void printLadder(LadderGame ladderGame, Result ladder) {
        System.out.println("실행결과");
        for (Person person : ladderGame.getPeople()) {
            System.out.print(person.toString()+" ");
        }
        System.out.println("\n");
        System.out.println(ladder.toString());
        System.out.println("\n");
        for (Reward reward : ladder.getRewards()) {
            System.out.print(reward.toString()+" ");
        }
    }

}
