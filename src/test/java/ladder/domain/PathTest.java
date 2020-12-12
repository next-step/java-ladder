package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PathTest {
    private int startIndex;
    private int endIndex;

    @BeforeEach
    public void init(){
        startIndex = 0;
        endIndex = 1;
    }

    @DisplayName("Path 생성 테스트")
    @Test
    void pathConstructorTest(){
        assertThat(Path.of(startIndex, endIndex)).isEqualTo(Path.of(startIndex, endIndex));
    }
}
