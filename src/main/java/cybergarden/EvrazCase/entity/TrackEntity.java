package cybergarden.EvrazCase.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "track_track")
public class TrackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long id;

    @JoinColumn(name = "number")
    private Long number;

    @JoinColumn(name = "is_free")
    private Boolean isFree;

    @JoinColumn(name = "max_wagon_count")
    private Long maxWagonCount;

    @JoinColumn(name = "station_id")
    private Long stationId;

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

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    public Long getMaxWagonCount() {
        return maxWagonCount;
    }

    public void setMaxWagonCount(Long maxWagonCount) {
        this.maxWagonCount = maxWagonCount;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }
}
