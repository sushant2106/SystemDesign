package com.sushant.properties.encapsulation;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<String> subjects=new ArrayList<>();

    public void addSubject(String subject){
        if(subject == null || subject.isBlank()){
            throw  new IllegalArgumentException(
                    "Subject cannot be empty"
            );
        }
        subjects.add(subject);

    }

    public void removeSubject(String subject) {
        subjects.remove(subject);
    }

    public boolean hasSubject(String subject) {
        return subjects.contains(subject);
    }


}
