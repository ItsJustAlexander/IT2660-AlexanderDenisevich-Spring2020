import java.util.Scanner;
class Node {
protected int dataInfo;
protected Node link;
public Node() {
link = null;
dataInfo = 0;
}
public Node(final int dData, final Node nData) {
    dataInfo = dData;
    link = nData;
}

public void setLink(final Node nDataInfo) {
    link = nDataInfo;
}

public void setData(final int dDataInfo) {
    dataInfo = dDataInfo;
}

public Node getLink() {
    return link;
}

public int getData() {
    return dataInfo;
}
}

class linkedList {
    protected Node start;
    protected Node end;
    public int size;

    public linkedList() {
        start = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public int getSize() {
        return size;
    }

    public void insertAtStartPos(final int ObjVal) {
        final Node ObjNptr = new Node(ObjVal, null);
        size++;
        if (start == null) {
            start = ObjNptr;
            end = start;
        } else {
            ObjNptr.setLink(start);
            start = ObjNptr;
        }
    }

    public void insertAtEndPos(final int valData) {
        final Node ObjNptrInfo = new Node(valData, null);
        size++;
        if (start == null) {
            start = ObjNptrInfo;
            end = start;
        } else {
            end.setLink(ObjNptrInfo);
            end = ObjNptrInfo;
        }
    }

    public void insertAtSpecPos(final int ObjVal, int ObjPos) {
        final Node nptr = new Node(ObjVal, null);
        Node ptr = start;
        ObjPos = ObjPos - 1;
        for (int iData = 1; iData < size; iData++) {
            if (iData == ObjPos) {
                final Node tmp = ptr.getLink();
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size++;
    }

    public void deleteAtSpecPos(int posInfo) {
        if (posInfo == 1) {
            start = start.getLink();
            size--;
            return;
        }
        if (posInfo == size) {
            Node ObjS = start;
            Node ObjT = start;
            while (ObjS != end) {
                ObjT = ObjS;
                ObjS = ObjS.getLink();
            }
            end = ObjT;
            end.setLink(null);
            size--;
            return;
        }
        Node ObjPtr = start;
        posInfo = posInfo - 1;
        for (int ObjI = 1; ObjI < size - 1; ObjI++) {
            if (ObjI == posInfo) {
                Node tmp = ObjPtr.getLink();
                tmp = tmp.getLink();
                ObjPtr.setLink(tmp);
                break;
            }
            ObjPtr = ObjPtr.getLink();
        }
        size--;
    }

    public void display() {
        System.out.print("\nHere is singly Linked List Data = ");
        if (size == 0) {
            System.out.print("oh list is empty\n");
            return;
        }
        if (start.getLink() == null) {
            System.out.println(start.getData());
            return;
        }
        Node ptrData = start;
        System.out.print(start.getData() + "->");
        ptrData = start.getLink();
        while (ptrData.getLink() != null) {
            System.out.print(ptrData.getData() + "->");
            ptrData = ptrData.getLink();
        }
        System.out.print(ptrData.getData() + "\n");
    }
}

public class OperationsSinglyLinkedTest {
    public static void main(final String[] args) {
        final Scanner scanInfo = new Scanner(System.in);
        final linkedList objlinkedList = new linkedList();
        System.out.println("This is for Singly Linked List Test\n");
        char ObjCh;
        do {
            System.out.println("\nOperations for Singly Linked List \n");
            System.out.println("1. is for insert at begining");
            System.out.println("2. is for insert at end");
            System.out.println("3. is for insert at position");
            System.out.println("4. is for delete at position");
            System.out.println("5. is for check empty");
            System.out.println("6. is for get size");
            final int getChoice = scanInfo.nextInt();
            switch (getChoice) {
                case 1:
                    System.out.println("Please enter integer element to insert");
                    objlinkedList.insertAtStartPos(scanInfo.nextInt());
                    break;
                case 2:
                    System.out.println("Please enter integer element to insert");
                    objlinkedList.insertAtEndPos(scanInfo.nextInt());
                    break;
                case 3:
                    System.out.println("Please enter integer element to insert");
                    final int ObjNum = scanInfo.nextInt();
                    System.out.println("Please enter position");
                    final int ObjPos = scanInfo.nextInt();
                    if (ObjPos <= 1 || ObjPos > objlinkedList.getSize())
                        System.out.println("This is invalid position\n");
                    else
                        objlinkedList.insertAtSpecPos(ObjNum, ObjPos);
                    break;
                case 4:
                    System.out.println("Please enter position");
                    final int ObjP = scanInfo.nextInt();
if (ObjP < 1 || ObjP > objlinkedList.getSize())
System.out.println("This is invalid position\n");
else
objlinkedList.deleteAtSpecPos(ObjP);
break;
case 5:
System.out.println("Empty status is = " + objlinkedList.isEmpty());
break;
case 6:
System.out.println("Size of list is = " + objlinkedList.getSize() + " \n");
break;
default:
System.out.println("oh it is wrong Entry \n ");
break;
}
objlinkedList.display();
System.out.println("\n Want to continue Still (Type y or n) \n");
ObjCh = scanInfo.next().charAt(0);
} while (ObjCh == 'Y' || ObjCh == 'y');
}
}