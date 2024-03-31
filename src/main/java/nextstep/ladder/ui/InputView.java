package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.dto.LadderGameRequest;
import nextstep.ladder.exception.LadderHeightException;
import nextstep.ladder.exception.ParticipantNameLengthExceedException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static LadderGameRequest createLadderGameRequest() {
        List<String> names = InputView.readParticipantNames();
        int height = InputView.readLadderMaxHeight();
        return new LadderGameRequest(names, height);
    }

    private static List<String> readParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉽표(,)로 구분하세요)");

        List<String> names;
        try {
            names = parseStringList(nextLine());
            validateParticipantNames(names);
        } catch (ParticipantNameLengthExceedException e) {
            ResultView.printException(e.getMessage());
            return readParticipantNames();
        }

        return names;
    }

    private static String nextLine() {
        return SCANNER.nextLine();
    }

    private static List<String> parseStringList(String string) {
        String[] strings = string.replace(" ", "").split(",");
        return Arrays.stream(strings).collect(Collectors.toUnmodifiableList());
    }

    private static int readLadderMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        int height;
        try {
            height = nextInt();
            validateLadderMaxHeight(height);
        } catch (LadderHeightException e) {
            ResultView.printException(e.getMessage());
            return readLadderMaxHeight();
        }

        return height;
    }

    private static int nextInt() {
        return SCANNER.nextInt();
    }

    private static void validateParticipantNames(List<String> names) {
        names.forEach(InputView::validateName);
    }

    private static void validateName(String name) throws ParticipantNameLengthExceedException {
        int nameLength = name.length();
        if (nameLength < Participant.MIN_NAME_LENGTH || nameLength > Participant.MAX_NAME_LENGTH) {
            throw new ParticipantNameLengthExceedException(name);
        }
    }

    private static void validateLadderMaxHeight(int height) throws LadderHeightException {
        if (height < Ladder.MIN_LADDER_HEIGHT) {
            throw new LadderHeightException(height);
        }
    }

}
