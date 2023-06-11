package nextstep.fp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamStudyTest {

  private static final Logger log = LoggerFactory.getLogger(StreamStudyTest.class);
  private List<Integer> numbers;

  @BeforeEach
  public void setup() {
    numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
  }

  @Test
  public void countWords() throws Exception {
    long result = StreamStudy.countWords();
    log.info("result : {}", result);
  }

  @Test
  public void printLongestWordTop100() throws Exception {
    List<String> actualWords = (List<String>) StreamStudy.printLongestWordTop100();
    assertAll("",
        () -> assertThat(actualWords)
            .as("길이가 12 초과해야한다")
            .noneMatch(string -> string.length() <= 12),
        () -> assertThat(actualWords)
            .as("100개의 원소를 갖는다")
            .hasSize(100),
        () -> assertThat(actualWords)
            .as("중복을 허용하지 않는다")
            .doesNotHaveDuplicates(),
        () -> assertThat(actualWords)
            .as("소문자로만 구성되어야 한다")
            .noneMatch(string -> string.matches(".*[A-Z].*")),
        () -> assertThat(actualWords)
            .as("문자열의 길이 순서로 정렬되어있어야만 한다")
            .isSortedAccordingTo(Comparator.comparingInt(String::length))
    );
  }

  @Test
  public void map() throws Exception {
    List<Integer> doubleNumbers = StreamStudy.doubleNumbers(numbers);
    doubleNumbers.forEach(i -> log.info("{}", i));
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
