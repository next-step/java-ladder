package ladder.domain.point;

import ladder.core.DirectionGenerator;

// 랜덤 요소를 배제한 Right - Left - Empty를 반복 생성하는 Fake 객체
public class FakeDirectionGenerator implements DirectionGenerator {
    @Override
    public Direction next(final Direction current) {
        if (current.isEmpty()) {
            return Direction.of(DirectionValue.RIGHT);
        }
        if (current.isRight()) {
            return Direction.of(DirectionValue.LEFT);
        }
        if (current.isLeft()) {
            return Direction.of(DirectionValue.EMPTY);
        }

        throw new RuntimeException("DirectionValue 검사가 제대로 이루지지 않았습니다.");
    }

    @Override
    public Direction first() {
        return Direction.of(DirectionValue.RIGHT);
    }

    @Override
    public Direction last(final Direction current) {
        if (current.isRight()) {
            return Direction.of(DirectionValue.LEFT);
        }
        return Direction.of(DirectionValue.EMPTY);
    }
}
