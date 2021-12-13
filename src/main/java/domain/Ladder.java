package domain;

import domain.strategy.HorizontalLineDrawingStrategy;
import domain.strategy.RandomHorizontalLineDrawingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private Height height;
  private List<Floor> floors = new ArrayList();

  public Ladder(int height, int numberOfPlayers) {
    this.height = new Height(height);
    createFloors(numberOfPlayers, new RandomHorizontalLineDrawingStrategy());
  }

  public Ladder(int height, int numberOfPlayers, HorizontalLineDrawingStrategy strategy) {
    this.height = new Height(height);
    createFloors(numberOfPlayers, strategy);
  }

  private void createFloors(int numberOfPlayers, HorizontalLineDrawingStrategy strategy) {
    List<Floor> lines = new ArrayList();
    lines.add(new Floor(numberOfPlayers, strategy));
    for (int i = 0; i < height.getValue(); i++) {
      this.floors.add(new Floor(numberOfPlayers, strategy));
    }
  }

  public List<Floor> getFloors() {
    return new ArrayList(floors);
  }

}
