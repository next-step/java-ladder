package nextstep.ladder.view;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA = ",";

    private InputView() {
    }

    public static Participants inputParticipantsNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputNames = SCANNER.nextLine();

        return parseParticipants(inputNames);
    }

    public static Height inputMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return new Height(Integer.parseInt(SCANNER.nextLine()));
    }

    private static Participants parseParticipants(String inputNames) {
        List<Participant> participants = Arrays.stream(inputNames.split(COMMA))
                .map(Participant::new)
                .collect(Collectors.toList());

        return new Participants(participants);
    }

}
