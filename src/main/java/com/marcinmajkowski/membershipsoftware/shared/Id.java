package com.marcinmajkowski.membershipsoftware.shared;

import java.util.Objects;
import java.util.UUID;

public final class Id {

    private final UUID uuid;

    public Id(UUID uuid) {
        Objects.requireNonNull(uuid);
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return uuid.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Id id = (Id) o;

        return uuid.equals(id.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
