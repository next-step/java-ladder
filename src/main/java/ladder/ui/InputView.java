package ladder.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView implements AutoCloseable {


    private static final String MAX_VERTICAL_LINE_LENGTH_QST = "최대 사다리 높이는 몇 개인가요?";
    private static final String USER_NAME_ASK_QST = "참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구분하세요)";
    private static final String DEFAULT_DELIMITER = ",";

    private static final String RESULT_ASK_QST = "실행 결과를 입력하세요. (결과는 쉼표(%s)로 구분하세요)";

    private static final String RESULT_OF_USER_ASK_QST = "결과를 보고 싶은 사람은?";
    private final BufferedReader bufferedReader;

    public InputView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void close() throws Exception {
        this.bufferedReader.close();
    }

    public List<String> getUser() throws IOException {
        System.out.printf(USER_NAME_ASK_QST, DEFAULT_DELIMITER);
        return Arrays.stream(bufferedReader.readLine().split(DEFAULT_DELIMITER))
                .collect(Collectors.toList());
    }

    public int getVerticalLine() throws IOException {
        System.out.println(MAX_VERTICAL_LINE_LENGTH_QST);
        return parseNumber(bufferedReader.readLine());
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.", e);
        }
    }

    public List<String> getResult() throws IOException {
        System.out.printf(RESULT_ASK_QST, DEFAULT_DELIMITER);
        return Arrays.stream(bufferedReader.readLine().split(DEFAULT_DELIMITER))
                .collect(Collectors.toList());
    }

    public String getUserForResult() throws IOException {
        System.out.printf(RESULT_OF_USER_ASK_QST);
        return bufferedReader.readLine().trim();
    }
}
