//package nextstep.ladder.domain;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertAll;
//
//class LadderBaseLineTest {
//
//
//    @DisplayName("연결된 Point위치의 연결여부를 물어보면 true/false 를 반환한다")
//    @Test
//    void connect() {
//        //given
//        Set<Point> points = new HashSet<>();
//        points.add(Point.of(1));
//        points.add(Point.of(2));
//        ConnectPoints connectPoints = ConnectPoints.of(points, 5);
//        LadderBaseLine userLine = new LadderBaseLine(new LadderGameUser(Order.FIRST_ORDER, "abc"), connectPoints);
//
//        //when
//        //then
//        assertAll(
//                () -> assertThat(userLine.connectedWith(Point.of(1))).isEqualTo(true),
//                () -> assertThat(userLine.connectedWith(Point.of(2))).isEqualTo(true),
//                () -> assertThat(userLine.connectedWith(Point.of(3))).isEqualTo(false)
//        );
//    }
//}