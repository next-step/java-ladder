package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER_COMMA = ",";

    public List<String> getParticipantsName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String participants = scanner.nextLine();

        List<String> participantList = Arrays.stream(splitByDelimiter(participants))
                                             .collect(Collectors.toList());

        if (hasUnvalidName(participantList)) {
            throw new IllegalArgumentException("참가자의 이름은 5글자를 초과할 수 없습니다.");
        }

        return participantList;
    }

    public int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return scanner.nextInt();
    }

    private boolean hasUnvalidName(List<String> participantList) {
        return participantList.stream()
                              .anyMatch(participant -> participant.length() > 5);
    }

    private String[] splitByDelimiter(String text) {
        return text.split(DELIMITER_COMMA);
    }

}
