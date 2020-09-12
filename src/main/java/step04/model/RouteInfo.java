package step04.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RouteInfo<T> {

    private final Map<T, T> routeMap;

    public RouteInfo(Map<T, T> routeMap) {
        this.routeMap = Collections.unmodifiableMap(routeMap);
    }

    public static <T> RouteInfo<T> navigateRoutes(List<RouteInfo<T>> routeInfoList) {
        Map<T, T> resultMap = new HashMap<>();

        for (RouteInfo<T> routeInfo : routeInfoList) {
            navigate(routeInfo.routeMap, resultMap);
        }

        return new RouteInfo<>(resultMap);
    }

    private static <T> void navigate(Map<T, T> routeMap, Map<T, T> resultMap) {
        for (T t : routeMap.keySet()) {
            resultMap.put(t, routeMap.get(resultMap.getOrDefault(t, t)));
        }
    }

    public Map<T, T> getRouteMap() {
        return routeMap;
    }

    public T getValue(T key) {
        return routeMap.get(key);
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
