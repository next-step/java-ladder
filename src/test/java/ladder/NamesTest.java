package ladder;

import nextstep.ladder.Name;
import nextstep.ladder.Names;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {
    @Test
    @DisplayName("[Names.of] 이름 하나 주면 -> 이름 하나 담긴 리스트 반환")
    public void generation() {
        assertThat(Names.of("hello"))
                .hasSameElementsAs(List.of(new Name("hello")));
    }

    @Test
    @DisplayName("[Names.of] ,로 구분되는 이름 주면 -> 분리된 이름을 담고 있는 리스트 반환")
    public void multipleGeneration() {
        assertThat(Names.of("hello,world"))
                .hasSameElementsAs(
                        List.of( new Name("hello"),
                                new Name("world")
                        )
                );
    }
}