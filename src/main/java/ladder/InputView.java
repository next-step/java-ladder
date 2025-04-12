package ladder;

import java.util.*;
import java.util.stream.Collectors;

class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> getParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String namesInput = scanner.nextLine();

        String[] names = namesInput.split(",");
        List<String> participants = new ArrayList<>();

        for (String name : names) {
            String trimmedName = name.trim();
            validateParticipants(trimmedName);
            participants.add(trimmedName);
        }
        return participants;
    }

    public void validateParticipants(String participants) {
        if (participants.isEmpty()) {
            throw new IllegalArgumentException("빈 이름은 입력할 수 없습니다.");
        }
        if (participants.length() > 5) {
            throw new IllegalArgumentException("참가자 이름은 최대 5글자까지 가능합니다");
        }
    }

    public int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}