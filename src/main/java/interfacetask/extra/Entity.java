package interfacetask.extra;
import java.util.Objects;

public abstract class Entity {
    private double mass;
    private String entityType;

    public Entity() {
    }

    public Entity(double mass, String entityType) {
        this.mass = mass;
        this.entityType = entityType;
    }

    // getters & setters
    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Double.compare(entity.mass, mass) == 0 && Objects.equals(entityType, entity.entityType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mass, entityType);
    }

    @Override
    public String toString() {
        return "entityType: " + entityType + "\nmass: " + mass;
    }
}
