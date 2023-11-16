package ru.vk.itmo.abramovilya.table;

import ru.vk.itmo.abramovilya.DaoImpl;

import java.lang.foreign.MemorySegment;

public interface TableEntry extends Comparable<TableEntry> {
    MemorySegment value();

    MemorySegment key();

    int number();

    Table table();

    @Override
    default int compareTo(TableEntry other) {
        int compare = DaoImpl.compareMemorySegments(this.key(), other.key());
        if (compare != 0) {
            return compare;
        }
        return other.number() - this.number();
    }
}
