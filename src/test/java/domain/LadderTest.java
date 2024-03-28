package domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("입력으로 들어온 높이를 기반으로 Ladder 객체를 생성한다. ")
    @Test
    void test01() {
        Ladder ladder = new Ladder(List.of(new Name("pobi"), new Name("jay"), new Name("bob")), 5);
        
        assertThat(ladder).isNotNull();
    }
}
