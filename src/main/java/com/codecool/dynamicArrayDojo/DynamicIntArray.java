package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {
    private int[] data;

    public DynamicIntArray() {
        this.data = new int[0];
    }

    public DynamicIntArray(int elementsNr) {
        this.data = new int[elementsNr];
    }

    public void add(int element) {
        int arrayLength = this.data.length;
        this.data = Arrays.copyOf(this.data, arrayLength + 1);
        this.data[arrayLength] = element;
    }

    private void validate(int index) {
        if (index < 0 || index >= this.data.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void remove(int index) {
        validate(index);

        int[] newData = new int[this.data.length - 1];
        int pointerToOldData = 0;

        for (int i = 0; i < newData.length; i++) {

            if (i == index) {
                pointerToOldData++;
            }

            newData[i] = this.data[pointerToOldData++];
        }

        this.data = newData;
    }

    public void insert(int index, int value) {

        if (index >= this.data.length) {
            this.add(value);
        } else {
            int[] newData = new int[this.data.length + 1];
            int pointerToOldData = 0;

            for (int i = 0; i < newData.length; i++) {

                if (i == index) {
                    newData[i] = value;
                } else {
                    newData[i] = this.data[pointerToOldData++];
                }
            }

            this.data = newData;
        }

    }

    @Override
    public String toString() {
        String arrayAsString = "";

        for (int element : this.data) {
            arrayAsString = arrayAsString + " " + element;
        }

        return arrayAsString;
    }

}
