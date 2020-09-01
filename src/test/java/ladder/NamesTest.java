package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import ladder.domain.ladder.Name;
import ladder.domain.ladder.Names;

public class NamesTest {

	@Test
	public void oneNameExceptionTest() {
		assertThatThrownBy(() -> Names.of("John"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("이름은 두명 이상 입력해주세요.");
	}

	@Test
	public void emptyNameExceptionTest() {
		assertThatThrownBy(() -> Names.of(StringUtils.EMPTY))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("이름을 입력해주세요.");
	}

	@Test
	public void noNameExceptionTest() {
		assertThatThrownBy(() -> Names.of("John,Mark,Hue,Mayer").getIndexesOf(Name.of("Jack")))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("해당하는 이름이 존재하지 않습니다.");
	}

	@Test
	public void namesSizeTest() {
		Names names = Names.of("John,Mark,Hue,Mayer");
		assertThat(names.getSize()).isEqualTo(4);
	}

	@Test
	public void nameGettingTest() {
		Names names = Names.of("John,Mark,Hue,Mayer");
		assertThat(names.getNameOf(1)).isEqualTo(Name.of("Mark"));
	}

	@Test
	public void nameIndexesTest() {
		Names names = Names.of("John,Mark,Hue,Mayer");
		assertThat(names.getIndexesOf(Name.of("Mayer"))).isEqualTo(Arrays.asList(3));
	}

	@Test
	public void nameIndexesTest2() {
		Names names = Names.of("John,Mark,Hue,Mayer");
		assertThat(names.getIndexesOf(Name.of("all"))).isEqualTo(Arrays.asList(0, 1, 2, 3));
	}

	@Test
	public void namesToStringTest() {
		Names names = Names.of("John,Mark,Hue,Mayer");
		assertThat(names.toString()).isEqualTo("John  Mark  Hue  Mayer");
	}

}
