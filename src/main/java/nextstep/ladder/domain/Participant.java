package nextstep.ladder.domain;

public class Participant {
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final String result;

    private Position position;

    public Participant(String name) {
        this(name, 0);
    }

    public Participant(String name, int xAxis) {
        this(name, new Position(xAxis, 0), "");
    }

    public Participant(String name, Position position, String result) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 " + MAX_NAME_LENGTH + "글자입니다.");
        }

        this.name = name;
        this.position = position;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%-5s", name);
    }

    public void move(Lines lines) {
        for (Line line : lines.getLines()) {
            Point point = PointFactory.generatePoint(position.getX(), line);
            position.move(point.getDirection());
        }
    }

    public int getPositionX() {
        return position.getX();
    }

    public int getPositionY() {
        return position.getY();
    }

    public Position getPosition() {
        return position;
    }

    public String getResult() {
        return result;
    }

}
