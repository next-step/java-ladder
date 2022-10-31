package ladder.view;

import ladder.domain.LadderHeight;
import ladder.domain.Participant;
import ladder.domain.Participants;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Participants inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Participants(Stream.of(SCANNER.nextLine()
                                                 .split(","))
                                      .map(String::trim)
                                      .map(Participant::new)
                                      .collect(Collectors.toList()));
    }

    public static LadderHeight inputLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        final int intLadderHeight = SCANNER.nextInt();
        SCANNER.skip(System.lineSeparator());
        return new LadderHeight(intLadderHeight);
    }
}
