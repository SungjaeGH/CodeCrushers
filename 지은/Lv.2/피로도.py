from itertools import permutations


def solution(k, dungeons):
    max_travel = 0

    for odds in permutations(dungeons):
        curr_fatigue = k
        travel = 0

        for dungeon in odds:
            req, cost = dungeon
            if curr_fatigue >= req:
                travel += 1
                curr_fatigue -= cost
            else:
                break

        max_travel = max(max_travel, travel)

    return max_travel


# 다른 사람의 풀이1
answer = 0
N = 0
visited = []


def dfs(k, cnt, dungeons):
    global answer
    if cnt > answer:
        answer = cnt

    for j in range(N):
        if k >= dungeons[j][0] and not visited[j]:
            visited[j] = 1
            dfs(k - dungeons[j][1], cnt + 1, dungeons)
            visited[j] = 0


def solution(k, dungeons):
    global N, visited
    N = len(dungeons)
    visited = [0] * N
    dfs(k, 0, dungeons)
    return answer


# 다른 사람의 풀이2
def solution(k, dungeons):
    answer = 0
    dungeons = sorted(dungeons, key=lambda x: ((x[1]+x[0])/x[0], x[1]))
    for x, y in dungeons:
        if k >= x:
            k -= y
            answer += 1
    return answer
