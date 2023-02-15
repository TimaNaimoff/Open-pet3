package edu.tampa.open_pet3.model;

public class BaseEntity {
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public boolean isNew(){
        return (this.id==null);
    }
}
