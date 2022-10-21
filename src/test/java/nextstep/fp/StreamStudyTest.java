package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamStudyTest {
    private List<Integer> numbers;
    private List<String> words;

    @BeforeEach
    public void setup() throws IOException {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        words = StreamStudy.findLongestWordTop100();
    }

    @Test
    public void countWords() throws Exception {
        long result = StreamStudy.countWords();
        System.out.println("result : " + result);
    }

    @DisplayName("12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 출력한다. 단 중복이 없어야하며, 모두 소문자로 출력해야한다.")
    @Nested
    class LongestWordTop100 {

        @DisplayName("출력")
        @Test
        public void printLongestWordTop100() throws IOException {
            StreamStudy.printLongestWordTop100();
        }

        @DisplayName("길이가 긴 순서대로 정렬되어 있는지")
        @Test
        public void printLongestWordTop100_sort() {
            IntStream.range(0, words.size() - 1)
                    .forEach(index -> assertThat(findWordLength(words, index))
                            .isGreaterThanOrEqualTo(findWordLength(words, index + 1)));
        }

        private int findWordLength(List<String> words, int index) {
            return words.get(index).length();
        }

        @DisplayName("모든 단어가 12자가 넘는지 확인")
        @Test
        public void printLongestWordTop100_max_word_length() {
            words.forEach(word -> assertThat(word.length()).isGreaterThan(12));
        }

        @DisplayName("모든 단어가 소문자인지 확인")
        @Test
        public void printLongestWordTop100_lower_case() {
            words.forEach(word -> assertThat(word).isLowerCase());
        }

        @DisplayName("중복된 단어는 없는지 확인")
        @Test
        public void printLongestWordTop100_duplicate() {
            int expected = words.size();

            int actual = new HashSet<>(words).size();

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("단어 개수가 100가인지 확인")
        @Test
        public void printLongestWordTop100_list_size() {
            int actual = words.size();

            assertThat(actual).isEqualTo(100);
        }
    }

    @Test
    public void map() {
        List<Integer> doubleNumbers = StreamStudy.doubleNumbers(numbers);
        doubleNumbers.forEach(System.out::println);
    }

    @Test
    public void sumAll() {
        long sum = StreamStudy.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumOverThreeAndDouble() {
        numbers = Arrays.asList(3, 1, 6, 2, 4, 8);
        long sum = StreamStudy.sumOverThreeAndDouble(numbers);
        assertThat(sum).isEqualTo(36);
    }
}
