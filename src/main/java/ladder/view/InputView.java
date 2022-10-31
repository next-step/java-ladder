package ladder.view;

import ladder.domain.Participant;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static List<Participant> inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Stream.of(SCANNER.nextLine()
                                .split(","))
                     .map(String::trim)
                     .map(Participant::new)
                     .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        final int ladderHeight = SCANNER.nextInt();
        SCANNER.skip(System.lineSeparator());
        return ladderHeight;
    }
}
