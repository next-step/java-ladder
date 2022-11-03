package nextstep.ladder.domain.participant;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import nextstep.ladder.exception.BadRequestException;

public class Participants implements Iterable<String> {

	private List<String> names;

	public Participants(List<String> names) {
		names.forEach(this::checkName);
		this.names = names;
	}

	public int size() {
		return names.size();
	}

	public void checkName(String name) {
		if(name.length() == 0 || name.length() > 5){
			throw new BadRequestException("입력가능한 이름 글자수가 아닙니다.");
		}
	}

	@Override
	public Iterator<String> iterator() {
		return names.iterator();
	}

	@Override
	public void forEach(Consumer<? super String> action) {
		Iterable.super.forEach(action);
	}
}
