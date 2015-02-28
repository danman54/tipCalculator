package com.danielibarra.tipcalculator;


// A package is a library file in JAVA. In eclipse it is the 2x2 box that 
// shows up under the source folder package com.example.tipscalculator; 
// Android packages used to run your code and handle the hardware
import android.os.Bundle; 
import android.app.Activity; 
import android.util.Log;
import android.view.Menu; 
// Add packages below to work with 1) Textboxes, forms, and the seekbar

import android.text.*; 
import android.widget.*; 
import android.text.TextWatcher;
import android.widget.SeekBar.OnSeekBarChangeListener;
// Class structure automatically created and defined for you. The class 
// represents your activity and has access to functionality associated with 
// activities 
public class MainActivity extends Activity {
	// Define constant variables that never change 
	// These variables will be used to store state/screen information 
	// so that when you start up again you will see the same thing as when
	// you closed the screen 
	private static final String BILL_TOTAL = "BILL_TOTAL"; 
	private static final String CUSTOM_PERCENT = "CUSTOM_PERCENT";
	
	// Create variables in this location. These variables will hold 
	// references to your gui items and other variables that will hold
	// important info needed for the app to run 
	// Create 1 more variable of type int below totalBill, that will hold 
	// the custom tip amount 
	private double totalBill;
	private int customTip;
	
	
	// Create private variables to hold the GUI items. I have listed a few 
	// to help you out but you will need to complete the rest
 
	private EditText totBillEditText;
	private EditText billEditText;
	private EditText tip10EditText;
	private EditText tip15EditText;
	private EditText tip20EditText;
	private EditText total10EditText;
	private EditText total15EditText;
	private EditText total20EditText;
	private EditText tipCustomEditText;
	private EditText totalCustomEditText;
	
	
	
	
	// Custom Information GUI variables � You will need to complete the rest
	private TextView customTipText;
	private TextView customTipTextView;
	// @Override is a keyword that makes sure you are filling in the 
	// template correctly 
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		// Add this if else statement and read the comments 
		if(savedInstanceState == null) 
		{
			// If it�s the first time the app is running then 
			// initialize variables to default values 
			totalBill = 0.0; 
			customTip = 18; // Use 18% as the default custom tip value
		}
		
		else{
			// Else this is not the first time the app is running so 
			// let�s grab the values we save earlier and set them to 
			// code variables 
			totalBill = savedInstanceState.getDouble(BILL_TOTAL); 
			customTip = savedInstanceState.getInt(CUSTOM_PERCENT);
		}
	
		

		// Assign GUI items to the variables � a few of them are shown 
		// for you 
		this.tip10EditText = (EditText) findViewById(R.id.tip10EditText);
		this.billEditText = (EditText) findViewById(R.id.billEditText);
		this.tip15EditText = (EditText) findViewById(R.id.tip15EditText);
		this.tip20EditText = (EditText) findViewById(R.id.tip20EditText);
		this.total10EditText = (EditText) findViewById(R.id.total10EditText);
		this.total15EditText = (EditText) findViewById(R.id.total15EditText);
		this.total20EditText = (EditText) findViewById(R.id.total20EditText);
		this.tipCustomEditText = (EditText) findViewById(R.id.tipCustomEditText);
		this.totalCustomEditText = (EditText) findViewById(R.id.totalCustomEditText);
		
		// Custom Information
		
		this.customTipText = (TextView) findViewById(R.id.customTipTextView);
		
		this.tipCustomEditText = (EditText) findViewById(R.id.tipCustomEditText);
		
		// Create SeekBar and add seekbar listener
		SeekBar customTipSeekBar = (SeekBar)findViewById(R.id.tipSeekBar);
		customTipSeekBar.setOnSeekBarChangeListener(tipSeekBarListener); 
	// Set bill total GUI and add textWatcher (similar to a listener for the 
	// textbox 
	this.totBillEditText = (EditText)findViewById(R.id.billEditText);
		totBillEditText.addTextChangedListener(billEditTextWatcher);
	}
	//Create function below
	private void updateCustom(){ 
			// Set values for custom textboxes 
		double cusTip = ((double)this.customTip/(double)100) * this.totalBill; 
		double custotal = cusTip + this.totalBill; 
		// set textboxes and labels for custom tip total and custom total 
		// textbox 
		this.tipCustomEditText.setText(String.format("%.02f", cusTip)); 
		
		// -------------------->Need to add code to set custom total text box
		
		
	}
	
	private void updateStandardFeatures(){ 
		// -------------------->This whole method
		// This function will compute the tip and total for 10%, 15%, and
		// 20% and it will update the textboxes to show these amounts 
		// using the setText
		
		
		
		
	}

	// Create the listeners and fill them in as follows
	private OnSeekBarChangeListener tipSeekBarListener = new OnSeekBarChangeListener(){
	
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		
		// .getProgress() gets the current amount the seekbar is 
		// set to 
		customTip =seekBar.getProgress(); 
		// Display the new slide value in the textbox and add a % // sign
		customTipText.setText(customTip + "%");
		// Call the updateCustom() function to update all of the 
		// values 
		updateCustom();
	}
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) { 
	// These functions HAVE to be defined
	}
	
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) { 
	// This function has to be defined but we will leave it
	// empty
	}
};
	
	// This is the listener for the textbox (where you can grab text)
	private TextWatcher billEditTextWatcher = new TextWatcher(){
	
		@Override
		public void afterTextChanged(Editable arg0) { 
		// TODO Auto-generated method stub
	
		}
		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		
			// Grab the total amount string and parse it to a type 
			// double 
			// --------------------> Added the no crashing 
		
			
			totalBill = Double.parseDouble(arg0.toString());
			
			updateStandardFeatures();
			updateCustom();
	}
};
		@Override
		public boolean onCreateOptionsMenu(Menu menu) { 
		// Inflate the menu; this adds items to the action bar if it is present. 
			getMenuInflater().inflate(R.menu.main, menu); 
			return true;
		}
		// Add this function, it is how we save the state information
		@Override
		protected void onSaveInstanceState(Bundle outState){ 
			outState.putDouble(BILL_TOTAL, totalBill); 
			outState.putInt(CUSTOM_PERCENT, customTip);
		}
		
		}