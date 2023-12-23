package cybergarden.EvrazCase.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "wagon_wagon")
public class WagonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long id;

    @JoinColumn(name = "number")
    private Long number;

    @JoinColumn(name = "car_id")
    private Long carId;

    @JoinColumn(name = "cargo_id")
    private Long cargoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }
}
