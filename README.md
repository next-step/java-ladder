# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

---
## 2단계 - 사다리(생성)
### 기능 요구사항 
- 게임 참여자 이름 최대 5글자 
- 사다리 출력시 이름도 함께 출력
- 사람 이름은 쉼표로 구분
- 사람 이름 5자에 맞춘 사다리 폭
- 사다리 타기가 정상적으로 동작하기 위해 라인이 겹치지 않도록 해야한다

### TODO
- Ladder Application
  - ~~input name String -> split(,)~~
- Name
  - ~~5자 제한 exception~~
- Ladder Application
    - ~~input height~~
- Height
  - ~~높이 제한 exception~~
- Ladder
  - ~~생성자 Names, Height~~
  - ~~name list, Line list(height)~~
- Line
  - ~~number of persion~~
  - ~~point list~~
- Point
  - ~~이전 point 상태로 랜덤 boolean 생성~~ 
- 출력


---
## 1단계 - 자바8 스트림, 람다, Optional
### TODO
- ~~람다 실습 1 - 익명 클래스를 람다로 전환~~
- ~~람다 실습 2 - 람다를 활용해 중복 제거~~
- ~~map, reduce, filter 실습 1~~
- ~~map, reduce, filter 실습 2~~
- ~~요구사항 1 - Optional을 활용해 조건에 따른 반환~~
- ~~요구사항 2 - Optional에서 값을 반환~~
- ~~요구사항 3 - Optional에서 exception 처리~~