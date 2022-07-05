package com.testarmy.aplikacjaToDo;

import java.util.Date;
import java.util.List;

@FunctionalInterface
public interface Dane <T>  {
     T Dane(String title, String description, int priorities, String personResponsible,
                String data, boolean end);
//    T Dane(T vallue);

}