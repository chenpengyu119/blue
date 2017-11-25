package com.topnews;



import android.app.Activity;
import android.app.FragmentManager;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;





public class MyNewIndexActivity extends Activity {
    private FrameLayout f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_new_index);
        f1 = (FrameLayout) findViewById(R.id.fragment_question1);

        Fragment fragment=new QuestionFragment();

        FragmentManager frgManager = getFragmentManager();
       // frgManager.beginTransaction().replace(R.id.fragment_question1, fragment).commit();
        frgManager.beginTransaction().show(fragment);




    }
}
