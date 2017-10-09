package com.rbc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rbc.data.model.Robot;
import com.rbc.service.robot.RobotService;



@RestController
@RequestMapping("/api/robot")
public class RobotController {
	
	@Autowired
	private RobotService robotService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Robot> getRobots() {
		return robotService.findAllRobots();
	}
	
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Robot findRobot(@PathVariable("id") Long robotId){
     return robotService.findRobot(robotId);
  } 
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Robot createRobot(@RequestBody Robot robot) {
		return robotService.saveRobot(robot);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Robot updateRobot(@RequestBody Robot robot) {
		return robotService.saveRobot(robot);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteRobot(@RequestBody Long robotId) {
		robotService.deleteRobot(robotId);
	}

}
