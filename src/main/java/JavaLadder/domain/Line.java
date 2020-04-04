package JavaLadder.domain;

import java.util.*;

public class Line {
    private List<Boolean> line = new ArrayList<>();

    public Line(int countOfPerson) {
        List line = generate(countOfPerson);
        this.line = line;
    }

    private List generate(int countOfPerson) {
        List<Boolean> points = new ArrayList();
        for (int i = 0; i < countOfPerson - 1; i++) {
            checkSuccessTrue(line, i);
        }
        return line;
    }

    private void checkSuccessTrue(List<Boolean> line, int i) {
        if (i > 0 && line.get(i - 1)) {
            line.add(false);
            return;
        }
        line.add(new Random().nextBoolean());
        return;
    }

    @Override
    public String toString() {
        return line.toString();
    }

    public Boolean isLine(int i) {
        return this.line.get(i);
    }

    public int size() {
        return this.line.size();
    }
}
