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

    @DisplayName(value = "파일 내에 word 전체 갯수 확인 테스트")
    @Test
    public void countWords() throws Exception {
        long result = StreamStudy.countWords();
        assertThat(result).isEqualTo(1946);
    }

    @DisplayName(value = "파일 내에 존재하는 단어를 가장 긴 순으로 100개를 소문자로 출력")
    @Test
    public void printLongestWordTop100() throws Exception {
        StreamStudy.printLongestWordTop100();
    }

    @DisplayName(value = "List에 담긴 모든 숫자 값을 2배한 결과 List를 생성 테스트")
    @Test
    public void map() {
        List<Integer> doubleNumbers = StreamStudy.doubleNumbers(numbers);
        doubleNumbers.forEach(System.out::println);
    }

    @DisplayName(value = "숫자 합산 테스트")
    @Test
    public void sumAll() {
        long sum = StreamStudy.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @DisplayName(value = "숫자 조건에 따른 합산 테스트 (3을 초과 및 2배)")
    @Test
    public void sumOverThreeAndDouble() {
        numbers = Arrays.asList(3, 1, 6, 2, 4, 8);
        long sum = StreamStudy.sumOverThreeAndDouble(numbers);
        assertThat(sum).isEqualTo(36);
    }
}
