package org.coopmobil.sandbox.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import org.coopmobil.sandbox.R;

import java.util.ArrayList;

public class SensorAdapter extends ArrayAdapter<Sensor> {

    private ArrayList<Sensor> items;
    private Context context;

    public SensorAdapter(Context context, int textViewResourceId, ArrayList<Sensor> items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.sensorlist, null);
        }
        Sensor o = items.get(position);
        if (o != null) {
            TextView sensorName = (TextView) v.findViewById(R.id.sensor_name);
            if (sensorName != null) {
                sensorName.setText("Sensor: " + o.getSensorName());
            }
        }
        return v;
    }
}
