package nextstep.ladder;

import nextstep.ladder.model.*;
import nextstep.ladder.view.LadderGameDrawer;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderController {
    private static final String LAST_COMMAND = "all";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {
        List<Person> people = initPeoplePhase(scanner);
        List<Reward> rewards = initRewardsPhase(scanner);
        validateRewardsAndPeople(people, rewards);

        Ladder ladder = initLadderPhase(scanner, people.size());
        LadderGameDrawer.drawLadderResult(people, ladder, rewards);

        boolean runnable = true;
        while (runnable) {
            LadderGameDrawer.drawWantedResultInputText();

            runnable = run(people, ladder, rewards);
        }
    }

    private static boolean run(List<Person> people, Ladder ladder, List<Reward> rewards) {
        String command = scanner.nextLine().trim();

        if (LAST_COMMAND.equals(command)) {
            List<Result> results = doAllResult(people, ladder, rewards);
            LadderGameDrawer.drawResults(results);
            return false;
        }

        int startPosition = findPeoplePosition(command, people);
        Reward reward = doResult(startPosition, ladder, rewards);

        LadderGameDrawer.drawOneResult(reward);
        return true;
    }

    private static Reward doResult(int startPosition, Ladder ladder, List<Reward> rewards) {
        return rewards.get(ladder.doPlay(startPosition));
    }

    private static List<Result> doAllResult(List<Person> people, Ladder ladder, List<Reward> rewards) {
        return IntStream.range(0, people.size())
                .mapToObj((index) -> new Result(people.get(index),  doResult(index, ladder, rewards)))
                .collect(Collectors.toList());
    }

    private static List<Person> initPeoplePhase(Scanner scanner) {
        LadderGameDrawer.drawPeopleInputText();
        return LadderGameMakeUtil.makePeople(scanner.nextLine());
    }

    private static List<Reward> initRewardsPhase(Scanner scanner) {
        LadderGameDrawer.drawRewardInputText();
        return LadderGameMakeUtil.makeRewards(scanner.nextLine());
    }

    private static Ladder initLadderPhase(Scanner scanner, int numberOfPeople) {
        LadderGameDrawer.drawHeightInputText();
        int height = Integer.valueOf(scanner.nextLine());

        return LadderGameMakeUtil.makeLadder(numberOfPeople, height);
    }

    private static void validateRewardsAndPeople(List<Person> people, List<Reward> rewards) {
        if (rewards.size() == people.size()) {
            return;
        }

        throw new IllegalArgumentException("참가자의 명수와 보상의 갯수가 일치하지 않습니다.");
    }

    private static int findPeoplePosition(String name, List<Person> people) {
        if (!people.contains(new Person(name))) {
            throw new IllegalArgumentException("this name does not contains in people ");
        }

        return people.indexOf(new Person(name));
    }
}