package cc.oakk.ladder.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayUtilsTest {
    @ParameterizedTest
    @MethodSource("createBooleanLists")
    public void toPrimitiveArray(boolean[] booleans) {
        List<Boolean> booleanList = IntStream.range(0, booleans.length).mapToObj(i -> booleans[i]).collect(Collectors.toList());
        assertThat(ArrayUtils.toPrimitiveArray(booleanList))
                .isEqualTo(booleans);
    }

    private static Stream<boolean[]> createBooleanLists() {
        return Stream.of(
                new boolean[]{ true, false, true, false },
                new boolean[]{ false, false, true, false },
                new boolean[]{ true, true, true, false },
                new boolean[]{ true, false, true, true, false, true }
        );
    }
}
