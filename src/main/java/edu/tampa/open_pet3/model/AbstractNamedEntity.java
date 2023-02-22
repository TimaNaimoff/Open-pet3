package edu.tampa.open_pet3.model;

public abstract class AbstractNamedEntity extends BaseEntity{
    protected String name;
    public static final int START_SEQ=100000;
    public AbstractNamedEntity(){

    }
    protected AbstractNamedEntity(Integer id, String name){
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
