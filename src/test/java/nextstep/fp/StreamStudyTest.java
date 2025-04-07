package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void printLongestWordTop100() throws Exception {
        StreamStudy.printLongestWordTop100();
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

    @Test
    void doubleNumbersTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> expected = Arrays.asList(2, 4, 6);
        assertEquals(expected, StreamStudy.doubleNumbers(numbers));
    }

    @Test
    void sumAllTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(15, StreamStudy.sumAll(numbers));
    }

    @Test
    void printLongestWordTop100_출력_검증() throws Exception {
        // 기존 표준 출력을 가로채기 위한 설정
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 테스트 실행
        StreamStudy.printLongestWordTop100();

        // 출력된 결과를 라인 단위로 분리
        String output = outContent.toString(StandardCharsets.UTF_8);
        String[] lines = output.strip().split("\\R"); // \R: 모든 라인 구분자 처리

        // 검증 1: 정확히 100개의 단어가 출력됐는가?
        assertEquals(100, lines.length, "100개의 단어가 출력되어야 합니다.");

        // 검증 2: 모든 단어가 12자 초과인가?
        assertTrue(Arrays.stream(lines).allMatch(word -> word.length() > 12), "모든 단어는 12자 초과여야 합니다.");

        // 검증 3: 중복이 없는가?
        Set<String> uniqueWords = Arrays.stream(lines).collect(Collectors.toSet());
        assertEquals(100, uniqueWords.size(), "모든 단어는 중복 없이 고유해야 합니다.");
    }
}
