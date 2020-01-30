//driver.java

import javax.swing.*;

import java.util.Scanner;

public class driver {

    static Scanner indata = new Scanner(System.in);

    static int choice() {

        System.out.println("1. insert data");

        System.out.println("2. fetch data");

        System.out.println("3. delete data");

        System.out.println("4. update data");

        System.out.println("5. output student data");

        System.out.println("6. exit the program");

        System.out.print("enter choice: ");

        return indata.nextInt();

    }

    public static void main(String[] args) {

        int choice11;

        Listlinked Listlinked = new Listlinked();

        listpro listing11;

        String name;

        while (true) {

            choice11 = choice();

            switch (choice11) {

                case 1:

                    listing11 = new listpro();

                    listing11.input();

                    Listlinked.insert(listing11);

                    System.out.println("operation finish");

                    break;

                case 2:

                    name = JOptionPane.showInputDialog("Fetch the name");

                    listing11 = Listlinked.fetch(name);

                    if(listing11 == null)

                        System.out.println("invalid structure");

                    else {

                        System.out.println(listing11.toString());

                    }

                    break;

                case 3:

                    name = JOptionPane.showInputDialog("Delete the name");

                    if(Listlinked.delete(name)) {

                        System.out.println("operation complete");

                    } else {

                        System.out.println("Invalid structure");

                    }

                    break;

                case 4:

                    name = JOptionPane.showInputDialog("update the name");

                    listing11 = Listlinked.fetch(name);

                    if(listing11 == null)

                        System.out.println("invalid structure");

                    else {

                        listing11.input();

                        System.out.println("operation finish");

                    }

                    break;

                case 5:

                    Listlinked.printAll();

                    System.out.println("operation finish");

                    break;

                case 6:

                    return;

                default:

                    System.out.println("Invalid choice. Please try again!!");

                    break;

            }

        }

    }

}