package laddergame.view;

import laddergame.domain.ParticipantName;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private static final int MIN_VALUE_OF_POSITIVE_NUMBER = 1;

    private InputView() {}

    public static List<ParticipantName> inputParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = SCANNER.nextLine();
        return Arrays.stream(input.split(DELIMITER))
                .map(ParticipantName::new)
                .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return inputPositiveNumber();
    }

    private static int inputPositiveNumber() {
        int number = SCANNER.nextInt();
        if (number < MIN_VALUE_OF_POSITIVE_NUMBER) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해야 합니다.");
        }
        return number;
    }

}
