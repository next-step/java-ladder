package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;

public class RendererTest {
    @DisplayName("랜더링이 잘 되는지 검증한다")
    @Test
    public void sdsdfa() {
        Users users = new Users(List.of(new User("a"),new User("b"),new User("c")));
        Lines lines = new Lines(Set.of(new Line(2, 2)));
        //new Line(0, 0)
        Renderer renderer = new Renderer(4, 4, lines, users);
        //given
        //when
        Scene scene = renderer.renderingSceneWithUser();
        //then
        List<String> ladderArea = scene.getLadderArea();
        ladderArea.stream().forEach(s -> System.out.println(s));
    }
}