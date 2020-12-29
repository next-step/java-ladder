package nextstep.ladder.domain.floor;

import nextstep.ladder.domain.Height;

import java.util.ArrayList;
import java.util.List;

public class Floors {
    private final Height height;
    private final List<Floor> floorList;

    public Floors(Height height) {
        this.height = height;
        floorList = new ArrayList<>();
    }

    public void addFloor(Floor floor) {
        validateAddingFloor();
        floorList.add(floor);
    }

    public int getMaxHeight() {
        return height.getHeight();
    }

    public Floor getFloor(int height) {
        return floorList.get(height);
    }

    public void followFrom(Position position) {
        for (Floor floor : floorList) {
            floor.followFrom(position);
        }
    }

    private void validateAddingFloor() {
        if (height.getHeight() <= floorList.size()) {
            throw new IllegalArgumentException("더이상 floor 를 추가할 수 없습니다");
        }
    }
}
