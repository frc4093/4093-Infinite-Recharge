/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.jni.DistanceSensorJNIWrapper;

/**
 * Add your docs here.
 */
public class Constants {
    public static final int a = 0;
    public final static InterpolatingTree distanceToRPM = new InterpolatingTree(10);
    {
        distanceToRPM.put(0.0,0.0);
    }
}
