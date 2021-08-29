package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
public class LineTest {

    @Test
    void 라인은_겹치면_오류발생(){
        assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> Line.of(Arrays.asList(true,true,false,false))
                ).withMessageContaining("라인은 겹치면 안됩니다.");
    }

}
