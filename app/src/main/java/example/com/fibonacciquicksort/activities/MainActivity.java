package example.com.fibonacciquicksort.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import example.com.fibonacciquicksort.R;
import example.com.fibonacciquicksort.adapter.StudentsAdapter;
import example.com.fibonacciquicksort.util.StudentApplicationClass;
import example.com.fibonacciquicksort.util.StudentRecord;
import example.com.fibonacciquicksort.util.Utility;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Utility
{


    StringBuilder sb,
                  sbUNOCOIN;
    List<String> listOfStrings;
    LayoutInflater layoutInflater;
    LinearLayout linearLayoutParent,
                 linearLayoutUNOCOIN ;
    List<String> listUNOCOIN,
                 listUNOCOINvalues ;
    Button buttonSubmit;
    EditText enterNumbrEdittext;
    int count;
    String FibonacciString;
    LinearLayout LinearLayParentFiboonaci;
    StudentsAdapter studentsAdapter;
    Toolbar toolbar ;




    // Views related to Quicksort

    LinearLayout LinearLayParentQuicksort;
    EditText editTextName,
             editTextEnglish,
             editTextMath,
             editTextScience;

    Button buttonSumitStudent;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerViewStudents;
    List<StudentRecord> listStudentRecord;
    LinearLayout linearLayoutTableStudent;



    // Buttons of Toolbar
    Button buttonQuicksortToolbar,
            buttonFibonacciToolbar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Getting the the id of the two buttons
        buttonFibonacciToolbar =(Button)findViewById(R.id.id_buttonFibonacci);
        buttonQuicksortToolbar =(Button)findViewById(R.id.id_buttonQuicksort);
        buttonFibonacciToolbar.setOnClickListener(this);
        buttonQuicksortToolbar.setOnClickListener(this);



        // Holding view for Fibonacci and Quicksort
        LinearLayParentFiboonaci = (LinearLayout)findViewById(R.id.id_LineLay_ParentFibonnaci);
        LinearLayParentQuicksort = (LinearLayout)findViewById(R.id.id_LinearLay_Quicksort);

        //Layout holding table of marks Student
        linearLayoutTableStudent = (LinearLayout)findViewById(R.id.id_Linrlay_tableRecord);


        // Codes related to Fibonacci moved to this method
        relatedToFibonacci();



        //Initialising view related to Quicksort
        editTextName  =(EditText)findViewById(R.id.id_EdittextStudentName);
        editTextEnglish  =(EditText)findViewById(R.id.id_editext_English);
        editTextMath  =(EditText)findViewById(R.id.id_editext_math);
        editTextScience  =(EditText)findViewById(R.id.id_editext_Science);
        buttonSumitStudent  =(Button) findViewById(R.id.id_buttonSubmitStudent);
        buttonSumitStudent.setOnClickListener(this);
        recyclerViewStudents = (RecyclerView)findViewById(R.id.id_RecyclerviewStudent);


        // Specifying input type as NUMBER only word for name
        editTextEnglish.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
        editTextMath.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
        editTextScience.setInputType(EditorInfo.TYPE_CLASS_NUMBER);



        //Initialising the adapter and assigning the list of students obj from SharedPreferences
        listStudentRecord =new ArrayList<>();
        listStudentRecord = StudentApplicationClass.geTinstance().getListStudents();
                //Set visibility  GONE if size of student record is zero
                if(listStudentRecord==null )
                    linearLayoutTableStudent.setVisibility(View.GONE);
        studentsAdapter  = new StudentsAdapter(listStudentRecord);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewStudents.setLayoutManager(linearLayoutManager);
        recyclerViewStudents.setAdapter(studentsAdapter);


        //Set selected Quicksort
        setVisibilityQuicksort();

    }


    // initialization of the view related to  Fibonacci
    public void relatedToFibonacci()
    {

        // Getting id of the two Linear layouts to inflate toolbar
        linearLayoutParent =(LinearLayout)findViewById(R.id.id_LinLay);
        linearLayoutUNOCOIN =(LinearLayout)findViewById(R.id.id_LinLayUN0COIN);

        //Getting id of SubmitButton and Edittext for input
        buttonSubmit = (Button)findViewById(R.id.id_buttonSubmit);
        enterNumbrEdittext =(EditText)findViewById(R.id.id_EdittextNumber);
        enterNumbrEdittext.setInputType(EditorInfo.TYPE_CLASS_NUMBER);

        // setting click listener
        buttonSubmit.setOnClickListener(this);

        layoutInflater = LayoutInflater.from(this);


        listUNOCOIN = Arrays.asList("U","N","O","C","O","I","N");



    }



    // View to inflate Linear Layout Dynamically
    public void InflateStationName()
    {
        linearLayoutParent.removeAllViews();
        for (int i = 0; i < listOfStrings.size(); i++)
        {
            View view = layoutInflater.inflate(R.layout.inflating_layout, linearLayoutParent, false);
            ((TextView) view.findViewById(R.id.id_TextView_value)).setText(listOfStrings.get(i));
            linearLayoutParent.addView(view);

        }
    }

    // View to inflate Linear Layout for UNOCOIN Dynamically
    public void InflateFibonacciUNOCOIN()
    {

        linearLayoutUNOCOIN.removeAllViews();
        for (int i = 0; i < listUNOCOINvalues.size(); i++)
        {
            View view = layoutInflater.inflate(R.layout.inflating_layout, linearLayoutUNOCOIN, false);
            ((TextView) view.findViewById(R.id.id_TextView_value)).setText(listUNOCOINvalues.get(i));
            linearLayoutUNOCOIN.addView(view);

        }
    }




    //Method to get list of strings for fibonacci
    public List<String> Fibonacci(String number)
    {
        int n, c, k, space=1;


        n = Integer.parseInt(number)/2+1;

        space = n-1;

        int p=0;

        for(k=1; k<=n; k++)
        {
            sb = new StringBuilder();
            sbUNOCOIN = new StringBuilder();

            for(c=1; c<=space; c++)
            {
                sb.append(" ");
                sbUNOCOIN.append(" ");
            }
            space--;
            int y =0;
            for(c=1; c<=(2*k-1); c++)
            {
                sb.append(FibonacciString.substring(p,p+1));
                p++;

                if(c<=listUNOCOIN.size())
                sbUNOCOIN.append(listUNOCOIN.get(c-1));
                else
                {
                    sbUNOCOIN.append(listUNOCOIN.get(y));
                    y++;
                }

            }

            // adding string to List of Strings
            listOfStrings.add(sb.toString());
            listUNOCOINvalues.add(sbUNOCOIN.toString());

        }

        space = 1;

        for(k=1; k<=(n-1); k++)
        {
            sb = new StringBuilder();
            sbUNOCOIN = new StringBuilder();
            for(c=1; c<=space; c++)
            {
                sb.append(" ");
                sbUNOCOIN.append(" ");
            }
            space++;
            int y =0;
            for(c=1; c<=(2*(n-k)-1); c++)
            {

                sb.append(FibonacciString.substring(p,p+1));
                p++;

                if(c<=listUNOCOIN.size())
                    sbUNOCOIN.append(listUNOCOIN.get(c-1));
                else
                {
                    sbUNOCOIN.append(listUNOCOIN.get(y));
                    y++;
                }
            }

            // adding string to List of Strings
            listOfStrings.add(sb.toString());
            listUNOCOINvalues.add(sbUNOCOIN.toString());
        }
        return listOfStrings;
    }


    // Method to detect click
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.id_buttonSubmit:
                //Calling the method to check input
                CheckInputButton();
                break;

            case R.id.id_buttonSubmitStudent:
                StudentInput();
                break;


            case R.id.id_buttonFibonacci:
                setVisibilityFibonacci();
                break;


            case R.id.id_buttonQuicksort:
                setVisibilityQuicksort();
                break;


            default:
                break;

        }

    }


    //Method to detect user input
    public void CheckInputButton()
    {
       String number= enterNumbrEdittext.getText().toString();
       count = Integer.parseInt(number)*2;

        // getting fibonacci string
        FibonacciString = getFibonacciString();

        //Insantiating arraylists
        listOfStrings = new ArrayList<>();
        listUNOCOINvalues = new ArrayList<>();


       if(number != "" && !number.equals("0"))
       {
           //Getting the value of Fibonacci as list to inflate in textview dynamically
           listOfStrings = Fibonacci(number);
           InflateStationName();
           InflateFibonacciUNOCOIN();

       }
        else
       Toast.makeText(this,"Wrong Input",Toast.LENGTH_SHORT).show();

    }




    // method returning a string of all fibonnaci
    public String getFibonacciString()
    {
        int n1=1,n2=2,n3,i;

        StringBuilder sb = new StringBuilder();
        sb.append(n1+""+n1+"+"+n2);

        for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed
        {
            n3=n1+n2;
            sb.append(n3);

            if(sb.length()== 9)
                sb.append("");
            else
                sb.append("+");
            n1=n2;
            n2=n3;
        }

        return sb.toString();
    }




    // Codes related to QuickSort starts  from here

    // Method to handle Student details
    public void StudentInput()
    {

        if(!editTextEnglish.getText().toString().equals("")&&
                  !editTextMath.getText().toString().equals("")&&
                  !editTextScience.getText().toString().equals("")&&
                   !editTextName.getText().toString().equals(""))
        {

            StudentRecord stdr = new StudentRecord();
            Map<String, Integer> mp = new HashMap<>();
            mp.put(ENGLISH,Integer.parseInt(editTextEnglish.getText().toString()));
            mp.put(MATH,Integer.parseInt(editTextMath.getText().toString()));
            mp.put(SCIENCE,Integer.parseInt(editTextScience.getText().toString()));
            stdr.setName(editTextName.getText().toString());
            stdr.setRank(1);
            stdr.setMapSubMark(mp);
            // Adding all scores
            Integer total = Integer.parseInt(editTextEnglish.getText().toString())+
                    Integer.parseInt(editTextMath.getText().toString()) +
                    Integer.parseInt(editTextScience.getText().toString());


            stdr.setTotal(total);

            // Store student object in SharedPreferences
            StudentApplicationClass.geTinstance().StoreStudenObjList(stdr);


            // Clear input Edittexyts of previous record
            editTextName.setText("");
            editTextEnglish.setText("");
            editTextMath.setText("");
            editTextScience.setText("");


            listStudentRecord = StudentApplicationClass.geTinstance().getListStudents();
            //Set visibility  VISIBLE if size of student record is not greater than zero
            if(listStudentRecord!=null && listStudentRecord.size()>0)
                linearLayoutTableStudent.setVisibility(View.VISIBLE);
            studentsAdapter.setData(listStudentRecord);
            studentsAdapter.notifyDataSetChanged();

        }
        else
        {
            Toast.makeText(this,"Provide Input",Toast.LENGTH_SHORT).show();
        }


    }



    // method to set Visibility of Fibonacci
    public void setVisibilityFibonacci()
    {
           buttonFibonacciToolbar.setBackgroundColor(getResources().getColor(R.color.colorWhiteOpacity70));
           buttonQuicksortToolbar.setBackgroundColor(getResources().getColor(R.color.colorWhiteOpacity30));
           LinearLayParentFiboonaci.setVisibility(View.VISIBLE);
           LinearLayParentQuicksort.setVisibility(View.GONE);
    }


    // method to set Visibility of Fibonacci
    public void setVisibilityQuicksort()
    {
        buttonFibonacciToolbar.setBackgroundColor(getResources().getColor(R.color.colorWhiteOpacity30));
        buttonQuicksortToolbar.setBackgroundColor(getResources().getColor(R.color.colorWhiteOpacity70));
        LinearLayParentFiboonaci.setVisibility(View.GONE);
        LinearLayParentQuicksort.setVisibility(View.VISIBLE);
    }
}
