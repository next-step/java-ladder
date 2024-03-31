package nextstep.ladder.ui;

import nextstep.ladder.exception.LadderHeightException;
import nextstep.ladder.exception.ParticipantNameLengthExceedException;
import nextstep.ladder.validator.LadderGamePrizeValidator;
import nextstep.ladder.validator.LadderValidator;
import nextstep.ladder.validator.ParticipantValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> readParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉽표(,)로 구분하세요)");

        List<String> names;
        try {
            names = parseStringList(nextLine());
            ParticipantValidator.validateNamesLength(names);
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

    public static int readLadderMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        int height;
        try {
            height = nextInt();
            LadderValidator.validateLadderMaxHeight(height);
        } catch (LadderHeightException e) {
            ResultView.printException(e.getMessage());
            return readLadderMaxHeight();
        }

        return height;
    }

    private static int nextInt() {
        return SCANNER.nextInt();
    }

    public static List<String> readLadderGamePrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요.");
        List<String> prizes = parseStringList(nextLine());
        LadderGamePrizeValidator.validatePrizes(prizes);
        return prizes;
    }

}
