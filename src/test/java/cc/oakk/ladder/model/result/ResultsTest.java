package cc.oakk.ladder.model.result;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultsTest {
    @Test
    public void constructor_ShouldThrow_WhenEmptyList() {
        assertThatIllegalArgumentException().isThrownBy(() ->  new Results(null));
        assertThatIllegalArgumentException().isThrownBy(() ->  new Results(new ArrayList<>()));
    }

    @Test
    public void get() {
        Results results = new Results(Stream.of("꽝", "꽝", "1000", "2000")
                .map(Result::new)
                .collect(Collectors.toList()));

        assertThat(results.get(0)).isEqualTo(new Result("꽝"));
        assertThat(results.get(1)).isEqualTo(new Result("꽝"));
        assertThat(results.get(2)).isEqualTo(new Result("1000"));
        assertThat(results.get(3)).isEqualTo(new Result("2000"));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6 })
    public void size(int size) {
        Results results = new Results(IntStream.range(0, size).boxed()
                .map(v -> new Result("temp"))
                .collect(Collectors.toList()));
        assertThat(results.size()).isEqualTo(size);
    }

    @Test
    public void forEach() {
        List<String> names = Arrays.asList("꽝", "꽝", "1000", "2000");
        Results results = new Results(names.stream()
                .map(Result::new)
                .collect(Collectors.toList()));

        List<String> forEachResults = new ArrayList<>();
        results.forEach(result -> forEachResults.add(result.getName()));
        assertThat(forEachResults).isEqualTo(names);
    }
}
