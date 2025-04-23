package nextstep.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 사다리의 각 행을 관리하는 객체
 * 0     1     2
 * |-----|-----|
 */
public class Line {
    private final int column;
    private final List<Edge> edges = new ArrayList<>();
    private final Random random = new Random();

    /** 기본 생성자: 모든 연결을 false 상태로 초기화 */
    private Line(int column) {
        this(column, IntStream.range(0, column - 1)
            .mapToObj(i -> new Edge(i, false))
            .collect(Collectors.toList()));
    }

    /** 내부 생성자: 미리 연산된 Edge 리스트를 주입 */
    private Line(int column, List<Edge> edges) {
        this.column = column;
        this.edges.addAll(edges);
    }

    /* 생성의도 명확하게 하는 팩토리 메서드 */
    public static Line ofColumn(int column) {
        return new Line(column);
    }

    /** 테스트용 팩토리: 외부에서 상태 리스트 주입 */
    public static Line ofStatus(int column, List<Boolean> statuses) {
        if (statuses.size() != column - 1) {
            throw new IllegalArgumentException("statuses 크기는 column-1 이어야 합니다.");
        }
        List<Edge> edges = IntStream.range(0, column - 1)
            .mapToObj(i -> new Edge(i, statuses.get(i)))
            .collect(Collectors.toList());
        return new Line(column, edges);
    }

    /** 랜덤으로 연결 상태를 다시 생성 */
    public void generateRandomStatus() {
        edges.clear();
        for (int i = 0; i < column - 1; i++) {
            boolean prev = (i > 0 && edges.get(i - 1).isConnected());
            boolean conn = !prev && random.nextBoolean();
            edges.add(new Edge(i, conn));
        }
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

    /** boolean 리스트*/
    public List<Boolean> rowStatus() {
        return edges.stream()
            .map(Edge::isConnected)
            .collect(Collectors.toUnmodifiableList());
    }

}
