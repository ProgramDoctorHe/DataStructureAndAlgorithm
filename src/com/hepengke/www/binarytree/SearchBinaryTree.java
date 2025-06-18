package com.hepengke.www.binarytree;

import com.hepengke.www.baseelement.TreeNode;

public class SearchBinaryTree {
    private TreeNode root;

    public SearchBinaryTree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode search(int val) {
        TreeNode cur = root;
        //循环查找
        while (cur != null) {
            if (cur.val > val) {
                cur = cur.left;
            } else if (cur.val < val) {
                cur = cur.right;
            } else {
                //匹配成功
                break;
            }
        }
        return cur;
    }

    public void insert(int val) {
        if (root == null) {    //空树
            root = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        //查找插入位置
        while (cur != null) {
            if (cur.val == val) { //插入的值已经存在
                return;
            }
            pre = cur;//记录前置结点
            if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        //开始插入
        if (pre.val > val) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }
    }


    public void remove(int val) {
        TreeNode cur = root;
        TreeNode pre = null;
        //查找指定值是否存在
        while (cur != null) {
            if (cur.val == val) {
                break;
            }
            pre = cur;
            if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        //没查找到指定值,退出
        if (cur == null) {
            return;
        }
        //查找到指定值需要判定指定值的度(degree)
        if (cur.left == null && cur.right == null) {
            //degree为0
            if (cur == root) {
                root = null;
                return;
            }
            if (cur == pre.left) {
                pre.left = null;
            } else {
                pre.right = null;
            }
        } else if (cur.left == null || cur.right == null) {
            //degree为1
            TreeNode child = (cur.left == null) ? cur.right : cur.left;
            if (cur == root) {
                root = child;
            } else {
                if (cur == pre.left) {
                    pre.left = child;
                } else {
                    pre.right = child;
                }
            }
        } else{
            //degree为2
            //找到左子树的最大值或者右子树的最小值进行替换
            TreeNode minNodeInRightTree = cur.right;
            while(minNodeInRightTree.left != null){
                minNodeInRightTree = minNodeInRightTree.left;
            }
            //递归删除
            remove(minNodeInRightTree.val);
            //对删除结点重新赋值
            cur.val = minNodeInRightTree.val;
        }
    }
}
