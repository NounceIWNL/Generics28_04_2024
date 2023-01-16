package com.company.graphs;

import java.util.ArrayList;

public class GraphDemo {

    public static void main(String[] args) {

        Graph<Integer> graph = new Graph<>();
        Graph.Node node1 = graph.new Node(1);
        Graph.Node node2 = graph.new Node(2);
        Graph.Node node3 = graph.new Node(3);
        Graph.Node node4 = graph.new Node(4);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);
        graph.addEdge(node1, node2);
        graph.addEdge(node2, node3);
        graph.addEdge(node3, node4);
        graph.traverse(node2);



    }
}

//Простая реализация неориентированного графа
class Graph<E> {
    private ArrayList<Node> nodes = new ArrayList<>(); //Список узлов графа
    private ArrayList<Pair<Node, Node>> edges = new ArrayList<>(); //Список ребер графа

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(Node node1, Node node2) {
        edges.add(new Pair(node1, node2));
        node1.addChild(node2);
        node2.addChild(node1);
    }

    //Пометить все вершины
    public void setVisited(boolean visited) {
        for (int i = 0; i < nodes.size(); i++)
            nodes.get(i).visited = visited;
    }

    //Обход дерева в глубину
    public void traverse(Node node) {
        if (node.visited) return;
        System.out.println(node.value);
        node.visited = true;
        for (int i = 0; i < node.childs.size(); i++)
            traverse(node.childs.get(i));
    }

    //Узел графа
    public class Node {
        private E value; //Объект, привязанный к узлу графа
        private ArrayList<Node> childs = new ArrayList<>(); //Список узлов графа
        boolean visited = false;

        public Node(E value) {
            this.value = value;
        }

        public void addChild(Node child) {
            childs.add(child);
        }
    }
}
