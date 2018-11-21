package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private ArrayList<Position> points = new ArrayList<>();
    private int countOfPerson;

    private Line(int countOfPerson) {
        this.countOfPerson = countOfPerson;
    }

    public static Line of(int countOfPerson, List<Direction> directions) {
        Line line = new Line(countOfPerson);
        directions.stream()
                .forEach(d -> {
                    line.addPoint(d);
                });
        
        return line;
    }

    public static Line of(int countOfPerson) {
        Line line = new Line(countOfPerson);
        for (int i = 0; i < countOfPerson; i++) {
            line.addPoint(Direction.STRAIGHT);
        }
        return line;
    }

    public boolean hasLine(int index) {
        if (index >= points.size()) {
            return false;
        }

        if (index < 0) {
            return false;
        }

        return points.get(index).hasLeftOrRight();
    }

    /**
     * 좌표 추가
     *
     * @param direction
     */
    public void addPoint(Direction direction) {
        if (points.size() >= countOfPerson) {
            throw new IllegalStateException("좌표의 최대값은 인원 수를 초과할 수 없습니다.");
        }

        points.add(Position.of(Positive.of(points.size()), direction));
    }
    

    /**
     * 선 추가
     *
     * @param index
     */
    public void addLine(Integer index) {
        addLine(Positive.of(index));
    }

    /**
     * 선 만듦
     *
     * @param index
     */
    public void addLine(Positive index) {
        if (!canAddLine(index)) {
            throw new IllegalArgumentException("선 생성 불가");
        }
        int num = index.getNum();
        points.get(num).setDirectionRight();
    }

    /**
     * 해당 좌표에 선을 추가할 수 있는지 여부
     *
     * @param index
     * @return
     */
    public boolean canAddLine(int index) {
        return canAddLine(Positive.of(index));
    }

    /**
     * 해당 좌표에 선을 추가할 수 있는지 여부 (양수)
     *
     * @param index
     * @return
     */
    public boolean canAddLine(Positive index) {
        
        int num = index.getNum();
        if (num >= points.size() - 1) {
            return false;
        }
        if( points.get(num).hasLeftOrRight() ) {
            return false;
        }

        return true;
    }

    public List<Position> getPoints() {
        return Collections.unmodifiableList(points);
    }

    /**
     * 자동으로 선 추가
     */
    public void addAutoLines() {
        Random random = new Random();
        IntStream.rangeClosed(0, points.size())
                .filter(i -> isAddLine(random.nextBoolean(), i))
                .forEach(this::addLine);
    }

    /**
     * 선 추가할 건지 여부
     *
     * @param isAdd
     * @param i
     * @return
     */
    private boolean isAddLine(Boolean isAdd, int i) {
        return canAddLine(i) && isAdd;
    }
    
    public static Positive move(List<Line> lines, Positive result) {
        for (int i = 0; i < lines.size(); i++) {
            result = lines.get(i).getPoints().get(result.getNum()).move();
        }
        return result;
    }
}
