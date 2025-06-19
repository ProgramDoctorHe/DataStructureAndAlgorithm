package com.hepengke.www.graph;

import com.hepengke.www.baseelement.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphAdjList {
    public Map<Vertex, List<Vertex>> adjList;

    public GraphAdjList(Vertex[][] edges) {
        adjList = new HashMap<>();
        for (Vertex[] edge : edges) {
            addVertex(edge[0]);
            addVertex(edge[1]);
            addEdge(edge[0], edge[1]);
        }
    }

    public int size() {
        return adjList.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void addEdge(Vertex vet1, Vertex vet2) {
        if (!adjList.containsKey(vet1) || !adjList.containsKey(vet2) || (vet1 == vet2)) {
            throw new IllegalArgumentException("参数异常");
        }
        adjList.get(vet1).add(vet2);
        adjList.get(vet2).add(vet1);
    }

    private void removeEdge(Vertex vet1, Vertex vet2) {
        if (!adjList.containsKey(vet1) || !adjList.containsKey(vet2) || (vet1 == vet2)) {
            throw new IllegalArgumentException("参数异常");
        }
        adjList.get(vet1).remove(vet2);
        adjList.get(vet2).remove(vet1);
    }

    private void addVertex(Vertex vet) {
        if (!adjList.containsKey(vet)) {
            List<Vertex> list = new ArrayList<>();
            adjList.put(vet, list);
        }
    }

    private void removeVertex(Vertex vet) {
        if (!adjList.containsKey(vet)) {
            throw new IllegalArgumentException("参数异常");
        }
        adjList.remove(vet);
        for (List<Vertex> list : adjList.values()) {
            list.remove(vet);
        }
    }
}
