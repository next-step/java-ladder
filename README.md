# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)


# 요구사항
- 사다리 초기화하기
- 사다리 실행해 결과 얻기
- 사다리 최종 결과 구하기

----
# 요구사항
```
사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
사람 이름은 쉼표(,)를 기준으로 구분한다.
사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
|-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
```
1. 플레이어가 참가한다 
- [x] 사다리 게임에 참여하는 사람의 이름을 받는다.
    -[x] 이름은 5자이상 일 시 exception
    -[x] 쉼표(,)를 구분자로 한다.
    
2. 사다리 초기화
- [x] 사다리를 생성한다.
    -[x] 사다리는 행,열의 크기를 갖는다. ( 행: 사다리 높이, 열: 참여하는 사람 수 )
    -[x] 사다리는 높이만큼 라인을 가진다.
    -[x] 사다리의 높이가 양수가 아닐 시 exception
    
    -[x] 라인은 참여하는 사람 수 만큼의 point을 생성한다
    -[x] 라인은 point를 가지고 있다. (point는 다음 point로 이동가능한 여부를 알고 있다.)
    -[x] point는 랜덤으로 다음 point로 이동 가능 여부를 생성한다
    -[x] point는 연속으로 이동할 수 없다. ex) |------|-----| (x)
    - if) 전 position이 가로대를 갖는 경우, 무조건 가로대를 갖지 않는다.
    -[x] 마지막 point는 항상 이동이 불가능하다.
      
    사다리를 생성하라 -> ladder -> 열을 생성하라 -> line
                     - 행만큼 열(라인)을 생성한다.
                     - 라인은 해당 라인의 point을 생성한다. 
                     - 라인은 각 point의 상태를 알고 있다.
                     - point은 우측을 기준으로 가로대가 존재하는 지 유무를 알 고 있다.
                     - 전 point에 가로대가 존재하면, 다음 가로대는 무조건 false이다.
----
- [ ] point는 이동가능 여부를 갖는다.
- [ ] point은 랜덤으로 이동여부를 생성한다.
