package com.example.mvvmdemo.View;

import java.util.Observable;
import java.util.Observer;

import com.example.mvvmdemo.Model.Model;

public class LowerCasePresenter extends Observable {

   private String presentableData;

   private Model model = new Model();

   public LowerCasePresenter() {
        observeModel(model);
        presentableData = getTransformedData(model.getInput());

   }

   private void observeModel(Model model) {
       model.addObserver(new Observer() {
           @Override
           public void update(Observable o, Object arg) {
               if (o instanceof Model) {
                   String data = ((Model) o).getInput();
                   presentableData = getTransformedData(data);

                   LowerCasePresenter.super.setChanged();
                   LowerCasePresenter.super.notifyObservers();
               }
           }
       });
   }

   private String getTransformedData(String data) {
       return data.toLowerCase();
   }

   public String getPresentableData() {
       return presentableData;
   }

   public void setInput(String data) {
       model.setInput(data);
   }

}
