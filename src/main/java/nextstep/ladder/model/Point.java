package nextstep.ladder.model;

public class Point {
    private int goal = -1;

    public boolean isUsed() {
        return goal >= 0;
    }

    public void use(int goal) {
        if (isUsed()) {
            throw new IllegalArgumentException("이미 사용된 point 입니다. ");
        }

        if (goal < 0) {
            throw new IllegalArgumentException("음수 값을 목표로 받을 수 없습니다. goal : " + goal);
        }

        this.goal = goal;
    }

    public int getGoal() {
        return goal;
    }
}
