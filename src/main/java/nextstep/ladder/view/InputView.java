package nextstep.ladder.view;

import nextstep.ladder.domain.PersonName;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int getPositiveNumberInput(String prompt) {
        return getNumberInput(prompt, "0 이상의 정수만 허용됩니다. 다시 입력해 주세요.",
                input -> input >= 0);
    }

    private static int getNumberInput(String prompt, String errorMessage, Predicate<Integer> predicate) {
        System.out.println(prompt);

        while (true) {
            try {
                int result = scanner.nextInt();

                // scanner.nextInt() 는 개행 문자를 제거하지 못해 nextInt 이후 nextLine 으로 개행 제거
                scanner.nextLine();

                if (predicate.test(result)) {
                    return result;
                }

                System.out.println(errorMessage + " input: " + result);
            } catch (InputMismatchException e) {
                System.out.println(errorMessage + scanner.nextLine());
            }
        }
    }

    public static List<String> getPersonNameInput(String prompt, String delimiter) {
        System.out.println(prompt);
        while (true) {
            String line = scanner.nextLine();

            String[] split = line.split(delimiter);
            if (split.length == 0) {
                System.out.println("이름은 하나 이상 입력되어야 합니다. 다시 입력해 주세요.");
                continue;
            }

            List<String> result = Arrays.stream(split)
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());

            if (split.length != result.size()) {
                System.out.println("이름은 중복될 수 없습니다. 다시 입력해 주세요.");
                continue;
            }

            if (result.stream().allMatch(s -> s.length() <= PersonName.MAX_NAME_LENGTH)) {
                return result;
            }

            System.out.println("이름은 최대 5글자까지 사용 가능합니다. 다시 입력해 주세요.");
        }
    }
}
