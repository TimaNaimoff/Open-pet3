package edu.tampa.open_pet3.model;

import java.util.Objects;

public abstract class BaseEntity {
    protected Integer id;

    public BaseEntity(){}
    public Integer getId() {
        return id;
    }

    public boolean isNew(){
        return (this.id==null);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id==null?0:id;
    }
}
