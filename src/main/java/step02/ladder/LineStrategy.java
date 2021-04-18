package step02.ladder;

import java.util.List;

interface LineStrategy {

    // 변경되는 부분과 변경되지 않는 부분을 분리한다.
    // 변경되는 부분을 인터페이스로 추출한다.
    // 인터페이스에 대한 구현체를 익명 클래스(anonymous class)로 구현해 메소드의 인자로 전달한다.
    boolean makeLine(List<Line> lines);

}
