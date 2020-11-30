package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.dto.LadderDto;
import step2.dto.PlayersRewardsDto;
import step2.exception.EmptyNameException;
import step2.exception.LadderHeightException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameSplitterTest {

    @Test
    @DisplayName("이름이 잘 나누어지는지 확인한다.")
    void create() {
        //given
        String name = "a,b,c";
        List<String> names = NameSplitter.splitParticipationNames(name);

        //then
        assertThat(names).isEqualTo(Arrays.asList("a", "b", "c"));
        assertThat(names).containsExactly("a", "b", "c");
    }

    @Test
    @DisplayName("빈칸을 입력하면 익셉션이 발생한다.")
    void throwNullException() {
        assertThatThrownBy(() -> NameSplitter.splitParticipationNames("  "))
                .isInstanceOf(EmptyNameException.class);
    }

}
