package AnimalBase.Cat;

import AnimalBase.Cats;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddCat extends Cats implements Serializable {
    private static final long serialVersionUID = 1L;

    public AddCat(String name, String home) {
        super(name, home);

        readAtHome(name,home);
    }

    private void readAtHome(String home, String name) {
        ArrayList<String> catsList = new ArrayList<>();

        final String homeWay = "src/resources/" + home;
        File file = new File(homeWay);
        
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String cat = scanner.next();
                catsList.add(cat);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        if(file.exists()){
            try(FileWriter fw = new FileWriter(homeWay)){
                catsList.add(name);
                for(int i = 0; i < catsList.size(); i++){
                    fw.write(catsList.get(i)+" ");
                }
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            System.out.println("Новый кот успешно добавлен в питомник");
        }
        else System.out.println("Такого питомника не существует");
    }
}
