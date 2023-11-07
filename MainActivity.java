package space.poliantr.Venture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vers1.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btnBall, btnCoin, btnTip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       TextView tvGreeting = findViewById(R.id.tvGreeting);
        btnBall=findViewById(R.id.btnBall);
        btnCoin=findViewById(R.id.btnCoin);
        btnTip=findViewById(R.id.btnTip);

        btnBall.setOnClickListener(this);
        btnCoin.setOnClickListener(this);
        btnTip.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
    switch (view.getId()){
        case R.id.btnBall:
            Intent intentBall=new Intent(this, ActivityBall.class);
            startActivity(intentBall);
            break;
        case R.id.btnCoin:
            Intent intentCoin=new Intent(this, ActivityCoin.class);
            startActivity(intentCoin);
            break;
        case R.id.btnTip:
            Intent intentTip=new Intent(this, ActivityTip.class);
            startActivity(intentTip);
            break;
        default:
            break;
    }
    }
}