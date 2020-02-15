public class DriverStack

{

     public static void main(String args[])

     {

          Stack s=new Stack(2);//Stack of size only 2

          Listing l1=new Listing("Philp","1st Avenue","123 4567");

          Listing l2=new Listing("John","2nd Avenue","456 3232");

          Listing l3=new Listing("Joy","3rd Avenue","444 4444");

          Listing l4=new Listing("David","4th Avenue","765 4321");

          s.push(l1);

          s.push(l2);

         

          System.out.println("Top element : \n"+s.peek());//Display top element

          s.push(l3);//overflow error

          System.out.println("Current stack elements :");

          s.showAll();//Display l1 and l2

          s.expandStack();//Size becomes double, that is 4

          s.push(l3);//Now,push l3

          System.out.println("Current stack elements :");

          s.showAll();//Display l1,l2 and l3

          s.pop();//pop l3

          s.pop();//pop l2

          System.out.println("Current stack elements :");

          s.showAll();//Display l1

          s.pop();//Pop l1

          s.pop();//Underflow error

          s.reInitStack();//Make the stack empty

          s.push(l4);//push l4

          System.out.println("Current stack elements :");

          s.showAll();//Display l4

     }

}

/**Listing.java**/

public class Listing

{

     private String name;

     private String address;

     private String number;

     public Listing()

     {

          name=" ";

          address=" ";

          number =" ";      

     }

     public Listing(String n,String a, String num)

     {

          name=n;

          address=a;

          number =num;      

     }

     public String toString()

     {

          return ("Name is "+ name + "\n" +

                   "Address is " + address + "\n" +

                   "Number is " + number + "\n");

     }

     public Listing deepCopy()

     {

          Listing clone=new Listing(name,address,number);

          return clone;

     }   

}