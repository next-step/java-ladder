package camp.nextstep.edu.nextstep8.ladder.entity;

import camp.nextstep.edu.nextstep8.ladder.JoinersConvertor;

import java.util.*;
import java.util.stream.Collectors;

public class Ladder {
    private static final String PIPE = "|";
    private static final String LINE = "-----";
    private static final String SPACE = "     ";
    private static Random RANDOM = new Random();

    private final int cols;
    private final int height;
    private final List<Row> rows;
    private final List<String> joiners;

    public Ladder(String input, int height) {
        this.joiners = JoinersConvertor.makeJoiners(input);
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

    public Ladder make() {
        int randomRows, randomCols;
        for(int i = 0; i < cols * height; i++) {
            randomRows = RANDOM.nextInt(height - 1);
            randomCols = RANDOM.nextInt(cols - 1);
            rows.get(randomRows).draw(randomRows, randomCols);
        }
        return this;
    }

    public String getHeaderForPrint() {
        return joiners.stream().collect(Collectors.joining(SPACE));
    }

    public String getLadderForPrint() {
        StringBuilder output = new StringBuilder();
        int x = 0;
        for(Row row : rows) {
            output.append(getRowForPrint(row, x));
            output.append("\n");
            x++;
        }
        return output.toString();
    }

    private String getRowForPrint(Row row, int rowIndex) {
        StringBuilder output = new StringBuilder();
        for(int y = 0; y < cols; y++) {
            output.append(PIPE);
            output.append(resolveDrawLine(row.pick(rowIndex, y), row.pick(rowIndex, y + 1)));
        }
        return output.toString();
    }

    private boolean hasDrawLine(Point cur, Point next) {
        if(cur.meetLast(cols)) {
            return false;
        }
        return cur.isStart() && next.isEnd();
    }

    private String resolveDrawLine(Point cur, Point next) {
        if(hasDrawLine(cur, next)) {
            return LINE;
        }
        return SPACE;
    }
}
