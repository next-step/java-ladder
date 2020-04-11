package ladder.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    private static final String REQUEST_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUEST_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final int NAME_START = 0;
    private static final int NAME_LIMIT = 5;

    private final List<String> participants;
    private final int height;

    public InputView() {
        System.out.println(REQUEST_NAME);
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        String[] nameToken = inputValue.split(COMMA);
        this.participants = getParticipants(nameToken);
        this.height = requestHeight();
    }

    private List<String> getParticipants(String[] nameToken) {
        return Arrays.stream(nameToken)
                .map(String::trim)
                .collect(toList());
    }

    public List<String> getParticipants() {
        return participants;
    }

    public int getCountOfPerson() {
        return participants.size();
    }

    public int getHeight() {
        return height;
    }

    private int requestHeight() {
        System.out.println(REQUEST_HEIGHT);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InvalidHeightException();
        }
    }
}
