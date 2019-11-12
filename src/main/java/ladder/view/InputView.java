package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import ladder.model.Height;
import ladder.model.Participant;
import ladder.model.Participants;

public class InputView {

    private static final String INPUT_DELIMITER = ",";
    private static Scanner scanner = new Scanner(System.in);

    public static Participants getParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String participantsInput = scanner.nextLine();

        return new Participants(Participant.ofNameList(convertInputToList(participantsInput)));
    }

    private static List<String> convertInputToList(String participantsInput) {
        return Arrays.asList(participantsInput.split(INPUT_DELIMITER));
    }

    public static Height getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightInput = scanner.nextInt();
        scanner.nextLine();

        return Height.of(heightInput);
    }
}
