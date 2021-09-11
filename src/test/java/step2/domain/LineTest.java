//package step2.domain;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class LineTest {
//
//    @Test
//    @DisplayName("first line은 false로 생성")
//    void createFirstLineTest() {
//        final int height = 3;
//        final Line firstLine = new Line(height);
//        final Line expected = new Line(Stream.generate(() -> false)
//                .limit(height)
//                .collect(Collectors.toList()));
//        assertThat(firstLine).isEqualTo(expected);
//    }
//
//    @Test
//    @DisplayName("first line의 point가 false일 때 true로 point 생성 테스트")
//    void createLineTest() {
//        final int height = 5;
//        final Line firstLine = new Line(height);
//        final Line actual = new Line(firstLine, () -> true);
//
//        final Line expected = new Line(Stream.generate(() -> true)
//                .limit(height)
//                .collect(Collectors.toList()));
//
//        System.out.println(actual);
//        System.out.println(expected);
//        assertThat(actual).isEqualTo(expected);
//    }
//
//}