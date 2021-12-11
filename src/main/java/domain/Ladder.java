package domain;

import domain.strategy.HorizontalLineDrawingStrategy;
import domain.strategy.RandomHorizontalLineDrawingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private Height height;
  private List<Floor> floors = new ArrayList();

  public Ladder(int height, int playersAmount) {
    this.height = new Height(height);
    createFloors(playersAmount, new RandomHorizontalLineDrawingStrategy());
  }

  public Ladder(int height, int playersAmount, HorizontalLineDrawingStrategy strategy) {
    this.height = new Height(height);
    createFloors(playersAmount, strategy);
  }

  private void createFloors(int playersAmount, HorizontalLineDrawingStrategy strategy) {
    List<Floor> lines = new ArrayList();
    lines.add(new Floor(playersAmount, strategy));
    for (int i = 0; i < height.getValue(); i++) {
      this.floors.add(new Floor(playersAmount, strategy));
    }
  }

  public List<Floor> getFloors() {
    return floors;
  }

}
