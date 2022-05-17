package ladder.view;

import ladder.domain.Participant;
import ladder.domain.Participants;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_PARTICIPANTS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String BLANK_STRING = " ";
    public static final String EMPTY_STRING = "";
    public static final String DELIMITER_REG = ",";

    public Participants readParticipants() {
        System.out.println(INPUT_PARTICIPANTS_MESSAGE);
        return Arrays.stream(getSplitArray())
                .map(Participant::new)
                .collect(getParticipants());
    }

    private String[] getSplitArray() {
        String participantsString = readLine();
        return participantsString.replaceAll(BLANK_STRING, EMPTY_STRING).split(DELIMITER_REG);
    }

    private Collector<Participant, Object, Participants> getParticipants() {
        return Collectors.collectingAndThen(Collectors.toList(), Participants::new);
    }

    public String readLine() {
        return SCANNER.nextLine();
    }
}
