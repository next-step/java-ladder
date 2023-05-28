package nextstep.ladder.domain;


import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class Point {

    private PointStatus status;
    private final PointStatus beforeStatus;

    public Point(PointStatus status) {
        this.status = status;
        this.beforeStatus = PointStatus.NONE;
    }

    private Point(PointStatus status, PointStatus beforeStatus) {
        this.status = status;
        this.beforeStatus = beforeStatus;
    }

    public PointStatus getStatus() {
        return status;
    }

    public void saveStatus(PointStatus status) {
        this.status = status;
    }

    public static Point create(Supplier<Integer> randomNumber, Point beforeStatus) {
        if (beforeStatus.getStatus() == PointStatus.RIGHT) {
            return new Point(PointStatus.LEFT, beforeStatus.getStatus());
        }
        if (beforeStatus.getStatus() == PointStatus.LEFT) {
            return new Point(PointStatus.NONE, beforeStatus.getStatus());
        }
        PointStatus status = PointStatus.getRandomStatus(randomNumber.get());
        if (PointStatus.LEFT == status) {
            beforeStatus.saveStatus(PointStatus.RIGHT);
        }
        return new Point(status, beforeStatus.getStatus());
    }

    public static Point createFirst(Supplier<Integer> randomNumber) {
        return new Point(PointStatus.getRandomStatusExceptLeft(randomNumber.get()));
    }

    public static Point createLast(Supplier<Integer> randomNumber, Point beforeStatus) {
        if (beforeStatus.getStatus() == PointStatus.RIGHT) {
            return new Point(PointStatus.LEFT, beforeStatus.getStatus());
        }
        if (beforeStatus.getStatus() == PointStatus.LEFT) {
            return new Point(PointStatus.NONE, beforeStatus.getStatus());
        }
        return new Point(PointStatus.getRandomStatusExceptRight(randomNumber.get()), beforeStatus.getStatus());
    }

}
