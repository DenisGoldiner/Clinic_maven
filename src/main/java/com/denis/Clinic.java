package com.denis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class describes work of clinic. There are methods to add/remove clients/pets,
 * to search client by his/her name or name of his/her pet,
 * to change name of client/pet, to show on console list of all clients or result of search
 * Created by Denis on 16.09.2015.
 */
public class Clinic {

    /**
     * List which will contain all clients and information about them and their pets
     */
    private final LinkedList<Client> clients = new LinkedList<Client>();

    /**
     * List which will contain result of search by the name of client or his/her pet
     */
    protected final ArrayList<Client> searchList = new ArrayList<Client>();

    /**
     * adding to list of clients
     * @param newClient name of client to add
     */
    public void addClient(Client newClient){
        this.clients.addLast(newClient);
    }

    /**
     * Searching client by his/her name
     * @param nameToFind name that will be searching in the list of all clients
     */
    public void findClient(String nameToFind){
        clearSearchList();
        for(Client current: this.clients){
            if(current.getClientName().equals(nameToFind)){
                this.searchList.add(current);
            }
        }
    }

    /**
     * Searching client by name of his/her pet
     * @param nameToFind name of pet that will be searching in the list of all clients
     */
    public void findPet(String nameToFind){
        clearSearchList();
        for(Client current: this.clients){
            if(current.getPet().getPetName().equals(nameToFind)){
                this.searchList.add(current);
            }
        }
    }

    /**
     * deleting client from clinic
     * @param delClient client that will be deleted
     */
    public void deleteClient(Client delClient){
        Iterator<Client> it = clients.iterator();
        while(it.hasNext()){
            Client current = it.next();
            if(current.equals(delClient)){
                it.remove();
            }
        }
    }

    /**
     * changing the name of client
     * @param oldName old name of client
     * @param newName new name of client
     */
    public void changeNameClient(String oldName, String newName){
        clearSearchList();
        findClient(oldName);
        if(this.searchList.size() > 0) {
            for (Client current : this.clients) {
                if (current.getClientName().equals(oldName)) {
                    current.setClientName(newName);
                }
            }
        } else{
            System.out.println("There is no client with tis name");
        }
    }

    /**
     * changing the name of pet
     * @param oldName old name of pet
     * @param newName new name of pet
     */
    public void changePetName(String oldName, String newName){
        clearSearchList();
        findPet(oldName);
        if(this.searchList.size() > 0) {
            for (Client current : this.clients) {
                if (current.getPet().getPetName().equals(oldName)) {
                    current.getPet().setPetName(newName);
                }
            }
        } else {
            System.out.println("There is no pet with this name");
        }
    }

    /**
     * shows current list of all clients in the console
     */
    public void showList(){
        for(Client current: this.clients){
            System.out.println("[ Client's name = " + current.getClientName() + ", Pet's name = " + current.getPet().getPetName() + " ]");
        }
    }

    /**
     * Shows result of searching in the console
     */
    public void showSearchRes(){
        for(Client current: this.searchList){
            System.out.println("[ Client's name = " + current.getClientName() + ", Pet's name = " + current.getPet().getPetName() + " ]");
        }
    }

    /**
     * clears result of searching
     */
    public void clearSearchList(){
        this.searchList.clear();
    }
}
