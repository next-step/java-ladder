package ladder.model;

import utils.RandomUtils;

import java.util.Objects;

public class Bridge {
    private final static String BRIDGE_MOVE_ERROR = "해당 다리에서는 이동할 수 없는 위치에 있습니다.";
    private final static int BRIDGE_WIDTH = 1;
    private final int left;
    private final int right;
    private final LadderItem ladderItem;

    private Bridge(int left, LadderItem ladderItem){
        this.left = left;
        this.right = left +BRIDGE_WIDTH;
        this.ladderItem = ladderItem;
    }

    public static Bridge of(int left, LadderItem ladderItem){
        return new Bridge(left,ladderItem);
    }

    public static Bridge createMovableBridge(int left){
        return new Bridge(left, LadderItem.HORIZONTAL);
    }

    public static Bridge createNonMovableBridge(int left){
        return new Bridge(left, LadderItem.BLANK_HORIZONTAL);
    }

    public static Bridge createRandomBridge(int left){
        return new Bridge(left, LadderItem.findItem(RandomUtils.getZeroOrOne()));
    }

    public boolean isMovable(){
        return ladderItem.equals(LadderItem.HORIZONTAL);
    }

    public int move(int now){
        if(now < left || right < now){
            throw new RuntimeException(BRIDGE_MOVE_ERROR);
        }

        if(!isMovable()){
            return now;
        }

        return now == left ? right : left;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Bridge){
            return this.ladderItem.equals(((Bridge) obj).ladderItem);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right,ladderItem);
    }

    @Override
    public String toString() {
        return ladderItem.getItem();
    }
}
