package nextstep.ladder.study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CollectionStudyTest {

    @Test
    void unmodifiableList() {
        //given
        List<Integer> unmodifiableList = Collections.unmodifiableList(Arrays.asList(1, 2, 3, 4));
        List<Integer> unmodifiableList2 = List.of(1, 2, 3, 4); // 위와 완전히 동일

        //when
        //then
        assertThatThrownBy(() -> unmodifiableList.add(1))
                .isInstanceOf(UnsupportedOperationException.class);

        assertThatThrownBy(() -> unmodifiableList2.add(1))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
