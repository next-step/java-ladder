package ladder.domain;

public class Column {
    private final boolean canMoveLeft;
    private final boolean canMoveRight;

    private Column(boolean canMoveLeft, boolean canMoveRight) {
        this.canMoveLeft = canMoveLeft;
        this.canMoveRight = canMoveRight;
    }

    public static Column of(boolean canMoveLeft, boolean canMoveRight) {
        return new Column(canMoveLeft, canMoveRight);
    }

    public void navigate(Player player) {
        if(canMoveLeft){
            player.moveLeft();
            return;
        }

        if(canMoveRight){
            player.moveRight();
        }
    }
}
