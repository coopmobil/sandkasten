package org.coopmobil.sandbox;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import org.coopmobil.sandbox.acceleration.AccelActivity;
import org.coopmobil.sandbox.compass.CompassActivity;
import org.coopmobil.sandbox.utils.Sensor;
import org.coopmobil.sandbox.utils.SensorAdapter;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    ArrayList<Sensor> sensors = new ArrayList<Sensor>();
    SensorAdapter sensorAdapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        sensorAdapter = new SensorAdapter(this, R.layout.sensorlist, sensors);
        setListAdapter(sensorAdapter);

        SensorManager sensorService = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        for (int i = 1; i < 21; i++) {
            android.hardware.Sensor sensor = sensorService.getDefaultSensor(i);
            if (sensor != null) {
                sensors.add(new Sensor(sensor.getName(), i));
            }
        }

        sensorAdapter.notifyDataSetChanged();
    }

    public void runCompass(View view) {
        Intent intent = new Intent(this, CompassActivity.class);
        startActivity(intent);
    }

    public void runAcceleration(View view) {
        Intent intent = new Intent(this, AccelActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Sensor item = (Sensor) getListAdapter().getItem(position);
        if (item.getSensorType() == android.hardware.Sensor.TYPE_ACCELEROMETER) {
            Intent intent = new Intent(this, AccelActivity.class);
            startActivity(intent);
        }
        else { Toast.makeText(this, item.getSensorName() + " selected", Toast.LENGTH_LONG).show(); }
    }
}
