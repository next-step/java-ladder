package ladder.domain;

import java.util.Objects;

public class UserLocation {

    private final User user;

    private final Location location;

    private UserLocation(User user, Location location) {
        this.user = user;
        this.location = location;
    }

    public static UserLocation create(User user, Location location) {
        return new UserLocation(user, location);
    }

    public User getUser() {
        return user;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLocation that = (UserLocation) o;
        return Objects.equals(user, that.user) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, location);
    }
}
