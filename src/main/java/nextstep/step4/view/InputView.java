package nextstep.step4.view;

import nextstep.step4.model.Name;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    private static final int MIN_COUNT = 2;
    private static final String COMMA_DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public List<Name> askNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        try {
            return toNames(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return askNames();
    }

    private List<Name> toNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("이름을 입력하세요");
        }

        return Arrays.stream(input.split(COMMA_DELIMITER))
                .map(String::trim)
                .map(Name::new)
                .collect(toList());
    }

    public List<String> askRewards(int countOfPerson) {
        if (countOfPerson < MIN_COUNT) {
            throw new IllegalArgumentException("최소 인원은 " + MIN_COUNT + "명 입니다");
        }

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        try {
            return toRewards(SCANNER.nextLine(), countOfPerson);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return askRewards(countOfPerson);
    }

    private List<String> toRewards(String input, int countOfPerson) {
        String[] rewards = input.split(COMMA_DELIMITER);

        if (rewards.length < countOfPerson) {
            throw new IllegalArgumentException(countOfPerson + "개의 보상을 입력하세요");
        }

        return Arrays.stream(rewards)
                .map(String::trim)
                .collect(toList());
    }

    public int askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return askLadderHeight();
    }

    public Name askNameForConfirm() {
        System.out.println("결과를 보고 싶은 사람은?");

        try {
            return new Name(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return askNameForConfirm();
    }
}
