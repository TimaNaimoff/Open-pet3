package edu.tampa.open_pet3.model;

public class NamedEntity {
    protected String name;
    public NamedEntity(){

    }
    protected NamedEntity(String name){
        this.name=name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "NamedEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
