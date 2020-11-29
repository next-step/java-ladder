package ladder.domain;

public interface DirectionGenerator { 
    Direction generateFirst();

    Direction generateNext(Direction beforeDirection);
}
