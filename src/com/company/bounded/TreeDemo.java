package com.company.bounded;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

public class TreeDemo {
    public static void main(String[] args) {
        Tree<String> tree = new Tree<>("root");
        Tree.Node root = tree.getRoot();

        Tree.Node node1 = tree.new Node(root, "n1");
        root.addChild(node1);
        root.addChild(tree.new Node(root, "n2"));
        root.preOrder(root);

        root.removeChild(node1);
        root.preOrder(root);
    }
}

//Простая реализация дерева
class Tree<E> {
    private Node root;

    Tree(E value) {
        root = new Node(null, value);
    }

    //Узел дерева
    public class Node {
        private E value; //Объект, привязанный к узлу дерева
        private Node parent; //Родительский элемент
        private ArrayList<Node> childs = new ArrayList<>(); //Массив дочерних элементов

        public Node(Node parent, E value) {
            this.parent = parent;
            this.value = value;
        }

        public void addChild(Node child) {
            child.parent = this;
            childs.add(child);
        }

        public void removeChild(Node child) {
            childs.remove(childs.indexOf(child));
        }

        public void preOrder(Node node) {
            if (node == null) return;
            System.out.println(node.value);
            for (int i = 0; i < node.childs.size(); i++) {
                preOrder(node.childs.get(i));
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}