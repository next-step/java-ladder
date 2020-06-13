package camp.nextstep.edu.nextstep8.ladder.entity;

import camp.nextstep.edu.nextstep8.ladder.JoinMemberConvertor;

import java.util.*;

public class Ladder {
    private static Random RANDOM = new Random();
    private final int cols;
    private final int height;
    private final List<Row> rows;
    private final List<String> joiners;

    public Ladder(String joinMemberStr, int height) {
        this.joiners = JoinMemberConvertor.makeJoinMembers(joinMemberStr);
        this.cols = joiners.size();
        this.height = height;
        this.rows = generateRows();
    }

    private List<Row> generateRows(){
        List<Row> rows = new ArrayList<>();
        for(int x = 0; x < height; x++) {
            rows.add(generateRow(x));
        }

        return rows;
    }

    private Row generateRow(int x) {
        List<Point> points = new ArrayList<>();
        for(int y = 0; y < cols; y++) {
            points.add(new Point(x, y));
        }
        return new Row(points);
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(rows);
    }

    public List<String> getJoiners() {
        return Collections.unmodifiableList(joiners);
    }

    public int getCols() {
        return cols;
    }

    public int getHeight() {
        return height;
    }

    public void make() {
        int randomRows, randomCols;
        for(int i = 0; i < cols * height; i++) {
            randomRows = RANDOM.nextInt(height - 1);
            randomCols = RANDOM.nextInt(cols - 1);
            rows.get(randomRows).draw(randomRows, randomCols);
        }
    }
}
