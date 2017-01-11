package mdpa.lasalle.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {

    private TextView numberQuestionsText, questionText;
    private RadioButton answer1RadioButton, answer2RadioButton, answer3RadioButton, answer4RadioButton;
    private Button submitButton;
    private RadioGroup answersRadioGroup;

    private int numberQuestion = 1, totalQuestions, correctQuestions, incorrectQuestions;
    private String strNumberQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        totalQuestions = Integer.parseInt(getString(R.string.number_questions));

        numberQuestionsText = (TextView) findViewById(R.id.numberQuestionsText);
        strNumberQuestions = getString(R.string.question) + " " + numberQuestion + "/" + getString(R.string.number_questions);
        numberQuestionsText.setText(strNumberQuestions);
        questionText = (TextView) findViewById(R.id.questionTextView);
        answersRadioGroup = (RadioGroup) findViewById(R.id.answersRadioGroup);
        answer1RadioButton = (RadioButton) findViewById(R.id.answer1RadioButton);
        answer2RadioButton = (RadioButton) findViewById(R.id.answer2RadioButton);
        answer3RadioButton = (RadioButton) findViewById(R.id.answer3RadioButton);
        answer4RadioButton = (RadioButton) findViewById(R.id.answer4RadioButton);
        submitButton = (Button) findViewById(R.id.submitButton);

        setListeners();
    }

    private void setListeners(){
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer1RadioButton.isChecked() || answer2RadioButton.isChecked() || answer3RadioButton.isChecked() || answer4RadioButton.isChecked()) {
                    switch (numberQuestion){
                        case 1:
                            if (answer4RadioButton.isChecked()) {
                                correctQuestions++;
                            }else{
                                incorrectQuestions++;
                            }
                            numberQuestion++;
                            strNumberQuestions = getString(R.string.question) + " " + numberQuestion + "/" + getString(R.string.number_questions);
                            numberQuestionsText.setText(strNumberQuestions);
                            questionText.setText(R.string.question2);
                            answer1RadioButton.setText(R.string.answer21);
                            answer2RadioButton.setText(R.string.answer22);
                            answer3RadioButton.setText(R.string.answer23);
                            answer4RadioButton.setText(R.string.answer24);
                            answer1RadioButton.setChecked(false);
                            answer2RadioButton.setChecked(false);
                            answer3RadioButton.setChecked(false);
                            answer4RadioButton.setChecked(false);
                            break;
                        case 2:
                            if (answer1RadioButton.isChecked()) {
                                correctQuestions++;
                            }else{
                                incorrectQuestions++;
                            }
                            Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                            intent.putExtra("correctQuestions",correctQuestions);
                            intent.putExtra("incorrectQuestions",incorrectQuestions);
                            intent.putExtra("numberQuestions",totalQuestions);
                            startActivity(intent);
                            finish();
                            break;
                    }
                }else{
                    Toast.makeText(getApplicationContext(),R.string.no_radio_buttons,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
