package ladder.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView implements AutoCloseable {


    private static final String MAX_VERTICAL_LINE_LENGTH_QST = "최대 사다리 높이는 몇 개인가요?";
    private static final String USER_NAME_ASK_QST = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final BufferedReader bufferedReader;

    public InputView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void close() throws Exception {
        this.bufferedReader.close();
    }

    public List<String> getUser() throws IOException {
        System.out.println(USER_NAME_ASK_QST);
        return Arrays.stream(bufferedReader.readLine().split(",")).collect(Collectors.toList());
    }

    public Integer getVerticalLine() throws IOException {
        System.out.println(MAX_VERTICAL_LINE_LENGTH_QST);
        return parseNumber(bufferedReader.readLine());
    }

    private Integer parseNumber(String input) {
        try {
            return Integer.valueOf(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.", e);
        }
    }

}
