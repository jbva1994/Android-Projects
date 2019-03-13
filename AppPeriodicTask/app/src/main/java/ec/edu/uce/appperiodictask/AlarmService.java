package ec.edu.uce.appperiodictask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlarmService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        // Realiza una operación interesante, solo mostraremos la hora actual
        Calendar now = Calendar.getInstance();
        DateFormat formmatter = SimpleDateFormat.getTimeInstance();
        Toast.makeText(this, formmatter.format(now.getTime()),Toast.LENGTH_SHORT).show();
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind (Intent intent){
        return null;
    }
}
