package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.players.Person;
import ladder.domain.players.Players;
import ladder.domain.result.LadderResult;
import ladder.domain.rewards.Rewards;

public class ConsoleOutput {

    public static void printPlayers(Players players) {
        System.out.println();
        printResultString();
        System.out.println();

        players.getPeople().forEach(System.out::print);
    }

    public static void printLadders(Ladder ladder) {
        System.out.println();
        ladder.getLines().forEach(System.out::println);
    }

    public static void printRewards(Rewards rewards) {
        rewards.getPeople().forEach(System.out::print);
    }

    public static void printRewardOfPlayers(LadderResult ladderResult, String name) {
        System.out.println();
        printResultString();
        if (name.equals("all")) {
            printAllPlayersReward(ladderResult);
            return;
        }
        System.out.println(ladderResult.getItemByPersonName(name).value());
    }

    private static void printAllPlayersReward(LadderResult ladderResult) {
        for (Person person : ladderResult.getResults().keySet()) {
            System.out.println(person.value() + " : "
                + ladderResult.getItemByPersonName(person.value()).value());
        }
    }

    private static void printResultString() {
        System.out.println("실행결과");
    }

}
