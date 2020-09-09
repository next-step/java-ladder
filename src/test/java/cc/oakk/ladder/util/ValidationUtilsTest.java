package cc.oakk.ladder.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValidationUtilsTest {
    @ParameterizedTest()
    @CsvSource(value = { "10:11", "5:-5", "10:10", "5:-1", "10:50" }, delimiter = ':')
    public void throwIfOutOfArrayRange_ShouldThrow(int length, int index) {
        List<Integer> list = IntStream.range(0, length).boxed().collect(Collectors.toList());
        assertThatIllegalArgumentException().isThrownBy(() -> ValidationUtils.throwIfOutOfListSize(list, index));
    }
    
    @ParameterizedTest()
    @CsvSource(value = { "10:1", "5:2", "10:3", "5:0", "10:0" }, delimiter = ':')
    public void throwIfOutOfArrayRange(int length, int index) {
        List<Integer> list = IntStream.range(0, length).boxed().collect(Collectors.toList());
        assertThat(ValidationUtils.throwIfOutOfListSize(list, index)).isEqualTo(list);
    }

    @Test
    public void tryUntilSuccess() {
        Supplier<Integer> supplier = new Supplier<Integer>() {
            int i = 0;
            @Override
            public Integer get() {
                i += 1;
                if (i < 5) {
                    throw new RuntimeException();
                }
                return i;
            }
        };
        int result = ValidationUtils.tryUntilSuccess(supplier, t -> {});
        assertThat(result).isEqualTo(5);
    }
}
