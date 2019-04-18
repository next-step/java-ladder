package domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Positions {
    private static final Integer MIN_USER_NAME_LENGTH = 1;
    private static final Integer MAX_USER_NAME_LENGTH = 5;

    Map<String, Integer> positions = new HashMap<>();

    public Positions(List<String> names) {
        AtomicInteger integer = new AtomicInteger(1);
        names.stream()
            .peek(this::validateName)
            .forEach(n -> positions.put(n, integer.getAndIncrement()));
    }

    private void validateName(String name) {
        if(name.length() < MIN_USER_NAME_LENGTH || name.length() > MAX_USER_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public Integer findByName(String name) {
        return positions.keySet().stream()
            .filter(n -> n.equals(name))
            .map(positions::get)
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    public String findByLocation(Integer location) {
        return positions.entrySet().stream()
            .filter(e -> e.getValue().equals(location))
            .map(Map.Entry::getKey)
            .findFirst()
            .orElseThrow(IllegalAccessError::new);
    }

    public List<String> getNames() {
        return new ArrayList<>(positions.keySet());
    }

    public List<Integer> getLocations() {
        return new ArrayList<>(positions.values());
    }

    @Override
    public String toString() {
        return getNames().stream()
            .map(n -> StringUtils.rightPad(n, MAX_USER_NAME_LENGTH + 1))
            .collect(Collectors.joining());
    }
}
