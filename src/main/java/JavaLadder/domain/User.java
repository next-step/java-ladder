package JavaLadder.domain;

public class User {
    private String name;
    private Point point;

    public User(String name, int point) {
        validate(name);
        this.name = name;
        this.point = new Point(point);
    }

    public User(String name) {
        this.name = name;
    }

    public boolean isEqualName(String name) {
        return this.name == name;
    }

    private void validate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[" + name + "]: 5자리이하만입력가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return this.point.getPoint();
    }
}
