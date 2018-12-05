import java.util.ArrayList;
import java.util.List;

/**
 * 이동 직진, 왼쪽, 오른쪽 이동
 * 라인 만들기
 * 사람 입력받기
 * 출력하기
 *
 */
public class LadderLine {
    private List<Point> points = new ArrayList<Point>();

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson, LadderLineGenerator ladderLineGenerator) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, ladderLineGenerator);
        point = initBody(sizeOfPerson, points, point, ladderLineGenerator);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static void initLast(List<Point> points, Point point) {
        points.add(point.last());
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, LadderLineGenerator ladderLineGenerator) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(ladderLineGenerator);
            points.add(point);
        }
        return point;
    }

    private static Point initFirst(List<Point> points, LadderLineGenerator ladderLineGenerator) {
        Point point = Point.first(ladderLineGenerator.generatePoint());
        points.add(point);
        return point;
    }
    
    
    public static int move(int idx, List<LadderLine> ladderLines) {
        for (int i = 0; i < ladderLines.size(); i++) {
            idx = ladderLines.get(i).move(idx);
        }
        
        return idx;
    }
    
    public List<Point> getPoints() {
        return points;
    }
    
    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
