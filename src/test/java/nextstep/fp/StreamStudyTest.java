package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class StreamStudyTest {
    private List<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    void countWords() throws Exception {
        long result = StreamStudy.countWords();
        System.out.println("result : " + result);
    }

    @Test
    void printLongestWordTop100() throws Exception {
        //when
        List<String> strings = StreamStudy.printLongestWordTop100();
        //then
        assertAll(
                () -> assertThat(strings.size()).isEqualTo(100),
                () -> assertThat(strings).extracting(String::length)
                        .allMatch(length -> length > 12),
                () -> assertThat(strings).extracting(String::chars)
                        .allMatch(chars -> chars.allMatch(Character::isLowerCase)),
                () -> assertThat(strings.get(0).length())
                        .isGreaterThanOrEqualTo(strings.get(strings.size() - 1).length())
        );
    }

    @Test
    void map() {
        List<Integer> doubleNumbers = StreamStudy.doubleNumbers(numbers);
        doubleNumbers.forEach(System.out::println);
    }

    @Test
    void sumAll() {
        long sum = StreamStudy.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    void sumOverThreeAndDouble() {
        numbers = Arrays.asList(3, 1, 6, 2, 4, 8);
        long sum = StreamStudy.sumOverThreeAndDouble(numbers);
        assertThat(sum).isEqualTo(36);
    }
}
