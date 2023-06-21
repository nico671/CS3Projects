import java.util.ArrayList;

class BST {

    public Node root;

    public BST() {
        Node root = null;
    }

    // helper function for more consice code in insert and remove (both need
    // rotations on composition of recursive function)
    // precondition: root isn't null
    // postcondition: returns root with whatever rotations needed made

    // precondition: root isn't null
    // postcondition: inserts a new node with value key in a sorted order
    void insert(int key) {
        root = insertHelper(root, key);
    }

    // does recursion for insert function
    private Node insertHelper(Node root, int key) {
        if (root == null) {
            return new Node(key);
        } else if (key < root.key) {
            root.left = insertHelper(root.left, key);
        } else if (key > root.key) {
            root.right = insertHelper(root.right, key);
        }

        int currentRootBalance = balance(root);

        if (currentRootBalance < -1) {
            if (key < root.left.key) {
                return rightRotate(root);
            } else if (key > root.left.key) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }
        if (currentRootBalance > 1) {
            if (key > root.right.key) {
                return leftRotate(root);
            } else if (key < root.right.key) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }

        return root;
    }

    // precondition: root isn't null
    // postcondition: returns true if the key is found within the tree
    boolean search(int key) {
        if (root == null) {
            return false;
        } else {
            return searchHelper(root, key);
        }
    }

    boolean searchHelper(Node root, int key) {

        if (root.key == key) {
            return true;
        }
        if (root.key < key) {
            if (root.right != null) {
                return searchHelper(root.right, key);
            } else {
                return false;
            }
        }
        if (root.key > key) {
            if (root.left != null) {
                return searchHelper(root.left, key);
            } else {
                return false;
            }
        }
        return false;
    }

    // precondition: passed in a non-null root of a bst
    // postcondition: if the key is contained removes the node with that key
    Node remove(int key) {
        if (root != null) {
            root = removeHelper(root, key);
        }
        return root;
    }

    void clear() {
        root = null;
    }

    Node removeHelper(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = removeHelper(root.left, key);
        } else if (key > root.key) {
            root.right = removeHelper(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }


            int min = findMinHelper(root.right);
            if (min == root.right.key) {
                root.right = null;
            }
            root.key = min;

        }

        int currentRootBalance = balance(root);
        if (currentRootBalance < -1) {
            if (key > root.left.key) {
                return rightRotate(root);
            } else if (key < root.left.key) {
                root = leftRotate(root);
                return rightRotate(root);
            }
        }
        if (currentRootBalance > 1) {
            if (key < root.right.key) {
                return leftRotate(root);
            } else if (key > root.right.key) {
                root = rightRotate(root);
                return leftRotate(root);
            }
        }

        return root;
    }

    // precondition: a none null node is passed in
    // postcondition: finds the min node's value below the argument node
    public int findMinHelper(Node root) {

        int min = root.key;
        while (true) {

            if (root.left != null) {
                if (root.left.left == null) {
                    min = root.left.key;
                    root.left = null;
                    System.out.println("min: " + min);
                    break;
                }
                min = root.left.key;
                root = root.left;
            } else {
                return root.key;
            }

        }

        return min;


    }

    // Add the following functions to your BST
    // Please use this code to verify your tree integrity
    public boolean isBSTOrNot() {
        return isBSTOrNot(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTOrNot(Node root, int minValue, int maxValue) {
        // check for root is not null or not
        if (root == null) {
            return true;
        }
        // check for current node value with left node value and right node value and
        // recursively check for left sub tree and right sub tree
        if (root.key >= minValue && root.key <= maxValue && isBSTOrNot(root.left, minValue, root.key) &&
            isBSTOrNot(root.right, root.key, maxValue)) {
            return true;
        }
        return false;
    }

    // please use the following pieces of code to display your tree in a more easy
    // to follow style (Note* you'll need to place the Trunk class in it's own file)
    public static void showTrunks(Trunk p) {
        if (p == null) {
            return;
        }

        showTrunks(p.prev);
        System.out.print(p.str);
    }

    public void printTree() {
        printTree(root, null, false);
    }

    private void printTree(Node root, Trunk prev, boolean isLeft) {
        if (root == null) {
            return;
        }

        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);

        printTree(root.right, trunk, true);

        if (prev == null) {
            trunk.str = "———";
        } else if (isLeft) {
            trunk.str = ".———";
            prev_str = "   |";
        } else {
            trunk.str = "`———";
            prev.str = prev_str;
        }

        showTrunks(trunk);
        System.out.println(" " + root.key);

        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";

        printTree(root.left, trunk, false);
    }

    // precondition: neither the subroot or prev are null
    // postcondition: performs a left rotation around subroot
    public Node leftRotate(Node root) {
        // a
        // \
        // b
        // \
        // c
        // root is a
        if (root == null) {
            return null;
        }
        Node temp = root.right;
        Node temp2 = root.right.left;
        root.right.left = null;
        temp.left = root;
        temp.left.right = temp2;
        return temp;

    }

    // precondition: neither the subroot or prev are null
    // postcondition: performs a right rotation around subroot
    public Node rightRotate(Node root) {
        if (root == null) {
            return null;
        }
        Node temp = root.left;
        Node temp2 = root.left.right;
        root.left.right = null;
        temp.right = root;
        temp.right.left = temp2;
        return temp;

    }

    // precondition: root is not null
    // returns the height of the root (calculated from the max height of the left
    // and right subtrees)
    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            return max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }

    // precondition: primitive types can't be null in java so the variables passed
    // in will never be null
    // postcondition: returns the higher parameter
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // // precondition: root is not null
    // returns the height of the root (calculated from the difference of the heights
    // of the left and right subtrees)
    private int balance(Node root) {
        if (root == null) {
            return 0;
        }
        return getHeight(root.right) - getHeight(root.left);
    }

}

// go away i hate u i love printTree so much more
// precondition: tree isn't empty
// // postcondition: prints out tree with height accounted for
// public String toString() {
// ArrayList<ArrayList<Integer>> emptyTree = new
// ArrayList<ArrayList<Integer>>();
// ArrayList<ArrayList<Integer>> tree = fillTree(root, 0, emptyTree);
// String treeAsString = "";
// for (int i = 0; i < tree.size(); i++) {
// for (int j = 0; j < tree.get(i).size(); j++) {
// treeAsString = new StringBuilder(treeAsString).append(tree.get(i).get(j) + "
// ").toString();

// }
// treeAsString = new StringBuilder(treeAsString).append("\n").toString();
// }
// return treeAsString;
// }

// precondition: non empty tree
// postcondition: fills a 2d array with the information from the BST // in order
// to be printable
// public ArrayList < ArrayList < Integer >> fillTree(Node root, int height,
// ArrayList < ArrayList < Integer >> tree) {

// if (root != null) {
// try {
// tree.get(height).add(root.key);
// fillTree(root.left, height + 1, tree);
// fillTree(root.right, height + 1, tree);
// } catch (IndexOutOfBoundsException e) {
// tree.add(height, new ArrayList < Integer > ());
// tree.get(height).add(root.key);
// fillTree(root.left, height + 1, tree);
// fillTree(root.right, height + 1, tree);
// }
// }
// return tree;
// }