//listpro.java

import javax.swing.*;

public class listpro {

    private String Name;

    private int ID;

    private float grade_point;

    public listpro(){

    }

  public listpro(String Name, int ID, float grade_point){

        this.Name = Name;

        this.ID = ID;

        this.grade_point = grade_point;

    }

    public String getNamedata() {

        return Name;

    }

    public void setNamedata(String Name) {

        this.Name = Name;

    }

    public int getID() {

        return ID;

    }

    public void setID(int ID) {

        this.ID = ID;

    }

    public float getgrade_point() {

        return grade_point;

    }

    public void setgrade_point(float grade_point) {

        this.grade_point = grade_point;

    }

    public listpro deepCopy(){

        listpro clone = new listpro(Name,ID,grade_point);

        return clone;

    }

    public String toString(){

        return "Name : " + Name + "\nID :" + ID + "\nGrade points :" + grade_point;

    }

    public void input(){

        Name = JOptionPane.showInputDialog("Enter a Name");

        ID = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID"));

        grade_point = Float.parseFloat(JOptionPane.showInputDialog("Enter a grade point average"));

    }

}