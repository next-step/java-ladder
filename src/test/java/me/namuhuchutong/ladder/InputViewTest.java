package me.namuhuchutong.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    private static final String NEW_LINE = "\n";

    @BeforeEach
    void setUp() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
    }

    private void setIn(String givenInput) {
        String input = createInputString(givenInput);
        System.setIn(convertForInputStream(input));
    }

    private String createInputString(String givenInput) {
        return givenInput + NEW_LINE;
    }

    private ByteArrayInputStream convertForInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("사다리 높이는 숫자만 입력할 수 있다.")
    @Test
    void ladder_height_should_be_number() {
        //given
        String given = "safdasf@";
        setIn(given);
        InputView inputView = new InputView();

        //when, then
        assertThatThrownBy(inputView::inputInteger)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
