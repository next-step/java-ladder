package nextstep.ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringParserTest {

    @Test
    @DisplayName("성공 - 참여자의 이름을 쉼표로 구분한다.")
    void success_string_parse() {
        String text = "pobi,honux,crong,jk";
        int size = 4;

        List<String> persons = StringParser.split(text);

        assertThat(persons).hasSize(size);
    }

}