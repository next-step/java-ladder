package com.fineroot.ladder.engine;

import com.fineroot.ladder.utils.ExceptionMessage;
import java.util.List;
import java.util.Objects;

public class Position implements Comparable<Position>{
    private final int value;

    public Position(final int value){
        validate(value);
        this.value = value;
    }

    public Position increase(){
        return new Position(value+1);
    }

    public Position decrease(){
        return new Position(value-1);
    }

    public <E> E  getFromList(List<E> value){
        return value.get(this.value);
    }

    private void validate(int value) {
        if(value < 0){
            throw new IllegalArgumentException(ExceptionMessage.POSITION_NEGATIVE.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.value, o.value);
    }
}
