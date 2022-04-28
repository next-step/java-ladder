package ladder.view;

import ladder.model.Height;
import ladder.model.Participant;
import ladder.model.Participants;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class InputView {

    private static final String INPUT_PARTICIPANT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public Participants inputParticipants() {
        System.out.println(INPUT_PARTICIPANT_NAMES_MESSAGE);
        return convertParticipants();
    }

    private Participants convertParticipants() {
        String[] participants = readLine().replace(" ", "").split(",");
        return Arrays.stream(participants)
                .map(Participant::create)
                .collect(collectingAndThen(toList(), Participants::create));
    }

    public Height inputLadderHeight() {
        System.out.println(MAX_LADDER_HEIGHT_MESSAGE);
        return Height.create(Integer.parseInt(readLine()));
    }

    private String readLine() {
        return scanner.nextLine();
    }

}
