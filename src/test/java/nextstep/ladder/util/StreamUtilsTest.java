package nextstep.ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class StreamUtilsTest {

    @Test
    @DisplayName("리스트 요소를 두 개씩 짝지어 순회하는 스트림을 만든다.")
    void generatePairStream() {
        List<Integer> lists = Arrays.asList(1, 2, 3, 4);
        List<Pair<Integer, Integer>> pairs = Arrays.asList(
            new Pair<>(1, 2),
            new Pair<>(2, 3),
            new Pair<>(3, 4)
        );

        assertThat(StreamUtils.pairStream(lists)
                              .collect(Collectors.toList())).isEqualTo(pairs);
    }

    @Test
    @DisplayName("요소 개수가 부족하여 짝을 만들 수 없으면 빈 스트림을 반환한다.")
    void returnEmptyStream() {
        List<Integer> singletonList = Collections.singletonList(1);
        List<Integer> emptyList = Collections.emptyList();

        assertAll(
            () -> assertThat(StreamUtils.pairStream(singletonList)
                                        .collect(Collectors.toList())).isEmpty(),
            () -> assertThat(StreamUtils.pairStream(emptyList)
                                        .collect(Collectors.toList())).isEmpty()
        );
    }
}
