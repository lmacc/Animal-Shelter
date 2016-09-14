package model;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by leslie on 08/05/2016.
 */
public class MaintenanceList {
    private ArrayList<String>  types = new ArrayList<>();



    public MaintenanceList(){}

    public void addType(String type){
        types.add(type);
    }

    public ArrayList<String> getMaintenanceList() {
        return types;
    }

    public void removeType(Maintenance type){
        types.remove(type);
    }

    public String get(int p){
        return types.get(p);
    }

    public int size(){
        return types.size();
    }

    public void writetoFile(File file) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(String.valueOf(file), true));

            for (String str : types) {
                bw.write(str + "\n");
            }
            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearList(){
        types.clear();
    }

    public void print() {

        for (int i = 0; i < types.size(); i++) {
            System.out.println(types.get(i));

        }
    }


}
