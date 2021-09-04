package nextstep.ladder;

import nextstep.ladder.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LadderGameMakeUtil {
    private static final String INPUT_SEPARATOR = ",";

    public static List<Person> makePeople(String input) {
        if ("".equals(input.trim())) {
            throw new IllegalArgumentException("참가자가 없습니다.");
        }

        return Arrays.stream(input.split(INPUT_SEPARATOR))
                .map((name) -> new Person(name))
                .collect(Collectors.toList());
    }

    public static List<Reward> makeRewards(String input) {
        if ("".equals(input.trim())) {
            throw new IllegalArgumentException("결과 값이 입력되지 않았습니다.");
        }

        return Arrays.stream(input.split(INPUT_SEPARATOR))
                .map((reward) -> new Reward(reward))
                .collect(Collectors.toList());
    }

    private static final Random RANDOM = new Random();

    public static Lines makeLines(int numberOfPeople, int height) {
        if (numberOfPeople <= 0 || height <= 0) {
            throw new IllegalArgumentException("참가자가 존재하지 않습니다.");
        }

        if (height <= 0) {
            throw new IllegalArgumentException("사다리 길이가 유효하지 않습니다.");
        }

        List<Line> lineList = makeDefaultLines(numberOfPeople, height);

        for (int i = 0; i < height; i++) {
            makeStairs(lineList, i);
        }

        return new Lines(lineList);
    }

    private static void makeStairs(List<Line> lines, int height) {
        for (int index = 0; index < lines.size() - 1; index++) {
            int origin = index;

            makeStair(lines, height, origin);
        }
    }

    private static void makeStair(List<Line> lines, int height, int origin) {
        int destination = origin + 1;

        Point start = lines.get(origin).getPoints().get(height);
        Point end = lines.get(destination).getPoints().get(height);

        if (!RANDOM.nextBoolean()) {
            return;
        }

        if (start.isUsed() || end.isUsed()) {
            return;
        }

        start.use(destination);
        end.use(origin);
    }

    private static List<Line> makeDefaultLines(int numberOfPeople, int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            lines.add(new Line(height));
        }

        return lines;
    }
}
