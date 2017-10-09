package com.rbc.service.robot;

import java.util.List;

import com.rbc.data.model.Robot;


public interface RobotService {
	
	public List<Robot> findAllRobots();

	public Robot saveRobot(Robot robot);
	
	public Robot findRobot(Long robotId);

	public void deleteRobot(Long robotId);

}
