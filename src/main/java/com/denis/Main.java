package com.denis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Clinic clinic = new Clinic();
        String exit = "no";

        System.out.println( "\nWelcome to clinic application!   \n" +
                            "You can use this app for modeling  \n" +
                            "work of real veterinary clinic.    \n");
        helpMenu();

        while(!exit.equals("yes")){

            String operationExit = "yes";
            String clientName, petName;

            while(operationExit.equals("yes")){
                System.out.println("what operation would you like to do?");
                String operation = reader.next();
                operationExit = "no";

                switch (operation){
                    case "addClient":
                        System.out.println("Enter name of client");
                        clientName = reader.next();
                        System.out.println("Enter name of pet");
                        petName = reader.next();
                        System.out.println("Enter age of pet");
                        try{
                            String petAge = reader.next();
                            clinic.addClient(new Client(clientName, new Pet(petName, Integer.valueOf(petAge))));
                        }   catch (NumberFormatException e){
                            System.out.println("Exception: " + e.getMessage() + ", you can use only numbers");
                        }
                        break;
                    case "deleteClient":
                        System.out.println("Enter name of client");
                        clientName = reader.next();
                        clinic.findClient(clientName);
                        for(Client current: clinic.searchList){
                            clinic.deleteClient(current);
                        }
                        break;
                    case "findClient":
                        System.out.println("Enter name of client");
                        clientName = reader.next();
                        clinic.findClient(clientName);
                        clinic.showSearchRes();
                        break;
                    case "findPet":
                        System.out.println("Enter name of pet");
                        petName = reader.next();
                        clinic.findPet(petName);
                        clinic.showSearchRes();
                        break;
                    case "showList":
                        clinic.showList();
                        break;
                    case "changeClientName":
                        System.out.println("Enter old name");
                        clientName = reader.next();
                        System.out.println("Enter new name");
                        String newCName = reader.next();
                        clinic.changeNameClient(clientName, newCName);
                        break;
                    case "changePetName":
                        System.out.println("Enter old name");
                        petName = reader.next();
                        System.out.println("Enter new name");
                        String newPName = reader.next();
                        clinic.changePetName(petName, newPName);
                        break;
                    case "help":
                        helpMenu();
                        break;
                    case "exit":
                        exit = "yes";
                        break;
                    default:
                        System.out.println("There is no such command, try again? yes/no ");
                        operationExit = reader.next();
                }
            }
        }
    }

    private static void helpMenu (){
        System.out.println("There are next available operations: \n" +
                " -- to add client to clinic                -- addClient            \n" +
                " -- to delete client from clinic           -- deleteClient         \n" +
                " -- to find clint by his/her name          -- findClient           \n" +
                " -- to find clint by name of his/her pet   -- findPet              \n" +
                " -- to change name of client               -- changeClientName     \n" +
                " -- to change name of pet of client        -- changePetName        \n" +
                " -- to show list of all clients            -- showList             \n" +
                " -- to get help menu                       -- help                 \n" +
                " -- to exit the program                    -- exit                 \n");
    }
}
