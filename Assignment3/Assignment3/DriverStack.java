public class DriverStack
{
     public static void main(String args[])
     {

          Stack s=new Stack(2);

          Listing l1=new Listing("Cody","1230 Walling Street","216-331-1119");

          Listing l2=new Listing("Alex","4545 Lakeview Drive","216-456-0000");

          Listing l3=new Listing("Zach","3319 3rd Main Street","216-450-3344");

          Listing l4=new Listing("David","8585 Wade Avenue","440-765-0825");

          s.push(l1);

          s.push(l2);

          System.out.println("Top element : \n"+s.peek());

          s.push(l3);

          System.out.println("Current stack elements :");

          s.showAll();

          s.expandStack();

          s.push(l3);

          System.out.println("Current stack elements :");

          s.showAll();

          s.pop();

          s.pop();

          System.out.println("Current stack elements :");

          s.showAll();

          s.pop();

          s.pop();

          s.reInitStack();

          s.push(l4);

          System.out.println("Current stack elements :");

          s.showAll();

     }

}