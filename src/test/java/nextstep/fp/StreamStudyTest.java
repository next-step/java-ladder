package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("스트림 실습 - StreamStudy 클래스 테스트")
public class StreamStudyTest {
    private List<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("filter - 파일 문자 중 길이가 12보다 큰 문자의 수 계산")
    void countWords() throws Exception {
        long result = StreamStudy.countWords();
        assertThat(result).isEqualTo(1946);
    }

    @Test
    @DisplayName("map - 리스트에 담긴 모든 숫자 2배한 결과로 List 생성")
    void map() throws Exception {
        List<Integer> doubleNumbers = StreamStudy.doubleNumbers(numbers);
        assertThat(doubleNumbers).containsExactly(2, 4, 6, 8, 10, 12);
    }

    @Test
    @DisplayName("reduce - 리스트에 담긴 모든 숫자 합 구현")
    void sumAll() throws Exception {
        long sum = StreamStudy.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    @DisplayName("실습 1 - 3보다 큰 숫자를 2배한 후 모든 값의 합 계산")
    void sumOverThreeAndDouble() throws Exception {
        numbers = Arrays.asList(3, 1, 6, 2, 4, 8);
        long sum = StreamStudy.sumOverThreeAndDouble(numbers);
        assertThat(sum).isEqualTo(36);
    }

    @Test
    @DisplayName("실습 2 - 12자를 넘는 단어를 중복없이 긴 순서로 100개 추출해 소문자로 출력")
    void printLongestWordTop100() throws Exception {
        StreamStudy.printLongestWordTop100();
    }
}
