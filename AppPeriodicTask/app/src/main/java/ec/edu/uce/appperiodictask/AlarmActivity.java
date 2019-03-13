package ec.edu.uce.appperiodictask;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AlarmActivity extends AppCompatActivity implements View.OnClickListener {

    private PendingIntent mAlarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        // Adjuntar el listener a ambos botones
        findViewById(R.id.start).setOnClickListener(this);
        findViewById(R.id.stop).setOnClickListener(this);
        // Crear el remitente de lanzamiento
        Intent launchIntent = new Intent(this, AlarmService.class);
        mAlarmIntent = PendingIntent.getService(this,0,launchIntent,0);
    }

    @Override
    public void onClick(View v) {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        long interval = 5*1000; //5 segundos

        switch(v.getId()){
            case R.id.start:
                Toast.makeText(this,"Scheduled", Toast.LENGTH_SHORT).show();
                manager.setRepeating(AlarmManager.ELAPSED_REALTIME,
                        SystemClock.elapsedRealtime()+interval,interval,mAlarmIntent);
                break;
            case R.id.stop:
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
                manager.cancel(mAlarmIntent);
                break;
            default:
                break;

        }

    }
}
