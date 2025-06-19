package com.hepengke.www.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjMatrix {
    List<Integer> vertices;
    List<List<Integer>> adjMatrix;

    public GraphAdjMatrix(int[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>();
        this.adjMatrix = new ArrayList<>();
        for (int val : vertices) {
            addVertex(val);
        }
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
        }
    }

    public int size() {
        return vertices.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void addVertex(int vertex) {
        vertices.add(vertex);
        //添加行
        int size = size();
        List<Integer> newRow = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            newRow.add(0);
        }
        adjMatrix.add(newRow);
        //添加列
        for (List<Integer> row : adjMatrix) {
            row.add(0);
        }
    }

    private void removeVertex(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException("超出范围");
        }
        vertices.remove(index);
        //删除行
        adjMatrix.remove(index);
        //删除列
        for (List<Integer> row : adjMatrix) {
            row.remove(index);
        }
    }

    private void addEdge(int i, int j) {
        if (i < 0 || j < 0 || i > size() - 1 || j > size() - 1) {
            throw new IndexOutOfBoundsException("超出范围");
        }
        adjMatrix.get(i).set(j,1);
        adjMatrix.get(j).set(i,1);
    }

    private void removeEdge(int i, int j) {
        if (i < 0 || j < 0 || i > size() - 1 || j > size() - 1) {
            throw new IndexOutOfBoundsException("超出范围");
        }
        adjMatrix.get(i).set(j,0);
        adjMatrix.get(j).set(i,0);
    }
}
