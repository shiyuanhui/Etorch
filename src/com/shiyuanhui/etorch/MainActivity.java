package com.shiyuanhui.etorch;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;





public class MainActivity extends Activity implements OnClickListener {
	
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Camera camera;
	private Parameters parameter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		button1 = (Button)findViewById(R.id.light1);
		button2 = (Button)findViewById(R.id.light2);
		button3 = (Button)findViewById(R.id.light3);
		button4 = (Button)findViewById(R.id.light4);
		
		
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()){
		case R.id.light1:
		  OnCamera();
		  break;
		  
		case R.id.light2:
			while(true)
			{
			 OnCamera();
			 OffCamera();
			 OnCamera();
			 OffCamera();
			 OnCamera();
			 OffCamera();
			 LongTime();
			 LongTime();
			 LongTime();
			 OnCamera();
			 OffCamera();
			 OnCamera();
			 OffCamera();
			 OnCamera();
			 OffCamera();
			}
			
		case R.id.light3:
			while(true)
			{
			  OnCamera();
		      OffCamera();
			}
		
		case R.id.light4:
			OffCamera();
			break;
			
		default: break;
		}
	}

	private void OnCamera(){
		camera = Camera.open();  
		camera.startPreview();
		parameter = camera.getParameters();  
		parameter.setFlashMode(Parameters.FLASH_MODE_TORCH);
		camera.setParameters(parameter);
		
	}
	
	private void OffCamera()
	{
		parameter = camera.getParameters();  
		parameter.setFlashMode(Parameters.FLASH_MODE_OFF);
		camera.setParameters(parameter);
		camera.release();
	}
	private void LongTime()
	{
		OnCamera();
		  new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(1000*2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		  OffCamera();
	}
	
	
}
