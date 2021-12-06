/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Food;
import Utill.Util;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author tuanb
 */
public class FoodManager {

    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    ArrayList<Food> Foodmanager = new ArrayList<>();

    public void addFood() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------");
        String ID = Util.checkInputIDString();
        for (Food food : Foodmanager) {
            if (food.getID().equals(ID)) {
                do {
                    System.err.println("You input a duplicate ID, please re-input it : ");
                    ID = Util.checkReinputIDString();
                } while (food.getID().equals(ID));
            }
        }
        System.out.println("---------------------------------");

        System.out.println("---------------------------------");
        String Name = Util.checkInputNameString();
        System.out.println("---------------------------------");

        System.out.println("---------------------------------");
        double Grams = Util.inputDoubleNumber(0.0, 10000.00);
        System.out.println("---------------------------------");

        System.out.println("---------------------------------");
        String Type = Util.chooseType();
        System.out.println("---------------------------------");

        System.out.println("---------------------------------");
        String Place = Util.choosePlace();
        System.out.println("---------------------------------");

        System.out.println("---------------------------------");
        Date now = Util.inputDate();
        System.out.println("---------------------------------");

        System.out.println("---------------------------------");
        Foodmanager.add(new Food(ID, Name, Grams, Type, Place, now));
        System.out.println("Add food succesfully !");
    }

    public void showInfo() {
        do {
            if (Foodmanager.isEmpty()) {
                System.out.println("Food list is empty, cannot show info!");
                break;
            }
            System.out.println("Show Food List");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%15s %5s %15s %5s %8s %5s %30s %5s %10s %5s %15s %5s", "Food ID", "|", "Food Name", "|", "Grams", "|", "Type", "|", "Place", "|", "Expired Date", "|");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Food food : Foodmanager) {

                System.out.format("%15s %5s %15s %5s %8s %5s %30s %5s %10s %5s %15s %5s", food.getID(), "|", food.getName(), "|", food.getGrams(), "|", food.getType(), "|", food.getPlace(), "|", df.format(food.getexpiredDate()), "|");
                System.out.println();
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        } while (false);
    }

    public void sortByExpireDate() {
        Collections.sort(Foodmanager, (o2, o1) -> {
            return (o1.getexpiredDate().compareTo(o2.getexpiredDate()));
        });
    }

    public void searchByName() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Scanner sc = new Scanner(System.in);
        String i = null;
        //Date searchDate = new Date();
        do {
            if (Foodmanager.isEmpty()) {
                System.out.println("Food list is empty, canot search !");
                break;
            }
            System.out.println("Enter the name of food to be printed !");
            String ten = Util.checkInputNameString();
            Boolean hasFood = false;
            System.out.println("Show Food List");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%15s %5s %15s %5s %8s %5s %30s %5s %10s %5s %15s %5s", "Food ID", "|", "Food Name", "|", "Grams", "|", "Type", "|", "Place", "|", "Expired Date", "|");
            System.out.println();
            for (int a = 0; a < Foodmanager.size(); a++) {
                if (Foodmanager.get(a).getName().contains(ten)) {

                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.format("%15s %5s %15s %5s %8s %5s %30s %5s %10s %5s %15s %5s", Foodmanager.get(a).getID(), "|", Foodmanager.get(a).getName(), "|", Foodmanager.get(a).getGrams(), "|", Foodmanager.get(a).getType(), "|", Foodmanager.get(a).getPlace(), "|", df.format(Foodmanager.get(a).getexpiredDate()), "|");
                    System.out.println();
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                    hasFood = true;
                }
            }
            if (!hasFood) {
                System.out.println("Food doesn't exist!");
            }
            System.out.println("Do you want to continue search? (YES/NO)");
            Boolean wrongInput = false;
            do {
                if (wrongInput) {
                    System.out.println("Please enter \"yes\" or \"no\" correctly.  ! ");

                }
                i = sc.nextLine().toUpperCase().trim();
                wrongInput = true;

            } while (!"YES".equals(i) && !"NO".equals(i));

        } while ("YES".equals(i));
    }

    public void removeByID() {
        do {
            if (Foodmanager.isEmpty()) {
                System.out.println("Food list is empty, cannot remove!");
                break;
            }
            System.out.println("Enter Food's ID to delete  :");
            String ID = Util.checkReinputIDString();
            Food found = null;
            for (Food food : Foodmanager) {
                if (food.getID().equals(ID)) {
                    found = food;
                    break;
                }
            }
            if (found != null) {
                System.out.println("Are you sure you want to removed this food ? (Y=1 : N=0) ");
                int a = 10;
                Boolean wrongInput = false;
                do {
                    if (wrongInput) {
                        System.out.println("Wrong input ! You entered the word or wrong numbers ! Please choose [1=Yes/0=No]");
                    }
                    try {
                        Scanner ch = new Scanner(System.in);
                        a = ch.nextInt();
                    } catch (Exception e) {
                    }
                    wrongInput = true;
                } while (a < 0 || a > 1);
                if (a == 1) {
                    Foodmanager.remove(found);
                    System.out.println("The food has been removed successfully ");
                } else if (a == 0) {
                    System.out.println("Removed food failed");
                }
            } else {
                System.out.println("Food doesn't exist!");
            }
        } while (false);

    }

    public void printToFile() {
        do {
            if (Foodmanager.isEmpty()) {
                System.out.println("Food list is empty, cannot print to file!");
                break;
            }
            try {
                FileOutputStream fos = new FileOutputStream("data.txt");
                PrintWriter pw = new PrintWriter(fos);
                for (int i = 0; i < Foodmanager.size(); i++) {
                    pw.println("---------------------------------");
                    pw.println(Foodmanager.get(i).getID());
                    pw.println(Foodmanager.get(i).getName());
                    pw.println(Foodmanager.get(i).getGrams());
                    pw.println(Foodmanager.get(i).getType());
                    pw.println(Foodmanager.get(i).getPlace());
                    pw.println(df.format(Foodmanager.get(i).getexpiredDate()));
                    pw.println("---------------------------------");
                }
                pw.close();
                fos.close();

            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            } finally {
                System.out.println("Print file to data.txt successfull !!");
            }
        } while (false);
    }

}
