package naruto.rajdeep.com.narutoepisodetracker;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView numberField;
    Button updateBtn,rectifyBtn,setBtn,aboutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberField=findViewById(R.id.number_field);
        updateBtn=findViewById(R.id.update_btn);
        rectifyBtn=findViewById(R.id.rectify_btn);
        aboutBtn=findViewById(R.id.about_btn);
        fetchData();
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(fetchData()+1);
            }
        });
        rectifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(fetchData()-1);
            }
        });

    }
    private int fetchData() {
        int temp=-1;
        String fileName = "record.txt";

        try {
            FileInputStream file = openFileInput(fileName);
            temp = file.read();
            numberField.setText(Integer.toString(temp));
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            FileOutputStream file = null;
            try {
                String zero = "0";
                file = openFileOutput(fileName, Context.MODE_PRIVATE);
                file.write(Integer.parseInt(zero));
                file.close();
                fetchData();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        return temp;
    }
        private void update(int value){
        String fileName="record.txt";
        FileOutputStream file= null;
        try {

            file = openFileOutput(fileName, Context.MODE_PRIVATE);
            file.write(value);
            file.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

}
