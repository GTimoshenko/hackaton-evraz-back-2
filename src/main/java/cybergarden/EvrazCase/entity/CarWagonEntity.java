package cybergarden.EvrazCase.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "wagons_carwagons")
public class CarWagonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long id;

    @JoinColumn(name = "position")
    private Long position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car")
    private CarEntity car;

    @JoinColumn(name = "wagon_id")
    private Long wagonId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public Long getWagonId() {
        return wagonId;
    }

    public void setWagonId(Long wagonId) {
        this.wagonId = wagonId;
    }
}
