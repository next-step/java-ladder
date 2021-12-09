package ladder.model.direction;

public class DirectionKey {

    private DirectionKey() {}

    public static int get(boolean left, boolean right){
        if(left == false && right == false) {
            return 1;
        }
        if(left == false && right == true) {
            return 2;
        }
        if(left == true && right == false) {
            return 3;
        }
        throw new IllegalArgumentException("선과 선은 나란히 그릴 수 없습니다.");
    }
}
