package nextstep.ladder.view;

import java.util.List;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.People;
import nextstep.ladder.model.Rewards;
import nextstep.ladder.model.dto.LadderGameResult;

public class ResultView {
    private static final String LADDER_RESULT_TITLE = "사다리 결과";
    private static final String NAME_FORMAT = "%6s";
    private static final String REWARD_FORMAT = "%-6s";
    private static final String WITH_POINT_STRING = "-----|";
    private static final String WITHOUT_POINT_STRING = "     |";
    private static final String ALL_PEOPLE = "all";
    private static final String GAME_RESULT_TITLE = "실행 결과";

    public void printLadderStatus(People people, Ladder ladder, Rewards rewards) {
        printLadderTitle();
        printPeopleNames(people);
        printLadder(ladder);
        printRewards(rewards);
        System.out.println();
    }

    public void printGameResult(String targetPersonName, People people, LadderGameResult gameResult) {
        if (targetPersonName.equals(ALL_PEOPLE)) {
            printAllGameResult(people.getPeopleNames(), gameResult);
            return;
        }

        System.out.println(GAME_RESULT_TITLE);
        System.out.println(gameResult.findRewardByPersonName(targetPersonName));
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    private void printLadderTitle() {
        System.out.println(LADDER_RESULT_TITLE);
        System.out.println();
    }

    private void printPeopleNames(People people) {
        people.getPeopleNames()
            .forEach(name -> System.out.printf(NAME_FORMAT, name));
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines()
            .forEach(this::printLine);
    }

    private void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append(WITHOUT_POINT_STRING);

        line.getMovingPoints()
            .forEach(point -> sb.append(getFormattedMovingPoint(point)));

        System.out.println(sb);
    }

    private String getFormattedMovingPoint(boolean point) {
        return point ? WITH_POINT_STRING : WITHOUT_POINT_STRING;
    }

    private void printRewards(Rewards rewards) {
        rewards.getValue()
            .forEach(reward -> System.out.printf(REWARD_FORMAT, reward));
        System.out.println();
    }

    private void printAllGameResult(List<String> peopleNames, LadderGameResult gameResult) {
        System.out.println(GAME_RESULT_TITLE);
        peopleNames.forEach(name -> {
            System.out.printf("%s : %s\r\n", name, gameResult.findRewardByPersonName(name));
        });
    }
}
