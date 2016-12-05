package example.com.fibonacciquicksort.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class StudentApplicationClass extends Application implements Utility
{
    static SharedPreferences sharedPreferencesListOfStudent;
    private static StudentApplicationClass sInstance;


    private static Context context;
    static Gson gson ;

    @Override
    public void onCreate()
    {
        super.onCreate();
        StudentApplicationClass.context = getApplicationContext();
        sharedPreferencesListOfStudent = context.getSharedPreferences(SharedPreferenceListStudent, Context.MODE_PRIVATE);
        gson = new Gson();


    }


    public static StudentApplicationClass geTinstance()
    {
        if(sInstance == null)
            sInstance = new StudentApplicationClass();

        return sInstance;
    }



    public static Context getContext()
    {
        return context;
    }


    //Store in shared preference as a list
    public void StoreStudenObjList(StudentRecord studentRecord)
    {

        List<StudentRecord>  listAlredyAvailabe =new ArrayList<>();
        if(getListStudents()!=null &&getListStudents().size()!=0)
          listAlredyAvailabe.addAll(getListStudents());


        listAlredyAvailabe.add(studentRecord);

        sharedPreferencesListOfStudent.edit().clear().commit();

        if(listAlredyAvailabe.size()>1)
            listAlredyAvailabe = quickSortInDescendingOrder(listAlredyAvailabe,0,listAlredyAvailabe.size()-1);

        String jsonStudents = gson.toJson(listAlredyAvailabe);
        sharedPreferencesListOfStudent.edit().putString(ListStudents,jsonStudents).commit();
    }



    //Get list of student Objects
    public List<StudentRecord> getListStudents()
    {

            String listOfObjects = sharedPreferencesListOfStudent.getString(ListStudents, "");
            Type type = new TypeToken<List<StudentRecord>>(){}.getType();

             List<StudentRecord> studentList = gson.fromJson(listOfObjects, type);
             if(studentList!=null &&studentList.size()>1)
                 studentList = quickSortInDescendingOrder(studentList,0,studentList.size()-1);
             return studentList;

    }





    // sort in descending order
    //This method sorts the input array in descending order using quick sort
//    public static void quickSortInDescendingOrder (int[] numbers, int low, int high)
    public List<StudentRecord> quickSortInDescendingOrder (List<StudentRecord> studentList, int low, int high)
    {

        int i=low;
        int j=high;
        int temp;
        int middle=studentList.get((low+high)/2).getTotal();

        while (i<j)
        {
            while (studentList.get(i).getTotal()>middle)
            {
                i++;
            }
            while (studentList.get(j).getTotal()<middle)
            {
                j--;
            }
            if (j>=i)
            {

                Collections.swap(studentList,  i,  j);
                i++;
                j--;
            }
        }


        if (low<j)
        {
            quickSortInDescendingOrder(studentList, low, j);
        }
        if (i<high)
        {
            quickSortInDescendingOrder(studentList, i, high);
        }


        return studentList;


    }






}
