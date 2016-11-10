package com.netcracker.sd4.persistence.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "`order`")
public class Order {
    private int id;
    private int cast;
    private int date;
    private Set<CarInOrder> carInOrdersById;
    private User userByFkUser;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cast")
    public int getCast() {
        return cast;
    }

    public void setCast(int cast) {
        this.cast = cast;
    }

    @Basic
    @Column(name = "date")
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (cast != order.cast) return false;
        if (date != order.date) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cast;
        result = 31 * result + date;
        return result;
    }

    @OneToMany(mappedBy = "orderByFkOrder")
    public Set<CarInOrder> getCarInOrdersById() {
        return carInOrdersById;
    }

    public void setCarInOrdersById(Set<CarInOrder> carInOrdersById) {
        this.carInOrdersById = carInOrdersById;
    }

    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id", nullable = false)
    public User getUserByFkUser() {
        return userByFkUser;
    }

    public void setUserByFkUser(User userByFkUser) {
        this.userByFkUser = userByFkUser;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", cast=" + cast +
                ", date=" + date +
                ", carInOrdersById=" + carInOrdersById +
                ", userByFkUser=" + userByFkUser +
                '}';
    }
}
