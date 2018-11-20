package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NameTagGroupTest {

    @Test
    public void name() {
        List<NameTag> nameTags = new ArrayList<>();
        NameTag nameTag = NameTag.of("crox");
        nameTags.add(nameTag);
    }
}