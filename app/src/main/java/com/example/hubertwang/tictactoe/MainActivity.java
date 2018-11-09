package com.example.hubertwang.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int turn = 0;
    Button grid[][] = new Button[3][3];
    Button resetButton;
    TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        statusTextView = (TextView) findViewById(R.id.textViewName);
        resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(this);

        grid[0][0] = (Button) findViewById(R.id.grid00);
        grid[0][1] = (Button) findViewById(R.id.grid01);
        grid[0][2] = (Button) findViewById(R.id.grid02);

        grid[1][0] = (Button) findViewById(R.id.grid10);
        grid[1][1] = (Button) findViewById(R.id.grid11);
        grid[1][2] = (Button) findViewById(R.id.grid12);

        grid[2][0] = (Button) findViewById(R.id.grid20);
        grid[2][1] = (Button) findViewById(R.id.grid21);
        grid[2][2] = (Button) findViewById(R.id.grid22);

        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                grid[i][j].setOnClickListener(this);
            }
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.resetButton){
            clearGrid();
            statusTextView.setText("Hubert Wang");

        } else {
            for (int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    if (view.getId() == grid[i][j].getId()){
                        grid[i][j].setText(alterText());
                        grid[i][j].setClickable(false);
                        break;
                    }
                }
            }

            if (checkWin()){
                if (turn%2==1){
                    statusTextView.setText("Player one wins!");
                } else {
                    statusTextView.setText("Player two wins!");
                }
                for (int i=0;i<3;i++){
                    for (int j=0;j<3;j++){
                        grid[i][j].setClickable(false);
                    }
                }

            } else if (turn == 9){
                statusTextView.setText("Draw!");
            } else {
                statusTextView.setText("In Game...");
            }
        }
    }

    private void clearGrid(){
        turn = 0;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                grid[i][j].setText("");
                grid[i][j].setClickable(true);
            }
        }
    }

    private String alterText(){
        turn+=1;
        if (turn%2==1){
            return "X";
        } else {
            return "O";
        }
    }

    private boolean checkWin(){
        for (int i=0;i<3;i++){
            if (grid[i][0].getText().toString() == grid[i][1].getText().toString() && grid[i][0].getText().toString() == grid[i][2].getText().toString() && grid[i][0].getText().toString().length() != 0 && grid[i][1].getText().toString().length() != 0 && grid[i][2].getText().toString().length() != 0){
                return true;
            } else if (grid[0][i].getText().toString() == grid[1][i].getText().toString() && grid[0][i].getText().toString() == grid[2][i].getText().toString() && grid[0][i].getText().toString().length() != 0 && grid[1][i].getText().toString().length() != 0 && grid[2][i].getText().toString().length() != 0){
                return true;
            }
        }
        if (grid[0][0].getText().toString() == grid[1][1].getText().toString() && grid[0][0].getText().toString() == grid[2][2].getText().toString() && grid[0][0].getText().toString().length() != 0 && grid[1][1].getText().toString().length() != 0 && grid[2][2].getText().toString().length() != 0){
            return true;
        } else if (grid[0][2].getText().toString() == grid[1][1].getText().toString() && grid[0][2].getText().toString() == grid[2][0].getText().toString() && grid[0][2].getText().toString().length() != 0 && grid[1][1].getText().toString().length() != 0 && grid[2][0].getText().toString().length() != 0){
            return true;
        }

        return false;
    }
}
