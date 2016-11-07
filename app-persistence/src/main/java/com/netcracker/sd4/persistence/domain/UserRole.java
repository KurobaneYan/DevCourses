package com.netcracker.sd4.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_role", schema = "netcracker")
public class UserRole {
    private int id;
    private User userByFkUser;
    private Role roleByFkRole;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        return id == userRole.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id", nullable = false)
    public User getUserByFkUser() {
        return userByFkUser;
    }

    public void setUserByFkUser(User userByFkUser) {
        this.userByFkUser = userByFkUser;
    }

    @ManyToOne
    @JoinColumn(name = "fk_role", referencedColumnName = "id", nullable = false)
    public Role getRoleByFkRole() {
        return roleByFkRole;
    }

    public void setRoleByFkRole(Role roleByFkRole) {
        this.roleByFkRole = roleByFkRole;
    }
}
