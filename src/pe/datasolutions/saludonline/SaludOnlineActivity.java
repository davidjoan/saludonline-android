package pe.datasolutions.saludonline;

import org.springframework.web.client.RestTemplate;

import pe.datasolutions.saludonline.model.User;

import android.app.Activity;
import android.util.Log;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SaludOnlineActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        View aboutButton = findViewById(R.id.logo);
        View loginButton = findViewById(R.id.btnLogin);
        aboutButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
        
        
    }

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.logo:
			Intent i = new Intent(this, About.class);
			startActivity(i);
			break;
		case R.id.btnLogin :
			
			   RestTemplate restTemplate = new RestTemplate();
			   String url = "https://twitter.com/statuses/user_timeline.xml?id=davidjoan";
			   String userObject = restTemplate.getForObject(url, String.class);
			   Log.i(ALARM_SERVICE, userObject);
			Intent e = new Intent(this, PanelActivity.class );
			startActivity(e);
			break;			

		default:
			break;
		}
		
	}
}