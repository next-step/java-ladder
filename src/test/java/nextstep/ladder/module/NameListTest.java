package nextstep.ladder.module;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameListTest {

    @Test
    @DisplayName("이름 리스트가 비어있으면 에러")
    void givenEmptyNames_whenCreateNameList_thenThrowException() {
        assertThatThrownBy(() -> new NameList(Collections.emptyList())).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 리스트는 비어있을 수 없습니다.");
    }

    @Test
    @DisplayName("이름 리스트가 중복된 이름을 포함하면 에러")
    void givenDuplicateNames_whenCreateNameList_thenThrowException() {
        assertThatThrownBy(() -> new NameList(Arrays.asList("bt", "bt"))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 리스트는 중복된 이름을 포함할 수 없습니다.");
    }

    @Test
    @DisplayName("이름 리스트가 최소 2개의 이름을 포함하지 않으면 에러")
    void givenLessThanTwoNames_whenCreateNameList_thenThrowException() {
        assertThatThrownBy(() -> new NameList(Collections.singletonList("bt")))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("이름 리스트는 최소 2개의 이름을 포함해야 합니다.");
    }

    @Test
    @DisplayName("이름 리스트가 최소 2개의 이름을 포함하면 통과")
    void givenAtLeastTwoNames_whenCreateNameList_thenPass() {
        assertThat(new NameList(Arrays.asList("bt", "tb")).value()).containsExactly(new Name("bt"), new Name("tb"));
    }

}
