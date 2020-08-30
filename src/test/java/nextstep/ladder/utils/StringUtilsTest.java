package nextstep.ladder.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    private String input;

    @BeforeEach
    void setUp() {
        input = "pobi,honux,crong,jk";
    }

    @Test
    @DisplayName("입력되는 이름 split")
    void split() {
        String[] split = new StringUtils(input).split();
        assertThat(split).contains("pobi", "honux", "crong", "jk");
    }

}
