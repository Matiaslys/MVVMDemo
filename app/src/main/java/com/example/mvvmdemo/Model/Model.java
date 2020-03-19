package com.example.mvvmdemo.Model;


import java.util.Observable;

public class Model extends Observable {
    private String input = "Hello";


    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
        setChanged();
        notifyObservers(input);
    }

}
