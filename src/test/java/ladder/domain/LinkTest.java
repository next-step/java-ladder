package ladder.domain;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkTest {
    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "1,2,3,4 | 1 | 2,1,3,4",
            "1,2,3,4 | 2 | 1,3,2,4",
            "1,2,3,4 | 3 | 1,2,4,3",
    })
    void swapPosition(
            @ConvertWith(IntListConverter.class) List<Integer> initial,
            int linkIndex,
            @ConvertWith(IntListConverter.class) List<Integer> expected
    ) {
        new Link(linkIndex, true).swapPosition(initial);
        assertThat(initial).isEqualTo(expected);
    }

    static class IntListConverter implements ArgumentConverter {
        @Override
        public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
            String stringSource = (String) source;
            return Arrays.stream(stringSource.split(",")).collect(Collectors.toList());
        }
    }
}
