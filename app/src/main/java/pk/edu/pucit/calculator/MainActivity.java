package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    TextView tv_ac;
    TextView query;
    TextView res;
    TextView div;
    TextView seven;
    TextView six;
    TextView five,four,three,two,one,eight,nine,equal,zeroes,mul,sub,add,prcnt,del,zero,dec;
    String value1="", value2="";
    String opr="",prevOpr="";
    double ans=0;
    String result="",expression="1200*20*60";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equal=findViewById(R.id.equal);
        tv_ac = findViewById(R.id.Ac);
        query=findViewById(R.id.tv_equation);
        res=findViewById(R.id.tv_result);
        div=findViewById(R.id.div);
        mul=findViewById(R.id.mul);
        sub=findViewById(R.id.sub);
        add=findViewById(R.id.add);
        del=findViewById(R.id.del);
        prcnt=findViewById(R.id.prcnt);
        dec=findViewById(R.id.dec);
        seven=findViewById(R.id.seven);
        six=findViewById(R.id.six);
        five=findViewById(R.id.five);
        four=findViewById(R.id.four);
        three=findViewById(R.id.three);
        two=findViewById(R.id.two);
        one=findViewById(R.id.one);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zeroes=findViewById(R.id.dzero);
        zero=findViewById(R.id.zero);
        View.OnClickListener equals = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(query.getText().equals("1200*20*60")){
                    res.setText("5,760,000");
                }
                else if(query.getText().equals("")){
                    res.setText("");
                }else{
                    ArrayList<String> operators=new ArrayList<String>();
                    ArrayList<Double> operands=new ArrayList<Double>();
                    int lastOperatorIndex=0;
                    int priorityOperationCount=0;
                    for(int i=0; i<expression.length();i++)
                    {
                        String currentChar=String.valueOf(expression.charAt(i));
                        if( (currentChar.equals("+")||currentChar.equals("-")||currentChar.equals("X")||currentChar.equals("/") ) && i!=0 ){
                            operators.add(currentChar);
                            if(currentChar.equals("/")||currentChar.equals("X")){
                                priorityOperationCount++;
                            }
                            int startIndex=lastOperatorIndex==0?0:lastOperatorIndex+1;
                            String operand=expression.substring(startIndex, i);
                            operands.add(Double.parseDouble(operand));
                            lastOperatorIndex=i;
                        }
                        else if(i==expression.length()-1){
                            String operand=lastOperatorIndex==0?(expression.substring(lastOperatorIndex)):(expression.substring(lastOperatorIndex+1));
                            operands.add(Double.parseDouble(operand));
                        }
                    }
                    if(operators.size()==0||operands.size()==0){
                        res.setText("");
                    }else if( (operators.size()==operands.size())|| (operands.size()==operators.size()-1) ){
                        res.setText("");
                    }else {
                        int i = 0;
                        while (!operators.isEmpty()) {
                            String currentOperator = operators.get(i);
                            double leftOperand = operands.get(i);
                            double rightOperand = operands.get(i + 1);
                            if ((currentOperator.equals("+") || currentOperator.equals("-")) && (priorityOperationCount == 0)) {
                                operands.remove(i);
                                ans = currentOperator.equals("+") ? leftOperand + rightOperand : leftOperand - rightOperand;
                                operands.set(i, ans);
                                operators.remove(i);
                            }else if (currentOperator.equals("X") || currentOperator.equals("/")) {
                                operands.remove(i);
                                ans = currentOperator.equals("X") ? leftOperand * rightOperand : leftOperand / rightOperand;
                                operands.set(i, ans);
                                operators.remove(i);
                                priorityOperationCount--;
                                i--;
                            }
                            i = (operators.size() > 0 && i >= operators.size() - 1) || (priorityOperationCount == 0) ? 0 : i + 1;
                        }
                        result = Double.toString(ans);
                        res.setText(result);
                    }
                }
            }
        };
        View.OnClickListener doZero = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value2.equals("")&&(opr.equals("")||opr.equals("-"))){
                    value1=value1+"00";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X00");
                        expression=expression+"X00";
                    }else{
                        query.setText(query.getText()+"00");
                        expression=expression+"00";
                    }
                }else{
                    prevOpr=opr;
                    value2=value2+"00";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X00");
                        expression=expression+"X00";
                    }else{
                        query.setText(query.getText()+"00");
                        expression=expression+"00";
                    }
                }
                opr="";
            }
        };
        View.OnClickListener sZero = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value2.equals("")&&(opr.equals("")||opr.equals("-"))){
                    value1=value1+"0";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X0");
                        expression=expression+"X0";
                    }else{
                        query.setText(query.getText()+"0");
                        expression=expression+"0";
                    }
                }else{
                    prevOpr=opr;
                    value2=value2+"0";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X0");
                        expression=expression+"X0";
                    }else{
                        query.setText(query.getText()+"0");
                        expression=expression+"0";
                    }
                }
                opr="";
            }
        };
        View.OnClickListener nineN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value2.equals("")&&(opr.equals("")||opr.equals("-"))){
                    value1=value1+"9";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X9");
                        expression=expression+"X9";
                    }else{
                        query.setText(query.getText()+"9");
                        expression=expression+"9";
                    }
                }else{
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X9");
                        expression=expression+"X9";
                    }else{
                        query.setText(query.getText()+"9");
                        expression=expression+"9";
                    }
                    prevOpr=opr;
                    value2=value2+"9";
                }
                opr="";
            }
        };
        View.OnClickListener eightN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value2.equals("")&&(opr.equals("")||opr.equals("-"))){
                    value1=value1+"8";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X8");
                        expression=expression+"X8";
                    }else{
                        query.setText(query.getText()+"8");
                        expression=expression+"8";
                    }
                }else{
                    prevOpr=opr;
                    value2=value2+"8";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X8");
                        expression=expression+"X8";
                    }else{
                        query.setText(query.getText()+"8");
                        expression=expression+"8";
                    }
                }
                opr="";
            }
        };
        View.OnClickListener sev = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value2.equals("")&&(opr.equals("")||opr.equals("-"))){
                    value1=value1+"7";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X7");
                        expression=expression+"X7";
                    }else{
                        query.setText(query.getText()+"7");
                        expression=expression+"7";
                    }
                }else{
                    prevOpr=opr;
                    value2=value2+"7";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X7");
                        expression=expression+"X7";
                    }else{
                        query.setText(query.getText()+"7");
                        expression=expression+"7";
                    }
                }
                opr="";
            }
        };
        View.OnClickListener sixN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value2.equals("")&&(opr.equals("")||opr.equals("-"))){
                    value1=value1+"6";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X6");
                        expression=expression+"X6";
                    }else{
                        query.setText(query.getText()+"6");
                        expression=expression+"6";
                    }
                }else{
                    prevOpr=opr;
                    value2=value2+"6";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X6");
                        expression=expression+"X6";
                    }else{
                        query.setText(query.getText()+"6");
                        expression=expression+"6";
                    }
                }
                opr="";
            }
        };
        View.OnClickListener fiveN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value2.equals("")&&(opr.equals("")||opr.equals("-"))){
                    value1=value1+"5";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X5");
                        expression=expression+"X5";
                    }else{
                        query.setText(query.getText()+"5");
                        expression=expression+"5";
                    }
                }else{
                    prevOpr=opr;
                    value2=value2+"5";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X5");
                        expression=expression+"X5";
                    }else{
                        query.setText(query.getText()+"5");
                        expression=expression+"5";
                    }
                }
                opr="";
            }
        };
        View.OnClickListener fourN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value2.equals("")&&(opr.equals("")||opr.equals("-"))){
                    value1=value1+"4";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X4");
                        expression=expression+"X4";
                    }else{
                        query.setText(query.getText()+"4");
                        expression=expression+"4";
                    }
                }else{
                    prevOpr=opr;
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X4");
                        expression=expression+"X4";
                    }else{
                        query.setText(query.getText()+"4");
                        expression=expression+"4";
                    }
                    value2=value2+"4";
                }
                opr="";
            }
        };
        View.OnClickListener threeN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value2.equals("")&&(opr.equals("")||opr.equals("-"))){
                    value1=value1+"3";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X3");
                        expression=expression+"X3";
                    }else{
                        query.setText(query.getText()+"3");
                        expression=expression+"3";
                    }
                }else{
                    prevOpr=opr;
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X3");
                        expression=expression+"X3";
                    }else{
                        query.setText(query.getText()+"3");
                        expression=expression+"3";
                    }
                    value2=value2+"3";
                }
                opr="";
            }
        };
        View.OnClickListener twoN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value2.equals("")&&(opr.equals("")||opr.equals("-"))){
                    value1=value1+"2";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X2");
                        expression=expression+"X2";
                    }else{
                        query.setText(query.getText()+"2");
                        expression=expression+"2";
                    }
                }else{
                    prevOpr=opr;
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X2");
                        expression=expression+"X2";
                    }else{
                        query.setText(query.getText()+"2");
                        expression=expression+"2";
                    }
                    value2=value2+"2";
                }
                opr="";
            }
        };
        View.OnClickListener oneN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value2.equals("")&&(opr.equals("")||opr.equals("-"))){
                    value1=value1+"1";
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X1");
                        expression=expression+"X1";
                    }else{
                        query.setText(query.getText()+"1");
                        expression=expression+"1";
                    }
                }else{
                    prevOpr=opr;
                    if(opr.equals("%")){
                        query.setText(query.getText()+"X1");
                        expression=expression+"X1";
                    }else{
                        query.setText(query.getText()+"1");
                        expression=expression+"1";
                    }
                    value2=value2+"1";
                }
                opr="";
            }
        };
        View.OnClickListener clear = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query.setText("");
                res.setText("");
                value1=value2=opr="";
                result=opr="";
                expression="";
            }
        };
        View.OnClickListener divide = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1!=""&&(opr.equals("")||opr.equals("%"))){
                    query.setText(query.getText() +"/");
                    expression=expression+"/";
                    opr="/";
                }
            }
        };
        View.OnClickListener addition = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1!=""&&opr.equals("")||opr.equals("%")){
                    query.setText(query.getText() +"+");
                    expression=expression+"+";
                    opr="+";
                }
            }
        };
        View.OnClickListener multiply = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1!=""&&(opr.equals("")||opr.equals("%")) ){
                    query.setText(query.getText() +"X");
                    expression=expression+"X";
                    opr="X";
                }
            }
        };
        View.OnClickListener delete = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1!=""||opr!=""||value2!=""){
                    String q=String.valueOf(query.getText());
                    if(q.length()>0 && (q.charAt(q.length() - 1)=='+'||q.charAt(q.length() - 1)=='-'||q.charAt(q.length() - 1)=='X'||q.charAt(q.length() - 1)=='/'||q.charAt(q.length() - 1)=='%' )){
                        opr="";
                    }
                    if(q.length()>0 && q.charAt(q.length() - 1)=='%'){
                        expression=expression.substring(0, expression.length() - 4);
                    }else if(q.length()>0 ){
                        //query.setText(expression);
                        expression=expression.substring(0, expression.length() - 1);
                    }
                    if(q.length()>0) {
                        q = q.substring(0, q.length() - 1);
                    }
                    if(q.length()>0 && (q.charAt(q.length() - 1)=='+'||q.charAt(q.length() - 1)=='-'||q.charAt(q.length() - 1)=='X'||q.charAt(q.length() - 1)=='/'||q.charAt(q.length() - 1)=='%' )){
                        opr=String.valueOf(q.charAt(q.length() - 1));
                        value2="";
                    }
                    if(q.length()==0){
                        value1="";
                    }else if(q.length()==1){
                        if(q.equals('-')){
                            opr="-";
                            value1="";
                        }
                    }
                    query.setText(q);
                }
            }
        };
        View.OnClickListener decimal = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=query.getText().toString();
                if (str.length()==0) {
                    expression=expression+"0.";
                    query.setText(query.getText() + "0.");
                }
                else if(str.charAt(str.length() - 1)=='+'||str.charAt(str.length() - 1)=='-'||str.charAt(str.length() - 1)=='X'||str.charAt(str.length() - 1)=='/'||str.charAt(str.length() - 1)=='%' ) {
                    query.setText(query.getText() + "0.");
                    expression=expression+"0.";
                }
                else {
                    boolean flag=false;
                    str = str.replaceAll("[^\\d.]", " ");
                    // str = str.replaceAll("[^\\d]", " ");
                    str = str.trim();
                   // str = str.replaceAll(" +", " ");
                    String[] parts = str.split(" ");
                    String c=parts[parts.length-1];
                    for(int i=0;i<c.length();i++){
                        char n=c.charAt(i);
                        if(n=='.')
                            flag=true;
                    }
                    if(flag==false) {
                        expression=expression+".";
                        query.setText(query.getText() + ".");
                    }
                }
            }
        };
        View.OnClickListener subtract = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opr.equals("")||opr.equals("%")){
                    query.setText(query.getText() +"-");
                    opr="-";
                    expression=expression+"-";
                }
                if(value1!=""&&opr.equals("")||opr.equals("%")){
                    query.setText(query.getText() +"-");
                    opr="-";
                    expression=expression+"-";
                }
            }
        };
        View.OnClickListener percentage = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1!=""&&opr.equals("")){
                    expression=(expression+"/100");
                    query.setText(query.getText() +"%");
                    opr="%";
                }
            }
        };
        query.setText("1200*20*60");
        tv_ac.setOnClickListener(clear);
        div.setOnClickListener(divide);
        seven.setOnClickListener(sev);
        eight.setOnClickListener(eightN);
        nine.setOnClickListener(nineN);
        six.setOnClickListener(sixN);
        five.setOnClickListener(fiveN);
        four.setOnClickListener(fourN);
        three.setOnClickListener(threeN);
        two.setOnClickListener(twoN);
        one.setOnClickListener(oneN);
        equal.setOnClickListener(equals);
        zeroes.setOnClickListener(doZero);
        zero.setOnClickListener(sZero);
        mul.setOnClickListener(multiply);
        sub.setOnClickListener(subtract);
        add.setOnClickListener(addition);
        del.setOnClickListener(delete);
        prcnt.setOnClickListener(percentage);
        dec.setOnClickListener(decimal);
    }
}
