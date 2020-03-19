package com.example.mvvmdemo.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Observable;
import java.util.Observer;

import com.example.mvvmdemo.Model.Model;

public class AndroidLowerCaseViewModel extends ViewModel {

   private MutableLiveData<String> presentableData = new MutableLiveData<>();
   private Model model = new Model();

   public AndroidLowerCaseViewModel() {
        observeModel(model);
        presentableData.setValue(getTransformedData(model.getInput()));

   }

   private void observeModel(Model model) {
       model.addObserver(new Observer() {
           @Override
           public void update(Observable o, Object arg) {
               if (o instanceof Model) {
                   String data = ((Model) o).getInput();
                   presentableData.setValue(getTransformedData(data));
               }
           }
       });
   }

   private String getTransformedData(String data) {
       return data.toLowerCase();
   }


   public MutableLiveData<String> getPresentableData() {
       return presentableData;
   }

   public void setInput(String data) {
       model.setInput(data);
   }

}
