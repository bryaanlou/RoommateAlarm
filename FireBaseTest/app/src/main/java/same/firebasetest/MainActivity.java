package same.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.database.*;
import android.widget.Button;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button stop = (Button)findViewById(R.id.mButtonStop);
        Button start = (Button)findViewById(R.id.mButtonStart);

        DatabaseReference mRoofRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mConditionRef = mRoofRef.child("condition");
        mConditionRef.setValue("Startup");
        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                System.out.println(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mConditionRef.setValue("STOP");
            }
        });
        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mConditionRef.setValue("START");
            }
        });
    }



}
