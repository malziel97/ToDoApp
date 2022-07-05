package com.testarmy.aplikacjaToDo;

import java.io.File;

public class Task {


    private String title;
    private String description;
    private int priorities;
    private String personResponsible;
    private String data;
    private boolean isTaskFinished;
    private  File fileLocation;

    public Task(String title, String description, int priorities, String personResponsible, String data, boolean isTaskFinished) {
        this.title = title;
        this.description = description;
        this.priorities = priorities;
        this.personResponsible = personResponsible;
        this.data = data;
        this.isTaskFinished = this.isTaskFinished;
        fileLocation=new File("Dane/" + title + ".txt");
        //fileLocation=new File("src/com/testarmy/aplikacjaToDo/dane/" + title + ".txt");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriorities() {
        return priorities;
    }

    public void setPriorities(int priorities) {
        this.priorities = priorities;

    }

    public String getPersonResponsible() {
        return personResponsible;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priorities=" + priorities +
                ", personResponsible='" + personResponsible + '\'' +
                ", data='" + data + '\'' +
                ", isTaskFinished=" + isTaskFinished +
                '}';
    }




    public void setPersonResponsible(String personResponsible) {
        this.personResponsible = personResponsible;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isTaskFinished() {
        return isTaskFinished;
    }

    public void setTaskFinished(boolean taskFinished) {
        this.isTaskFinished = taskFinished;
    }


    public File getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(File fileLocation) {
        this.fileLocation = fileLocation;
    }
}


