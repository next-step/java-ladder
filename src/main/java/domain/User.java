package domain;

public class User {
    private String name;
    private Point position;

    public User(String name, Integer order) {
        this.name = name;
        this.position = Point.valueOf(order, 1);
    }

    public String getName() {
        return name;
    }

    public Point getPosition() {
        return position;
    }
}
