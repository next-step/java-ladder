# 사다리 게임

🚀 2단계 - 사다리(생성)

- [ ] 사람 이름을 쉼표로 구분하여 반환한다.
    - [ ] 사람 이름이 5자를 초과하면 예외를 throw 한다.
- [ ]      
- [ ] 사다리를 랜덤하게 생성한다. 
- [ ] 랜던하게 생성된 사다리를 출력한다.


``````
- Line 은 가로라인에 대한 정보를 나타낸다.
       해당 position 에 라인이 존재하면 True, 없으면 False
 
  |-----|     |-----|    Line[0] : True True True True
  |     |-----|     |    Line[1] : False True True False
  |-----|     |     |    Line[2] : True True False False
  |     |-----|     |    Line[3] : False True True False
  |-----|     |-----|    Line[4] : True True True True
  
  # 사다리 랜덤 생성 전략
  1. 최소 2자리 이상 비어있으면 True or False를 선택할 수 있다.
    1-1. True 인 경우 True True 를 동시에 넣어준다. ( 라인은 두 점을 잇는 선이다.)
    1-2. False 인 경우 False만 넣어준다.  
  2. 한 자리만 남았다면 그 자리는 무조건 False 이다.
``````

