package nextstep.step2.view;

import nextstep.step2.domain.Participant;
import nextstep.step2.domain.Participants;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NAME_DELIMITER = ",";

    private InputView() {
    }

    public static Participants inputParticipantPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        final var names = SCANNER.nextLine();

        return new Participants(Arrays.stream(names.split(NAME_DELIMITER))
                .map(Participant::new)
                .collect(Collectors.toList()));
    }

    public static int inputLadderHeight() {
        System.out.println(System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?");

        return SCANNER.nextInt();
    }

}
