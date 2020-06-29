package laddergame.model;

public interface LinkablePoint extends Point {

  LinkablePoint createNext();

  LinkablePoint createNextWithLinkedBy(boolean isLinked);

}
