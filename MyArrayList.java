package HW9;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList {

    private Object massiv[];

    // add(Object value) додає елемент у кінець
    public boolean add(Object value) {
        boolean rez = false;
        Object[] old_massiv;

        if (massiv == null) {
            massiv = new Object[1];
            massiv[0] = value;
            rez = true;
        } else {
            old_massiv = massiv;
            massiv = new Object[old_massiv.length + 1];

            for(int i=0; i< old_massiv.length; i++) {
                massiv[i] = old_massiv[i];
            }

            massiv[massiv.length - 1] = value;
            rez = true;
        }
        return rez;
    }
    // remove(int index) видаляє елемент під індексом
    public Object remove(int index) {
        Object[] new_massiv = new Object[massiv.length - 1];
        Object deleted = null;
        int kol_del = 0;
        for(int i=0; i< massiv.length-1; i++) {
            if(i==index) {
                deleted = massiv[i];
                kol_del++;
            }
            new_massiv[i] = massiv[i+kol_del];
        }
        massiv = new_massiv;
        return (deleted);
    }
    // clear() очищує колекцію
    public void clear() {
        for(int i=0; i<size(); i++) {
            massiv[i] = null;
        }
//        massiv = null;
    }
    // size() повертає розмір колекції
    public int size() {
        return (massiv.length);
    }
    //get(int index) повертає елемент під індексом
    public Object get(int index) {
        return (massiv[index]);
    }

    @Override
    public String toString() {
        return "MyArrayList{ " +
                "massiv = " + Arrays.toString(massiv) +
                " }";
    }
}







