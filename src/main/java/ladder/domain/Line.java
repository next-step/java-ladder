package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private List<Bar> bars;

    Line(List<Bar> bars) {
        this.bars = new ArrayList<>(bars);
    }

    public static Line from(int numberOfPlayers) {
        LineMaker lineMaker = new LineMaker();
        return new Line(lineMaker.generateBars(numberOfPlayers));
    }

    public List<Bar> getBars() {
        return Collections.unmodifiableList(bars);
    }

    Position travel(Position position) {
        if (bars.get(position.getPosition()).isExist()) {
            return position.moveToRight(); // 사용자와 같은 위치에 bar가 있으면 사용자 위치 1 증가
        }
        if (position.isMovableToLeft()
                && bars.get(position.getLeftPosition()).isExist()) {
            return position.moveToLeft(); // 사용자의 왼쪽에 bar가 있으면 사용자 위치 1 감소
        }
        return position; // 위의 경우가 아니면 위치 유지(패스)
    } //TODO: 이 부분에 대한 질문을 https://github.com/next-step/java-ladder/pull/207 피드백 주신 이 곳에 남겼습니다.

}
