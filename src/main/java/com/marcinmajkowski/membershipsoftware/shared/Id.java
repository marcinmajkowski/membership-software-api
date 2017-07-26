package com.marcinmajkowski.membershipsoftware.shared;

import java.util.UUID;

public final class Id {

    private final UUID uuid;

    public Id() {
        this.uuid = UUID.randomUUID();
    }

    public static Id fromString(String s) {
        return new Id(UUID.fromString(s));
    }

    private Id(UUID uuid) {
        this.uuid = uuid;
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
