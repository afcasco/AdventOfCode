package com.adventofcode.y2022.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CrateContainer {

    private final List<Crate> crateContainer;

    public CrateContainer() {
        this.crateContainer = new ArrayList<>();
        IntStream.range(0, 9).forEach(i -> crateContainer.add(new Crate()));
    }

    public void fillCrates(List<String> data) {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j < 8; j++) {
                String value = String.valueOf(data.get(j).charAt(i));
                if (!value.trim().isEmpty()) {
                    crateContainer.get(i).addElement(value);
                }
            }
        }
    }

    public Crate getCrate(int num){
        return  crateContainer.get(num-1);
    }

    public List<Crate> getAllCrates(){
        return crateContainer;
    }

    public void moveElements(Move move) {
        List<String> temp = crateContainer.get(move.getOrigin()).removeElements(move.getQuantity());
        crateContainer.get(move.getDestination()).addElements(temp);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        crateContainer.forEach(i -> builder.append(i.toString()).append("\n"));
        return builder.toString();
    }
}