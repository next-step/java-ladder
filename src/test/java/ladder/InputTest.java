package ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    @DisplayName("참가자가 한 명일 때 예외")
    void validatePlayers() {

        String input = "1,";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String errorMessage = "2명이상 입력해주세요";

        assertThatThrownBy(Input::players)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @Test
    @DisplayName("참가자가 입력시 구분자 ',' 가 아닐 때 예외")
    void validateSeparator() {

        String input = "poby.wuga.neojjc";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String errorMessage = "구분자 ',' 를 입력해주세요";

        assertThatThrownBy(Input::players)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @Test
    @DisplayName("참가자 이름이 5자를 초과했을 때 예외")
    void validateNameLength() {

        String input = "poby,wuga,neojjc";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String errorMessage = "이름은 최대 5글자만 입력 가능합니다.";

        assertThatThrownBy(Input::players)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }
}
