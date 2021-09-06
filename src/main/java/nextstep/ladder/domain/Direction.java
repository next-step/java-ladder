package nextstep.ladder.domain;

public enum Direction {

    LEFT(-1), RIGHT(1), MIDDLE(0);

    int direction;


    Direction(int direction) {
        this.direction = direction;
    }

    int move(int position) {
        return position + this.direction;
    }
}
