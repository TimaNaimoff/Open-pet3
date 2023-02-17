package edu.tampa.open_pet3.model;

public class NamedEntity {
    protected Integer id;
    protected String name;
    public NamedEntity(){

    }
    protected NamedEntity(Integer id,String name){
        this.id=id;
        this.name=name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "NamedEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
