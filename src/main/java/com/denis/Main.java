package com.denis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Clinic clinic = new Clinic();
        String exit = "no";

        System.out.println("\nWelcome to clinic application!                \n");
        System.out.println("You can use this app for modeling work of real  \n" +
                            "veterinary clinic. There are next available    \n" +
                            "operations: \n" +
                            " -- to add client to clinic                -- addClient            \n" +
                            " -- to delete client from clinic           -- deleteClient         \n" +
                            " -- to find clint by his/her name          -- findClient           \n" +
                            " -- to find clint by name of his/her pet   -- findPet              \n" +
                            " -- to change name of client               -- changeClientName     \n" +
                            " -- to change name of pet of client        -- changePetName        \n" +
                            " -- to show list of all clients            -- showList             \n");

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
                        if(clinic.searchList.size() > 0){
                            clinic.showList();
                        } else{
                            System.out.println("Clinic's client list is empty");
                        }
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
                    default:
                        System.out.println("There is no such command, try again? yes/no ");
                        operationExit = reader.next();
                }
            }
            System.out.println("\nExit yes/no ? \n");
            exit = reader.next();
        }
    }
}
