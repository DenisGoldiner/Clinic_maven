package com.denis;

/**
 * This class describes a pet, belongs to client of clinic
 * Created by Denis on 16.09.2015.
 */
public class Pet {

    private String petName;
    private int petAge;

    public Pet(String petName, int petAge) {
        this.petName = petName;
        this.petAge = petAge;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

}
