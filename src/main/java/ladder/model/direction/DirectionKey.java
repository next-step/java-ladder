package ladder.model.direction;

public class DirectionKey {

    public int get(boolean left, boolean right){
        if(left == false && right == false) {
            return 1;
        }
        if(left == false && right) {
            return 2;
        }
        if(left && right == false) {
            return 3;
        }
        throw new IllegalArgumentException("선과 선은 나란히 그릴 수 없습니다.");
    }
}
