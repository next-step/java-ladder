package nextstep.ladder.view;

import nextstep.ladder.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameDrawer {
    private static final String STAIR = "-----";
    private static final String EMPTY_STAIR = "     ";
    private static final String LEFT_MARGIN = "    ";
    private static final String LINE = "|";
    private static final String WHITE_SPACE = " ";

    public static void drawPeopleInputText() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void drawHeightInputText() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void drawWantedResultInputText() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    private static void drawResultText() {
        System.out.println("실행 결과");
    }

    public static void drawResults(List<Result> results) {
        drawResultText();
        String allResults = results.stream().map((result -> result.toString())).collect(Collectors.joining("\n"));
        System.out.println(allResults);
    }

    public static void drawLadderResult(List<Person> people, Ladder ladder, List<Reward> rewards) {
        System.out.println("사다리 결과\n");

        drawPeople(people);
        drawLines(ladder.getLines());
        drawRewards(rewards);
    }

    private static void drawRewards(List<Reward> rewards) {
        String rewardsString = rewards.stream()
                .map((reward) -> makeLeftPadding(reward.toString(), Reward.MAX_REWARD_LENGTH) + reward)
                .collect(Collectors.joining(WHITE_SPACE));
        System.out.println(rewardsString);
    }

    public static void drawOneResult(Reward reward) {
        drawResultText();
        System.out.println(reward);
    }

    private static void drawLines(List<Line> lines) {
        int height = lines.get(0)
                .getPoints()
                .size();

        String ladderString = "";
        for (int index = 0; index < height; index++) {
            ladderString += makeStairString(index, lines) + "\n";
        }

        System.out.println(ladderString);
    }

    private static String makeStairString(int currentStair, List<Line> lines) {
        String stair = LEFT_MARGIN;

        for (int index = 0; index < lines.size(); index++) {
            stair += LINE;

            Line currentLine = lines.get(index);
            List<Point> pointList = currentLine.getPoints();

            Point point = pointList.get(currentStair);
            stair += makeStairBetweenLine(index, point);
        }

        return stair;
    }

    private static String makeStairBetweenLine(int index, Point point) {
        if (isExistsStair(index, point)) {
            return STAIR;
        }

        return EMPTY_STAIR;
    }

    private static boolean isExistsStair(int currentLineIndex, Point point) {
        return point.move() > currentLineIndex;
    }

    private static void drawPeople(List<Person> people) {
        String peopleString = people.stream()
                .map((person) -> makeLeftPadding(person.toString(), Person.NAME_MAX_SIZE) + person)
                .collect(Collectors.joining(WHITE_SPACE));
        System.out.println(peopleString);
    }

    private static String makeLeftPadding(String name, int max) {
        int spaceSize = max - name.length();

        String space = "";
        for (int index = 0; index < spaceSize; index++) {
            space += WHITE_SPACE;
        }

        return space;
    }

    public static void drawRewardInputText() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }
}
