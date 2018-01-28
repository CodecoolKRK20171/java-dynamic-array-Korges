package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {

    int size = 5;
    int[] dynamicArray;
    int index;


    public DynamicIntArray() {

        dynamicArray = new int[size];
    }


    public DynamicIntArray(int size) {

        this.size = size;
        dynamicArray = new int[size];
    }


    public void add(int element) {

        if(ifFreeSpace()) {
            increaseArraySize();
        }
        dynamicArray[index++] = element;
    }


    public boolean ifFreeSpace() {
        return index == size;
    }


    public void increaseArraySize() {

        this.size = size + 1;
        int[] temp = new int[size];

        for(int i=0;i<dynamicArray.length;i++) {
            temp[i]=dynamicArray[i];
        }
        this.dynamicArray = temp;
    }


    public void insert(int position, int element) {

        if(position>=size) {
            add(element);
        } else {
            this.size = size + 1;
            this.index = 0;
            int[] temp = new int[size];
            for(int value: this.dynamicArray) {
                if(index == position) {
                    temp[index++] = element;
                }
                temp[index++] = value;
            }
            this.dynamicArray = temp;
        }
    }


    public void remove(int element) {

        int[] temp = new int[--size];
        int i = 0;
        for(int value : dynamicArray) {
            if(value!= element) {
                temp[i++] = value;
            }
        }
        this.dynamicArray = temp;
    }


    @Override
    public String toString() {


        StringBuilder builder = new StringBuilder();
        for (int value : this.dynamicArray) {
            builder.append(" " + value);
        }
        return builder.toString();
    }
}
