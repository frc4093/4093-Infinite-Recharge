//2020 ready Dash
package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * Stuff that got removed
 * Toggle from hatch to cargo
 * speed
 * encoder
 * voltage(can display easily from shuffleboard)
 * 
 * Stuff that needs to be added
 * Shuffleboard support
 */
public class Dash  {
	private int lastTab;
	public void Dash(){
		lastTab = 0;
// erik
	}
	public void displayData( String key, double value){
		SmartDashboard.putNumber(key, value);
	}
	public void displayData( String key,  String value){
		SmartDashboard.putString(key, value);
	}
	public void displayData( String key, Boolean value) {
		SmartDashboard.putBoolean(key, value);
	}

    //A way to read from dashboard
    public double readNumber(String key){
        return SmartDashboard.getNumber(key,0);
    }
    public Boolean readBoolean(String key){
        return SmartDashboard.getBoolean(key,false);
    }
    public String readString(String key){
        return SmartDashboard.getString(key,"Default");
	}
	
	public void updateDashBoard(){
		//nothing needed this year
	}
	public void changeTab(final int tab){
		Shuffleboard.selectTab(tab); //switch to tab
		lastTab = tab;
	}
}