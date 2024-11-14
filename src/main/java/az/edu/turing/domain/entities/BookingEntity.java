package az.edu.turing.domain.entities;

import java.util.List;
import java.util.Objects;

public class BookingEntity {

    private Long id;
    private FlightEntity flightId;
    private List<PassengerEntity> passengers;
    private boolean isCancelled;

    public BookingEntity(Long id, FlightEntity flightId, List<PassengerEntity> passengers, boolean isCancelled) {
        this.id = id;
        this.flightId = flightId;
        this.passengers = passengers;
        this.isCancelled = isCancelled;
    }

    public BookingEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getFlightId() {
        return flightId != null ? flightId.getId() : null;
    }

    public void setFlightId(FlightEntity flightId) {
        this.flightId = flightId;
    }

    public List<PassengerEntity> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerEntity> passengers) {
        this.passengers = passengers;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity that = (BookingEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(flightId, that.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightId);
    }

    @Override
    public String toString() {
        return String.format("BookingEntity{id=%d, flightId=%d, passengers=%s, isCancelled=%s}",
                id, flightId, passengers, isCancelled);
    }


}
