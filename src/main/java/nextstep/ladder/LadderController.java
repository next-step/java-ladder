package nextstep.ladder;

import nextstep.ladder.model.Lines;
import nextstep.ladder.model.Person;
import nextstep.ladder.model.Result;
import nextstep.ladder.model.Reward;
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

        Lines lines = initLinesPhase(scanner, people.size());
        LadderGameDrawer.drawLadderResult(people, lines, rewards);

        while (true) {
            LadderGameDrawer.drawWantedResultInputText();
            String command = scanner.nextLine().trim();

            LadderGameDrawer.drawResultText();
            if (LAST_COMMAND.equals(command)) {
                List<Result> results = doAllResult(people, rewards, lines);
                LadderGameDrawer.drawResults(results);
                break;
            }

            int startPosition = findPeoplePosition(command, people);
            LadderGameDrawer.drawResult(new Result(people.get(startPosition), rewards.get(lines.doResult(startPosition))));
        }
    }

    private static List<Result> doAllResult(List<Person> people, List<Reward> rewards, Lines lines) {
        return IntStream.range(0, people.size())
                .mapToObj((index) -> new Result(people.get(index), rewards.get(lines.doResult(index))))
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

    private static Lines initLinesPhase(Scanner scanner, int width) {
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
