package com.rbc.service.robot.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbc.data.dao.RobotDao;
import com.rbc.data.model.Robot;
import com.rbc.service.robot.RobotService;

@Service
public class RobotServiceImpl implements RobotService{
	
	@Autowired
	private RobotDao robotDao;

	@Override
	public List<Robot> findAllRobots() {
		return robotDao.findAll();
	}

	@Override
	public Robot saveRobot(Robot robot) {
		return robotDao.save(robot);
	}

	@Override
	public Robot findRobot(Long robotId) {
		return robotDao.findOne(robotId);
	}

	@Override
	public void deleteRobot(Long robotId) {
		robotDao.delete(robotId);
	}

}
