package com.example.gestiontask.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Title;
    private String Description;
    private boolean completed;

    //Getter
    public Long getId(){ return id;}
    public String getTitle(){return Title;}
    public String getDescription(){return Description;}
    public boolean isCompleted(){return completed;}

    //Setter
    public void setId(Long id ){this.id = id;}
    public void setTitle(String Title){this.Title = Title;}
    public void setDescription(String Description){this.Description = Description;}
    public void setCompleted(boolean completed){this.completed = completed;}



}
