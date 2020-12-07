# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

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
1. 사다리를 생성하기 위해 한 라인의 n개의 좌표 중 연속되는 2개를 랜덤하게 선택하여 사다리 생성
##DONE
