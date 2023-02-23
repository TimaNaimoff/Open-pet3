package edu.tampa.open_pet3.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name="users",uniqueConstraints = {@UniqueConstraint(columnNames = "email",name="unique_email")})
public class User extends AbstractNamedEntity {
   
    private String email;
    @Column(name="password",nullable=false)
    @NotEmpty
    @Length(min=5)
    private String password;
    @Column(name="enabled",nullable=false)
    private boolean enabled=true;
    @Column(name="registered",columnDefinition="timestamp default now()")
    private Date registered =new Date();
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="users_roles",joinColumns=@JoinColumn(name="user_id"))
    @Column(name="role")
    @ElementCollection(fetch=FetchType.EAGER)
    private Set<Role> authorities;
    public User(){}
    public User(User user){
        this(user.getId(),user.getName(),user.getEmail(),user.getPassword(),user.isEnabled(),user.getRegistered(),user.getAuthorities());
        }

    public User(Integer id, String name, String email, String password, boolean enabled, Date registered, Set<Role>authorities){
        super(id,name);
        this.email=email;
        this.password=password;
        this.enabled=enabled;
        this.registered = registered;
        this.authorities=authorities;
    }
    public User(Integer id, String name, String email, String password, boolean enabled, Date registered, Role role, Role...roles){
        super(id,name);
        this.email=email;
        this.password=password;
        this.enabled=enabled;
        this.registered = registered;
        this.authorities= EnumSet.of(role,roles);
    }
    public User(Integer id,String name,String email,String password,Role role,Role...roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        authorities= EnumSet.of(role,roles);
    }
    public User(String name,String email,String password,Role role,Role...roles) {
        super(null, name);
        this.email = email;
        this.password = password;
        authorities= EnumSet.of(role,roles);
    }

    public User(String name,String email,String password){
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }
    public boolean isNew(){
        return id==null;
    }
    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", date=" + registered +
                ", authorities=" + authorities +
                '}';
    }
}
