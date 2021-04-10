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

    @DisplayName("파일에 존재하는 문자열들 중에 길이가 12를 초과하는 값들의 개수를 알맞게 반환하는지 테스트")
    @Test
    public void countWords() throws Exception {
        long result = StreamStudy.countWords();
        System.out.println("result : " + result);
    }

    @DisplayName("파일에 존재하는 문자열들 중에 길이가 12를 초과하는 값들 중 top 100개를 알맞게 반환하는지 테스트")
    @Test
    public void printLongestWordTop100() throws Exception {
        StreamStudy.printLongestWordTop100();
    }

    @DisplayName("주어진 리스트의 값을 2배로 변환 한 뒤 출력하는 테스트")
    @Test
    public void map() throws Exception {
        List<Integer> doubleNumbers = StreamStudy.doubleNumbers(numbers);
        doubleNumbers.forEach(System.out::println);
    }

    @DisplayName("주어진 리스트의 값들을 다 더한 누적 값을 테스트")
    @Test
    public void sumAll() throws Exception {
        long sum = StreamStudy.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @DisplayName("주어진 리스트의 값들 중 3초과 의 값들을 더한 누적 값을 테스트")
    @Test
    public void sumOverThreeAndDouble() throws Exception {
        numbers = Arrays.asList(3, 1, 6, 2, 4, 8);
        long sum = StreamStudy.sumOverThreeAndDouble(numbers);
        assertThat(sum).isEqualTo(36);
    }

}
