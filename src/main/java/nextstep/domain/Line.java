package nextstep.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 사다리의 각 행을 관리하는 객체
 * 0     1     2
 * |-----|-----|
 */
public class Line {
    private final int column;
    private final List<Edge> edges = new ArrayList<>();

    /** 내부 생성자: 미리 연산된 Edge 리스트를 주입 */
    private Line(int column, List<Edge> edges) {
        this.column = column;
        this.edges.addAll(edges);
    }

    /**
     * 전략 패턴을 이용한 팩토리 메서드
     */
    private static Line of(int column, EdgeStrategy strategy) {
        List<Edge> edges = new ArrayList<>();
        boolean prev = false;
        for (int i = 0; i < column - 1; i++) {
            boolean connected = strategy.generate(i, prev);
            edges.add(new Edge(i, connected));
            prev = connected;
        }
        return new Line(column, edges);
    }

    /**
     * 자동 라인 생성
     */
    public static Line ofRandom(int column) {
        return of(column, new RandomEdgeStrategy());
    }

    /**
     * 라인 수동 생성
     */
    public static Line ofManual(int column, List<Boolean> statues) {
        return of(column, new ManualEdgeStrategy(statues));
    }

    /**
     * 현재 위치(position)에서 이 라인을 타고 이동할 최종 인덱스를 반환.
     */
    public int move(int position) {
        for (Edge edge : edges) {
            Optional<Integer> next = edge.otherSide(position);
            if (next.isPresent()) {
                return next.get();
            }
        }
        return position;
    }

    public List<Boolean> statues() {
        List<Boolean> statues = new ArrayList<>();
        for (Edge edge : edges) {
            statues.add(edge.isConnected());
        }
        return statues;
    }

}
