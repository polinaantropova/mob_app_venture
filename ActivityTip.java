package space.poliantr.Venture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vers1.R;

public class ActivityTip extends AppCompatActivity implements View.OnClickListener{
    Button btnTip;
    TextView tvTip, tvHeadTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        tvTip = findViewById(R.id.tvTip);
        tvHeadTip = findViewById(R.id.tvHeadTip);
        btnTip=findViewById(R.id.btnTip);


        btnTip.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnTip:
                tvHeadTip.setText("");
                switch ((int)(Math.random()*11)+1){
                    case 1:
                        tvTip.setText(R.string.tip1);
                        break;
                    case 2:
                        tvTip.setText(R.string.tip2);
                        break;
                    case 3:
                        tvTip.setText(R.string.tip3);
                        break;
                    case 4:
                        tvTip.setText(R.string.tip4);
                        break;
                    case 5:
                        tvTip.setText(R.string.tip5);
                        break;
                    case 6:
                        tvTip.setText(R.string.tip6);
                        break;
                    case 7:
                        tvTip.setText(R.string.tip7);
                        break;
                    case 8:
                        tvTip.setText(R.string.tip8);
                        break;
                    case 9:
                        tvTip.setText(R.string.tip9);
                        break;
                    case 10:
                        tvTip.setText(R.string.tip10);
                        break;
                    default:
                        break;
                }

                break;
            default:
                break;
        }
    }
}