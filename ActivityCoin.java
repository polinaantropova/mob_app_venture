package space.poliantr.Venture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.vers1.R;

public class ActivityCoin extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnFlip;
    TextView tvRes;
    Animation anim_coin;
    Animation anim_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);

        tvRes = findViewById(R.id.tvRes);
        btnFlip=findViewById(R.id.btnFlip);

        btnFlip.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnFlip:
                if ((int)(Math.random()*2)==0) {
                    tvRes.setText("eagle");
                    btnFlip.setImageResource(R.drawable.coin_eagle);
                    anim_tv=AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
                    tvRes=(TextView) findViewById(R.id.tvRes);
                    tvRes.startAnimation(anim_tv);
                    anim_coin=AnimationUtils.loadAnimation(this, R.anim.shake);
                    btnFlip=(ImageButton) findViewById(R.id.btnFlip);
                    btnFlip.startAnimation(anim_coin);
                } else {
                    tvRes.setText("tail");
                    btnFlip.setImageResource(R.drawable.coin_tail);
                    anim_tv=AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
                    tvRes=(TextView) findViewById(R.id.tvRes);
                    tvRes.startAnimation(anim_tv);
                    anim_coin=AnimationUtils.loadAnimation(this, R.anim.shake);
                    btnFlip=(ImageButton) findViewById(R.id.btnFlip);
                    btnFlip.startAnimation(anim_coin);
                }
                break;
            default:
                break;
        }
    }
}