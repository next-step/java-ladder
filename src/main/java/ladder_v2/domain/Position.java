package ladder_v2.domain;

public class Position {

    private int position;

    public Position(int position) {
        if(position<0){
            throw new IllegalArgumentException("Position은 0보다 작을 수 없습니다.");
        }
        this.position = position;
    }

    public Position move(Direction direction){
        if(direction == Direction.RIGHT){
            return new Position(position + 1);
        }
        if(direction == Direction.LEFT){
            return new Position(position - 1);
        }
        return this;
    }

    public int position() {
        return position;
    }
}
