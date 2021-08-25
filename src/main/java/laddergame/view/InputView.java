package laddergame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputPeople() {
        System.out.println("참여할 사람들의 이름을 입력하세요. (이름은 쉽표(,)로 구분하세요.");
        String peopleString = scanner.nextLine();
        return peopleStringToList(peopleString);
    }

    public static int inputHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    private static List<String> peopleStringToList(String peopleString){
        return Arrays.stream(peopleString.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
