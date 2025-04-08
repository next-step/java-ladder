package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @Test
    void 참여자_이름_생성() {
        Name name = new Name("pobi2");
        assertThat(name).isEqualTo(new Name("pobi2"));
    }

    @Test
    void 참여자_이름_초과() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name("pobi22"));
    }
}
