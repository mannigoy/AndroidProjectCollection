package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import android.view.View;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

public class Calculator extends AppCompatActivity implements View.OnClickListener {
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    Button btn_minus, btn_times, btn_add, btn_divide, btn_close,btn_open,btn_AC,btn_dot,btn_erase,btn_equals;
    TextView resultTv, solutionTv;
   boolean decimalAdded = false;
  String dataToCalculate;
   CalculatorHandler calculate= new CalculatorHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculator);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        resultTv = findViewById(R.id.res);
        solutionTv = findViewById(R.id.resultTv);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);


        btn_AC=findViewById(R.id.btn_ac);
        btn_minus = findViewById(R.id.btn_minus);
        btn_times = findViewById(R.id.btn_times);
        btn_add = findViewById(R.id.btn_plus);
        btn_divide = findViewById(R.id.btn_div);

        btn_dot = findViewById(R.id.btn_dot);
        btn_erase =findViewById(R.id.erase);
        btn_equals=findViewById(R.id.equals);
        setClickListeners();
    }

    private void setClickListeners() {
        //  btn_.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener( this);
        btn_5.setOnClickListener( this);
        btn_6.setOnClickListener( this);
        btn_7.setOnClickListener( this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener( this);


        btn_AC.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_times.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_divide.setOnClickListener(this);

        btn_dot.setOnClickListener(this);
        btn_erase.setOnClickListener(this);
        btn_equals.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String data = solutionTv.getText().toString();



        switch (buttonText) {
            case "AC":
                try {
                    data = data.substring(0, data.length() - 1);
                } catch (Exception e) {
                    e.printStackTrace();
                    resultTv.setText("");
                } finally {
                    solutionTv.setText(data);
                }
                break;

            case "=":
                try {
                    if (endsWith(data)) {
                        resultTv.setText("Syntax Error");
                    } else {
                        data = calculateData(data);
                        resultTv.setText(data);
                        solutionTv.setText(" ");
                    }
                } catch(Exception e) {
                    resultTv.setText((CharSequence) e);
                }
                break;


            case "C":
                solutionTv.setText("");
                resultTv.setText("");

                //   solutionTv.setText(dataToCalculate);

                break;
            case ".":
                String last_num = "";
                for(int i = data.length()-1; i>=0; i--){
                    if(isOperator(data.charAt(i))){
                        break;
                    }
                    last_num += data.charAt(i);
                }
                if(last_num.equals("")){
                    data += "0";
                    data += buttonText;
                } else if(last_num.contains(".")){
                    if(last_num.charAt(0) == '.'){
                        data = data.substring(0,data.length() - 1);
                    }
                } else {
                    data += buttonText;
                }
                solutionTv.setText(data);
                break;


            default:
                if (!data.isEmpty() && isOperator(data.charAt(data.length() - 1)) && isOperator(buttonText)) {
                    data = data.substring(0, data.length() - 1);
                }
                String tempo = data;
                data += buttonText;
                solutionTv.setText(data);
                if(isOperator(buttonText)){
                    resultTv.setText(sequentialCalculate(tempo));
                }
                break;

        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '×' || c == '÷' || c == '^';
    }
    private boolean endsWith(String expression) {
        char lastChar = expression.charAt(expression.length() - 1);
        return lastChar == '+' || lastChar == '-' || lastChar == '×' || lastChar == '÷' || lastChar == '^';

    }
    private boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("×")||s.equals("÷") || s.equals("^");
    }
    private String calculateData(String data) {
        ArrayList<String> finalData = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    finalData.add(temp.toString());
                    temp.setLength(0);
                }
                finalData.add(String.valueOf(c));
            }
        }
        if (temp.length() > 0) {
            finalData.add(temp.toString());
        }
        Stack<String> stackOp = new Stack<>();
        stackOp.push(finalData.get(0));

        for (int i = 1; i < finalData.size(); i++) {
            if (finalData.get(i).equals("+") || finalData.get(i).equals("-")) {
                stackOp.push(finalData.get(i));
            } else if (finalData.get(i).equals("×")) {
                double prevNum = Double.parseDouble(stackOp.pop());
                double nextNum = Double.parseDouble(finalData.get(++i));
                stackOp.push(String.valueOf(prevNum * nextNum));
            } else if (finalData.get(i).equals("÷")) {
                double prevNum = Double.parseDouble(stackOp.pop());
                double nextNum = Double.parseDouble(finalData.get(++i));
                stackOp.push(String.valueOf(prevNum / nextNum));
            } else if(finalData.get(i).equals("^")) {
                double prevNum = Double.parseDouble(stackOp.pop());
                double nextNum = Double.parseDouble(finalData.get(++i));
                stackOp.push(String.valueOf(Math.pow(prevNum, nextNum)));
            } else {
                stackOp.push(finalData.get(i));
            }
        }
        double result = Double.parseDouble(stackOp.get(0));

        for(int i = 1; i < stackOp.size(); i += 2) {
            if (stackOp.get(i).equals("+")) {
                result += Double.parseDouble(stackOp.get(i + 1));
            } else {
                result -= Double.parseDouble(stackOp.get(i + 1));
            }
        }
        return String.valueOf(result);
    }
    private String sequentialCalculate(String data){

        ArrayList<String> finalData = new ArrayList<>();

        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    finalData.add(temp.toString());
                    temp.setLength(0);
                }
                finalData.add(String.valueOf(c));
            }
        }
        if (temp.length() > 0) {
            finalData.add(temp.toString());
        }

        Stack<String> stackOp = new Stack<>();
        int start = 0;

        if(isOperator(finalData.get(0))){
            stackOp.push("0");
        } else {
            stackOp.push(finalData.get(0));
            start = 1;
        }

        for (int i = start; i < finalData.size(); i++) {
            if ( isOperator(finalData.get(i))) {
                if(finalData.get(i).equals("+")){
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum + nextNum));
                } else if (finalData.get(i).equals("-")){
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum - nextNum));
                } else if (finalData.get(i).equals("×")) {
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum * nextNum));
                } else if (finalData.get(i).equals("÷")) {
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum / nextNum));
                } else if (finalData.get(i).equals("^")) {
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(Math.pow(prevNum, nextNum)));
                }
            } else {
                stackOp.push(finalData.get(i));
            }
        }
        return stackOp.pop();

    }

}