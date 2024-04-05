package ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {

    @Test
    @DisplayName("쉼표 구분 테스트")
    void splitWithCommaTest(){
        List<String> names = StringSplitter.splitWithComma("jay,kim,lee");

        assertThat(names).hasSize(3);
        assertThat(names).containsExactlyInAnyOrder("jay", "kim", "lee");
    }
}
