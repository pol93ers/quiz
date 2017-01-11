package mdpa.lasalle.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    private TextView totalQuestionsText, correctQuestionsText, incorrectQuestionsText;
    private Button tryAgainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        totalQuestionsText = (TextView) findViewById(R.id.totalNumQuestionsText);
        correctQuestionsText = (TextView) findViewById(R.id.correctQuestionsText);
        incorrectQuestionsText = (TextView) findViewById(R.id.incorrectQuestionsText);
        tryAgainButton = (Button) findViewById(R.id.tryAgainButton);

        totalQuestionsText.setText(String.valueOf(getIntent().getIntExtra("numberQuestions",0)));
        correctQuestionsText.setText(String.valueOf(getIntent().getIntExtra("correctQuestions",0)));
        incorrectQuestionsText.setText(String.valueOf(getIntent().getIntExtra("incorrectQuestions",0)));

        setListeners();

    }

    private void setListeners(){

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }
}
