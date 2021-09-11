package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

  private final int MINIMUM_INDEX = 2;

  private List<Boolean> points = new ArrayList<>();
  private Random rd = new Random();


  public Line(List<Boolean> points) {
    this.points = points;
  }

  public Line(GameParticipants participants) {
    generator(participants);
  }

  private void generator(GameParticipants gameParticipants) {

    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      addRandomPoint(i);
    }
  }

  private void addRandomPoint(int index) {

    boolean randomPoint = getRandomPoint();

    if (isDuplicate(index, randomPoint)) {
      randomPoint = !randomPoint;
    }

    points.add(randomPoint);
  }

  private boolean isDuplicate(int index, boolean randomPoint) {
    if (index < MINIMUM_INDEX) {
      return false;
    }
    return isDuplicatePoint(index, randomPoint);
  }

  private boolean isDuplicatePoint(int index, boolean randomPoint) {
    return (points.get(index - 1) == randomPoint) && (points.get(index - 2) == randomPoint);
  }

  private boolean getRandomPoint() {
    return rd.nextBoolean();
  }

  public int getPointSize() {
    return points.size();
  }

  public Boolean getPoint(int index) {
    return points.get(index);
  }

  public List<Boolean> getPoints() {
    return points;
  }
}
