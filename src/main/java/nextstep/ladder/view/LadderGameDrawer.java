package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Person;
import nextstep.ladder.model.Point;

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

    public static void drawResult(List<Person> people, Ladder ladder) {
        System.out.println("실행결과\n");

        drawPeople(people);
        drawLadder(ladder);

    }

    private static void drawLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();

        int height = ladder.getHeight();
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

            Point point = currentLine.getPoint(currentStair);
            if (isExistsStair(index, point)) {
                stair += STAIR;
                continue;
            }

            stair += EMPTY_STAIR;
        }

        return stair;
    }

    private static boolean isExistsStair(int currentLineIndex, Point point) {
        return point.isUsed() && point.getGoal() > currentLineIndex;
    }

    private static void drawPeople(List<Person> people) {
        String peopleString = people.stream()
                .map((person) -> makePeopleLeftPadding(person.getName()) + person.getName())
                .collect(Collectors.joining(WHITE_SPACE));
        System.out.println(peopleString);
    }

    private static String makePeopleLeftPadding(String name) {
        int spaceSize = Person.NAME_MAX_SIZE - name.length();

        String space = "";
        for (int index = 0; index < spaceSize; index++) {
            space += WHITE_SPACE;
        }

        return space;
    }
}
