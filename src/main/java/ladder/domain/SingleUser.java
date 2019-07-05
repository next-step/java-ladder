package ladder.domain;

public class SingleUser {
    private String name;
    private Position position;

    public SingleUser(String name, int firstPos) {
        this.name = name;
        position = new Position(firstPos);
    }

    public SingleUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean matchName(String name) {
        return this.name.equals(name);
    }

    public Position getPosition() {
        return position;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SingleUser other = (SingleUser) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "This SingleUser is " + getName();
    }
}
