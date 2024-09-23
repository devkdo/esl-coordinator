package io.dvkdo.eslcoord;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class ParticleEntity extends PanacheEntity{
    public String name;

    @Override
    public String toString() {
        return "ParticleEntity [name=" + name + "]";
    }
}
