package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamStudyTest {
    private List<Integer> numbers;

    @BeforeEach
    public void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("길이가 12자가 넘는 단어의 개수를 출력한다")
    @Test
    public void countWords() {
        long result = StreamStudy.countWords();
        System.out.println("result : " + result);
    }

    @DisplayName("가장 긴 단어 순으로 100건을 출력한다")
    @Test
    public void printLongestWordTop100() {
        StreamStudy.printLongestWordTop100();
    }

    @DisplayName("2배 하여 출력한다")
    @Test
    public void map() {
        List<Integer> doubleNumbers = StreamStudy.doubleNumbers(numbers);
        doubleNumbers.forEach(System.out::println);
    }

    @DisplayName("전체 총 합이 올바른지 확인")
    @Test
    public void sumAll() {
        // given
        long expected = 21L;

        // when
        long sum = StreamStudy.sumAll(numbers);

        // then
        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName("3보다 큰 수 들만 2배 하여 전체 총 합이 올바른지 확인")
    @Test
    public void sumOverThreeAndDouble() {
        // given
        numbers = Arrays.asList(3, 1, 6, 2, 4, 8);
        long expected = 36L;

        // when
        long sum = StreamStudy.sumOverThreeAndDouble(numbers);

        // then
        assertThat(sum).isEqualTo(expected);
    }
}
