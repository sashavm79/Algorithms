import java.util.ArrayList;

public class Tree {
    // travers
    // delete

    private class TreeNode implements Comparable {
        private Cat c;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(Cat c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "c=" + c.toString() +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Cat))
                throw new ClassCastException("Not a cat");
            return c.getAge() - ((Cat) o).getAge();
        }
    }

    TreeNode root;

    public void insert(Cat c) {
        TreeNode node = new TreeNode(c);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (true) {
                parent = current;
                if (c.getAge() < current.c.getAge()) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else if (c.getAge() > current.c.getAge()){
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public Cat find(int age) {
        TreeNode current = root;
        while (current.c.getAge() != age) {
            current = (age < current.c.getAge()) ? current.left : current.right;
            if (current == null) return null;
        }
        return current.c;
    }

    //  Метод поиск глубины дерева
    public int Level(int age) {
        TreeNode current = root;
        int numberLevel = 1;
        while (current.c.getAge() != age) {
            current = (age < current.c.getAge()) ? current.left : current.right;
            numberLevel++;
            if (current == null) return 0;
        }
        return numberLevel;
    }

//    Метод возвращает true если дерево сбалансированно и fals если нет
    public boolean isBalanced(TreeNode current) {

        int leftTree;
        int rightTtree;

        if (current == null) return true;

        leftTree = height(current.left);
        rightTtree = height(current.right);

        if(Math.abs(leftTree- rightTtree) <= 1 && isBalanced(current.left) && isBalanced(current.right)) return true;

        return false;
    }

    // Метод вычисляет высоту дерева или его части
    public int height(TreeNode current){
    if (current ==null) return 0;

        return 1 + max(height(current.left), height((current.right)));
    }

    // Метод определяет аксимальное число
    public int max(int a, int b) {
        return (a > b) ? a : b;
    }


    private void preOrderTraverse(TreeNode current) {
        if (current != null) {
            System.out.print(current.c.getAge() + " ");
            preOrderTraverse(current.left);
            preOrderTraverse(current.right);
        }
    }

    public void displayTree() {
        preOrderTraverse(root);
    }

    public boolean delete(int age) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while (current.c.getAge() != age) {
            parent = current;
            if (age < current.c.getAge()) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }

        // leaf
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        // one ancestor
        else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        // two ancestors
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parent = node;
        TreeNode s = node;
        TreeNode curr = node.right;
        while (curr != null) {
            parent = s;
            s = curr;
            curr = curr.left;
        }

        if (s != node.right) {
            parent.left = s.right;
            s.right = node.right;
        }
        return s;
    }

}
// 23 22 89 25 10 18 39 53 75 27 9 16 87 33 17 23 17

// 9 (4 (2 (1, 3), 8 (6 (5, 7), N)), 13 (11 (10, 12), 15 (14, 16)))
