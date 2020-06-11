# Step2 - 사다리 (생성)
Q. 가로줄은 조건만 맞으면 랜덤으로 생성되는건가요 ,,?

Q. LadderGameUsers 가 오버프로그래밍인 건지? Getter 없는 로직이 생각이안난당.
Dto 역할만 하는 것 같기도 한다. 
```java
List<LadderGameUser> gameUsers = ladderGameUsers.getLadderGameUsers();
```


기능
[View]
1. 사용자의 이름을 입력받는다(,기준)
2. 최대 사다리의 높이를 입력받는다.

1. 생성된 사다리를 출력한다.(5자 기준이라 폭도 넓게)


[Domain]
**BaseUserLine**
1. 유저는 5자 이내이름과 자신의 지점을 가진다(0,1,2,3,...) - o 
: name, List<Boolean> pointConnections 각 포인트별 라인이 연결되어있는지의 여부 
 
 |  ------- true/false
 |  ------- 
 |  ------- 
 |  -------  
 
**LadderGameUser**
게임참여자
- 이름은 5자를 넘길 수 없다. - o
- 중복시 Exception을 던질까? - o 

**Ladder**
```java
List<BaseUserLine> baseUserLines
```
 
1. 최대 사다리의 높이를 가지고 BaseUserLine 을 생성한다. (pointConnections의 size)
2. 
```java
for( 0..n-1 in baseUserLines) // 마지막 사다리는 긋지 않는다
    while(최대높이 -1){ // 하나의 사다리는 최대 "높이 -1" 만큼의 라인을 그을 수 있다.
        if(첫번째 사다리){
            // 체크없이 Random으로 긋거나 긋지않는다
        }else{
            if(현재사다리의 이전사다리의 현재포인트가 true이면){
                // 긋지않는다
            }else{
                // 긋거나 긋지않는다
            }          
        }       
    }
```   





# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)