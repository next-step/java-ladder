package ladder.domain.model;

import ladder.dto.ResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    private final List<String> values = Arrays.asList(
            "1",
            "22",
            "333",
            "4444",
            "55555"
    );
    private final Results results = values.stream()
            .map(Result::new)
            .collect(collectingAndThen(toList(), Results::new));

    @Test
    @DisplayName("Results 의 사이즈가 정상적으로 받아져야 한다.")
    void size() {
        assertThat(results.size())
                .isEqualTo(5);
    }

    @ParameterizedTest
    @DisplayName("position 에 올바른 ResultDto 를 반환하는지 확인")
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void exportResultDto(int position) {
        assertThat(results.exportResultDto(position).getResult())
                .isEqualTo(values.get(position));
    }

    @Test
    @DisplayName("ResultsDto 의 포장을 풀었을 때 값이 일치하는지 확인")
    void exportResultsDto() {
        assertThat(results.exportResultsDto()
                .getResults()
                .stream()
                .map(ResultDto::getResult)
                .collect(toList())
        ).isEqualTo(values);
    }

    @Test
    @DisplayName("exportMovedResultsDto 확인")
    void exportMovedResultsDto() {
        assertThat(results.exportMovedResultsDto(position -> values.size() - position - 1)
                .getResults()
                .stream()
                .map(ResultDto::getResult)
                .collect(toList())
        ).isEqualTo(Arrays.asList(
                "55555",
                "4444",
                "333",
                "22",
                "1"
        ));
    }
}
