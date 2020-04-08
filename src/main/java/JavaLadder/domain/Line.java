package JavaLadder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> line = new ArrayList<>();

    public Line(int countOfPerson) {
        List line = generate(countOfPerson);
        this.line = line;
    }

    public Line(List<Boolean> list) {
        this.line = list;
    }

    private List generate(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            checkSuccessTrue(line, i);
        }
        return line;
    }

    private void checkSuccessTrue(List<Boolean> line, int index) {
        if (index > 0 && line.get(index - 1)) {
            line.add(false);
            return;
        }
        line.add(new Random().nextBoolean());
        return;
    }

    public int size() {
        return line.size();
    }

    public boolean isTrue(int index) {
        return this.line.get(index);
    }

    public int numberOfTrue() {
        return (int) line.stream().filter(n -> n.equals(true)).count();
    }

    public void isMove(Point point) {
        if (point.getPoint() == 0){
            if(line.get(point.getPoint())){
                point.moveRight();
            }
            return;
        }

        int originalPoint = point.getPoint();
        if (line.get(point.getPoint() - 1)) {
            point.moveLeft();
            return;
        }
        if (originalPoint == point.getPoint()){
            if (line.get(point.getPoint())){
                point.moveRight();
                return;
            }
        }


    }
}
