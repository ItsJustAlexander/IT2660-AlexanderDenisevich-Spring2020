public class Stack
{
 private Listing[] data;

     private int top;

     private int size;

     //Default constructor

     public Stack()

     {

          top=-1;

          size=100;

          data=new Listing[100];

     }

     //Parameterized constructor

     public Stack(int n)

     {

          top=-1;

          size=n;

          data=new Listing[n];

     }

     //Pushes a new element into the stack, if the stack is not full

     public boolean push(Listing newNode)

     {

          if(isStackFull())

          {

              System.out.println("Stack is overflow");

              return false;

          }

          else

          {

              top=top+1;

              data[top]=newNode.deepCopy();

              return true;

          }

     }

     //Pops an element that is pushed recently, if the stack is not empty

     public Listing pop()

     {

          int topLocation;

          if(isStackEmpty())

          {

              System.out.println("Stack is underflow");

              return null;

          }

          else

          {

              topLocation=top;

              top=top-1;

              return data[topLocation];

          }

     }

     //Displays all the elements in the stack

     public void showAll()

     {

          for(int i=top;i>=0;i--)

              System.out.println(data[i].toString());

     }

     //Reinitializes the stack or makes the stack empty

     public void reInitStack()

     {

          top=-1;

     }

     //Returns true, if the stack is empty

     //otherwise, returns false.

     public boolean isStackEmpty()

     {

          if(top==-1)

              return true;

          else

              return false;

     }

     //Returns true, if the stack is full

     //otherwise, returns false.

     public boolean isStackFull()

     {

          if(top==size-1)

              return true;

          else

              return false;

     }

     //Returns the top element of the stack

     //with out removing the top element.

     public Listing peek()

     {

          if(isStackEmpty())

          {

              System.out.println("Stack is underflow");

              return null;

          }

          else

          {

              return data[top];

          }

     }

     //Expands the size of the stack

     public void expandStack()

     {

          Listing[] buff;

          buff=new Listing[size*2];

          for(int i=0;i<size;i++)

          {

              buff[i]=data[i];

          }

          size=size*2;

          data=buff;

     }

}