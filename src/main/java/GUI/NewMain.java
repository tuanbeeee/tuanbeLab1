/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.FoodManager;
import Utill.Util;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author tuanb
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, Exception {
        String i;
        Scanner sc = new Scanner(System.in);
        do {
            String a = Util.checkInputNameString();
            System.out.println(a);

            System.out.println("Do you want to continue YES/NO?");
            while(true){
            i = sc.nextLine().trim().toUpperCase();
            if ("YES".equals(i) && "NO".equals(i)) {
                break;
            } else {
                System.out.println("Reinput YES/NO?");
                i = sc.nextLine().toUpperCase().trim();
            }
            }
        } while ("YES".equals(i));
    }
}
