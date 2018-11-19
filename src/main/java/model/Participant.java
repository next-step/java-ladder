package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participant {
    private static final String COMMA = ",";
    private static final int LIMIT = 5;
    private String name;

    public Participant(String name) {
        if (name.length() > LIMIT) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public static List<Participant> getParticipants(String names) {
        return Arrays.stream(split(names))
                .map(Participant::new)
                .collect(Collectors.toList());
    }
    
    public static String[] split(String participants) {
        
        return participants.split(COMMA);
    }
}
