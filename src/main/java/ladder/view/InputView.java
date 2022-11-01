package ladder.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static List<String> inputPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String peopleString = new Scanner(System.in).nextLine();
        return Arrays.stream(peopleString.split(","))
                .filter(name -> !name.isBlank())
                .map(String::trim)
                .peek(name -> {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
                    }
                })
                .collect(Collectors.toList());
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요.");

        int height;
        try {
            height =  new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자가 입력되어야 합니다.", e);
        }

        if (height <= 0) {
            throw new IllegalArgumentException("1 이상의 숫자가 입력되어야 합니다.");
        }
        return height;
    }
}
