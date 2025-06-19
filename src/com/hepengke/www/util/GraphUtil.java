package com.hepengke.www.util;

import com.hepengke.www.baseelement.Vertex;
import com.hepengke.www.graph.GraphAdjList;

import java.util.*;

public class GraphUtil {
    //广度优先遍历
    public static List<Vertex> graphBFS(GraphAdjList graph, Vertex startVet) {
        //保存遍历数据
        List<Vertex> result = new ArrayList<>();
        //保存已经访问过的结点
        Set<Vertex> visited = new HashSet<>();
        //使用队列来确保广度优先遍历
        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(startVet);
        visited.add(startVet);
        while (!queue.isEmpty()) {
            Vertex vet = queue.poll();
            result.add(vet);
            for (Vertex adjVet : graph.adjList.get(vet)) {
                if (visited.contains(adjVet)) {
                    continue;
                }
                visited.add(adjVet);
                queue.offer(adjVet);
            }
        }
        return result;
    }

    //深度优先遍历
    public static List<Vertex> graphDFS(GraphAdjList graph, Vertex startVet) {
        //保存遍历数据
        List<Vertex> result = new ArrayList<>();
        //保存已经访问过的结点
        Set<Vertex> visited = new HashSet<>();
        dfs(graph, result, visited, startVet);
        return result;
    }

    private static void dfs(GraphAdjList graph, List<Vertex> result, Set<Vertex> visited, Vertex vet) {
        result.add(vet);
        visited.add(vet);
        //遍历邻接结点
        for (Vertex adjVet : graph.adjList.get(vet)) {
            if (visited.contains(adjVet)) {
                continue;
            }
            dfs(graph, result, visited, adjVet);
        }
    }
}
