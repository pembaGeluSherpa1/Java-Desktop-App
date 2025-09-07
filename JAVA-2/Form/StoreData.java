package Form;

import java.util.ArrayList;

public class StoreData {
    private static ArrayList<FormData> formDatas = new ArrayList<>();

    public static void addData(FormData data){
        formDatas.add(data);

        System.out.println("Displayed data: "+data);
    }

    public static ArrayList<FormData> getAllData() {
        return formDatas;
    }

}
