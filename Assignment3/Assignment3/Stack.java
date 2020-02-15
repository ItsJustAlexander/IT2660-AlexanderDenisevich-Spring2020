public class Stack
{
 private Listing[] data;

     private int top;

     private int size;

     public Stack()
     {

          top=-1;

          size=100;

          data=new Listing[100];

     }
     public Stack(int n)

     {

          top=-1;

          size=n;

          data=new Listing[n];

     }

     //This is where it pushes a new element into the stack, if the stack is not full Exercise #20

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

     public void showAll()

     {

          for(int i=top;i>=0;i--)

              System.out.println(data[i].toString());

     }

     public void reInitStack()

     {

          top=-1;

     }

     public boolean isStackEmpty()

     {

          if(top==-1)

              return true;

          else

              return false;

     }

     public boolean isStackFull()

     {

          if(top==size-1)

              return true;

          else

              return false;

     }

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