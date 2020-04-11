public class BinarySearch {
    Node root;
    Node checkNode;
    Node parent;

    public void addNode(Node newNode) {
        if (root == null) {
            root = newNode;
        }
        else {
            checkNode = root;
            while (true) {
                parent = checkNode;
                if (newNode.key > checkNode.key) {
                    checkNode = checkNode.rightChild;
                    if (checkNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
                if (newNode.key < checkNode.key) {
                    parent = checkNode;
                    checkNode = checkNode.leftChild;
                    if (checkNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    parent = checkNode;
                    checkNode = checkNode.rightChild;
                    if (checkNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node fetchStudent(int key) {
        Node currentNode = root;
        while (true) {
            if (currentNode.key == key) {
                return currentNode;
            } else if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
            } else currentNode = currentNode.rightChild;
        }
    }

    public boolean showAllRecords(Node currentNode) {
        if (currentNode == null) {
            System.out.println("No Records to Display" + "\n");
            return true;
        }
        System.out.println("Name: " + currentNode.name + "\n" + "ID: " + currentNode.key + "\n" + "G.P.A: " + currentNode.gpa + "\n");
        showAllRecords(currentNode.leftChild);
        showAllRecords(currentNode.rightChild);
        return false;
    }
    public Node getParent(int key) {
        Node currentNode = root;
        parent = currentNode;
        while (true) {
            if (currentNode.key == key) {
                return parent;
            } else if (key < currentNode.key) {
                parent = currentNode;
                currentNode = currentNode.leftChild;
            } else {
                parent = currentNode;
                currentNode = currentNode.rightChild;
            }
        }
    }

    public void deleteNode(int key) {
        if (key == root.key)    {
            root = null;
        }
        else    {
        Node currentNode = root;
        while (true) {
            if (currentNode.key == key) {
                if (currentNode.rightChild != null && currentNode.leftChild != null && currentNode.key < getParent(key).key)    {
                    getParent(currentNode.key).leftChild = currentNode.rightChild;
                    currentNode.rightChild.leftChild = currentNode.leftChild;
                    break;

                }
                if (currentNode.rightChild != null && currentNode.leftChild != null && currentNode.key > getParent(key).key)    {
                    getParent(currentNode.key).rightChild = currentNode.rightChild;
                    currentNode.rightChild.leftChild = currentNode.leftChild;
                    break;

                }
                if(currentNode.leftChild == null && currentNode.rightChild == null && currentNode.key < getParent(key).key)   {
                    getParent(key).leftChild = null;
                    break;
                }
                if (currentNode.leftChild == null && currentNode.rightChild == null && currentNode.key > getParent(key).key)    {
                   getParent(key).rightChild = null;
                   break;
                }
                if (currentNode.leftChild == null && currentNode.key < getParent(key).key) {
                    currentNode = currentNode.rightChild;
                    getParent(key).leftChild = currentNode;
                    break;
                }
                if (currentNode.leftChild == null && currentNode.key > getParent(key).key) {
                    currentNode = currentNode.rightChild;
                    getParent(key).rightChild = currentNode;
                    break;
                }
                if (currentNode.rightChild == null && currentNode.key < getParent(key).key) {
                    currentNode = currentNode.leftChild;
                    getParent(key).leftChild = currentNode;
                    break;
                }
                if (currentNode.rightChild == null && currentNode.key > getParent(key).key) {
                    currentNode = currentNode.leftChild;
                    getParent(key).rightChild = currentNode;
                    break;
                }
            }
            else if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
            }
            else {
                currentNode = currentNode.rightChild;
            }
        }
        }
        System.out.println("Record deleted successfully!" + "\n");
    }

    public void updateNode(int key, Node newStudent) {
        deleteNode(key);
        addNode(newStudent);
    }
}