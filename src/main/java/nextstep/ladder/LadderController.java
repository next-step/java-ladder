package nextstep.ladder;

import nextstep.ladder.model.*;
import nextstep.ladder.view.LadderGameDrawer;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderController {
    private static final String LAST_COMMAND = "all";

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = initPeoplePhase(scanner);
        List<Reward> rewards = initRewardsPhase(scanner);
        validateRewardsAndPeople(people, rewards);

        List<Line> lines = initLinesPhase(scanner, people.size());
        Ladder ladder = new Ladder(lines, rewards);
        LadderGameDrawer.drawLadderResult(people, ladder);

        boolean runnable = true;
        while (runnable) {
            LadderGameDrawer.drawWantedResultInputText();
            String command = scanner.nextLine().trim();

            run(people, ladder, command);

            runnable = isLastOrder(command);
        }
    }

    private static void run(List<Person> people, Ladder ladder, String command) {
        LadderGameDrawer.drawResultText();
        if (LAST_COMMAND.equals(command)) {
            List<Result> results = doAllResult(people, ladder);
            LadderGameDrawer.drawResults(results);
            return;
        }

        int startPosition = findPeoplePosition(command, people);
        LadderGameDrawer.drawResult(new Result(people.get(startPosition), ladder.doPlay(startPosition)));
    }

    private static boolean isLastOrder(String command) {
        return !LAST_COMMAND.equals(command);
    }

    private static List<Result> doAllResult(List<Person> people, Ladder ladder) {
        return IntStream.range(0, people.size())
                .mapToObj((index) -> new Result(people.get(index), ladder.doPlay(index)))
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

    private static List<Line> initLinesPhase(Scanner scanner, int width) {
        LadderGameDrawer.drawHeightInputText();
        int height = Integer.valueOf(scanner.nextLine());

        return LadderGameMakeUtil.makeLines(width, height);
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