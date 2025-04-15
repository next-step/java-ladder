package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamStudyTest {
    private List<Integer> numbers;

    @BeforeEach
    public void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void countWords() throws Exception {
        long result = StreamStudy.countWords();
        System.out.println("result : " + result);
    }

    @Test
    @DisplayName("단어의 길이가 12자를 초과하는 단어를 출력한다.")
    public void printLongestWordTop100_ShouldBeLengthOf12() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        StreamStudy.printLongestWordTop100();
        assertThat(out.toString().split(",")).allMatch(word -> word.length() > 12);
    }

    @Test
    @DisplayName("단어의 길이가 긴 순서로 100개의 단어를 추출한다.")
    public void printLongestWordTop100_ShouldOrderByLengthDesc() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        StreamStudy.printLongestWordTop100();
        assertThat(out.toString().split(","))
                .hasSize(100)
                .isSortedAccordingTo((word1, word2) -> word2.length() - word1.length());
    }

    @Test
    @DisplayName("단어 중복을 허용하지 않는다.")
    public void printLongestWordTop100_ShouldNotBeDuplicate() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        StreamStudy.printLongestWordTop100();
        assertThat(out.toString().split(",")).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("모든 단어는 소문자로 출력해야 한다.")
    public void printLongestWordTop100_ShouldBeLowerCase() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        StreamStudy.printLongestWordTop100();
        assertThat(out.toString().split(",")).allMatch(word -> word.equals(word.toLowerCase()));
    }


    @Test
    public void map() throws Exception {
        List<Integer> doubleNumbers = StreamStudy.doubleNumbers(numbers);
        doubleNumbers.forEach(System.out::println);
    }

    @Test
    public void sumAll() throws Exception {
        long sum = StreamStudy.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumOverThreeAndDouble() throws Exception {
        numbers = Arrays.asList(3, 1, 6, 2, 4, 8);
        long sum = StreamStudy.sumOverThreeAndDouble(numbers);
        assertThat(sum).isEqualTo(36);
    }
}
