package step04.model;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class RouteInfo<T> {

    private final Map<T, T> routeMap;

    public RouteInfo(Map<T, T> routeMap) {
        this.routeMap = Collections.unmodifiableMap(routeMap);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RouteInfo)) return false;
        RouteInfo<?> routeInfo = (RouteInfo<?>) o;
        return Objects.equals(routeMap, routeInfo.routeMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeMap);
    }
}
