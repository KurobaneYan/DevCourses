package com.netcracker.sd4.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "car_in_order", schema = "netcracker")
public class CarInOrder {
    private int id;
    private int amount;
    private Car carByFkCar;
    private Order orderByFkOrder;

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
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarInOrder that = (CarInOrder) o;

        if (id != that.id) return false;
        if (amount != that.amount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + amount;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fk_car", referencedColumnName = "id", nullable = false)
    public Car getCarByFkCar() {
        return carByFkCar;
    }

    public void setCarByFkCar(Car carByFkCar) {
        this.carByFkCar = carByFkCar;
    }

    @ManyToOne
    @JoinColumn(name = "fk_order", referencedColumnName = "id", nullable = false)
    public Order getOrderByFkOrder() {
        return orderByFkOrder;
    }

    public void setOrderByFkOrder(Order orderByFkOrder) {
        this.orderByFkOrder = orderByFkOrder;
    }
}
