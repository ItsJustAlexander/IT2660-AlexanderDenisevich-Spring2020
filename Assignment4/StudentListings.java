package studentlistings;
import javax.swing.JOptionPane;

public class StudentListings {

   private String Name;
   private int Id_number;
   private double Gpa;

   public StudentListings()
   {
       Name="abc";
       Id_number=1234;
       Gpa=0.0;
   
   }

   public String toString()
   {
        return("Name is " + Name +"\nIdentification number is " + Id_number +"\nGPA is " + Gpa+ "\n");
   }

   public StudentListings deepCopy( )
   {
      StudentListings clone = new StudentListings();
      return clone;
   }

   public int compareTo(String targetKey)
   {
       return(Name.compareTo(targetKey));
   }

   public void input()
   {
    Name = JOptionPane.showInputDialog("Enter the name");
    Id_number= Integer.parseInt(JOptionPane.showInputDialog("Enter the ID"));
    Gpa = Double.parseDouble(JOptionPane.showInputDialog("Enter the GPA"));
    }

    public static void main(String[] args) {
      
      StudentListings classlist= new StudentListings();
    
      classlist.input();
    
      System.out.println(classlist.toString());
      int flag=classlist.compareTo("Alex");
      classlist.deepCopy();
      if(flag==0)
      {
          System.out.println("Alex is there in the list");
      }
      else
          System.out.println("Alex is not there in the list");
    
    }
  
}