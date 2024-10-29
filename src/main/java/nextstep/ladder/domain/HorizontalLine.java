package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HorizontalLine {
    private final List<Boolean> hasLineOrNotList;

    private HorizontalLine(List<Boolean> hasLineOrNotList) {
        this.hasLineOrNotList = hasLineOrNotList;
    }

    public HorizontalLine(int userCount) {
        this(generateLines(userCount));
    }

    private static List<Boolean> generateLines(int userCount) {
        Random random = new Random();
        List<Boolean> lines = new ArrayList<>();
        Boolean isPreviousLineExist = null;
        int maxBooleanCountForLine = userCount - 1;

        while (lines.size() < maxBooleanCountForLine) {
            boolean isLineExist = generateIsLineExist(random, isPreviousLineExist);
            lines.add(isLineExist);
            isPreviousLineExist = isLineExist;
        }

        return lines;
    }

    private static boolean generateIsLineExist(Random random, Boolean isPreviousLineExist) {
        boolean isLineExist = random.nextBoolean();
        while (isPreviousLineExist != null && isLineExist == isPreviousLineExist) {
            isLineExist = random.nextBoolean();
        }
        return isLineExist;
    }

    public int size() {
        return hasLineOrNotList.size();
    }

    public Boolean hasLineOnIndex(int index) {
        return hasLineOrNotList.get(index);
    }
}
