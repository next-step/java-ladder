package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final int NAME_MAX_LENGTH = 5;
    private static Scanner scanner = new Scanner(System.in);

    public List<String> persons() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return stringToList(scanner.nextLine());
    }

    private List<String> stringToList(String inputText) {
        isEmpty(inputText);
        return Arrays.stream(inputText.split(","))
                .map(this::isNameLengthFiveOver)
                .collect(Collectors.toList());
    }

    private void isEmpty(String inputText) {
        if (inputText == null
                || inputText.trim().isEmpty()) {
            throw new IllegalArgumentException("참여자가 없습니다.");
        }
    }

    private String isNameLengthFiveOver(String name) {
        if (name.isEmpty()
                || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("사람 이름은 1~5글자야 합니다.");
        }
        return name;
    }

    public int ladderSize() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}