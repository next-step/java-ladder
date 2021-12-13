package domain;

import java.util.ArrayList;
import java.util.List;

public class Floors {

  private List<Floor> floors = new ArrayList();

  public void addFloor(Floor floor) {
    this.floors.add(floor);
  }

  public List<Floor> getFloors() {
    return new ArrayList(this.floors);
  }

}
