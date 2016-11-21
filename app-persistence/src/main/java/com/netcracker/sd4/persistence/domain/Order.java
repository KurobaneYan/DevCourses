package com.netcracker.sd4.persistence.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`order`")
public class Order {
    private int id;
    private int cast;
    private Date date;
    private List<CarInOrder> carsInOrder;
    private User user;

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
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
        result = 31 * result + date.hashCode();
        return result;
    }

    @OneToMany(mappedBy = "order")
    public List<CarInOrder> getCarsInOrder() {
        return carsInOrder;
    }

    public void setCarsInOrder(List<CarInOrder> carsInOrder) {
        this.carsInOrder = carsInOrder;
    }

    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", cast=" + cast +
                ", date=" + date +
                ", carsInOrder=" + carsInOrder +
                ", user=" + user +
                '}';
    }
}
