package com.example.stringcalc;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity{

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnComma;
    Button btnAdd, btnSub, btnDiv, btnMult, btnModul, btnEquals;
    Button btnDel, btnBack;
    EditText resultTxtV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        btn0 = (Button) findViewById( R.id.btn0 );
        btn1 = (Button) findViewById( R.id.btn1 );
        btn2 = (Button) findViewById( R.id.btn2 );
        btn3 = (Button) findViewById( R.id.btn3 );
        btn4 = (Button) findViewById( R.id.btn4 );
        btn5 = (Button) findViewById( R.id.btn5 );
        btn6 = (Button) findViewById( R.id.btn6 );
        btn7 = (Button) findViewById( R.id.btn7 );
        btn8 = (Button) findViewById( R.id.btn8 );
        btn9 = (Button) findViewById( R.id.btn9 );
        btnComma = (Button)findViewById( R.id.btnComma );
        //Arithmetics
        btnAdd = (Button) findViewById( R.id.btnAdd );
        btnSub = (Button) findViewById( R.id.btnSub );
        btnDiv = (Button) findViewById( R.id.btnDiv );
        btnMult = (Button) findViewById( R.id.btnMult );
        btnModul = (Button) findViewById( R.id.btnModul );
        btnEquals = (Button) findViewById(R.id.btnEquals);

        btnDel = (Button) findViewById( R.id.btnDelete );
        btnBack = (Button) findViewById( R.id.btnDele1 );

        //ResultView
        resultTxtV = (EditText) findViewById( R.id.resultTxtV );


        btnDel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText( "" );
            }
        } );

        btnBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String backspace = null;
                if(resultTxtV.getText().length() >0) {
                    StringBuilder strB = new StringBuilder(resultTxtV.getText());
                    strB.deleteCharAt(resultTxtV.getText().length() -1);
                    backspace = strB.toString();
                    resultTxtV.setText(backspace);
                }
            }
        } );




        //CickListners for the numbers
        btn0.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText( resultTxtV.getText()+ "0");

            }
        });

        btn1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText(resultTxtV.getText()+ "1" );

            }
        });
        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText( resultTxtV.getText()+ "2" );

            }
        });
        btn3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText(resultTxtV.getText()+ "3" );

            }
        });
        btn4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText(resultTxtV.getText()+ "4" );

            }
        });
        btn5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText( resultTxtV.getText()+ "5" );

            }
        });
        btn6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText( resultTxtV.getText()+ "6" );

            }
        });
        btn7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText(resultTxtV.getText()+ "7" );

            }
        });
        btn8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText( resultTxtV.getText()+ "8" );

            }
        });
        btn9.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText(resultTxtV.getText()+ "9" );

            }
        });
        btnComma.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText(  resultTxtV.getText()+ "." );

            }
        });

        //Listners for the arithmetics
        btnAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText(  resultTxtV.getText()+ "+" );

            }
        });
        btnSub.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText(  resultTxtV.getText()+ "-" );

            }
        });
        btnDiv.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText(  resultTxtV.getText()+ "/" );

            }
        });
        btnMult.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText(  resultTxtV.getText()+ "*" );

            }
        });
        btnModul.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxtV.setText(  resultTxtV.getText()+ "%" );

            }
        });
        //Listners for calc the results
        btnEquals.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                try {
                    if(resultTxtV != null) {
                    /*
                    String equation = txtFResult.getText();
                    double result = Calculate(equation);
                     */

                    String equation = resultTxtV.getText().toString();
                    double result = Calc( equation );

                    resultTxtV.setText( equation + " = " +result );
                    }
                    else {
                        resultTxtV.setText( "Can't handle the equation" );
                    }


                } catch (ArithmeticException e){
                    e.getCause();
                }
            }
        } );
    }



    //Method to go to Linkedin
    public void linkedin(View view){
        Intent linkedinIntent = new Intent( Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/in/sanogharzani") );
        startActivity( linkedinIntent );
    }
    public void info(View view){
        //setContentView(R.layout.infoactivity );
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Info");
        alertDialog.setMessage("This is a school project, created by Sano Gharzani with big help of youtube and StackOverflow. Simple String calculator wich allows you to type in the full equation, with basic arithmetics,,, Enjoy");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public double Calc(String equation) {
        try{
            if(equation.contains("+")) {
                return processAdd(equation);
            }
            if(equation.contains("-")) {
                return processSubtract(equation);
            }
            if(equation.contains("*")) {
                return processMuliply(equation);
            }
            if(equation.contains("%")) {
                return processModulus(equation);
            }
            if(equation.contains("/")) {
                return processDivide(equation);
            }

            if(equation.matches("[0-9]+")) {
                return Double.parseDouble(equation);
            }
            if(equation.matches("[0-9].+")) {
                return Double.parseDouble(equation);
            }

            return Double.NaN;
        } catch (Exception e) {
            resultTxtV.setText( "Can't handle the equation" );
        }
       return Double.NaN;
    }

    private double processDivide(String equation) throws  ArithmeticException {
        String[] components = equation.split("/");

        double result = Double.parseDouble(components[0]);

        for (int i= 1; i<components.length; i++) {

            result /= Double.parseDouble(components[i]);
        }

        return result;
    }

    private double processSubtract(String equation) {
        String[] components = equation.split("-");

        return Calc(components[0])- Calc(components[1]);
    }

    private double processMuliply(String equation) {
        String[] components = equation.split("\\*");
        double result = 1.0;
        for(String component : components) {
            result *= Calc(component);
        }
        return result;
    }

    private double processModulus(String equation) {
        String[] components = equation.split("\\%");
        return Calc(components[0]) % Calc(components[1]);
    }

    private double processAdd(String equation) {
        String[] components = equation.split("\\+");
        double result = 0.0;
        for(String component : components) {
            result += Calc(component);
        }
        return result;
    }

}
