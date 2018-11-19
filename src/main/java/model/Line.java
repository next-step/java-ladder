package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();
    private int countOfPerson;

    private Line(int countOfPerson) {
        this.countOfPerson = countOfPerson;

        for (int i = 0; i < countOfPerson; i++) {
            addPoint(false);
        }
    }

    public static Line of(int countOfPerson, List<Positive> indexs) {
        Line line = new Line(countOfPerson);
        line.addAutoLines(indexs);

        return line;
    }

    public static Line of(int countOfPerson) {
        return new Line(countOfPerson);
    }

    public boolean hasLine(int index) {
        if (index >= points.size()) {
            return false;
        }

        if (index < 0) {
            return false;
        }

        return points.get(index);
    }

    /**
     * 좌표 추가
     *
     * @param b
     */
    public void addPoint(boolean b) {
        if (points.size() >= countOfPerson) {
            throw new IllegalStateException("좌표의 최대값은 인원 수를 초과할 수 없습니다.");
        }

        points.add(b);
    }

    /**
     * 선들 추가
     *
     * @param indexs
     */
    public void addAutoLines(List<Positive> indexs) {
        for (Positive idx : indexs) {
            addLine(idx);
        }
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

        points.set(index.getNum(), true);
    }

    /**
     * 왼쪽 좌표에 선이 있는지 여부
     *
     * @param index
     * @return
     */
    public boolean hasLeftLine(Positive index) {
        return hasLine(index.getNum() - 1);
    }

    /**
     * 오른쪽 좌표에 선이 있는지 여부
     *
     * @param index
     * @return
     */
    public boolean hasRightPoint(Positive index) {
        return hasLine(index.getNum() + 1);
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

        if (hasRightPoint(index)) {
            return false;
        }

        if (num > 0 && hasLeftLine(index)) {
            return false;
        }

        return true;
    }

    public List<Boolean> getPoints() {
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
}
