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
 * all Still on 2019 dash
 */
public class Dash  {
	private int lastTab;
	public double voltage = 0; //needs to be grabbed from PDP
	public double l_voltage = 0;
	public double time = 0; //Grab from network table?
	public double l_time = 0;
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
		//check if change is actually needed to preserve cpu
		if (time != l_time){
			l_time = time;
			showMatchTime();
		}
		if (voltage != l_voltage){
			l_voltage = voltage;
			showVoltage();
		}
			
	}
	public void changeTab(final int tab){
		Shuffleboard.selectTab(tab); //switch to tab
		lastTab = tab;
	}
	public void showMatchTime(){
		displayData("Match Time", time);
	}
	public void showVoltage(){
		displayData("Voltage", voltage);
	}
}