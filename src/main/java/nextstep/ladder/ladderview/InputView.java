package nextstep.ladder.ladderview;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final String DELIMITER = ",";

    public List<String> inputName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return splitedName(scanner.nextLine());
    }

    public List<String> splitedName(String name) {
        return Arrays.stream(name.split(DELIMITER))
                .map(this::checkNameLengthOverMaxLength)
                .collect(Collectors.toList());
    }

    private String checkNameLengthOverMaxLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5자를 초과할 수 없습니다");
        }
        return name;
    }

    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return checkHeightIsValid(Integer.valueOf(scanner.nextLine()));
    }

    public int checkHeightIsValid(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다");
        }
        return height;
    }

}
