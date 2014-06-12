package com.example.proximitysample;

import java.util.List;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements SensorEventListener {
	//ON/OFFボタン用
    ToggleButton toggleButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SensorManager mgr = (SensorManager) getSystemService(SENSOR_SERVICE);
		List<Sensor> sensors = mgr.getSensorList(Sensor.TYPE_PROXIMITY);
		Sensor sensor = sensors.get(0);
		mgr.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		float[] values = event.values;
		setContentView(R.layout.activity_main);
	    toggleButton = (ToggleButton) findViewById(R.id.ToggleButton);

		TextView text = (TextView) findViewById(R.id.Proximity);
		text.setText(String.valueOf(values[0]));

		if(values[0]==0.0){
			// ToggleButton が On かどうかを設定
		    toggleButton.setChecked(true);

		    // ToggleButton が On かどうかを取得
		    boolean checked = toggleButton.isChecked();
		}


	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO 自動生成されたメソッド・スタブ

	}

}