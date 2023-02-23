package edu.tampa.open_pet3.model;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class BaseEntity {
    @Id
    @SequenceGenerator(name="GLOBAL_SEQ",sequenceName = "GLOBAL_SEQ",
    allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "GLOBAL_SEQ")
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
