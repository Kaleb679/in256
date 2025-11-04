package com.kaleb.multidimensionarr;
import java.util.ArrayList; // Import the ArrayList class

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //*********************************************************
        //****Assignment 3 Section 1
        //*********************************************************

        String[][] salesRegions = {
            {"North", "South", "East", "West"},
            {"Bob", "Sue", "Nathan", "Wanda"},
            {"Stef", "Janice", "Henry", "Charles"},
            {"Ron", "Will", "Kimmy", "Pete"}
        };
        System.out.println("Section 1: Two-Dimensional Array.");
        for (int i = 0; i < salesRegions.length; i++) {
            System.out.print("Row " + i + ": ");
            for (int j = 0; j < salesRegions[i].length; j++) {
                System.out.print(salesRegions[j][i]);
                if (j < salesRegions[i].length - 1) System.out.print(" | ");
            }
            System.out.println();
        }

        //*********************************************************
        //****Assignment 3 Section 2
        //*********************************************************

        System.out.println("\nSection 2: ArrayList");

        ArrayList<String> salesTeam = new ArrayList<>();

        salesTeam.add("Bob");
        salesTeam.add("Stef");
        salesTeam.add("Sue");

        System.out.println("There are three names in the salesTeam ArrayList.");

        if (salesTeam.contains("Stef")) {
            System.out.println("Stef is in the salesTeam ArrayList.");
        }

        salesTeam.add("Ron");
        salesTeam.add("Nathan");
        salesTeam.add("Will");

        System.out.println("There are six names in the salesTeam ArrayList.");

        salesTeam.remove("Ron");
        salesTeam.remove("Nathan");
        System.out.println("There are names in the salesTeam ArrayList.");

        System.out.println("\nNames currently in the salesTeam ArrayList");
        for (String name : salesTeam) {
            System.out.println(name);
        }

    }
}
