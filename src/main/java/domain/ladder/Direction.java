package domain.ladder;

import java.util.Arrays;
import java.util.List;

enum Direction {
    LEFT {
        @Override
        protected boolean isCanMove(List<Boolean> lines, int lineIndex) {
            if (lineIndex <= 0) {
                return false;
            }

            boolean now = lines.get(lineIndex);
            boolean prev = lines.get(lineIndex - 1);
            return isCanMove(prev, now);
        }

        @Override
        int move(int index) {
            return index - 1;
        }
    },
    DOWN {
        @Override
        protected boolean isCanMove(List<Boolean> lines, int lineIndex) {
            return false;
        }

        @Override
        int move(int index) {
            return index;
        }
    },
    RIGHT {
        @Override
        protected boolean isCanMove(List<Boolean> lines, int lineIndex) {
            if (lineIndex >= lines.size() - 1) {
                return false;
            }

            boolean now = lines.get(lineIndex);
            boolean next = lines.get(lineIndex + 1);
            return isCanMove(now, next);
        }

        @Override
        int move(int index) {
            return index + 1;
        }
    };

    public static Direction generate(List<Boolean> lines, int lineIndex) {
        if (lineIndex < 0 || lineIndex > lines.size() - 1) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(values())
                .filter(direction -> direction.isCanMove(lines, lineIndex))
                .findFirst()
                .orElse(DOWN);
    }

    protected abstract boolean isCanMove(List<Boolean> lines, int lineIndex);

    abstract int move(int index);

    protected boolean isCanMove(boolean prev, boolean next) {
        return prev == false && next == true;
    }
}