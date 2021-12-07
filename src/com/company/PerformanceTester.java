package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PerformanceTester {
    private int countOfMethodCalls;
    private int [][] CollectionsRunningTime;

    public PerformanceTester(int countOfMethodCalls){
        this.countOfMethodCalls = countOfMethodCalls;
        CollectionsRunningTime = new int[2][3];
        GeneralTester();

    }

    private void GeneralTester(){
        int [][] arrayIndices = new int[3][];
        arrayIndices[0] = createArrayIndicesForAdd();
        arrayIndices[1] = createArrayIndicesForGet();
        arrayIndices[2] = createArrayIndicesForDelete();

        ListTester(0, new ArrayList<Integer>(), arrayIndices);
        ListTester(1, new LinkedList<Integer>(),arrayIndices);
    }

    private void ListTester(int indexOfContainer, List<Integer> list, int[][] array ) {
        long startAdd = System.currentTimeMillis();
        for (int i = 0; i < countOfMethodCalls; ++i) {
            list.add(i, array[0][i]);
        }
        CollectionsRunningTime[indexOfContainer][0] =  (int)(System.currentTimeMillis() - startAdd);

        long startGet = System.currentTimeMillis();
        for (int i = 0; i < countOfMethodCalls; ++i) {
            list.get(array[1][i]);
        }
        CollectionsRunningTime[indexOfContainer][1] = (int)(System.currentTimeMillis() - startGet);

        long startDelete = System.currentTimeMillis();
        for (int i = 0; i < countOfMethodCalls; ++i) {
            list.remove(array[2][i]);
        }
        CollectionsRunningTime[indexOfContainer][2] =  (int)(System.currentTimeMillis() - startDelete);
    }
    public int getCountOfMethodCalls(){
        return countOfMethodCalls;
    }

    private int[] createArrayIndicesForAdd(){
        int[] arrayIndicesForAdd = new int[countOfMethodCalls];
        for (int i = 0; i < countOfMethodCalls; ++i){
            arrayIndicesForAdd[i] = (int)(Math.random() * i);
        }
        return arrayIndicesForAdd;
    }

    private int[] createArrayIndicesForGet(){
        int[] arrayIndicesForGet = new int[countOfMethodCalls];
        for (int i = 0; i < countOfMethodCalls; ++i){
            arrayIndicesForGet[i] = (int)(Math.random() * countOfMethodCalls);
        }
        return  arrayIndicesForGet;
    }


    private int[] createArrayIndicesForDelete(){
        int[] arrayIndicesForDelete = new int[countOfMethodCalls];
        for (int i = 0; i < countOfMethodCalls; ++i){
            arrayIndicesForDelete[i] = (int)(Math.random()*(countOfMethodCalls - i -1));
        }
        return arrayIndicesForDelete;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        PerformanceTester that = (PerformanceTester) obj;
        return that.toString().equals(this.toString()) &&
                that.countOfMethodCalls == this.countOfMethodCalls;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                hash += CollectionsRunningTime[i][j];
            }
        }
        return hash;
    }

    @Override
    public String toString() {
        //String resultTable = "";
        return "Array List:  " +
                        "add: " + String.valueOf(CollectionsRunningTime[0][0])  + " " +
                        "get: " + String.valueOf(CollectionsRunningTime[0][1])  + " " +
                        "delete:" + String.valueOf(CollectionsRunningTime[0][2])  + "\n" +
                        "Linked List:  " +
                        "add: " + String.valueOf(CollectionsRunningTime[1][0])  + " " +
                        "get: " + String.valueOf(CollectionsRunningTime[1][1])  + " " +
                        "delete: " + String.valueOf(CollectionsRunningTime[1][2]);
    }

}
