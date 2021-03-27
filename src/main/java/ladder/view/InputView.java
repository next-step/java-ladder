package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PERSON_GUIDANCE_PHRASES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_SIZE_GUIDANCE_PHRASES = "최대 사다리 높이는 몇 개인가요?";
    private static final String PERSON_EMPTY_ERROR = "참여자가 없습니다.";
    private static final String NAME_MAX_LENGTH_ERROR = "사람 이름은 최대 5글자 입니다.";
    private static final int NAME_MAX_LENGTH = 5;
    private static Scanner scanner = new Scanner(System.in);

    public List<String> person() {
        System.out.println(INPUT_PERSON_GUIDANCE_PHRASES);
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
            throw new IllegalArgumentException(PERSON_EMPTY_ERROR);
        }
    }

    private String isNameLengthFiveOver(String name) {
        if (name.isEmpty()
                || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_MAX_LENGTH_ERROR);
        }
        return name;
    }

    public int ladderSize() {
        System.out.println(INPUT_LADDER_SIZE_GUIDANCE_PHRASES);
        return scanner.nextInt();
    }
}
