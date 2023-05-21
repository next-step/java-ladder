package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ladder.domain.Height;
import ladder.domain.exception.LadderException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

    @Test
    @DisplayName("높이 생성 테스트")
    void generateHeightTest() {
        int height = 4;
        Height maxHeight = Height.from(height);

        Assertions.assertThat(maxHeight.getHeight()).isEqualTo(height);
    }

    @Test
    @DisplayName("높이 생성 예외 테스트")
    void generateHeightExceptionTest() {
        int height = 0;

        Assertions.assertThatThrownBy(() -> Height.from(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LadderException.HEIGHT_UNDER_ZERO.getMessage());
    }

    @Test
    void ttt() {
        String a = "AaA";
        String b = "aaa";

        List<String> s = Arrays.asList("AaA", "aaa");

        s.stream().distinct().forEach(System.out::println);
    }
}
