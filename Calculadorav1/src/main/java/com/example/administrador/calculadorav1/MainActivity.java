package com.example.administrador.calculadorav1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private Button[] botones=new Button[15];
    private TextView display;
    public float res,tmp;
    public String ari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<15;i++){
            int bid = this.getResources().getIdentifier("button"+i, "layout", this.getPackageName());
            botones[i]=(Button)findViewById(bid);
        }

        display=(TextView)findViewById(R.id.textView);
    }

    public void suma(View view){
        res=Float.parseFloat(display.getText().toString());
        tmp=1;
        ari="suma";
    }

    public void resta(View view){
        res=Float.parseFloat(display.getText().toString());
        tmp=1;
        ari="resta";
    }
    public void multi(View view){
        res=Float.parseFloat(display.getText().toString());
        tmp=1;
        ari="multi";
    }

    public void divi(View view){
        res=Float.parseFloat(display.getText().toString());
        tmp=1;
        ari="divi";
    }

    public void resultado(View view){
        Float resul = null;
        if(ari!=null) {
            switch (ari) {
                case "suma":
                    resul = res + Float.parseFloat(display.getText().toString());
                    break;
                case "resta":
                    resul = res - Float.parseFloat(display.getText().toString());
                    break;
                case "multi":
                    resul = res * Float.parseFloat(display.getText().toString());
                    break;
                case "divi":
                    if (res != 0 && Float.parseFloat(display.getText().toString()) != 0) {
                        resul = res / Float.parseFloat(display.getText().toString());
                    } else {
                        resul = Float.parseFloat("-1");
                        Toast.makeText(this, "Division entre Cero", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
            display.setText(resul.toString());
            tmp = 1;
        }else{
            Toast.makeText(this,"Ingresa mas valores",Toast.LENGTH_SHORT).show();
        }
    }

    public void limpia(View view){
        res=0;
        display.setText("0.");
        tmp=0;
    }

    public void butonpresionado(View view){
        String ans,tmp2;
        Button b=(Button)view;
        ans=display.getText().toString();
        //Toast.makeText(this,ans,Toast.LENGTH_SHORT).show();
        if(display.getText().toString().equals("0.") || tmp==1){
            display.setText(b.getText().toString());
            tmp=0;
        }else{
            display.setText(ans+b.getText().toString());
        }
    }
}
