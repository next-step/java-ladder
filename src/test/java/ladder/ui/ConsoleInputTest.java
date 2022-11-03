package ladder.ui;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleInputTest {

    private final ByteArrayOutputStream OUTPUT_STREAM_CAPTOR = new ByteArrayOutputStream();
    private final PrintStream STANDARD_OUT = System.out;

    private List<String> names;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(OUTPUT_STREAM_CAPTOR));
        names = List.of("hong", "foby", "jung", "apple");
    }

    @AfterEach
    void tearDown() {
        System.setOut(STANDARD_OUT);
    }

    @DisplayName("플레이어 이름들을 입력 받을 때")
    @Nested
    class Names {

        @DisplayName("메세지를 출력한다.")
        @Test
        void output_names_message() {
            setIn("name");

            ConsoleInput.receiveNames();
            String actual = OUTPUT_STREAM_CAPTOR.toString();

            assertThat(actual).isEqualTo("참여할 사람 이름을 입력하세요. (이름은 (,)로 구분하세요)\n");
        }

        @DisplayName("입력 받은 이름들을 구분자로 분리후 List 형으로 반환한다.")
        @ParameterizedTest
        @ValueSource(strings = "hong, foby, jung, apple")
        void receive_names(String input) {
            List<String> expected = names;
            setIn(input);

            List<String> actual = ConsoleInput.receiveNames();

            assertThat(actual).isEqualTo(expected);
        }
    }

    @DisplayName("높이를 입력받을 때")
    @Nested
    class Height {

        @DisplayName("메세지를 출력한다.")
        @Test
        void output_height_message() {
            setIn("1");

            ConsoleInput.receiveHeight();
            String actual = OUTPUT_STREAM_CAPTOR.toString();

            assertThat(actual).isEqualTo("최대 사다리 높이는 몇 개인가요?\n");
        }

        @DisplayName("입력받을 때 앞뒤 공백을 제거한다.")
        @ParameterizedTest
        @ValueSource(strings = " 1\n")
        void receive_height(String input) {
            setIn(input);

            String actual = ConsoleInput.receiveHeight();

            assertThat(actual).isEqualTo("1");
        }
    }

    private void setIn(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
    }

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
