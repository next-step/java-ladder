package nextstep.ladder.view;

import static java.lang.System.out;
import static nextstep.ladder.domain.Height.MAXIMUM_LADDER_HEIGHT;
import static nextstep.ladder.domain.Height.MINIMUM_LADDER_HEIGHT;
import static nextstep.ladder.domain.Name.MAXIMUM_NAME_LENGTH;
import static nextstep.ladder.domain.Name.MINIMUM_NAME_LENGTH;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.LinePart;
import org.apache.commons.lang3.StringUtils;

public class LadderGameCUI {

    private static final int MAXIMUM_TRY_COUNT = 3;

    private Scanner scanner = new Scanner(System.in);

    public List<String> inputParticipants() {
        return inputParticipantsImpl(MAXIMUM_TRY_COUNT);
    }

    private List<String> inputParticipantsImpl(int tryCount) {
        if (tryCount <= 0) System.exit(1);

        out.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) / 남은 시도 횟수: %d\n", tryCount);
        String inputLine = scanner.nextLine();

        List<String> names = Arrays.stream(inputLine.split(","))
            .map(String::trim)
            .collect(Collectors.toUnmodifiableList());

        if (!isValidNames(names)) {
            return inputParticipantsImpl(tryCount-1);
        }

        return names;
    }

    private boolean isValidNames(List<String> names) {
        return names.stream()
            .noneMatch(name ->
                StringUtils.isEmpty(name)
                || name.length() < MINIMUM_NAME_LENGTH
                || name.length() > MAXIMUM_NAME_LENGTH
            );
    }

    public int inputMaxLadderHeight() {
        return inputMaxLadderHeightImpl(MAXIMUM_TRY_COUNT);
    }

    private int inputMaxLadderHeightImpl(int tryCount) {
        out.printf("최대 사다리 높이는 몇 개인가요? (최소 2, 최대 100) / 남은 시도 횟수: %d\n", tryCount);
        int maxLadderHeight = scanner.nextInt();
        scanner.nextLine();

        if (isValid(maxLadderHeight)) {
            return inputMaxLadderHeightImpl(tryCount-1);
        }

        return maxLadderHeight;
    }

    private boolean isValid(int maxLadderHeight) {
        return maxLadderHeight < MINIMUM_LADDER_HEIGHT
            || maxLadderHeight > MAXIMUM_LADDER_HEIGHT;
    }

    private static String fixedLengthString(String string, int length) {
        return String.format("%1$"+length+ "s", string);
    }

    public void draw(Ladder ladder) {
        out.println("\n 사다리 결과");

        List<Line> lines = ladder.getLines();

        out.print(" ");
        for (Line line : lines) {
            out.print(fixedLengthString(line.getName(), 6));
        } out.println();

        for (int j = 0; j < ladder.lineHeight(); ++j) {
            out.print("     ");
            for (int i = lines.size()-1; i >= 1; --i) {
                out.print("|");
                if (lines.get(i-1).getParts().get(j).isConnected()) {
                    out.print("-----");
                    continue;
                }
                out.print("     ");
            }
            out.println("|");
        }
    }
}
