package step2.domain;

import step2.exception.IllegalPositionException;

import java.util.function.BiFunction;

public enum MovePosition {
    BEGIN((line, position) -> {
        if (line.getPoint(position.getPosition())) {
            return position.next(line);
        }

        return position.getPosition();
    }),
    MIDDLE((line, position) -> {
        if (line.getPoint(position.getPosition())) {
            return position.next(line);
        }

        return position.previous(line);
    }),
    END((line, position) -> {
        if (line.getPoint(position.getPosition())) {
            return position.previous(line);
        }

        return position.getPosition();
    });

    private BiFunction<Line, Position, Integer> move;

    MovePosition(BiFunction<Line, Position, Integer> move) {
        this.move = move;
    }

    public static MovePosition of(int size, int currentPosition) {
        if (size == currentPosition) {
            return MovePosition.END;
        }

        if (currentPosition == 0) {
            return MovePosition.BEGIN;
        }

        sizeValidate(size, currentPosition);
        return MovePosition.MIDDLE;
    }

    private static void sizeValidate(int size, int currentPosition) {
        if (currentPosition > size) {
            throw new IllegalPositionException("현재 위치가 line의 길이보다 클수 없습니다");
        }
    }

    public int getPosition(Line line, Position position) {
        return move.apply(line, position);
    }
}
