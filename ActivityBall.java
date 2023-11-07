package space.poliantr.Venture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.TextView;

import com.example.vers1.R;

public class ActivityBall extends AppCompatActivity implements SensorEventListener {

    private SensorManager senSensorManager;
    private Sensor senAccelerometer;

    private TextView tvAnswer;
    Animation anim;

    private long lastUpdate = 0;
    private float last_x, last_y, last_z;
    private static final int SHAKE_THRESHOLD = 600;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball);

        tvAnswer = findViewById(R.id.tvAnswer);

        senSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senSensorManager.registerListener(this, senAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
    }
    protected void onPause() {
        super.onPause();
        senSensorManager.unregisterListener(this);
    }

    protected void onResume() {
        super.onResume();
        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void executeShakeAction() {
        //this method is called when devices shakes
        switch ((int)(Math.random()*4)) {
            case 0:
                tvAnswer.setText("yes!");
                anim=AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
                tvAnswer=(TextView) findViewById(R.id.tvAnswer);
                tvAnswer.startAnimation(anim);
                break;
            case 1:
                tvAnswer.setText("no!");
                anim=AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
                tvAnswer=(TextView) findViewById(R.id.tvAnswer);
                tvAnswer.startAnimation(anim);
                break;
            case 2:
                tvAnswer.setText("try again");
                anim=AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
                tvAnswer=(TextView) findViewById(R.id.tvAnswer);
                tvAnswer.startAnimation(anim);
                break;
            case 3:
                tvAnswer.setText("maybe...");
                anim=AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
                tvAnswer=(TextView) findViewById(R.id.tvAnswer);
                tvAnswer.startAnimation(anim);
                break;
            default:
                break;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor mySensor = event.sensor;

        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            long curTime = System.currentTimeMillis();

            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;

                float speed = Math.abs(x + y + z - last_x - last_y - last_z)/ diffTime * 3000;

                if (speed > SHAKE_THRESHOLD) {
                    executeShakeAction();
                }

                last_x = x;
                last_y = y;
                last_z = z;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    }