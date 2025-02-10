package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkintechList<T extends Comparable<T>> extends ArrayList<T> {

    @Override
    public boolean add(T element) {
        if (!this.contains(element)) { // Tekrar eden elemanları engelle
            return super.add(element);
        }
        return false;
    }

    public void sort() {
        Collections.sort(this); // Listeyi sıralar
    }

    @Override
    public boolean remove(Object element) {
        boolean removed = super.remove(element);
        if (removed) {
            sort(); // Silme sonrası sıralama yap
        }
        return removed;
    }
}
