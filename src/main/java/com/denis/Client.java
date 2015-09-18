package com.denis;

/**
 * This class describes the client of clinic
 * Created by Denis on 16.09.2015.
 */
public class Client {

    private String clientName;
    private Pet pet;

    public Client(String clientName,Pet pet){
        this.clientName = clientName;
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
