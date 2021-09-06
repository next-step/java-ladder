package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

  private List<Boolean> points = new ArrayList<>();

  Line(GameParticipants participants) {
    generator(participants);
  }

  private void generator(GameParticipants gameParticipants) {

    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      addRandomPoint(i);
    }
  }

  private void addRandomPoint(int i) {

    boolean randomPoint = getRandomPoint();

    if (isDuplicate(i, randomPoint)) {
      randomPoint = !randomPoint;
    }

    points.add(randomPoint);
  }

  private boolean isDuplicate(int i, boolean randomPoint) {
    if (i < 2) {
      return false;
    }
    return ((points.get(i - 1) == randomPoint) && (points.get(i - 2) == randomPoint));
  }

  private boolean getRandomPoint() {
    Random rd = new Random(); // creating Random object
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
