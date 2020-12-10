# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 사다리 생성 방법
사다리 예시
```
|-----|     |
|     |-----|
|-----|     |
```
- TransverseLadder: '-----'를 연속되지 않게 생성한다.
- VerticalLadder: '|' 를 입력한 사람의 수 만큼 생성한다.
- Ladder: TransverseLadder, VerticalLadder를 조합하여 ladder를 생성한다.

## 요구사항 정리

Person
- String: name

Persons
- List<Person>: value
- Persons(String names)

Ladder
- List<Line>
- 0 1 2 3 (Persons.size())
- | | | |
- ...(Ladder.height())

Line
- List<Boolean>: points
    - n개중에서 연속되는 2개를 랜덤하게 선택(3개를 선택하면 안됨)

LadderHeight
- int: value

##TODO
- 사용하지 않는 메서드 삭제
##DONE
- 가로 사다리를 생성
    1. 랜덤하게 생성할지 말지를 결정하고, 이전 가로 사다리가 생성되어 있으면 생성하지 않음
- 세로 사다리를 생성
- 가로 사다리, 세로 사다리를 합쳐서 사다리 게임 생성
- TransverseLadder(가로 사다리) indent 1로 수정
- 참가자(Participants)를 생성하는 Class 추가
- 사다리 게임 생성 및 실행 결과 구현
- 중복되는 이름 입력시 Exception을 throw
