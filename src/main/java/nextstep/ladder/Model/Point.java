package nextstep.ladder.Model;

import java.util.Objects;

public class Point {

    private final int currentLocation;
    private final Bridge bridge;

    public Point (int currentLocation, Bridge bridge){
        this.currentLocation = currentLocation;
        this.bridge = bridge;
    }

    public int move(){
        if(bridge.move() == Direction.RIGHT){
            return currentLocation +1;
        }
        if(bridge.move() == Direction.LEFT){
            return currentLocation -1 ;
        }
        return currentLocation;
    }

    public Bridge getBridgeInfo(){
        return this.bridge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return currentLocation == point.currentLocation && Objects.equals(bridge, point.bridge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentLocation, bridge);
    }
}
