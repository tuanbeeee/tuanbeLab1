package GUI;

import DAO.FoodManager;
import Utill.Util;
import java.text.ParseException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tuanb
 */
public class FoodMenu {

    /**
     * @param args the command line arguments
     */
    public static void Menu() {
        System.out.println("---------------------------------");
        System.out.println("Welcome to Food Management - @ 2021 by <SE151159 - Nguyen Anh Tuan >");
        System.out.println("Select the options below:");
        System.out.println("1. Add a new food");
        System.out.println("2. Search a food by name");
        System.out.println("3. Remove the food by ID");
        System.out.println("4. Print the food list in the descending order of expired date");
        System.out.println("5. Print to file");
        System.out.println("6. Quit");
        System.out.println("---------------------------------");
        System.out.println("Please choose [1..6] : ");

    }

    public static void main(String[] args) throws ParseException {

        FoodManager w = new FoodManager();
        for (;;) {
            int choice = 0;
            Boolean wrongInput = false;
            do {
                if (wrongInput) {
                    System.out.println("Wrong input choice ! You are input text, or input the menu limit. Please input again ! ");
                }
                Menu();

                try {
                    choice = 0;
                    Scanner sc = new Scanner(System.in);
                    choice = sc.nextInt();
                } catch (Exception e) {

                }
                wrongInput = true;
            } while (choice < 1 || choice > 6);
            switch (choice) {
                case 1: {
                    
                    String i;
                    boolean wrong = false;
                    do {
                        w.addFood();
                        System.out.println("Do you want to continue add food YES/NO?");
                        do {
                            
                            if (wrong) {
                                System.out.println("Please enter \"yes\" or \"no\" correctly.  ! ");
                            }
                            Scanner sc = new Scanner(System.in);
                            i = sc.nextLine().toUpperCase().trim();
                            wrong = true;
                        } while (!"YES".equals(i) && !"NO".equals(i));
                    } while ("YES".equals(i));
                    break;
                }
                case 2: {
                    w.searchByName();

                    break;
                }
                case 3: {
                    w.removeByID();
                    break;
                }
                case 4: {
                    w.sortByExpireDate();
                    w.showInfo();
                    break;
                }
                case 5: {
                    w.printToFile();
                    break;
                }
                case 6: {
                    System.exit(0);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

}
