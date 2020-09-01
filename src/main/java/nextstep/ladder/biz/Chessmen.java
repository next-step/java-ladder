package nextstep.ladder.biz;

import nextstep.ladder.Player;

import java.util.Objects;

public class Chessmen {

    private Player player;
    private int location;

    public Chessmen(Player player) {
        this(player, player.getLocation());
    }

    public Chessmen(Player player, int location) {
        if (isOnLadder(location)) {
            throw new IllegalArgumentException("말의 위치가 잘 못되었습니다. ");
        }
        this.player = player;
        this.location = location;
    }

    public String getName() {
        return player.getName();
    }

    private boolean isOnLadder(int location) {
        return 0 > location;
    }

    public int getLocation() {
        return location;
    }

    public Chessmen move(Point point) {
        if (isHere(point)) {
            return moveRight();
        } else if (isLeft(point)) {
            return moveLeft();
        }

        return this;
    }

    public boolean isLeft(Point point) {
        if (isZeroIndex()) {
            return false;
        }
        return point.isLeftPosition(this.location);
    }

    private boolean isZeroIndex() {
        return location == 0;
    }

    public boolean isHere(Point point) {
        return point.isHerePosition(this.location);
    }

    public Chessmen moveLeft() {
        return Chessmen.of(player, --location);
    }

    public Chessmen moveRight() {
        return Chessmen.of(player, ++location);
    }

    public static Chessmen of(Player player) {
        return new Chessmen(player);
    }

    static Chessmen of(Player player, int location) {
        return new Chessmen(player, location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chessmen chessmen = (Chessmen) o;
        return location == chessmen.location &&
                Objects.equals(player, chessmen.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, location);
    }

    @Override
    public String toString() {
        return player.getName() + "[" + player.getLocation() + "] - current location:" + location;
    }
}
