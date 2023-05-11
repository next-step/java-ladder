package ladder.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    ByteArrayOutputStream output;

    @BeforeEach
    void 초기화() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    void 높이입력() {
        System.setIn(new ByteArrayInputStream("5".getBytes(StandardCharsets.UTF_8)));

        assertThat(InputView.nextInt()).isEqualTo(5);
    }

    @Test
    void 높이입력_문구() {
        InputView.askHeight();

        assertThat(output.toString()).contains("최대 사다리 높이는 몇 개 인가요?");
    }

    @Test
    void 참가자입력_문구() {
        InputView.askNames();

        assertThat(output.toString()).contains("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    @Test
    void 참가자입력() {
        System.setIn(new ByteArrayInputStream("a,b,c".getBytes(StandardCharsets.UTF_8)));

        assertThat(InputView.nextString()).isEqualTo("a,b,c");
    }

}
