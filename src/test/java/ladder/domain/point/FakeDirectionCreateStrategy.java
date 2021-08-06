package ladder.domain.point;

import static ladder.domain.point.Direction.*;

// 랜덤 요소를 배제한 Right - Left - Empty를 반복 생성하는 Fake 객체
public class FakeDirectionCreateStrategy implements DirectionCreateStrategy {
    @Override
    public Direction next(final Direction current) {
        if (current.isEmpty()) {
            return RIGHT;
        }
        if (current.isRight()) {
            return LEFT;
        }
        if (current.isLeft()) {
            return RIGHT;
        }

        throw new RuntimeException("DirectionValue 검사가 제대로 이루지지 않았습니다.");
    }

    @Override
    public Direction first() {
        return RIGHT;
    }

    @Override
    public Direction last(final Direction current) {
        if (current.isRight()) {
            return LEFT;
        }
        return EMPTY;
    }
}
