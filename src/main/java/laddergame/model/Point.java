package laddergame.model;

public interface Point {

  Position getPosition();

  Position getNextPosition();

  boolean isEmpty();
}
