package com.netcracker.sd4.persistence.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {
    private int id;
    private String name;
    private Boolean isAdmin;
    private Collection<User> users;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "is_admin", columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != role.id) return false;
        if (name != null ? !name.equals(role.name) : role.name != null) return false;
        if (isAdmin != null ? !isAdmin.equals(role.isAdmin) : role.isAdmin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isAdmin != null ? isAdmin.hashCode() : 0);
        return result;
    }

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="roles")
    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
