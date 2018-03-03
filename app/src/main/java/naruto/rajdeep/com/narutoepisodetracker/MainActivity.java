package naruto.rajdeep.com.narutoepisodetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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

    }

}
