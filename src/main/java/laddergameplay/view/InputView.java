package laddergameplay.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String INPUT_PEOPLE_MESSAGE = "참여할 사람들의 이름을 입력하세요. (이름은 쉽표(,)로 구분하세요.)";
    public static final String INPUT_RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String INPUT_PERSON_MESSAGE = "결과를 보고 싶은 사람은? (전체 : all, 종료 : exit)";
    public static final String INPUT_HEIGHT_OF_LADDER = "최대 사다리 높이는 몇 개인가요?";


    public static List<String> inputPeople() {
        String peopleString = inputString(INPUT_PEOPLE_MESSAGE);
        return stringToList(peopleString);
    }

    public static List<String> inputResults() {
        String resultsString = inputString(INPUT_RESULTS_MESSAGE);
        return stringToList(resultsString);
    }

    public static String inputPerson() {
        return inputString(INPUT_PERSON_MESSAGE);
    }

    public static int inputHeightOfLadder() {
        String inputValue = inputString(INPUT_HEIGHT_OF_LADDER);
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            System.out.println("사다리 높이는 숫자만 입력 가능 합니다.");
            System.exit(0);
            return 0;
        } finally {
            System.out.println();
        }
    }

    private static String inputString(String requestMessage) {
        System.out.println(requestMessage);
        String inputString = scanner.nextLine();
        System.out.println();
        return inputString;
    }

    private static List<String> stringToList(String peopleString){
        return Arrays.stream(peopleString.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
