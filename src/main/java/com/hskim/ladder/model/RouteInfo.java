package com.hskim.ladder.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteInfo<T> {

    private final Map<T, T> routeMap;

    public RouteInfo(Map<T, T> routeMap) {
        this.routeMap = routeMap;
    }

    public static <T> RouteInfo<T> navigateRoutes(List<RouteInfo<T>> routeInfoList) {
        Map<T, T> resultMap = new HashMap<>();

        for (RouteInfo<T> routeInfo : routeInfoList) {
            navigate(routeInfo.routeMap, resultMap);
        }

        return new RouteInfo<T>(resultMap);
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
}
