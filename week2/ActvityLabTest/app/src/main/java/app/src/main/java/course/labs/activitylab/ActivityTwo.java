package app.src.main.java.course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
    private int mCreate = 0;
    private int mStart = 0;
    private int mResume = 0;
    private int mRestart = 0;
    private TextView mTvCreate, mTvStart, mTvRestart, mTvResume;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
        mTvCreate = (TextView)findViewById(R.id.create);
        mTvRestart = (TextView)findViewById(R.id.restart);
        mTvResume = (TextView)findViewById(R.id.resume);
        mTvStart = (TextView)findViewById(R.id.start);

		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// This function closes Activity Two
				// Hint: use Context's finish() method
                finish();
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {

			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
            mStart = savedInstanceState.getInt("onStartCount");
            mCreate = savedInstanceState.getInt("onCreateCount");
            mRestart = savedInstanceState.getInt("onRestartCount");
            mResume = savedInstanceState.getInt("onResumeCount");
		}

        Log.i(TAG, "onCreate");

		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
        mCreate++;
	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		Log.i(TAG, "onStart");

		// Update the appropriate count variable
		// Update the user interface
        mStart++;
        displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();

		Log.i(TAG, "onResume");


		// Update the appropriate count variable
		// Update the user interface
        mResume++;
        displayCounts();
	}

	@Override
	public void onPause() {
		super.onPause();

		Log.i(TAG, "onPause");
	}

	@Override
	public void onStop() {
		super.onStop();

		Log.i(TAG, "onStop");
	}

	@Override
	public void onRestart() {
		super.onRestart();

		Log.i(TAG, "onRestart");

		// Update the appropriate count variable
		// Update the user interface
        mRestart++;
        displayCounts();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		Log.i(TAG, "onDestroy");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// Save counter state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
        savedInstanceState.putInt("onStartCount", mStart);
        savedInstanceState.putInt("onCreateCount", mCreate);
        savedInstanceState.putInt("onRestartCount", mRestart);
        savedInstanceState.putInt("onResumeCount", mResume);
	}

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
