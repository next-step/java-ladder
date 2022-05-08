//package nextstep.ladder.domain;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.Test;
//
//class LineTest {
//
//    @Test
//    void createTest() {
//        String name = "pobi";
//        int height = 5;
//
//        Line line = Line.of(name, height, 0);
//
//        assertThat(line).isNotNull();
//        assertThat(line.getName()).isEqualTo(name);
//        assertThat(line.getHeight()).isEqualTo(height);
//        assertThat(line.getPartCount()).isEqualTo(height);
//    }
//
//    @Test
//    void connect_전_상태_테스트() {
//        String name = "pobi";
//        int height = 5;
//
//        Line line = Line.of(name, height, 0);
//
//        LinePart linePart = line.getParts().stream()
//            .filter(LinePart::isConnected)
//            .findAny()
//            .orElse(null);
//
//        assertThat(linePart).isNull();
//    }
//
//    @Test
//    void connectOneTest() {
//        String name = "pobi";
//        int height = 5;
//
//        Line line = Line.of(name, height, 0);
//        line.connectOne();
//
//        LinePart linePart = line.getParts().stream()
//            .filter(LinePart::isConnected)
//            .findAny()
//            .get();
//
//        assertThat(linePart).isNotNull();
//    }
//
//}